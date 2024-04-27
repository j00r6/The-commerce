package com.toyproject.thecommerce.dto;

import com.toyproject.thecommerce.entity.Member;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatchRequest {
    private String loginId;
    private String password;
    private String nickName;
    private String name;
    private Long phone;
    private String email;
}
