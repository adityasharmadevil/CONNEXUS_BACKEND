package com.iilm.CONNEXUS.modle;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Getter
@Setter
@Data
@Document(collection = "users")
public class User {
    @Id
    private ObjectId id;

    private String username;  // 7-char unique
    private String email;
    private String phone;
    private String passwordHash;
    private String name;
    private boolean status;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createdAt;

}
