package ru.arttek.motivation.calculator_motivation.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.arttek.motivation.calculator_motivation.model.work_form.AcceptedFormRequest;
import ru.arttek.motivation.calculator_motivation.service.calculator_service.SalaryCalculator;
import ru.arttek.motivation.calculator_motivation.service.ratio_service.BonusRatioService;
import ru.arttek.motivation.calculator_motivation.service.ratio_service.PlanRatioService;


/**
 * @author Дмитрий Карпушов 22.11.2022
 */
@Controller
@RequiredArgsConstructor
public class FormController {
    private final SalaryCalculator salaryCalculator;
    private final BonusRatioService bonusRatioService;
    private final PlanRatioService planRatioService;

    @GetMapping("/")
    public String forms() {
        return "form";
    }

    @PostMapping("/forms/result")
    public String result(@ModelAttribute("motivationFields") AcceptedFormRequest FormRequest, Model model) {
        model.addAttribute("resultFormResponse", salaryCalculator.generalInformation(FormRequest, planRatioService, bonusRatioService));
        return "form";
    }
}
