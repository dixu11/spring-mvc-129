package com.mvc.service;

import com.mvc.entity.Imperator;
import com.mvc.exception.AuthenticationServiceException;
import com.mvc.repository.ImperatorRepository;
import com.mvc.request.RegisterRequest;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private ImperatorRepository imperatorRepository;

    public AuthenticationService(ImperatorRepository imperatorRepository) {
        this.imperatorRepository = imperatorRepository;
    }

    @Transactional
    public void createImperator(RegisterRequest request) {
        if (request.getPassword1().length() <= 5) {
            throw new AuthenticationServiceException("Hasło minimum 6 znaków!");
        }
        if (!request.getPassword1().equals(request.getPassword2())) {
            throw new AuthenticationServiceException("Podano różne hasła");
        }
        if(imperatorRepository.existsById(request.getImperatorName())){
            throw new AuthenticationServiceException("Ta nazwa jest już zajęta!");
        }

        Imperator imperator = new Imperator(request.getImperatorName(), request.getPassword1());
        imperatorRepository.save(imperator);
    }

}
