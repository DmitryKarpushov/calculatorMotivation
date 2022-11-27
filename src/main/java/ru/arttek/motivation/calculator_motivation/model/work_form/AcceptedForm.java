package ru.arttek.motivation.calculator_motivation.model.work_form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Positive;

/**
 * @author Дмитрий Карпушов 22.11.2022
 */
@Data
@AllArgsConstructor
public class AcceptedForm {
    @Positive(message = "Выручка должна быть положительной")
    private double revenue; //выручка
    @Positive(message = "рентабельность должна быть положительной")
    private double profitability; //рентабельность
    @Positive(message = "План по выручке должен быть положительным")
    private double revenuePlan; //План по выручке
    @Positive(message = "ГСМ должен быть положительным")
    private double fuelAndLubricants;// Гсм
    @Positive(message = "Скидка на ГСМ должна быть положительной")
    private double discountFuelAndLubricants;// скидка на гсм
    @Positive(message = "Сумма за дежурства должна быть положительной")
    private double shifts;// дежурства
    @Positive(message = "Ндс перевозчиков должен быть положительным")
    private double vatCarriers; // Ндс перевозчиков
    @Positive(message = "Рабочие дни должны быть положительными")
    private int workDays; // Рабочих дней
    @Positive(message = "Оклад должен быть положительным")
    private double salary; // Оклад
}
