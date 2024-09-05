package com.juliana.workshop_mongo.services;

import com.juliana.workshop_mongo.domain.Post;
import com.juliana.workshop_mongo.domain.User;
import com.juliana.workshop_mongo.repositories.PostRepository;
import com.juliana.workshop_mongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }
}
