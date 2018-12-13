package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;


import java.util.ArrayList;
import java.util.List;

public class FakeModel implements Model {
    @Override
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }

    private ModelData modelData = new ModelData();
    @Override
    public ModelData getModelData() {
        return modelData;
    }
    @Override
    public void loadUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("A", 1, 1));
        users.add(new User("B", 2, 1));
        modelData.setUsers(users);
    }
}
