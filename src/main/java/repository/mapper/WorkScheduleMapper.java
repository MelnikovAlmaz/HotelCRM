package repository.mapper;

import entity.WorkSchedule;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class WorkScheduleMapper implements RowMapper<WorkSchedule> {

    @Override
    public WorkSchedule mapRow(ResultSet resultSet, int i) throws SQLException {
        WorkSchedule workSchedule = new WorkSchedule();
        workSchedule.setWeekday(resultSet.getInt("weekday"));
        workSchedule.setStartTime(resultSet.getTime("startTime"));
        workSchedule.setEndTime(resultSet.getTime("endTime"));
        workSchedule.setEmployeeId(resultSet.getInt("employeeId"));
        return workSchedule;
    }
}
