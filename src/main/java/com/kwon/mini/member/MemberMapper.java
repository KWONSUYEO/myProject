package com.kwon.mini.member;

import java.util.List;

public interface MemberMapper {
	public abstract List<Member> getMember(Member m);

	public abstract int join(Member m);

	public abstract int withdraw(Member m);

	public abstract int update(Member m);
}
