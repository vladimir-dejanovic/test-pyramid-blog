package xyz.itshark.blog.testpyramid.testpyramid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.itshark.blog.testpyramid.testpyramid.pojo.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
}
