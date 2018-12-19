package top.maple007.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRespository postRespository;
    
    public void insertTwo() {
        Post post1 = new Post();
        post1.setId(1000);
        post1.setTitle("1000 post");
        post1.setContent("post content");
        postRespository.save(post1);
        
        Post post2 = new Post();
        post2.setId(1001);
        post2.setTitle("1001 post");
        post2.setContent("post content");
        postRespository.save(post2);
    }
}
