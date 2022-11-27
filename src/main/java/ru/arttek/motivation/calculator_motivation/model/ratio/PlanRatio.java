package ru.arttek.motivation.calculator_motivation.model.ratio;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

/**
 * @author Дмитрий Карпушов 26.11.2022
 */
@Data
@AllArgsConstructor
public class PlanRatio {
    @Positive
    @NotEmpty
    Integer id;
    @Positive(message = "Нижний порог должен быть положительным")
    Double lowerPercent;
    @Positive(message = "Высокий порог должен быть положительным")
    Double highPercent;
    @Positive(message = "Коэффициент порог должен быть положительным")
    Double ratioPercent;
}
