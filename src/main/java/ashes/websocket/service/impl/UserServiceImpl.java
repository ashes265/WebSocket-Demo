package ashes.websocket.service.impl;

import ashes.websocket.model.User;
import ashes.websocket.model.request.RegisterUserReq;
import ashes.websocket.repository.UserRepo;
import ashes.websocket.service.UserService;
import ashes.websocket.utils.TransformUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo repo;

    @Override
    public void addUser(RegisterUserReq req) {
        try {
            String username = req.getUsername();
            Optional<User> opUser = repo.findByUsername(username);
            if (opUser.isPresent()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username have already exist: " + username);
            }
            User entity = new User();
            TransformUtils.copyPropertiesNotNull(req, entity);
            repo.save(entity);
            log.info("Add user successfully");
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }
}
