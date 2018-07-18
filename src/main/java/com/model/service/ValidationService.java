package com.model.service;

import com.model.dto.UserDTO;

/**
 * Created by Mandrake on 06.07.2018.
 */
public interface ValidationService {

    boolean validateUser(UserDTO userDTO);
}
