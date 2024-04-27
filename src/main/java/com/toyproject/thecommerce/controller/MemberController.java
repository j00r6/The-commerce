package com.toyproject.thecommerce.controller;

import com.toyproject.thecommerce.dto.PostRequest;
import com.toyproject.thecommerce.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService service;
    @PostMapping("/join")
    public ResponseEntity joinMember(@RequestBody PostRequest request){

        service.signInMember(request);
        return new ResponseEntity<>("회원가입 성공!", HttpStatus.CREATED);
    }
}
