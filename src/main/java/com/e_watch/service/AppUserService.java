package com.e_watch.service;

import com.e_watch.entity.AppUser;
import com.e_watch.entity.LoginDTO;
import com.e_watch.exceptions.AppUserException;

public interface AppUserService {
	public AppUser validate(LoginDTO dto);
	public AppUser register(AppUser appuser) throws AppUserException;


}
