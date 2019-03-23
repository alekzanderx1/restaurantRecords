package com.worldrestaurants.project.controller;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.web.multipart.MultipartFile;

@Controller
@CrossOrigin
@RequestMapping(value = "restaurants")
public class MainController {

	@RequestMapping(value = "uploadcsvdata", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void uploadCsv(
			@RequestParam(value = "file", required = true) MultipartFile file)
	{

	}


}
