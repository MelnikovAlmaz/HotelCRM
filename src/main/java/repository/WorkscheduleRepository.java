package repository;

import entity.WorkSchedule;

import java.sql.Time;
import java.util.List;

public interface WorkscheduleRepository {
    WorkSchedule findWorkScheduleById(Integer id);
    void update(Integer weekday, Time startTime, Time endTime, Integer employeeId);
    List<WorkSchedule> findAllWorkSchedules();

    List<WorkSchedule> findWorkScheduleByEmployeeId(Integer id);
}
