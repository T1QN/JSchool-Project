
package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by Mandrake on 22.06.2018.
 */

@Controller
public class MainController {
    /**
     * Method for validate input from main form login and password
     * @param request request from main form
     * @param response response to next page
     * @return
     */
    @RequestMapping("/main")
    public ModelAndView validate(final HttpServletRequest request, final HttpServletResponse response) {
        if (    request.getParameter("name").equalsIgnoreCase("admin")
                &&
                request.getParameter("password").equals("123")) {
            return new ModelAndView("validate", "message", "Authentication correct");
        } else {
            return new ModelAndView("invalidate", "message", "Authentication incorrect");
        }
    }
}
