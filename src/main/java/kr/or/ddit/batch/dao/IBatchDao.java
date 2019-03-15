package kr.or.ddit.batch.dao;

import kr.or.ddit.batch.model.BatchVo;

public interface IBatchDao {
	
	int createBatch(BatchVo batchVo);
	int updateBatch(BatchVo batchVo);
	int getBatchBid();
		

}
