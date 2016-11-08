package repository.mapper;

import entity.City;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CityMapper implements RowMapper<City> {
    @Override
    public City mapRow(ResultSet resultSet, int i) throws SQLException {
        City city = new City();
        city.setId(resultSet.getInt("id"));
        city.setName(resultSet.getString("name"));
        return city;
    }
}
