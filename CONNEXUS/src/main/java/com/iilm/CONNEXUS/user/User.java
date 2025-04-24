package com.iilm.CONNEXUS.user;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@Document(collection = "users")
public class User {
    @Id
    private ObjectId id;

    private String userId;  // 7-char unique
    private String email;
    private String phone;
    private String passwordHash;
    private String name;
    private String status;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createdAt;

}
