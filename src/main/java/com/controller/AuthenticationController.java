
package com.controller;

import com.model.entity.User;
import com.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Calendar;


/**
 * This controller have methods to validate input data which seems like '/main.'
 * Created by Mandrake on 22.06.2018.
 */

@Controller
@RequestMapping("user")
public class AuthenticationController {
    /**
     *
     */
    @Autowired
    private UserService userService;

    /**
     *
     * @param service
     */
    public void setUserService(UserService service) {
        this.userService = service;
    }
    /**
     *
     * @param request HTTP request
     * @return
     */
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ModelAndView add(final HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        /* Incorrect.
         * Need realize DI and IoC to anything "UserFactory"
         *
         */
        try {
            User newUser = new User();
            newUser.setLogin(login);
            newUser.setPassword(password);
            newUser.setRegistration(Calendar.getInstance().getTime());
            newUser.setType(new UserType("user"));
            userService.add(newUser);
        } catch (SQLException exp) {
            return errorPage("Add new user");
        }
        return new ModelAndView("validate", "user", login);
    }

    /**
     * Method for validate input from main form login and password
     * @param request request from main form
     * @return
     */
    @RequestMapping("/validate")
    public ModelAndView validate(final HttpServletRequest request) {
        if (    request.getParameter("name").equalsIgnoreCase("admin")
                &&
                request.getParameter("password").equals("123")) {
            return new ModelAndView("validate", "message", "Authentication correct");
        } else {
            return new ModelAndView("invalidate", "message", "Authentication incorrect");
        }
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
}
