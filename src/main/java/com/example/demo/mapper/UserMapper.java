package com.example.demo.mapper;

import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by molds086 on 2019/2/13.
 */
@Repository
public interface UserMapper {

    List<User> findAllUser();

    void save(User user);

    User findUserById(Integer id);

    void edit(User user);

    void delete(Integer id);
}
