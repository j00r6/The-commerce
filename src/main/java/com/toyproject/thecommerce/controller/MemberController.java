package com.toyproject.thecommerce.controller;

import com.toyproject.thecommerce.dto.MultiResponseDto;
import com.toyproject.thecommerce.dto.PostRequest;
import com.toyproject.thecommerce.entity.Member;
import com.toyproject.thecommerce.mapper.MemberMapper;
import com.toyproject.thecommerce.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService service;
    private final MemberMapper mapper;
    @PostMapping("/join")
    public ResponseEntity joinMember(@RequestBody PostRequest request){

        service.signInMember(request);
        return new ResponseEntity<>("회원가입 성공!", HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity searchMember(@RequestParam int page,
                                       @RequestParam int pageSize){
        Page<Member> pageMembers = service.findAllMembers(page - 1, pageSize);
        List<Member> members = pageMembers.getContent();

        return new ResponseEntity<>(
                new MultiResponseDto<>(mapper.PostResponseDtoToMember(members), pageMembers), HttpStatus.OK);
    }
}
