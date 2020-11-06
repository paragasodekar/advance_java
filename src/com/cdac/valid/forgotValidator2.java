package com.cdac.valid;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cdac.dao.UserDao;
import com.cdac.dto.User;

@Service
public class forgotValidator2 implements Validator{

	@Autowired
	UserDao userDao;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(User.class);
		
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		User user = (User) target;
		if(!user.getUserPass().isEmpty())
		{
			String pass=user.getUserPass();
			
			String passRegex="/([a-z][A-z][0-9]){1}/";
			Pattern passPat=Pattern.compile(passRegex);
			Matcher matcher=passPat.matcher(pass);
			if(!matcher.matches())
			{
				System.out.println("=======================================");
				errors.rejectValue("userPass", "passKeya", "password is invalid");
			}
		}else {
			
			System.out.println("+++++++++++++++++++++++++++++++++++++++++");
			errors.rejectValue("userPass", "passKeyd", "password field is empty");
		}
	}
		
}
