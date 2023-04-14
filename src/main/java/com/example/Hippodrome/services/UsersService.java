package com.example.Hippodrome.services;

import com.example.Hippodrome.entities.Users;

public interface UsersService extends BaseService<Users>{
    boolean checkNameAndPassword(String nickName, String password);

    Users getUser();
}
