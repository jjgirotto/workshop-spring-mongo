package com.juliana.workshop_mongo.services;

import com.juliana.workshop_mongo.domain.User;
import com.juliana.workshop_mongo.dto.UserDTO;
import com.juliana.workshop_mongo.repositories.UserRepository;
import com.juliana.workshop_mongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public User insert(User obj) {
        return userRepository.insert(obj);
    }

    public User fromDTO (UserDTO objDTO) {
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }
}
