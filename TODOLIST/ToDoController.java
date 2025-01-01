package ToDoList.demo.Controller;

import ToDoList.demo.Service.NewService;
import ToDoList.demo.model.ToDoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class ToDoController {

    @Autowired
    private NewService newService;

    @GetMapping
    public List<ToDoModel> GetAllTodo(){
        return newService.FindAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDoModel> GetById(@PathVariable int id){
        ToDoModel toDoModel = newService.FindToDoByID(id);
        if(toDoModel == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(toDoModel);
    }

    @PostMapping
    public ToDoModel addToDo(@RequestBody ToDoModel toDoModel){
        return newService.AddList(toDoModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDoModel> update(@PathVariable int id, @RequestBody ToDoModel toDoModel){
        ToDoModel updateTDo = newService.Update(id, toDoModel);
        if(updateTDo == null){
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(updateTDo);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> delete(@PathVariable int id){
        newService.DeleteToDo(id);
        return ResponseEntity.noContent().build();
    }
}
