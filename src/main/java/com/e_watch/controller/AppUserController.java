package com.e_watch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_watch.dao.AppUserModel;
import com.e_watch.dao.AppUserRespose;
import com.e_watch.entity.AppUser;
import com.e_watch.entity.LoginDTO;
import com.e_watch.exceptions.AppUserException;
import com.e_watch.service.AppUserService;
@RestController
@RequestMapping("/watch")
public class AppUserController {
	
	@Autowired
	private AppUserService service;
	
	@PostMapping("/validate")
	public ResponseEntity<?> validate (@RequestBody LoginDTO dto){
		System.out.println(dto);
		AppUser appuser = service.validate(dto);
		if(appuser==null) {
			return ResponseEntity.badRequest().body("Incorrect userName OR Password");
		}
		return ResponseEntity.ok(appuser);
	}

	@PostMapping("/register")
	public ResponseEntity<AppUser> createNewAppUser( @RequestBody AppUser appuser) throws AppUserException{
		
		return new ResponseEntity<AppUser>(service.register(appuser),HttpStatus.CREATED);
	}
}
