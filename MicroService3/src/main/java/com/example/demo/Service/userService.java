package com.example.demo.Service;

import com.example.demo.Model.UserDetail;

public interface userService {
    public UserDetail saveUpdatePerson(UserDetail userDetail);
    public UserDetail findPersonById(Integer id);
}
