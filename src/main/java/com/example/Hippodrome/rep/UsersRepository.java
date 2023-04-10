package com.example.Hippodrome.rep;

import com.example.Hippodrome.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsersRepository extends JpaRepository<Users, Long> {
    @Query(value = "\n"+
            "select CASE WHEN COUNT(user) > 0 THEN true ELSE false END\n" +
            "from user \n" +
            "WHERE user.nickname=:nickName AND user.password=:password", nativeQuery = true)
    boolean findUsersByNickName(String nickName,String password);
}
