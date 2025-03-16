package com.example.task_app_web.repository;


import com.example.task_app_web.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
public class InMemoryTaskRepository implements TaskRepository {

    private final List<Task> tasks = new ArrayList<>();

    @Override
    public List<Task> findAll() {
        log.debug("Call findAll in InMemoryTaskRepository");

        return tasks;
    }

    @Override
    public Optional<Task> findById(Long id) {
        log.debug("Call findById in InMemoryTaskRepository");

        return tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }

    @Override
    public Task save(Task task) {
        log.debug("Call save in InMemoryTaskRepository");

        task.setId(System.currentTimeMillis());
        tasks.add(task);

        return task;
    }

    @Override
    public Task update(Task task) {
        log.debug("Call update in InMemoryTaskRepository");

        Task existedTask = findById(task.getId()).orElse(null);
        if (existedTask != null) {
            existedTask.setPriority(task.getPriority());
            existedTask.setTitle(task.getTitle());
            existedTask.setDescription(task.getDescription());
        }

        return existedTask;
    }

    @Override
    public void deleteById(Long id) {
        log.debug("Call delete in InMemoryTaskRepository. ID is: {}", id);

        findById(id).ifPresent(tasks::remove);
    }

    @Override
    public void batchInsert(List<Task> tasks) {
        this.tasks.addAll(tasks);
    }
}
