package ru.arttek.motivation.calculator_motivation.model.work_with_form;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Positive;

/**
 * @author Дмитрий Карпушов 22.11.2022
 */
@Data
@AllArgsConstructor
public class AcceptedFormRequest {
    @Positive(message = "Выручка должна быть положительной")
    private Double revenue;
    @Positive(message = "рентабельность должна быть положительной")
    private Double profitability;
    @Positive(message = "План по выручке должен быть положительным")
    private Double revenuePlan;
    @Positive(message = "ГСМ должен быть положительным")
    private Double fuelAndLubricants;
    @Positive(message = "Скидка на ГСМ должна быть положительной")
    private Double discountFuelAndLubricants;
    @Positive(message = "Сумма за дежурства должна быть положительной")
    private Double shifts;
    @Positive(message = "Ндс перевозчиков должен быть положительным")
    private Double vatCarriers;
    @Positive(message = "Рабочие дни должны быть положительными")
    private Integer workDays;
    @Positive(message = "Оклад должен быть положительным")
    private Double salary;
}
