package hello

import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

import groovy.json.JsonOutput

@RestController
public class PrettyPrintController {
	@RequestMapping(value = "/print", method=RequestMethod.POST)
	public @ResponseBody String print(@RequestBody String data) {
		return JsonOutput.prettyPrint(data)
	}
}
