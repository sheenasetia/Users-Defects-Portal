package com.sheena.defectapiproject.resource;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.sheena.defectapiproject.feignclient.DefectServiceClient;
import com.sheena.defectapiproject.models.Defect;
import com.sheena.defectapiproject.models.UserProfile;
import com.sheena.defectapiproject.models.Users;

@RestController
@RequestMapping("/userprofile")
public class UserProfileResource{

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DefectServiceClient dsc;
	
	@GetMapping("/{username}")
	public UserProfile getUserProfile(@PathVariable String username)
	{
		Users userInfo = restTemplate.getForObject("http://localhost:8081/users/"+username,Users.class);
		List<Defect> userDefects = new ArrayList<>();
		userDefects=dsc.getDefectsByUser(username);
		return new UserProfile(userInfo, userDefects);
	}
	
}
