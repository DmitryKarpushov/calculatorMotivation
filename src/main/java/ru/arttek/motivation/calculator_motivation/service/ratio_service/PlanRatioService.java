package ru.arttek.motivation.calculator_motivation.service.ratio_service;

import org.springframework.stereotype.Service;
import ru.arttek.motivation.calculator_motivation.model.ratio.PlanRatio;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Дмитрий Карпушов 26.11.2022
 */
@Service
public class PlanRatioService {
    private final Map<Integer, PlanRatio> planRatios = new HashMap<>();

    /**
     * В последующем изменения будут в создании таблицы в БД, где будем хранить наши пороговые значения и коэффициенты
     */ {
        planRatios.put(1, new PlanRatio(1, 0, 70, 0.6));
        planRatios.put(2, new PlanRatio(2, 70, 75, 0.8));
        planRatios.put(3, new PlanRatio(3, 75, 120, 1));
        planRatios.put(4, new PlanRatio(4, 120, 1000, 1.2));
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
        for (Map.Entry<Integer, PlanRatio> entry : planRatios.entrySet()) {
            if (result > entry.getValue().getLowerPercent() && result < entry.getValue().getHighPercent()) {
                return entry.getValue().getRatioPercent();
            }
        }
        return null;
    }
}
