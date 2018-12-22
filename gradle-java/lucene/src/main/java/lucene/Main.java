package lucene;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todos")
class Todo {
    @Id
    public int id;
    
    public String content;
    
    @Column(name = "isfinished")
    public boolean isFinished;
}

interface TodoRepository extends CrudRepository<Todo, Integer> {
}

@SpringBootApplication
public class Main implements CommandLineRunner {
    @Autowired TodoRepository todoRepository;
    
    @Override
    public void run(String... args) {
        todoRepository.findAll().forEach(t -> {
            System.out.println(t.id + " " + t.content);
        });
    }
    
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
