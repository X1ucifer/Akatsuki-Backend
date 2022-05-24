package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.*;
import com.example.demo.repos.*;
import com.example.demo.service.Service;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class MainController {
	
	@Autowired public Service newservice;
	

	@Autowired public SeriesRepo seriesrepo;
	
	
	@GetMapping("/all")
	
	public  List<Series> seriesAll() {
		return seriesrepo.findAll();
	}
	
	
	@GetMapping("/usergetseries")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public  List<Series> userseries() {
		return seriesrepo.findAll();
	}
	
	
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@PostMapping("/admin/upload")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> adminAccess(@RequestBody Series data) {
		return newservice.uploadform(data);
	}
	
	@GetMapping("/admin/series")
	@PreAuthorize("hasRole('ADMIN')")
	public  List<Series> series() {
		return seriesrepo.findAll();
	}
	
	@DeleteMapping("/seriesdelete")
	@PreAuthorize("hasRole('ADMIN')")
	public void seriesdelete(@RequestParam Long id) {
		 seriesrepo.deleteById(id);
	}
	
	@PutMapping("/seriesupdate")
	@PreAuthorize("hasRole('ADMIN')")
	public  ResponseEntity<Series> seriesupdate(@RequestBody Series data ) {
		
		return   new ResponseEntity<>(seriesrepo.save(data), HttpStatus.OK) ;
	}
}