package ru.arttek.motivation.calculator_motivation.controller.forms_controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.arttek.motivation.calculator_motivation.model.work_with_form.AcceptedFormRequest;
import ru.arttek.motivation.calculator_motivation.service.calculator_service.SalaryCalculatorService;

/**
 * @author Дмитрий Карпушов 22.11.2022
 */
@Controller
@RequiredArgsConstructor
public class FormController {

    private final SalaryCalculatorService salaryCalculator;

    @GetMapping("/")
    public String homePage() {
        return "homePage";
    }

    @PostMapping("/forms/result")
    public String getAndSendFormAndResult(@ModelAttribute("motivationFields") AcceptedFormRequest formRequest, Model model) {
        model.addAttribute("resultFormResponse", salaryCalculator.resultSalaryToEmployeeMonth(formRequest));
        return "homePage";
    }
}
