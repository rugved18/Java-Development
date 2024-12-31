//Model
package ToDoList.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ToDoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String Title;
    String Description;
    String Completed;

    public ToDoModel() {
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public String getCompleted() {
        return Completed;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setCompleted(String completed) {
        Completed = completed;
    }

    public ToDoModel(int id, String title, String description, String completed) {
        this.id = id;
        Title = title;
        Description = description;
        Completed = completed;
    }
}
