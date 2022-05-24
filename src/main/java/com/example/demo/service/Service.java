package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.demo.model.*;
import com.example.demo.payload.response.MessageResponse;
import com.example.demo.repos.*;

@org.springframework.stereotype.Service
public class Service {
	
	@Autowired SeriesRepo RepoOfSeries;


	public  ResponseEntity<?>  uploadform(Series data) {
		if (data.getTitle() == "") {
			return ResponseEntity.ok(new MessageResponse("title is required"));
        }
		RepoOfSeries.save(data);
		return ResponseEntity.ok(new MessageResponse("Series Created"));
	}
	
	

}
