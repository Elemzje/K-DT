package com.minju.jul103.member;

public interface MemberMapper {
	
	public abstract Member pwCheck(Member m);
	public abstract int doSignin(Member m);
	public abstract int updateInfo(Member m);
	public abstract int deleteAccount(Member m);
}
