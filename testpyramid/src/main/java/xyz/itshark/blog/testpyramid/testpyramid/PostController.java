package xyz.itshark.blog.testpyramid.testpyramid;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.itshark.blog.testpyramid.testpyramid.pojo.Post;
import xyz.itshark.blog.testpyramid.testpyramid.service.PostService;

import java.util.List;

@RestController
public class PostController {

    @Resource
    private PostService postService;

    @GetMapping(path="/posts")
    List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping(path = "/posts", consumes = "application/json", produces = "application/json")
    Post addPost(@RequestBody Post post) {
        return postService.addPost(post);
    }
}
