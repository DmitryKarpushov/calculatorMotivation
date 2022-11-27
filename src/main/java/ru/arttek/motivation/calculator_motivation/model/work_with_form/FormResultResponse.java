package ru.arttek.motivation.calculator_motivation.model.work_with_form;

import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * @author Дмитрий Карпушов 27.11.2022
 */
@Data
@AllArgsConstructor
public class FormResultResponse {
    private Double salaryDay;
    private Double salaryMonth;
    private Double motivationalPart;
    private Double finalSalary;
}
