package com.toyproject.thecommerce.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
    private String loginId;
    private String password;
    private String nickName;
    private String name;
    private Long phone;
    private String email;
}
