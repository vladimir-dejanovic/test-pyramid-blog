package xyz.itshark.blog.testpyramid.testpyramid.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.itshark.blog.testpyramid.testpyramid.pojo.Post;
import xyz.itshark.blog.testpyramid.testpyramid.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class PostServiceTest {

    @Mock
    PostRepository postRepository;

    @InjectMocks
    PostService postService = new PostService();

    @BeforeEach
    void setUp() {
        List<Post> list = new ArrayList<>();

        Post post = new Post();
        post.setTitle("title 1");
        list.add(post);

        Mockito.when(postRepository.findAll()).thenReturn(list);
    }

    @Test
    void getAllPosts() {
        List<Post> list = postService.getAllPosts();

        Assertions.assertEquals(1,list.size());
        Assertions.assertEquals("title 1", list.get(0).getTitle());
    }
}