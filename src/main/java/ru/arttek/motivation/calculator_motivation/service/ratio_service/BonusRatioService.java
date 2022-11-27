package ru.arttek.motivation.calculator_motivation.service.ratio_service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.arttek.motivation.calculator_motivation.model.ratio.BonusRatio;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author Дмитрий Карпушов 23.11.2022
 */
@Service
@Slf4j
public class BonusRatioService {
    private final Map<Integer, BonusRatio> bonusRatios = new HashMap<>();

    /**
     * В последующем изменения будут в создании таблицы в БД, где будем хранить наши пороговые значения и коэффициенты
     */
    {
        bonusRatios.put(1, new BonusRatio(1,0.0, 145750.0, 0.0));
        bonusRatios.put(2, new BonusRatio(2,145750.0, 174250.0, 0.28));
        bonusRatios.put(3, new BonusRatio(3,174251.0, 202751.0, 0.273));
        bonusRatios.put(4, new BonusRatio(4,202752.0, 231252.0, 0.266));
        bonusRatios.put(5, new BonusRatio(5,231253.0, 259753.0, 0.259));
        bonusRatios.put(6, new BonusRatio(6,259754.0, 288254.0, 0.252));
        bonusRatios.put(7, new BonusRatio(7,288255.0, 316755.0, 0.245));
        bonusRatios.put(8, new BonusRatio(8,316756.0, 345256.0, 0.238));
        bonusRatios.put(9, new BonusRatio(9,345257.0, 373757.0, 0.231));
        bonusRatios.put(10, new BonusRatio(10,373758.0, 402258.0, 0.224));
        bonusRatios.put(11, new BonusRatio(11,402259.0, 430759.0, 0.217));
        bonusRatios.put(12, new BonusRatio(12,430760.0, 459260.0, 0.21));
        bonusRatios.put(13, new BonusRatio(13,459261.0, 487761.0, 0.2));
        bonusRatios.put(14, new BonusRatio(14,487762.0, 516262.0, 0.2));
        bonusRatios.put(15, new BonusRatio(15,516263.0,10000000.0, 0.2));
    }

    /**
     * Вывод всего списка коэффициентов
     */
    public Map<Integer,BonusRatio> listBonusRatio() {
        log.info("BonusRatioService.Вывод всего списка коэффициентов премирования");
        return bonusRatios;
    }

    /**
     * Изменение порогов и коэффициентов
     */
    public void updateThreshold(BonusRatio bonusRatio) {
        log.info("BonusRatioService.Обновление порога или коэффициента {}",bonusRatio);
        bonusRatios.put(bonusRatio.getId(), bonusRatio);
    }

    /**
     * Показывает нам наш порог
     */
    public BonusRatio showThreshold(Integer id) {
        log.info("BonusRatioService.Вывод порога {}",bonusRatios.get(id));
        return bonusRatios.get(id);
    }

    /**
     * Получение нашего коэффициента
     */
    public Optional<Double> getRatio(Double margin) {
        log.info("BonusRatioService.Получение коэффициента, в зависимости от маржи {}",margin);
        return bonusRatios.values().stream()
                .filter(bonusRatio -> bonusRatio.getLowerThreshold() < margin && bonusRatio.getHighThreshold() >= margin)
                .map(BonusRatio::getRatio)
                .findAny();
    }

}
