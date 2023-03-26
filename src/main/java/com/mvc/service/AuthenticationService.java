package com.mvc.service;

import com.mvc.entity.Imperator;
import com.mvc.exception.AuthenticationServiceException;
import com.mvc.repository.ImperatorRepository;
import com.mvc.request.LoginRequest;
import com.mvc.request.RegisterRequest;
import com.mvc.responce.ImperatorResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class AuthenticationService {
    private ImperatorRepository imperatorRepository;
    private Imperator loggedImperator;

    public AuthenticationService(ImperatorRepository imperatorRepository) {
        this.imperatorRepository = imperatorRepository;
    }


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

    public void loginImperator(LoginRequest loginRequest) {
        String errorMassage = "Podano złe dane";
        Imperator imperator = imperatorRepository.findById(loginRequest.getName())
                .orElseThrow(()->new AuthenticationServiceException(errorMassage));

        if (!loginRequest.getPassword().equals(imperator.getPassword())) {
            throw new AuthenticationServiceException(errorMassage);
        }

        loggedImperator = imperator;

    }

    public Optional<ImperatorResponse> getLoggedImperatorResponse() {
        if (loggedImperator == null) {
            return Optional.empty();
        }
        ImperatorResponse imperatorResponse =
                new ImperatorResponse(loggedImperator.getName(),loggedImperator.getCredits());
        return Optional.of(imperatorResponse);
    }
}
