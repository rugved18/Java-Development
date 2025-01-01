package ToDoList.demo.Service;

import ToDoList.demo.Repo.ToDoRepo;
import ToDoList.demo.model.ToDoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewService {

    @Autowired
    private ToDoRepo toDoRepo;

    public List<ToDoModel> FindAll(){
        return toDoRepo.findAll();
    }

    public ToDoModel FindToDoByID(int id){
        return toDoRepo.findById(id).orElse(null);
    }

    public ToDoModel AddList(ToDoModel toDoModel){
       return  toDoRepo.save(toDoModel);
    }

    public ToDoModel Update(int id, ToDoModel toDoModel){
        ToDoModel existingToDo = toDoRepo.findById(id).orElse(null);
        if(existingToDo == null){
            return null;
        }
        existingToDo.setTitle(toDoModel.getTitle());
        existingToDo.setDescription(toDoModel.getDescription());
        existingToDo.setCompleted(toDoModel.getCompleted());
        return toDoRepo.save(existingToDo);
    }

    public void DeleteToDo(int id){
        toDoRepo.deleteById(id);
    }
}
