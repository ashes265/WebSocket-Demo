package ashes.websocket.controller;

import ashes.websocket.model.request.RegisterUserReq;
import ashes.websocket.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("add")
    public String add(@Valid @RequestBody RegisterUserReq req) {
        userService.addUser(req);
        return "Add successfully!!";
    }
}
