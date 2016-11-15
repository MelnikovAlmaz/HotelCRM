package service;

import org.joda.time.LocalDate;

import java.util.List;

public interface AccountancyService {
    List<Double> findMonthIncomeByHotelId(Integer hotelId, Integer year, Integer month);

    List<Double> findYearIncomeByHotelId(Integer hotelId, Integer year);

    List<List<Double>> findEachMonthYearIncomeByHotelId(Integer hotelId, Integer year);
}
