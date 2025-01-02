package ToDoList.demo.Controller;

import ToDoList.demo.Service.NewService;
import ToDoList.demo.model.ToDoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NewController {

    @Autowired
    private NewService newService;

    @GetMapping
    public List<ToDoModel> allList(){
        return newService.FindAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDoModel> FindById(@PathVariable int id){
        ToDoModel toDoModel = newService.FindToDoByID(id);
        if(toDoModel == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(toDoModel);
    }

    @PostMapping
    public ToDoModel AddList(@RequestBody ToDoModel toDoModel){
       return newService.AddList(toDoModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDoModel> UpdateToDo(@PathVariable int id, @RequestBody ToDoModel toDoModel){
        ToDoModel newTodo = newService.Update(id,toDoModel);

        if(newTodo == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(newTodo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteToDo(@PathVariable int id){
        newService.DeleteToDo(id);
        return ResponseEntity.noContent().build();
    }
}
