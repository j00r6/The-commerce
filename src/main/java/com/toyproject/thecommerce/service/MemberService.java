package com.toyproject.thecommerce.service;

import com.toyproject.thecommerce.dto.PostRequest;
import com.toyproject.thecommerce.entity.Member;
import com.toyproject.thecommerce.global.exception.LoginIdDuplicateException;
import com.toyproject.thecommerce.global.exception.NickNameDuplicateException;
import com.toyproject.thecommerce.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository repository;
    private final PasswordEncoder encoder;

    public boolean checkLoginIdDuplicate(String loginId) {
        return repository.existsByLoginId(loginId);
    }

    public boolean checkNickNameDuplicate(String nickName) {
        return repository.existsByNickName(nickName);
    }

    public void signInMember (PostRequest request) {

        if (checkLoginIdDuplicate(request.getLoginId())) throw new LoginIdDuplicateException("이미 존재하는 아이디입니다.");

        if (checkNickNameDuplicate(request.getNickName())) throw new NickNameDuplicateException("이미 존재하는 닉네임입니다.");

        Member member = request.PostRequestToEntity(encoder.encode(request.getPassword()));
        member.setCreatedAt(LocalDateTime.now());
        repository.save(member);
    }

    public Page<Member> findAllMembers(int page, int size) {
        return repository.findAll(PageRequest.of(page, size, Sort.by("createdAt").descending()));
    }

    public Member patchMember(Member member, String loginId) {

        Member findMember = findVerifyMember(loginId);

        Optional.ofNullable(member.getLoginId())
                .ifPresent(findMember::setLoginId);
        Optional.ofNullable(member.getPassword())
                .ifPresent(findMember::setPassword);
        Optional.ofNullable(member.getNickName())
                .ifPresent(findMember::setNickName);
        Optional.ofNullable(member.getName())
                .ifPresent(findMember::setName);
        Optional.ofNullable(member.getPhone())
                .ifPresent(findMember::setPhone);
        Optional.ofNullable(member.getEmail())
                .ifPresent(findMember::setEmail);
        return repository.save(findMember);
    }

    public Member findVerifyMember(String loginId) {
        Optional<Member> optionalMember = repository.findByLoginId(loginId);
        if (!optionalMember.isPresent()) {
            return null;
        }

        return optionalMember.get();
    }
}
