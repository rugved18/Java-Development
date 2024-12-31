//Service model
package ToDoList.demo.Service;

import ToDoList.demo.Repo.ToDoRepo;
import ToDoList.demo.model.ToDoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepo toDoRepo;

    public List<ToDoModel> getAllInfo() {
        return toDoRepo.findAll();
    }

    public  ToDoModel getItById(int id) {
        return toDoRepo.findById(id).orElse(null);
    }

    public ToDoModel AddList(ToDoModel toDoModel){
       return toDoRepo.save(toDoModel);
    }

    public ToDoModel UpdateToDo(int id, ToDoModel toDoModel){
        ToDoModel ToDoExisting = toDoRepo.findById(id).orElse(null);
        if(ToDoExisting == null){
            return null;
        }
        ToDoExisting.setTitle(toDoModel.getTitle());
        ToDoExisting.setDescription(toDoModel.getDescription());
        ToDoExisting.setCompleted(toDoModel.getCompleted());

        return toDoRepo.save(ToDoExisting);
    }

    public  void DeleteById(int id){
         toDoRepo.deleteById(id);

    }
}
