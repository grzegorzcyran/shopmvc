package com.grcy.shopmvc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    private List<UserDto> users;
    private static int userId = 0;

    public UserDao() {
        this.users = new ArrayList<>();
    }

    public void saveUser(UserDto userDto) {
        users.add(userDto);
        userDto.setId(userId++);
        users.forEach(u -> System.out.println(u));
    }

    public List<UserDto> getAllUsers() {
        //kopiowanie do lokalnej listy i wyświetlenie tej kopii
        return users;
    }

    public void deleteUser(UserDto userDto) {
        users.remove(userDto);
    }

    public void deleteUserWithId(int userId) {
        List<UserDto> usersToRemove = users.stream()
                .filter(u -> userId == u.getId())
                .collect(Collectors.toList());
        users.removeAll(usersToRemove);
    }

    public void updateUser(UserDto userDto){
        users.stream()
                .filter(u -> userDto.getId() == u.getId())
                .forEach(x -> {x.setName(userDto.getName());
                            x.setSurname(userDto.getSurname());});

    }
}
