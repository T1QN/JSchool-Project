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
    UserDTO registerUser(UserDTO userDTO);

    /**
     * Authorize current user in system
     * @param userDTO User Data
     * @return modified DTO for current user
     */
    @Transactional(isolation = Isolation.READ_COMMITTED)
    UserDTO loginUser(UserDTO userDTO);
}
