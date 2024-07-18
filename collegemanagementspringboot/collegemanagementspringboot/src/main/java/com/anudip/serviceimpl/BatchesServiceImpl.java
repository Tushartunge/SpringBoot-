package com.anudip.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.entity.Batches;
import com.anudip.entity.Courses;
import com.anudip.exception.BatchesIdNotFoundException;
import com.anudip.exception.CoursesIdNotFoundException;
import com.anudip.repository.BatchesRepository;
import com.anudip.service.BatchesService;

@Service
public class BatchesServiceImpl implements BatchesService {

	@Autowired
	BatchesRepository batRepo;
	@Override
	public Batches addBatches(Batches batches) {
		return batRepo.save(batches);
	}

	@Override
	public Batches getBatchesDetail(int bid) {
		return batRepo.findById(bid).
				orElseThrow(()-> new BatchesIdNotFoundException("Batch id is not corrected"));
	}

	@Override
	public Batches updateBatchesDetail(Batches batches, int bid) {
		Batches UpdateBatches = batRepo.findById(bid).
				orElseThrow(()-> new BatchesIdNotFoundException("Batch id is not corrected"));
				// set new value
		//Student.setSphone(student.getSphone());
		UpdateBatches.setDuration(batches.getDuration());
		UpdateBatches.setEnddate(batches.getEnddate());
		batRepo.save(UpdateBatches);
		return UpdateBatches;
	}

	@Override
	public void deleteBatchesDetail(int bid) {
		Batches delBatches =batRepo.findById(bid).
				orElseThrow(()-> new BatchesIdNotFoundException("Batch id is not corrected"));
		batRepo.delete(delBatches);
		
	}

}
