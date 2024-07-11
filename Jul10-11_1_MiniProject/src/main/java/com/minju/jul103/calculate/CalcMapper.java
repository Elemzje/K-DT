package com.minju.jul103.calculate;

public interface CalcMapper {
	public abstract int insertResult(Result r);
	public abstract Results selectAllResult(Result r);
	public abstract int selectUserCount(Result r);
}
