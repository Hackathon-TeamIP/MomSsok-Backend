package MomSsok.MomSsok.dto;

import lombok.*;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Integer id;
    private String username;
    private String email;


    // 필요시 비밀번호를 포함할 수 있지만, 보안을 위해 일반적으로 DTO에서는 제외합니다.
    // private String password;

    // 생성자, getter, setter 등을 필요에 따라 추가할 수 있습니다.
}
