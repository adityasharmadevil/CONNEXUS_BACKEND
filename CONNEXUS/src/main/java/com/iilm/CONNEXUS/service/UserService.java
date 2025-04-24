package com.iilm.CONNEXUS.service;

import com.iilm.CONNEXUS.repository.UserEntryRepo;
import com.iilm.CONNEXUS.user.User;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {

    private UserEntryRepo userEntryRepo;

    public User createUser(User user) {
        return userEntryRepo.save(user);
    }

    public List<User> getAllUsers() {
        return userEntryRepo.findAll();
    }

    public Optional<User> getUserByUserId(ObjectId userId) {
        return userEntryRepo.findByUserId(userId);
    }

    public User updateUser(ObjectId userId, User updatedUser) {
        Optional<User> existing = userEntryRepo.findByUserId(userId);
        if (existing.isPresent()) {
            User user = existing.get();
            user.setEmail(updatedUser.getEmail());
            user.setPhone(updatedUser.getPhone());
            user.setName(updatedUser.getName());
            user.setStatus(updatedUser.getStatus());
            // optionally update passwordHash
            return userEntryRepo.save(user);
        } else {
            throw new RuntimeException("User with ID " + userId + " not found");
        }

        }
        public void deleteUser(ObjectId userId) {
        userEntryRepo.deleteByUserId(userId);
    }
}
