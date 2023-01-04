package com.e_watch.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_watch.entity.AppUser;
import com.e_watch.entity.LoginDTO;
import com.e_watch.exceptions.AppUserException;
import com.e_watch.repo.AppUserRepo;
import com.e_watch.service.AppUserService;
@Service
public class AppUserServiceImpl implements AppUserService {
	@Autowired
	private AppUserRepo repo;

	@Override
	public AppUser validate(LoginDTO dto) {
		AppUser appuser = repo.findById(dto.getUserId()).orElse(null);
		if(appuser!=null && appuser.getPassword().equals(dto.getPassword())) {
			return appuser;
		}
		return null;

	}

	@Override
	public AppUser register(AppUser appuser) throws AppUserException {
		Optional<AppUser> existingAppUser=repo.findById(appuser.getId());
		if(existingAppUser.isPresent()){
			throw new AppUserException("App User Already exists");
		}
		else{
			return repo.save(appuser);
	     }

	}

}
