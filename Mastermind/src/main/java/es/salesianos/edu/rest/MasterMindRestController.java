package es.salesianos.edu.rest;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.salesianos.edu.model.GameOptions;
import es.salesianos.edu.model.InputOptions;
import es.salesianos.edu.model.UserAnswer;

@RestController
@RequestMapping(path = "/api")
public class MasterMindRestController {

	GameOptions gameOptions = new GameOptions();
	String[] colors = {"rojo","verde","azul"};
	
	@GetMapping(path = "/generateKey", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public GameOptions generateKey(@RequestBody GameOptions options) {
		gameOptions = options;
		int gamesize = gameOptions.getSize();
		String generatedKey="";
		for (int i = 0; i < gamesize; i++) {
			generatedKey+=""+ colors[(int) (Math.random()*3)]+",";
		}
		if(!generatedKey.equals("")) {
			generatedKey=generatedKey.substring(0, generatedKey.length()-1);
		}
		gameOptions.setGeneratedKey(generatedKey);
		return gameOptions;
	}
	@GetMapping(path = "/changeTries", produces = MediaType.APPLICATION_JSON_VALUE)
	public GameOptions changeTries(@RequestParam int tries) {
		gameOptions.setTries(tries);
		return gameOptions;
	}
		@GetMapping(path = "/answerSize/{size}", produces = MediaType.APPLICATION_JSON_VALUE)
	public GameOptions changeAnswerSize(@PathVariable int size) {
		gameOptions.setSize(size);
		return generateKey(gameOptions);
	}
		@GetMapping(path = "/checkAnswer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserAnswer> changeAnswerSize(@RequestBody UserAnswer answer) {
		String[] input = answer.getAnswer();
		input[1].toString();
		
		String[] newInput = (String[]) Arrays.stream(input).map(
				(in)->in.substring(0, 2)
		).toArray();
		
		if(input.length != gameOptions.getSize()) {
			answer.setMessage("answer size invalid ");
			answer.setReason("expected max size:"+gameOptions.getSize());
			return new ResponseEntity(answer, HttpStatus.NOT_ACCEPTABLE);
		}
		
		String joined = Arrays.stream(input).map(String::toString)
				  .collect(Collectors.joining(","));
		if(gameOptions.getGeneratedKey().equals(joined)) {
			answer.setMessage("answer correct");
		}else {
			answer.setMessage("answer incorrect");
		}
		return answer;
		
	}
}
