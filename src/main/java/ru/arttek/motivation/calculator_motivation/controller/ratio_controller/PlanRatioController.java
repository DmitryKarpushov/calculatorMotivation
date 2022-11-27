package ru.arttek.motivation.calculator_motivation.controller.ratio_controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.arttek.motivation.calculator_motivation.model.ratio.PlanRatio;
import ru.arttek.motivation.calculator_motivation.service.ratio_service.PlanRatioService;

/**
 * @author Дмитрий Карпушов 26.11.2022
 */
@Controller
@RequiredArgsConstructor
public class PlanRatioController {
    private final PlanRatioService planRatioService;

    @GetMapping("/planRatio")
    public String planRatio(Model model) {
        model.addAttribute("plan", planRatioService.listPlanRatio());
        return "planRatio";
    }

    @GetMapping("/editplanRatio/{id}")
    public String showPlanRatio(@PathVariable("id")int id, Model model) {
        model.addAttribute("planEdit", planRatioService.showPlan(id));
        return "editplanRatio";
    }

    //Костыль
    @PostMapping("/ed/{id}")
    public String editPlanRatio(@ModelAttribute("planEdit") PlanRatio planRatio) {
        planRatioService.updatePlan(planRatio);
        return "redirect:/planRatio";
    }
}
