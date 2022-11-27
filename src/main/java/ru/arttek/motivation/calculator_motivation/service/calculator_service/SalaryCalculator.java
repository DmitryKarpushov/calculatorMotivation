package ru.arttek.motivation.calculator_motivation.service.calculator_service;

import org.springframework.stereotype.Service;
import ru.arttek.motivation.calculator_motivation.model.work_form.AcceptedForm;
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

    private List<ResponseForm> resultForm = new ArrayList<>();
    public List<ResponseForm> generalInformation(AcceptedForm acceptedForm, PlanRatioService planRatioService, BonusRatioService bonusRatioService) {
        resultForm.clear();
        double salaryDay = Math.round(salaryDay(acceptedForm.getSalary())*100)/100.0d;
        double salaryMonth = Math.round(salaryMonth(salaryDay, acceptedForm.getWorkDays())*100)/100.0d;
        double margin = Math.round((acceptedForm.getRevenue() * ((acceptedForm.getProfitability() - 16.67) / 100) +
                (acceptedForm.getFuelAndLubricants() * 0.1667) - acceptedForm.getDiscountFuelAndLubricants()
                + acceptedForm.getVatCarriers())*100)/100.0d;
        double motivationalPart = Math.round(margin * bonusRatioService.getRatio(margin) *
                planRatioService.getRatioPlan(acceptedForm.getRevenue(), acceptedForm.getRevenuePlan())*100)/100.0d;
        if (motivationalPart > salaryMonth) {
            resultForm.add(new ResponseForm(salaryDay,salaryMonth,motivationalPart,(double) Math.round((motivationalPart + acceptedForm.getShifts()))));
        } else {
            resultForm.add(new ResponseForm(salaryDay,salaryMonth,motivationalPart,(double) Math.round((salaryMonth + acceptedForm.getShifts()))));
        }
        return resultForm;
    }

    private double salaryDay(double salary) {
        return salary / 22;
    }

    private double salaryMonth(double salaryDay, int day) {
        return Math.round(salaryDay * day)*100/100.0d;
    }
}
