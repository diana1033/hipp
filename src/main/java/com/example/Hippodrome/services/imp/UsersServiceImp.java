package com.example.Hippodrome.services.imp;

import com.example.Hippodrome.entities.Users;
import com.example.Hippodrome.rep.UsersRepository;
import com.example.Hippodrome.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImp implements UsersService {

    private UsersRepository repository;
    private Users users;

    @Autowired
    public UsersServiceImp(UsersRepository repository) {
        this.repository = repository;
    }

    @Override
    public Users save(Users t) {
        return repository.save(t);
    }

    @Override
    public Users findById(Long id) {
        return repository.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Users update(Long id, Users users) {
        Users users1 = findById(id);

        users1.setName(users.getName());
        users1.setLastName(users.getLastName());
        users1.setAge(users.getAge());
        users1.setNickname(users.getNickname());
        users1.setPassword(users.getPassword());

        return save(users1);
    }

    @Override
    public List<Users> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean checkNameAndPassword(String nickName, String password) {
        users = repository.findUsersByNicknameAndPassword(nickName,password);
        return repository.findUsersByNickName(nickName,password);
    }

    @Override
    public Users getUser() {
        return this.users;
    }
}
