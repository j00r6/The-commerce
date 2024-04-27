package com.toyproject.thecommerce.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column
    private String loginId;

    @Column
    private String password;

    @Column
    private String nickName;

    @Column
    private String name;

    @Column
    private Long phone;

    @Column
    private String email;

    @Column
    private LocalDateTime createdAt;
}
