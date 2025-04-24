package com.iilm.CONNEXUS.util;

import org.springframework.stereotype.Component;

@Component
public class PasswordUtil {
    public String hashPassword(String passwordHash) {

        return passwordHash;
    };
    //Same Function that was use in frontend where the password is converted into hascode
}

