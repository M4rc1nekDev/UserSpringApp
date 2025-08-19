package com.example.learnpostmanbasics.App;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {       // DODAWANIE UZYTKOWNIKA
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {       // WYSWIETLANIE WSZYSTKICH UZYTKOWNIKOW
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {    // WYSWIETLANIE UZYTKOWNIKOW PO ID
        return userRepository.findById(id);
    }


    public Optional<User> updateUser(Long id, int newAge, String newName, String newEmail) {   // ZMIANA IMION / WIEKU UZYTKOWNIKOW
        return userRepository.findById(id)
                .map( user -> {
                    if (newAge > 0) user.setAge(newAge);
                    if (newName !=null && !newName.isBlank()) user.setName(newName);
                    if (newEmail !=null && !newEmail.isBlank()) user.setEmail(newEmail);
                    return userRepository.save(user);
                });


    }


    public void deleteUser(Long id) {         // USUWANIE UZYTKOWNIKOW PO ID
        userRepository.deleteById(id);
    }
}

