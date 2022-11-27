package ru.arttek.motivation.calculator_motivation.service.ratio_service;

import org.springframework.stereotype.Service;
import ru.arttek.motivation.calculator_motivation.model.ratio.BonusRatio;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Дмитрий Карпушов 23.11.2022
 */
@Service
public class BonusRatioService {
    private final Map<Integer, BonusRatio> bonusRatios = new HashMap<>();

    /**
     * В последующем изменения будут в создании таблицы в БД, где будем хранить наши пороговые значения и коэффициенты
     */ {
        bonusRatios.put(1, new BonusRatio(1,0, 145750, 0));
        bonusRatios.put(2, new BonusRatio(2,145750, 174250, 0.28));
        bonusRatios.put(3, new BonusRatio(3,174251, 202751, 0.273));
        bonusRatios.put(4, new BonusRatio(4,202752, 231252, 0.266));
        bonusRatios.put(5, new BonusRatio(5,231253, 259753, 0.259));
        bonusRatios.put(6, new BonusRatio(6,259754, 288254, 0.252));
        bonusRatios.put(7, new BonusRatio(7,288255, 316755, 0.245));
        bonusRatios.put(8, new BonusRatio(8,316756, 345256, 0.238));
        bonusRatios.put(+9, new BonusRatio(9,345257, 373757, 0.231));
        bonusRatios.put(10, new BonusRatio(10,373758, 402258, 0.224));
        bonusRatios.put(11, new BonusRatio(11,402259, 430759, 0.217));
        bonusRatios.put(12, new BonusRatio(12,430760, 459260, 0.21));
        bonusRatios.put(13, new BonusRatio(13,459261, 487761, 0.2));
        bonusRatios.put(14, new BonusRatio(14,487762, 516262, 0.2));
        bonusRatios.put(15, new BonusRatio(15,516263,1000000, 0.2));
    }

    /**
     * Вывод всего списка коэффициентов
     */
    public Map<Integer,BonusRatio> listBonusRatio() {
        return bonusRatios;
    }

    /**
     * Изменение порогов и коэффициентов
     */
    public void updateBonus(BonusRatio bonusRatio) {
        bonusRatios.put(bonusRatio.getId(), bonusRatio);
    }

    /**
     * Показывает нам наш порог
     */
    public BonusRatio showBonus(int id) {
        return bonusRatios.get(id);
    }

    /**
     * Получение нашего коэффициента
     */
    public Double getRatio(Double ratio) {
        for (Map.Entry<Integer, BonusRatio> entry : bonusRatios.entrySet()) {
            if (entry.getValue().getLowerThreshold() < ratio && entry.getValue().getHighThreshold() >= ratio) {
                return entry.getValue().getRatio();
            }
        }
        return null;
    }

}
