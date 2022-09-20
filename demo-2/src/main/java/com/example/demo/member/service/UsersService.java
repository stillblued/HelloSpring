package com.example.demo.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.member.CustomUser;
import com.example.demo.member.MemberVO;
import com.example.demo.member.mapper.MemberMapper;

public class UsersService implements UserDetailsService {
	
	@Autowired MemberMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO vo =  new MemberVO();
		vo.setMemberId(username);
		vo = mapper.memberSelect(vo);
		if(vo == null) {
			throw new UsernameNotFoundException("no user");
		}
		return new CustomUser(vo);
	}
}
