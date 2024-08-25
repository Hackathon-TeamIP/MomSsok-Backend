//package MomSsok.MomSsok.service;
//
//import MomSsok.MomSsok.domain.User;
//import MomSsok.MomSsok.dto.UserDTO;
//import MomSsok.MomSsok.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class UserService {
//
//    private final UserRepository userRepository;
//
//    @Autowired
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    // 사용자 등록
//    public UserDTO registerUser(UserDTO userDTO) {
//        User user = new User();
//        user.setUsername(userDTO.getUsername());
//        user.setEmail(userDTO.getEmail());
//
//
//        User savedUser = userRepository.save(user);
//        return convertToDTO(savedUser);
//    }
//
//    // 사용자 이름으로 사용자 찾기
//    public Optional<UserDTO> findByUsername(String username) {
//        return userRepository.findByUsername(username)
//                .map(this::convertToDTO);
//    }
//
//    // 이메일로 사용자 찾기
//    public Optional<UserDTO> findByEmail(String email) {
//        return userRepository.findByEmail(email)
//                .map(this::convertToDTO);
//    }
//
//    // 사용자 ID로 사용자 찾기
//    public Optional<UserDTO> findById(Integer id) {
//        return userRepository.findById(id)
//                .map(this::convertToDTO);
//    }
//
//    // User 엔티티를 UserDTO로 변환
//    private UserDTO convertToDTO(User user) {
//        UserDTO userDTO = new UserDTO();
//        userDTO.setId(user.getId());
//        userDTO.setUsername(user.getUsername());
//        userDTO.setEmail(user.getEmail());
//        // 비밀번호는 DTO에 포함하지 않음
//        return userDTO;
//    }
//}
