package es.salesianos.edu.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.salesianos.edu.model.GameOptions;
import es.salesianos.edu.model.Record;
import es.salesianos.edu.model.UserAnswer;

@RestController
@RequestMapping(path = "/api")
public class MasterMindPostmanController {

	GameOptions gameOptions = new GameOptions();
	UserAnswer userAnswer = new UserAnswer();
	int tries = 3;
	String correctAnswer = "red,yellow,green,blue";
	String[] colors = { "rojo", "azul", "verde", "rosa" };
	List<Record> recordTable = new ArrayList<Record>();
	Record newRecord = new Record();

	@GetMapping(path = "/generateKey", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public GameOptions generateKey(@RequestBody GameOptions options) {
		gameOptions = options;
		int gameSize = gameOptions.getSize();
		String generatedKey = "";
		for (int i = 0; i < gameSize - 1; i++) {
			generatedKey += colors[(int) (Math.random() * 3)] + ", ";
		}
		generatedKey += colors[(int) (Math.random() * 3)];
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
	public ResponseEntity<UserAnswer> checkAnswer(@RequestBody UserAnswer answer) {
		String[] input = answer.getAnswer();
		if (input.length != gameOptions.getSize()) {
			userAnswer.setMessage("answer size invalid");
			userAnswer.setReason("expected max size: " + gameOptions.getSize());
			return new ResponseEntity<UserAnswer>(userAnswer, HttpStatus.NOT_ACCEPTABLE);
		}

		String joined = Arrays.stream(input).map(String::toString).collect(Collectors.joining(","));

		if (gameOptions.getGeneratedKey().equals(joined)) {
			userAnswer.setMessage("answer correct");
			return new ResponseEntity<UserAnswer>(userAnswer, HttpStatus.ACCEPTED);
		} else {
			userAnswer.setMessage("answer incorrect");
			return new ResponseEntity<UserAnswer>(userAnswer, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping(path = "/checkTries", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GameOptions> checkTries() {
		gameOptions.setLefttries(gameOptions.getTries() - tries);

		return new ResponseEntity<GameOptions>(gameOptions, HttpStatus.CREATED);
	}
	
	@PostMapping(path="/saveRecordScore", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Record> saveRecordScore(@RequestParam String initial, @RequestParam String name) {
		newRecord.setInitial(initial);
		newRecord.setName(name);
		newRecord.setTries(tries);
		if (newRecord.getInitial() != null && newRecord.getName() != null) {
			recordTable.add(newRecord);
			newRecord.setMessage("new record added");
			return new ResponseEntity<Record>(newRecord, HttpStatus.CREATED);
		} else {
			newRecord.setMessage("Check Your data");
			return new ResponseEntity<Record>(newRecord, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(path = "/listScoreboard", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Record> listScoreboard(@RequestParam int maxSize) {
		fillTable();
		return recordTable.stream().limit(maxSize).collect(Collectors.toList());
	}

	public void fillTable() {
		Record recordToAdd = new Record("gs","Gorka Sanz", 3);
		Record recordToAdd1 = new Record("gs","Gorka Sanz", 3);
		Record recordToAdd2 = new Record("gs","Gorka Sanz", 3);
		Record recordToAdd3 = new Record("gs","Gorka Sanz", 3);
		recordTable.add(recordToAdd);
		recordTable.add(recordToAdd);
		recordTable.add(recordToAdd);
		recordTable.add(recordToAdd);

	}


}
