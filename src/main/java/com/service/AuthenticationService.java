package com.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Mandrake on 25.06.2018.
 */
@Service
@Scope("singleton")
public class AuthenticationService {

    /**
     * Validate input data on correct rules.
     * @param login entered login
     * @param password entered password
     * @return model and view instance for validation result
     */
    public ModelAndView validate(String login, String password) {
        return null;
    }
}
