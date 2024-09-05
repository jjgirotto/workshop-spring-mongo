package com.juliana.workshop_mongo.resources;

import com.juliana.workshop_mongo.domain.Post;
import com.juliana.workshop_mongo.domain.User;
import com.juliana.workshop_mongo.dto.UserDTO;
import com.juliana.workshop_mongo.services.PostService;
import com.juliana.workshop_mongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    @Autowired
    private PostService postService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET) //ou @GetMapping
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = postService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
