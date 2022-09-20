package com.example.demo.member.mapper;

import java.util.List;
import java.util.Map;

import com.example.demo.member.MemberVO;

public interface MemberMapper {
	List<Map<String,Object>> memberSelectList();
	MemberVO memberSelect(MemberVO vo);
	int memberInsert(MemberVO vo);
	int memberUpdate(MemberVO vo);
	int memberDelete(MemberVO vo);
}
