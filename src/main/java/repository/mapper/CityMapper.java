package repository.mapper;

import entity.City;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CityMapper implements RowMapper<City> {
    @Override
    public City mapRow(ResultSet resultSet, int i) throws SQLException {
        City city = new City();
        city.setId(resultSet.getInt("id"));
        city.setName(resultSet.getString("name"));
        return city;
    }
}
