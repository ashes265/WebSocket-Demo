package ashes.websocket.service;

import ashes.websocket.model.User;
import ashes.websocket.model.request.RegisterUserReq;

public interface UserService {
    void addUser(RegisterUserReq req);
}
