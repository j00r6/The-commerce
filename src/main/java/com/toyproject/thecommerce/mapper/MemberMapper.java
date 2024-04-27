package com.toyproject.thecommerce.mapper;

import com.toyproject.thecommerce.dto.PostResponse;
import com.toyproject.thecommerce.entity.Member;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {


    default List<PostResponse> PostResponseDtoToMember(List<Member> members) {
        if ( members == null ) {
            return null;
        }

        List<PostResponse>  list = new ArrayList<PostResponse>( members.size() );
        for ( Member member : members ) {
            list.add( PostResponseDtoToMembers( member ) );
        }

        return list;
    }

    default PostResponse PostResponseDtoToMembers(Member member) {
        if (member == null) {
            return null;
        }

        PostResponse response = new PostResponse();

        response.setLoginId(member.getLoginId());
        response.setPassword(member.getPassword());
        response.setNickName(member.getNickName());
        response.setName(member.getName());
        response.setPhone(member.getPhone());
        response.setEmail(member.getEmail());

        return response;
    }
}
