package ToDoList.demo.Repo;

import ToDoList.demo.model.ToDoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepo extends JpaRepository<ToDoModel,Integer> {

}
