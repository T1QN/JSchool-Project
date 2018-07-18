package com.model.service;

import com.model.dto.UserDTO;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Mandrake on 03.07.2018.
 */
public interface UserService {
    /**
     * Creating new user in system
     * @param userDTO User Data
     * @return modified DTO for current user
     */
    @Transactional(isolation = Isolation.SERIALIZABLE)
    boolean registerUser(UserDTO userDTO);

    /**
     * Updating user data
     * @param user updated user data
     * @return updated user data
     */
    @Transactional
    UserDTO updateUserData(UserDTO user);

}
