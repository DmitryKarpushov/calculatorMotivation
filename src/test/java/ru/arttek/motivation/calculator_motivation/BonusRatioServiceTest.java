package ru.arttek.motivation.calculator_motivation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.arttek.motivation.calculator_motivation.model.ratio.BonusRatio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Дмитрий Карпушов 23.11.2022
 */
public class BonusRatioServiceTest {

    private final Map<Integer, BonusRatio> bonusRatios = new HashMap<>();
    private int ID = bonusRatios.size();

    /**
     * В последующем изменения будут в создании таблицы в БД,где будем хранить наши пороговые значения и коэффициенты
     */
    {
        bonusRatios.put(++ID, new BonusRatio(1,0, 145750, 0));
        bonusRatios.put(++ID, new BonusRatio(2,145750, 174250, 0.28));
        bonusRatios.put(++ID, new BonusRatio(3,174251, 202751, 0.273));
        bonusRatios.put(++ID, new BonusRatio(4,202752, 231252, 0.266));
        bonusRatios.put(++ID, new BonusRatio(5,231253, 259753, 0.259));
        bonusRatios.put(++ID, new BonusRatio(6,259754, 288254, 0.252));
        bonusRatios.put(++ID, new BonusRatio(7,288255, 316755, 0.245));
        bonusRatios.put(++ID, new BonusRatio(8,316756, 345256, 0.238));
        bonusRatios.put(++ID, new BonusRatio(9,345257, 373757, 0.231));
        bonusRatios.put(++ID, new BonusRatio(10,373758, 402258, 0.224));
        bonusRatios.put(++ID, new BonusRatio(11,402259, 430759, 0.217));
        bonusRatios.put(++ID, new BonusRatio(12,430760, 459260, 0.21));
        bonusRatios.put(++ID, new BonusRatio(13,459261, 487761, 0.2));
        bonusRatios.put(++ID, new BonusRatio(14,487762, 516262, 0.2));
        bonusRatios.put(++ID, new BonusRatio(15,516263,1000000, 0.2));
    }

    /**
     * Вывод всего списка коэффициентов
     */
    public List<BonusRatio> listBonusRatio() {
        for (Map.Entry<Integer, BonusRatio> entry : bonusRatios.entrySet()) {
            System.out.println("Key = " + entry.getKey() + "   Values = " + entry.getValue());
        }
        return new ArrayList<>(bonusRatios.values());
    }

    public Double getRatio(Double ratio) {
        for (Map.Entry<Integer, BonusRatio> entry : bonusRatios.entrySet()) {
            if (entry.getValue().getLowerThreshold() < ratio && entry.getValue().getHighThreshold() >= ratio) {
                return entry.getValue().getRatio();
            }
        }
        return null;
    }

    /**
     * Показывает человека
     */
    public BonusRatio showBonus(int id) {
        return bonusRatios.get(id);
    }


    @Test
    @DisplayName("1)Вывод всего списка пороговых значений")
    void correctlyFieldFilmTest() {
        listBonusRatio();
    }

    @Test
    @DisplayName("2)Вывод кэфа")
    void correctlyFieldFilmTestSecond() {
        System.out.println(getRatio(50.00));



        double d = 12122.34568;
        System.out.println(Math.round(d*100)/100.0d);

//        System.out.println(getRatio(145750.00));
//        System.out.println(getRatio(231252.00));
//        System.out.println(getRatio(350000.00));
//        System.out.println(getRatio(600000.00));
//        System.out.println(showBonus(1));
    }


}