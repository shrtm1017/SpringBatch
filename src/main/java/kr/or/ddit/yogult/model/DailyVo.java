package kr.or.ddit.yogult.model;

import lombok.Data;

@Data
public class DailyVo {
	private int cid;//����ȣ
	private int pid;//��ǰ��ȣ
	private String dt;//��������
	private int cnt;//��ǰ����
	public DailyVo(){
		
	}
	
	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
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
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "DailyVo [cid=" + cid + ", pid=" + pid + ", dt=" + dt + ", cnt=" + cnt + "]";
	}


}
