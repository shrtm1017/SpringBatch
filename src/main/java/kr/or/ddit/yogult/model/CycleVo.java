package kr.or.ddit.yogult.model;

import lombok.Data;

public class CycleVo {
	private int cid;//����ȣ
	private int pid;//��ǰ��ȣ
	private int day;//����(��:1,��:2....��7)
	private int cnt;//��ǰ����
	public CycleVo(){
		
	}
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	
}
