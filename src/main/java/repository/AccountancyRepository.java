package repository;

import org.joda.time.LocalDate;

import java.util.List;

public interface AccountancyRepository {
    List<Double> findOrderMonthIncomeByHotelId(Integer hotelId, Integer year, Integer month);

    List<Double> findOrderYearIncomeByHotelId(Integer hotelId, Integer year);
}
