package top.maple007.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRespository extends JpaRepository<Post, Integer> {
    public List<Post> findByTitle(String title);
}
