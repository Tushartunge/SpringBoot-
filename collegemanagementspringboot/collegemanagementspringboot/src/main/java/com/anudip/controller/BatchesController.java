package com.anudip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anudip.entity.Batches;
import com.anudip.service.BatchesService;


import jakarta.validation.Valid;

@RestController
public class BatchesController
{
	@Autowired
	BatchesService bservice;
	
	@PostMapping("/Batches/addBatches")
	public ResponseEntity<Batches> saveBatches(@Valid @RequestBody Batches batches)
	{
		return new ResponseEntity<Batches>(bservice.addBatches(batches),HttpStatus.CREATED);
		
	}
	//@PathVariable : bind to URI template variable
	//http://localhost:8080/Teacher/get(1)
	@GetMapping("/Batches/get/{bid}")
	public ResponseEntity<Batches> getBatches(@PathVariable ("bid") int bid)
	{
		return new ResponseEntity<Batches>(bservice.getBatchesDetail(bid),HttpStatus.OK);
	}
	
	// delete
	@DeleteMapping("/Batches/remove/{bid}")
	public ResponseEntity<String> deleteBatches(@PathVariable ("bid") int bid)
	{
		bservice.deleteBatchesDetail(bid);
		return new ResponseEntity<String>("Deleted Sucessfully", HttpStatus.OK);
	}
	
	//update
	//@RequestBody : Student object call to JSON file
	@PutMapping("/Batches/update/{bid}")
	public ResponseEntity<String> updateBatches(@RequestBody Batches batches,@PathVariable("bid") int bid) {
	bservice.updateBatchesDetail(batches,bid); // Delegate to service layer
	return new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);
	
	}
}
