package com.example.demo.configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.example.demo.domain.UserDto;

import lombok.Getter;

@Getter
public class SecurityUser extends User {
    
    private static final long serialVersionUID = 1L;

    private static final String ROLE_PREFIX = "ROLE_";

    private UserDto userDto;
    
    public SecurityUser(UserDto userDto) {
        super(userDto.getUsername() , userDto.getPassword(), makeGrantedAuthority(Arrays.asList("USER")));
        this.userDto = userDto;
    }

    private static List<GrantedAuthority> makeGrantedAuthority(List<String> roles) {
        List<GrantedAuthority> list = new ArrayList<>();
        roles.forEach(role -> list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role)));
        return list;
    }
}