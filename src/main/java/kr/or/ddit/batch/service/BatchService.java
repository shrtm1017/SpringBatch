package kr.or.ddit.batch.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.batch.dao.IBatchDao;
import kr.or.ddit.batch.model.BatchVo;
import kr.or.ddit.yogult.dao.IYogultDao;
@Service("batchService")
public class BatchService implements IBatchService{
	
		@Resource(name="batchDao")
		private IBatchDao batchDao;
		
		@Resource(name="yogultDao")
		private IYogultDao yogultDao;

		@Override
		public int dailyBatchYm(String ym) {
			int bid=batchDao.getBatchBid();
			BatchVo batchVo = new BatchVo(bid,"01","01");
			batchDao.createBatch(batchVo);
			int insertcnt =yogultDao.dailyBatchYm(ym);
			
			batchVo.setSt("02");
			batchDao.updateBatch(batchVo);
			return insertcnt;
		}
		
		//��ġ ���̵� ȹ��
		//��ġ ������ ���� -> �裞 ���� ���
		//�Ͻ��� ����
		//��ġ ����Ϸ�� ������Ʈ
//	@Override
//	public int dailyBatchYm(String ym) {
//		int bid=batchDao.getBatchBid();
//		BatchVo batchVo = new BatchVo(bid,"01","01");
//		batchDao.createBatch(batchVo);
//		int insertcnt =yogultDao.dailyBatchYm(ym);
//		
//		batchVo.setSt("02");
//		batchDao.updateBatch(batchVo);
//		return insertcnt;
//	}
//	

}
