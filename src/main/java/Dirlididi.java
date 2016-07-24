package main.java;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class Dirlididi {

	List<Problem> problemList;

	
	public Dirlididi() {
		this.problemList = new ArrayList<Problem>();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/problem")
	public List<Problem> getProblems() {
		return this.problemList;
	}
}
