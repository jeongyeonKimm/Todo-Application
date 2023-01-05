package webdev.todo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webdev.todo.model.TodoEntity;
import webdev.todo.persistence.TodoRepository;

import java.util.List;

@Slf4j
@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public String testService() {
        TodoEntity entity = TodoEntity.builder().title("My first todo item").build();
        todoRepository.save(entity);
        TodoEntity savedEntity = todoRepository.findById(entity.getId()).get();
        return savedEntity.getTitle();
    }

    public List<TodoEntity> create(final TodoEntity entity) {
        //Validations
        validate(entity);

        todoRepository.save(entity);

        log.info("Entity Id : {} is saved.", entity.getId());

        return todoRepository.findByUserId(entity.getUserId());
    }

    private void validate(TodoEntity entity) {
        if (entity == null) {
            log.warn("Entity cannot be null.");
            throw new RuntimeException("Entity cannot be null.");
        }

        if (entity.getUserId() == null) {
            log.warn("Unknown user.");
            throw new RuntimeException("Unknown user.");
        }
    }
}
