
package com.controller;

import com.model.dto.UserDTO;
import com.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

/**
 * This controller have methods to validate input data which seems like '/main.'
 * Created by Mandrake on 22.06.2018.
 */

@Controller
@RequestMapping("/user")
public class AuthenticationController {

    /**
     * Service for registration, authorization and deleting users
     */
    private UserService userService;

    /**
     * Setting user service for current controller
     * @param userService seated user service
     */
    @Autowired
    public void setUserService(final UserService userService) {
        this.userService = userService;
    }

    /**
     *
     * @param request HTTP request
     * @return
     */
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public ModelAndView register(final HttpServletRequest request) {

        return new ModelAndView("validate", "user", null);
    }

    /**
     * Return a name of error page
     * @param source Source of function, where was current error
     * @return
     */
    private ModelAndView errorPage(final String source) {
        ModelAndView modelAndView = new ModelAndView("invalidate");
        modelAndView.addObject("errorType", "SQL");
        modelAndView.addObject("errorSource", source);
        return modelAndView;
    }

    ///////////////////////////////////////////////////////////////////////////
    // DTO generation block
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Creating instance of User DTO
     * @param login user login
     * @param password user password
     * @param role user role
     * @return configured User DTO
     */
    public UserDTO createUserDTO(final String login, final String password, final String role) {
        return new UserDTO(null, login, password, Calendar.getInstance().getTime(), role);
    }

    /**
     * Creating instance of User DTO with default role
     * @param login user login
     * @param password user password
     * @return configured User DTO with default role
     */
    public UserDTO createUserDTO(final String login, final String password) {
        return createUserDTO(login, password, "user");
    }
}
