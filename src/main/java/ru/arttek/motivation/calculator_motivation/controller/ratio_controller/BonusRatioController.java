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

    @GetMapping("/editPorog/{id}")
    public String showRatio(@PathVariable("id")int id, Model model) {
        model.addAttribute("porogEdit", bonusRatioService.showBonus(id));
        return "editPorog";
    }

    @PostMapping("/{id}")
    public String editRatio(@ModelAttribute("porogEdit")BonusRatio bonusRatio) {
        bonusRatioService.updateBonus(bonusRatio);
        return "redirect:/bonusRatio";
    }
}
