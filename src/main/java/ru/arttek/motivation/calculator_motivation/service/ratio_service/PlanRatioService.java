package ru.arttek.motivation.calculator_motivation.service.ratio_service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.arttek.motivation.calculator_motivation.model.ratio.PlanRatio;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author Дмитрий Карпушов 26.11.2022
 */
@Service
@Slf4j
public class PlanRatioService {
    private final Map<Integer, PlanRatio> planRatios = new HashMap<>();

    /**
     * В последующем изменения будут в создании таблицы в БД, где будем хранить наши пороговые значения и коэффициенты
     */ {
        planRatios.put(1, new PlanRatio(1, 0.0, 70.0, 0.6));
        planRatios.put(2, new PlanRatio(2, 70.0, 75.0, 0.8));
        planRatios.put(3, new PlanRatio(3, 75.0, 120.0, 1.0));
        planRatios.put(4, new PlanRatio(4, 120.0, 1000.0, 1.2));
    }

    /**
     * Вывод всего списка коэффициентов
     */
    public Map<Integer, PlanRatio> listPlannedRatio() {
        log.info("PlanRatioService.Вывод всего списка коэффициентов премирования плана");
        return planRatios;
    }

    /**
     * Изменение порогов и коэффициентов
     */
    public void updatePlannedThreshold(PlanRatio planRatio) {
        log.info("PlanRatioService.Обновление порога или коэффициента {}",planRatio);
        planRatios.put(planRatio.getId(), planRatio);
    }

    /**
     * Показывает нам наш порог
     */
    public PlanRatio showPlannedThreshold(Integer id) {
        log.info("PlanRatioService.Вывод порога {}",planRatios.get(id));
        return planRatios.get(id);
    }

    /**
     * Получение нашего коэффициента
     */
    public Optional<Double> getRatioPlan(Double revenue, Double plan) {
        double result = revenue / plan * 100;
        log.info("PlanRatioService.Получение коэффициента, в зависимости от выручки {}",result);
        return planRatios.values().stream()
                .filter(planRatio -> planRatio.getLowerPercent() < result && planRatio.getHighPercent() >= result)
                .map(PlanRatio::getRatioPercent)
                .findAny();
    }
}
