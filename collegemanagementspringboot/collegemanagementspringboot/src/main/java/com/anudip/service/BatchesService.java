package com.anudip.service;

import com.anudip.entity.Batches;
import com.anudip.entity.Courses;

public interface BatchesService 
{
	// save teacher details in db table
			Batches addBatches(Batches batches);
			
			// method to fetch teacher detail based on tid from db table
			Batches getBatchesDetail(int cid);
			
			//method to modify teacher detail based on tid from db table
			Batches updateBatchesDetail(Batches batches, int bid);
			
			//method to remove teacher detail based on tid from db table
			void deleteBatchesDetail(int bid);
}
