package com.picpaysimplificado.picpaysimplificado.services;

import com.picpaysimplificado.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.picpaysimplificado.domain.user.UserType;
import com.picpaysimplificado.picpaysimplificado.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if (sender.getUserType() == UserType.MERCHANT) {
            throw new Exception(("Lojista não esta autorizado a realizar transação"));
        }

        if ((sender.getBalance().compareTo(amount) < 0)) {
            throw new Exception(("Saldo insuficiente"));

        }
    }

    public User findUserById(Long id) throws Exception {
        return this.userRepository.findUserById(id)
                .orElseThrow(() -> new Exception("Usuario não encontrado"));


    }

    public void saveUser(User user) {
        this.userRepository.save(user);
    }
}
