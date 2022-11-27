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
        model.addAttribute("plan", planRatioService.listPlannedRatio());
        return "planRatio";
    }

    @GetMapping("/editPlanRatio/{id}")
    public String showPlanThresholdRatio(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("updatePlanThreshold", planRatioService.showPlannedThreshold(id));
        return "editPlanRatio";
    }

    @PostMapping("/planRatio")
    public String updatePlanThresholdRatio(@ModelAttribute("planEdit") PlanRatio planRatio) {
        planRatioService.updatePlannedThreshold(planRatio);
        return "redirect:/planRatio";
    }
}
