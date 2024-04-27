package com.toyproject.thecommerce.dto;

import com.toyproject.thecommerce.entity.Member;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {
    private String loginId;
    private String password;
    private String nickName;
    private String name;
    private Long phone;
    private String email;

    public Member PostRequestToEntity(String encryptPassword) {
        return Member.builder()
                .loginId(this.loginId)
                .password(encryptPassword)
                .nickName(this.nickName)
                .name(this.name)
                .phone(this.phone)
                .email(this.email)
                .build();
    }
}
