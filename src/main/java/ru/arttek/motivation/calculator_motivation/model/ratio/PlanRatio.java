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
    int id;
    @Positive(message = "Нижний порог должен быть положительным")
    double lowerPercent;
    @Positive(message = "Высокий порог должен быть положительным")
    double highPercent;
    @Positive(message = "Коэффициент порог должен быть положительным")
    double ratioPercent;
}
