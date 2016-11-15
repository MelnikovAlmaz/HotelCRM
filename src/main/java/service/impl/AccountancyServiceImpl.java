package service.impl;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AccountancyRepository;
import service.AccountancyService;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountancyServiceImpl implements AccountancyService{
    @Autowired
    private AccountancyRepository accountancyRepository;

    @Override
    public List<Double> findMonthIncomeByHotelId(Integer hotelId, Integer year, Integer month) {
        List<Double> incomeMonth = accountancyRepository.findOrderMonthIncomeByHotelId(hotelId, year, month);
        //TODO add mealOrderIncome
        return incomeMonth;
    }

    @Override
    public List<Double> findYearIncomeByHotelId(Integer hotelId, Integer year) {
        List<Double> incomeYear = accountancyRepository.findOrderYearIncomeByHotelId(hotelId, year);
        //TODO add mealOrderIncome
        return incomeYear;
    }

    @Override
    public List<List<Double>> findEachMonthYearIncomeByHotelId(Integer hotelId, Integer year) {
        List<List<Double>> yearIncome = new ArrayList<>(31);
        for (int i = 0; i < 31; i++) {
            yearIncome.add(new ArrayList<Double>(12));
        }
        for (int i = 0; i < 12; i++) {
            List<Double> month = findMonthIncomeByHotelId(hotelId, year, i + 1);
            for (int j = 0; j < month.size(); j++) {
                yearIncome.get(j).add(i, month.get(j));
            }
        }
        return yearIncome;
    }
}
