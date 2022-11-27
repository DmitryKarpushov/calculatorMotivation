package ru.arttek.motivation.calculator_motivation.model.work_form;

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
    private double revenue;
    @Positive(message = "рентабельность должна быть положительной")
    private double profitability;
    @Positive(message = "План по выручке должен быть положительным")
    private double revenuePlan;
    @Positive(message = "ГСМ должен быть положительным")
    private double fuelAndLubricants;
    @Positive(message = "Скидка на ГСМ должна быть положительной")
    private double discountFuelAndLubricants;
    @Positive(message = "Сумма за дежурства должна быть положительной")
    private double shifts;
    @Positive(message = "Ндс перевозчиков должен быть положительным")
    private double vatCarriers;
    @Positive(message = "Рабочие дни должны быть положительными")
    private int workDays;
    @Positive(message = "Оклад должен быть положительным")
    private double salary;
}
