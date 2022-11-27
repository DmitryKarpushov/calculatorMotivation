package ru.arttek.motivation.calculator_motivation.service.calculator_service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.arttek.motivation.calculator_motivation.model.work_with_form.AcceptedFormRequest;
import ru.arttek.motivation.calculator_motivation.model.work_with_form.FormResultResponse;
import ru.arttek.motivation.calculator_motivation.service.ratio_service.BonusRatioService;
import ru.arttek.motivation.calculator_motivation.service.ratio_service.PlanRatioService;

/**
 * @author Дмитрий Карпушов 22.11.2022
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class SalaryCalculatorService {

    private final BonusRatioService bonusRatioService;
    private final PlanRatioService planRatioService;
    private final Integer WORKING_DAYS_MONTH = 22;
    private final Double VAT = 16.67;

    /**
     * Вычисление зарплаты сотрудника за месяц согласно формулам
     * и условиям ТЗ "программный калькулятор мотивации сотрудников"
     */
    public FormResultResponse resultSalaryToEmployeeMonth(AcceptedFormRequest acceptedForm) {
        log.info("SalaryCalculatorService.Получили данные с формы {}", acceptedForm);
        double salaryDay = salaryDay(acceptedForm.getSalary());
        double salaryMonth = salaryMonth(salaryDay, acceptedForm.getWorkDays());
        double margin = acceptedForm.getRevenue() * ((acceptedForm.getProfitability() - VAT) / 100) +
                (acceptedForm.getFuelAndLubricants() * (VAT / 100)) - acceptedForm.getDiscountFuelAndLubricants()
                + acceptedForm.getVatCarriers();
        double motivationalPart = margin * bonusRatioService.getRatio(margin).orElseThrow() *
                planRatioService.getRatioPlan(acceptedForm.getRevenue(), acceptedForm.getRevenuePlan()).orElseThrow();
        return createFormResultResponse(salaryDay, salaryMonth, motivationalPart, acceptedForm.getShifts());
    }

    /**
     * Вычисление ставки за день
     */
    private double salaryDay(Double salary) {
        log.info("SalaryCalculatorService.Зарплата {}", salary);
        return salary / WORKING_DAYS_MONTH;
    }

    private double salaryMonth(Double salaryDay, Integer day) {
        log.info("SalaryCalculatorService.Вычисление зарплаты  salaryDay : {} and day : {}", salaryDay, day);
        return salaryDay * day;
    }

    private FormResultResponse createFormResultResponse(Double salaryDay, Double salaryMonth, Double motivationalPart, Double shifts) {
        log.info("SalaryCalculatorService.Вычисление конечной зарплаты  salaryDay : {} and salaryMonth :" +
                " {} and motivationalPart : {} and shifts : {}", salaryDay, salaryMonth, motivationalPart, shifts);
        return new FormResultResponse(Math.round(salaryDay * 100) / 100.0d,
                Math.round(salaryMonth * 100) / 100.0d, Math.round(motivationalPart * 100) / 100.0d,
                Math.round((chooseMotivationalPartOrSalaryMonth(motivationalPart, salaryMonth) + shifts) * 100) / 100.0d);
    }

    /**
     * Определяем больше ли оклад, чем мотивационная часть
     */
    private double chooseMotivationalPartOrSalaryMonth(Double motivationalPart, Double salaryMonth) {
        log.info("SalaryCalculatorService.Определяем что больше motivationalPart : {} and salaryMonth : {}", motivationalPart, salaryMonth);
        return Math.max(salaryMonth, motivationalPart);
    }
}
