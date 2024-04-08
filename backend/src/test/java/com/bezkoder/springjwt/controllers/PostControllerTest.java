package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Post;
import com.bezkoder.springjwt.services.FileStorageService;
import com.bezkoder.springjwt.services.PostService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostControllerTest {

    @Mock
    private PostService postService;

    @Mock
    private FileStorageService fileStorageService;

    @InjectMocks
    private PostController postController;

    private final MockMvc mockMvc;

    public PostControllerTest() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(postController).build();
    }

    @Test
    void savePostTest() throws Exception {
        Post post = new Post();
        post.setTitle("Test Post");
        post.setPrix(100000);
        post.setType("House");
        post.setDescription("This is a test post description.");
        post.setLieu("Test Location");
        post.setImages(Collections.emptyList());
        post.setTempsPub(LocalDateTime.now());
        post.setTypeDeTransaction("Sale");
        post.setSuperficie(150);
        post.setSallesDeBains(2);
        post.setChambres(3);
        post.setUser_id(1);

        MockMultipartFile imageFile = new MockMultipartFile("imageFile", "test.jpg", MediaType.IMAGE_JPEG_VALUE, "test".getBytes());
        when(fileStorageService.saveFile(any())).thenReturn("/com/bezkoder/springjwt/uploads/test.jpg");

        mockMvc.perform(MockMvcRequestBuilders.multipart("/post")
                        .file(imageFile)
                        .param("post", new ObjectMapper().writeValueAsString(post))
                        .contentType(MediaType.MULTIPART_FORM_DATA))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
