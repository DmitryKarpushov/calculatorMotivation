package ru.arttek.motivation.calculator_motivation.controller.ratio_controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.arttek.motivation.calculator_motivation.model.ratio.BonusRatio;
import ru.arttek.motivation.calculator_motivation.service.ratio_service.BonusRatioService;

/**
 * @author Дмитрий Карпушов 23.11.2022
 */
@Controller
@RequiredArgsConstructor
public class BonusRatioController {
    private final BonusRatioService bonusRatioService;

    @GetMapping("/bonusRatio")
    public String bonusRatio(Model model) {
        model.addAttribute("bonus", bonusRatioService.listBonusRatio());
        return "bonusRatio";
    }

    @GetMapping("/bonusRatio/{id}")
    public String showThresholdRatio(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("updateThreshold", bonusRatioService.showThreshold(id));
        return "editBonusRatio";
    }

    @PostMapping("/bonusRatio")
    public String updateThresholdRatio(@ModelAttribute("updateThreshold") BonusRatio bonusRatio) {
        bonusRatioService.updateThreshold(bonusRatio);
        return "redirect:/bonusRatio";
    }
}
