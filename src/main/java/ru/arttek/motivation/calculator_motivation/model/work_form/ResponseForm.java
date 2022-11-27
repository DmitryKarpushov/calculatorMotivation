package ru.arttek.motivation.calculator_motivation.model.work_form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author Дмитрий Карпушов 27.11.2022
 */
@Data
@AllArgsConstructor
public class ResponseForm {
    private double salaryDay;
    private double salaryMonth;
    private double motivationalPart;
    private double finalSalary;
}
