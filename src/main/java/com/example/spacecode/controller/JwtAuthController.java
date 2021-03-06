package com.example.spacecode.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.spacecode.model.Role;
import com.example.spacecode.model.User;
import com.example.spacecode.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
public class JwtAuthController {

    @Autowired
    private AuthService authService;

    // login
    @RequestMapping(value = "/authentication/login", method = RequestMethod.POST)
    public JSONObject createToken(@RequestBody Map<String, String> map ) throws AuthenticationException {
    	if(map.containsKey("username") && (map.containsKey("password"))){
            return authService.login(map.get("username"),map.get("password"));
        }
        return null;
    }

    // register
    @RequestMapping(value = "/authentication/register", method = RequestMethod.POST)
    public User register(@RequestBody Map<String, String> map ) throws AuthenticationException {


        if(map.containsKey("username") && (map.containsKey("password"))){

            User addedUser = new User(map.get("username"),map.get("password"));
            return authService.register(addedUser);
        }
        return null;

    }
}
