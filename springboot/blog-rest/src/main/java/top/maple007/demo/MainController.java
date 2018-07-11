package top.maple007.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MainController {
    @Autowired
    private PostRespository postRespository;

    @GetMapping("/posts")
    public List<Post> main() {
        return postRespository.findAll();
    }

    @PostMapping("/posts")
    public Post addPost(@RequestParam("id") Integer id, @RequestParam("title") String title, @RequestParam("content") String content) {
        Post post = new Post();
        post.setId(id);
        post.setTitle(title);
        post.setContent(content);

        return postRespository.save(post);
    }

    @GetMapping("/posts/{id}")
    public Optional<Post> findPostByID(@PathVariable("id") Integer id) {
        return postRespository.findById(id);
    }
    
    @GetMapping("/posts/title/{title}")
    public List<Post> findPostByTitle(@PathVariable("title") String title) {
        return postRespository.findByTitle(title);
    }
    
    @PutMapping("/posts/{id}")
    public Post updatePost(@PathVariable Integer id, @RequestParam String title, @RequestParam String content) {
        Post post = new Post();
        post.setId(id);
        post.setTitle(title);
        post.setContent(content);
        
        return postRespository.save(post);
    }
    
    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable("id") Integer id) {
        postRespository.deleteById(id);
    }
}
