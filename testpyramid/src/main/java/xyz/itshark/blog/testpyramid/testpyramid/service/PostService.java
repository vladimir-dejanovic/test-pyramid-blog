package xyz.itshark.blog.testpyramid.testpyramid.service;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.itshark.blog.testpyramid.testpyramid.pojo.Post;
import xyz.itshark.blog.testpyramid.testpyramid.repository.PostRepository;

import java.util.List;

@Service
public class PostService {

    @Resource
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post addPost(Post post) {
        return postRepository.save(post);
    }
}
