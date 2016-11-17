package repository.impl;

import entity.WorkSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import repository.WorkscheduleRepository;
import repository.mapper.WorkScheduleMapper;

import java.sql.Time;
import java.util.List;

@Repository
public class WorkScheduleRepositoryImpl implements WorkscheduleRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private WorkScheduleMapper workScheduleMapper;

    @Override
    public WorkSchedule findWorkScheduleById(Integer id) {
        String SQL = "SELECT * FROM WorkSchedule WHERE id = ?";
        WorkSchedule workSchedule = jdbcTemplate.queryForObject(SQL, new Object[]{id}, workScheduleMapper);
        return workSchedule;
    }

    @Override
    public void update(Integer weekday, Time startTime, Time endTime, Integer employeeId) {
        String SQL = "UPDATE WorkSchedule SET weekday = ?, startTime = ?, endTime = ?, employeeId = ? WHERE weekday = ? and employeeId = ?";
        jdbcTemplate.update( SQL, weekday, startTime, endTime, employeeId, weekday, employeeId);
    }

    @Override
    public List<WorkSchedule> findAllWorkSchedules() {
        String SQL = "SELECT * FROM WorkSchedule ORDER BY weekday ASC";
        List<WorkSchedule> workSchedules = jdbcTemplate.query(SQL, workScheduleMapper);
        return workSchedules;
    }

    @Override
    public List<WorkSchedule> findWorkScheduleByEmployeeId(Integer id) {
        String SQL = "SELECT * FROM WorkSchedule WHERE employeeId = ? ORDER BY weekday ASC";
        List<WorkSchedule> workSchedules = jdbcTemplate.query(SQL, new Object[]{id}, workScheduleMapper);
        return workSchedules;
    }
}
