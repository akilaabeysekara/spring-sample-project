package lk.ijse.auth_backend.controller;

import lk.ijse.auth_backend.dto.APIResponse;
import lk.ijse.auth_backend.dto.AuthDTO;
import lk.ijse.auth_backend.dto.RegisterDTO;
import lk.ijse.auth_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@CrossOrigin
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    @PostMapping("signup")
    public ResponseEntity<APIResponse>saveUser(@RequestBody RegisterDTO registerDTO){
        return ResponseEntity.ok(new APIResponse(
                200,"User registered successfully",userService.saveUser(registerDTO)));

    }
    @PostMapping("signin")
    public ResponseEntity<APIResponse>loginUser(@RequestBody AuthDTO authDTO){
        return ResponseEntity.ok(new APIResponse(
                200,"User authenticated successfully",userService.authenticate(authDTO)));

    }
}