package com.iilm.CONNEXUS.repository;

import com.iilm.CONNEXUS.user.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserEntryRepo extends MongoRepository<User, ObjectId>{
    Optional<User> findByUserId(ObjectId userId);

    void deleteByUserId(ObjectId userId);
}
