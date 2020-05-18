package com.tippers.containment.live.service;

import com.tippers.containment.live.controller.dto.UserDto;
import com.tippers.containment.live.controller.exception.UserNotFoundException;
import com.tippers.containment.live.mapper.UsersMapper;
import com.tippers.containment.live.repository.model.postgres.Users;
import com.tippers.containment.live.repository.postgres.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class UsersService {

    private UsersRepository usersRepository;
    private UsersMapper usersMapper;

    @Autowired
    public UsersService(UsersRepository usersRepository,
                        UsersMapper usersMapper) {
        this.usersRepository = usersRepository;
        this.usersMapper = usersMapper;
    }

    public List<UserDto> getAllUsers() {

        List<Users> allUsers = usersRepository.findAll();
        return allUsers.stream()
                .map(user -> usersMapper.toDto(user))
                .collect(toList());
    }

    public UserDto saveUser(UserDto newUser) {

        Users user = usersMapper.toModel(newUser);
        Users savedUser = usersRepository.save(user);
        return usersMapper.toDto(savedUser);
    }

    public UserDto findUserById(Long userId) {

        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(String.format("User not found : userId=%s", userId)));
        return usersMapper.toDto(user);
    }

    public UserDto replaceUserById(Long userId, UserDto newUser) {

        Users user = usersRepository.save(
                usersRepository.findById(userId)
                        .map(users -> {
                            users.setUsername(newUser.getUsername());
                            users.setJob(newUser.getJob());
                            users.setAge(newUser.getAge());
                            return users;
                        })
                        .orElseGet(() -> {
                            Users users = usersMapper.toModel(newUser);
                            users.setUserId(userId);
                            return users;
                        })
        );
        return usersMapper.toDto(user);
    }

    public void deleteUserById(Long userId) {
        usersRepository.deleteById(userId);
    }

    public UserDto findUserByUsername(String username) {
        Users user = usersRepository.getByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("User not found with username = " + username);
        }
        return usersMapper.toDto(user);
    }
}
