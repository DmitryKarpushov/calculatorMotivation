package ru.arttek.motivation.calculator_motivation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.arttek.motivation.calculator_motivation.model.ratio.PlanRatio;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Дмитрий Карпушов 26.11.2022
 */
public class PlanRatioServiceTest {
    private final Map<Integer, PlanRatio> planRatios = new HashMap<>();
    private int ID = planRatios.size();

    /**
     * В последующем изменения будут в создании таблицы в БД, где будем хранить наши пороговые значения и коэффициенты
     */ {
        planRatios.put(++ID, new PlanRatio(1, 0, 70, 0.6));
        planRatios.put(++ID, new PlanRatio(2, 70, 75, 0.8));
        planRatios.put(++ID, new PlanRatio(3, 75, 120, 1));
        planRatios.put(++ID, new PlanRatio(4, 120, 0, 1.2));
    }

    /**
     * Вывод всего списка коэффициентов
     */
    public Map<Integer, PlanRatio> listPlanRatio() {
        return planRatios;
    }

    /**
     * Изменение порогов и коэффициентов
     */
    public void updatePlan(PlanRatio planRatio) {
        planRatios.put(planRatio.getId(), planRatio);
    }

    /**
     * Показывает нам наш порог
     */
    public PlanRatio showPlan(int id) {
        return planRatios.get(id);
    }

    /**
     * Получение нашего коэффициента
     */
    public Double getRatioPlan(double revenue, double plan) {
        double result = revenue / plan * 100;
        System.out.println("result " + result);
        for (Map.Entry<Integer, PlanRatio> entry : planRatios.entrySet()) {
            if (result > entry.getValue().getLowerPercent() && result < entry.getValue().getHighPercent()) {
                return entry.getValue().getRatioPercent();
            }
            if (revenue > plan && result > entry.getValue().getLowerPercent() && entry.getValue().getHighPercent() == 0) {
                return entry.getValue().getRatioPercent();
            }
        }
        return null;
    }

    @Test
    @DisplayName("1)Вывод всего списка пороговых значений")
    void correctlyFieldFilmTest() {
        System.out.println(listPlanRatio());
    }

    @Test
    @DisplayName("2)Вывод кэфа")
    void correctlyFieldFilmTestSecond() {
        System.out.println("План = 320 Выручка = 200");
        System.out.println("Результат работы функции = " + getRatioPlan(200, 320));
        System.out.println("");
        System.out.println("План = 280 Выручка = 200");
        System.out.println("Результат работы функции = " + getRatioPlan(200, 280));
        System.out.println("");
        System.out.println("План = 260 Выручка = 200");
        System.out.println("Результат работы функции = " + getRatioPlan(200, 260));
        System.out.println("");
        System.out.println("План = 240 Выручка = 200");
        System.out.println("Результат работы функции = " + getRatioPlan(200, 240));
        System.out.println("");
        System.out.println("План = 240 Выручка = 320");
        System.out.println("Результат работы функции = " + getRatioPlan(320, 240));

//        System.out.println(getRatio(145750.00));
//        System.out.println(getRatio(231252.00));
//        System.out.println(getRatio(350000.00));
//        System.out.println(getRatio(600000.00));
//        System.out.println(showBonus(1));
    }
}
