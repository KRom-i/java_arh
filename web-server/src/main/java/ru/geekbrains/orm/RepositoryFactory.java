package ru.geekbrains.orm;

import ru.geekbrains.entity.User;

public class RepositoryFactory {

    public static Repository<User> createUserRepository () {
        return new RepositoryImpl<> (User.class);
    }
}
