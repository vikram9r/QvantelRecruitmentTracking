package com.qvantel.web.controller;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.qvantel.dao.RoleDAO;
import com.qvantel.dao.UserDAO;
import com.qvantel.model.Role;
import com.qvantel.model.User;

@Controller
public class UserController {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private RoleDAO roleDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping(value="/user/new")
	public ModelAndView newUser() {
		ModelAndView model = new ModelAndView("user/user");
		model.addObject("user", new User());
		model.addObject("rolesList", roleDAO.getAll());
		return model;
	}
	
	@RequestMapping(value="/user/newRole")
	public ModelAndView newRole() {
		ModelAndView model = new ModelAndView("user/role");
		model.addObject("role", new Role());
		return model;
	}
	
	//to convert the roles(multiple select) from user.jsp to Set<Role> before submiting the request to '/createUser'
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Set.class, "roles", new CustomCollectionEditor(Set.class)
          {
            @Override
            protected Object convertElement(Object element)
            {
                Integer id = null;

                if(element instanceof String && !((String)element).equals("")){
                    //From the JSP 'element' will be a String
                    try{
                        id = Integer.valueOf((String) element);
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Element was " + ((String) element));
                        e.printStackTrace();
                    }
                }
                else if(element instanceof Long) {
                    //From the database 'element' will be a Long
                    id = (Integer) element;
                }

                return id != null ? roleDAO.get(id) : null;
            }
          });
    }
	
	
	@RequestMapping(value="/user/create", method = RequestMethod.POST)
	public ModelAndView createUser(@ModelAttribute("user")User user) {
		ModelAndView model = new ModelAndView("home");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userDAO.create(user);
		return model;
	}
	
	@RequestMapping(value="/user/createRole")
	public ModelAndView createRole(@ModelAttribute("user")Role role) {
		ModelAndView model = new ModelAndView("home");
		role.setRoleName(role.getRoleName().toUpperCase());
		role.setCreatedBy(SecurityContextHolder.getContext().getAuthentication().getName());
		role.setCreatedDate(new Date());
		roleDAO.create(role);
		return model;
	}
}
