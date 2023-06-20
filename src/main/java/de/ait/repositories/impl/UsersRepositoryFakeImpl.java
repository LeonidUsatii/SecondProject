package de.ait.repositories.impl;

import de.ait.models.User;
import de.ait.repositories.UsersRepository;



public class UsersRepositoryFakeImpl implements UsersRepository {
    @Override
    public void save(User model) {

    }

    @Override
    public User findById(String id) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        if (email.equals("user@gmail.com")) {
            return new User(
                    "b99ec11f-a78e-42ab-96ac-6a8817aa91ef",
                    "user@gmail.com",
                    "qwerty007"
            );
        }
        return null;
    }
}
