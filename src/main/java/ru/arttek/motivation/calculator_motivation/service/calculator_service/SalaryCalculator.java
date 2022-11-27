package ru.arttek.motivation.calculator_motivation.service.calculator_service;

import org.springframework.stereotype.Service;
import ru.arttek.motivation.calculator_motivation.model.work_form.AcceptedFormRequest;
import ru.arttek.motivation.calculator_motivation.model.work_form.ResponseForm;
import ru.arttek.motivation.calculator_motivation.service.ratio_service.BonusRatioService;
import ru.arttek.motivation.calculator_motivation.service.ratio_service.PlanRatioService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Дмитрий Карпушов 22.11.2022
 */

@Service
public class SalaryCalculator {

    private final List<ResponseForm> resultForm = new ArrayList<>();
    public List<ResponseForm> generalInformation(AcceptedFormRequest acceptedForm, PlanRatioService planRatioService, BonusRatioService bonusRatioService) {
        resultForm.clear();
        double salaryDay = salaryDay(acceptedForm.getSalary());
        double salaryMonth = salaryMonth(salaryDay, acceptedForm.getWorkDays());
        double margin = (acceptedForm.getRevenue() * ((acceptedForm.getProfitability() - 16.67) / 100) +
                (acceptedForm.getFuelAndLubricants() * 0.1667) - acceptedForm.getDiscountFuelAndLubricants()
                + acceptedForm.getVatCarriers());
        double motivationalPart = margin * bonusRatioService.getRatio(margin) *
                planRatioService.getRatioPlan(acceptedForm.getRevenue(), acceptedForm.getRevenuePlan());
        if (motivationalPart > salaryMonth) {
            resultForm.add(new ResponseForm(Math.round(salaryDay*100)/100.0d,
                    Math.round(salaryMonth*100)/100.0d,Math.round(motivationalPart*100)/100.0d,
                    Math.round((motivationalPart + acceptedForm.getShifts())*100)/100.0d));
        } else {
            resultForm.add(new ResponseForm(Math.round(salaryDay*100)/100.0d,
                    Math.round(salaryMonth*100)/100.0d,Math.round(motivationalPart*100)/100.0d,
                    Math.round((salaryMonth + acceptedForm.getShifts())*100)/100.0d));
        }
        return resultForm;
    }
    private double salaryDay(double salary) {
        return salary / 22;
    }

    private double salaryMonth(double salaryDay, int day) {
        return salaryDay * day;
    }
}
