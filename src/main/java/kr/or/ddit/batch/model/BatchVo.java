package kr.or.ddit.batch.model;

import java.util.Date;

import lombok.Data;
@Data
public class BatchVo {
	public BatchVo(int bid, String bcd, String st) {
		this.bid= bid;
		this.bcd=bcd;
		this.st =st;
	}
	private int bid;//��ġ �α׹�ȣ
	private String bcd;//��ġ�ڵ�(01:�Ͻ��� ���� ��ġ , 02:������ ��� ��ġ ...)
	private String st;//��ġ ���� (01:���� 02:�Ϸ�  99:����)
	private Date st_dt; // ��ġ �����Ͻ�
	private Date ed_dt; //��ġ ���� �Ͻ�
	
}
