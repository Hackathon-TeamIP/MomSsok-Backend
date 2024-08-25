//package MomSsok.MomSsok.controller;
//
//import MomSsok.MomSsok.dto.UserDTO;
//import MomSsok.MomSsok.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/users")
//public class UserController {
//
//    private final UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    // 사용자 등록
//    @PostMapping
//    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
//        UserDTO createdUser = userService.registerUser(userDTO);
//        return ResponseEntity.ok(createdUser);
//    }
//
//    // 사용자 이름으로 사용자 찾기
//    @GetMapping("/username/{username}")
//    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username) {
//        Optional<UserDTO> userDTO = userService.findByUsername(username);
//        return userDTO.map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    // 이메일로 사용자 찾기
//    @GetMapping("/email/{email}")
//    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email) {
//        Optional<UserDTO> userDTO = userService.findByEmail(email);
//        return userDTO.map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    // 사용자 ID로 사용자 찾기
//    @GetMapping("/{id}")
//    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id) {
//        Optional<UserDTO> userDTO = userService.findById(id);
//        return userDTO.map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//}
