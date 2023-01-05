package webdev.todo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import webdev.todo.model.TodoEntity;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, String> {
    //List<TodoEntity> findByUserId(String userId);

    @Query("select * from Todo t where t.userId = ?1")
    List<TodoEntity> findByUserId(String userId);
}
