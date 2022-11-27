package ru.arttek.motivation.calculator_motivation.model.ratio;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

/**
 * @author Дмитрий Карпушов 23.11.2022
 */
@Data
@AllArgsConstructor
public class BonusRatio {
    @Positive
    @NotEmpty
    Integer id;
    @Positive(message = "Нижний порог должен быть положительным")
    Double lowerThreshold;
    @Positive(message = "Высокий порог должен быть положительным")
    Double highThreshold;
    @Positive(message = "Коэффициент порог должен быть положительным")
    Double ratio;
}
