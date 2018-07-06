package com.model.service.impl;

import com.model.dto.UserDTO;
import com.model.service.ValidationService;
import org.springframework.stereotype.Service;

/**
 * Created by Mandrake on 06.07.2018.
 */
@Service("validationService")
public class ValidationServiceImpl implements ValidationService {

    /**
     * Minimal length of password
     */
    private static final int MIN_PASSWORD_LENGTH = 6;

    /**
     * Validate input data to correct values
     * @param userDTO
     * @return
     */
    @Override
    public UserDTO validate(final UserDTO userDTO) {
        boolean validate =
                !userDTO.getLogin().equals("")
                && userDTO.getPassword().length() > MIN_PASSWORD_LENGTH;
        userDTO.setValidate(validate);
        return userDTO;
    }
}
