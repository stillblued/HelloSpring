package com.example.demo.member;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

@Getter
public class CustomUser extends User {
	private MemberVO member;	
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}	
	public CustomUser(MemberVO vo) {
		super(vo.getMemberId(), 
				vo.getMemberPassword(), 
				Collections.singletonList(new SimpleGrantedAuthority(vo.getMemberAuthor())));
	}
}
