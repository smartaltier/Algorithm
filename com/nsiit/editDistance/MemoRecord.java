package com.nsiit.editDistance;
/**
 * 结果记录表类
 * @author Administrator
 *
 */
public class MemoRecord {
	int refCount;
	int distance;
	
	public MemoRecord() {
		refCount = 0;
		distance = 0;
	}
}
