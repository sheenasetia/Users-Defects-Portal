package com.sheena.defectapiproject.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sheena.defectapiproject.models.Defect;

@FeignClient( url= "http://localhost:8083/defect/getDefects", name = "defect-service")
public interface DefectServiceClient {

	@GetMapping("/{username}")
	public List<Defect> getDefectsByUser(@PathVariable String username);
	
}
