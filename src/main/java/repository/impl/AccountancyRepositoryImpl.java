package repository.impl;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import repository.AccountancyRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountancyRepositoryImpl implements AccountancyRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Double> findOrderMonthIncomeByHotelId(Integer hotelId, Integer year, Integer month) {
        String SQL = "SELECT * FROM order_income_month(?, ?, ?)";
        final List<Double> orderIncomeMonth = new ArrayList<>(31);
        for (int i = 0; i < 31; i++){
            orderIncomeMonth.add(0.0);
        }
        jdbcTemplate.query(SQL, new Object[]{hotelId, month, year}, new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                Double income = resultSet.getDouble("income");
                Double day = resultSet.getDouble("day");
                orderIncomeMonth.set((int)day.doubleValue(), income);
                return null;
            }
        });
        return orderIncomeMonth;
    }

    @Override
    public List<Double> findOrderYearIncomeByHotelId(Integer hotelId, Integer year) {
        String SQL = "SELECT * FROM order_income_year(?, ?)";
        final List<Double> orderIncomeMonth = new ArrayList<>(31);
        for (int i = 0; i < 12; i++){
            orderIncomeMonth.add(0.0);
        }
        jdbcTemplate.query(SQL, new Object[]{hotelId, year}, new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                Double income = resultSet.getDouble("income");
                Double month = resultSet.getDouble("month");
                orderIncomeMonth.set((int)month.doubleValue() - 1, income);
                return null;
            }
        });
        return orderIncomeMonth;
    }
}
