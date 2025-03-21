package com.example.task_app_web.repository.mapper;

import com.example.task_app_web.Task;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskRowMapper implements RowMapper<Task> {
    @Override
    public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
        Task task = new Task();

        task.setId(rs.getLong(Task.Fields.id));
        task.setTitle(rs.getString(Task.Fields.title));
        task.setDescription(rs.getString(Task.Fields.description));
        task.setPriority(rs.getInt(Task.Fields.priority));

        return task;
    }
}
