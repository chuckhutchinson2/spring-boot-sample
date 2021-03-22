package com.ths.restapi

import com.ths.restapi.aspect.RestCall
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

import groovy.json.JsonOutput

@RestController
public class PrettyPrintController {
	@RestCall
	@RequestMapping(value = "/print", method=RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody String print(@RequestBody String data) {
		return JsonOutput.prettyPrint(data)
	}
}
