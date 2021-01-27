package es.salesianos.service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import es.salesianos.model.CookingType;

@Service
@Profile("file")
public class CookingTypeServiceFile implements es.salesianos.service.Service {

	private static Logger log = LogManager.getLogger(CookingTypeServiceFile.class);

	private List<CookingType> cookingTypes = new ArrayList<>();

	@Override
	public void insert(CookingType cookingType) {

		log.info("inserting new cookingType:" + cookingType);

		List<String> lines = Arrays.asList(cookingType.toString());
		Path file = Paths.get(System.getProperty("user.dir") + "/the-file-name.txt");
		try {
			Files.write(file, lines, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException("error al escribir en el fichero", e);
		}
		cookingTypes.add(cookingType);
	}

	@Override
	public List<CookingType> listAll() {
		List<CookingType> listCookingType = new ArrayList<>();
		Path file = Paths.get(System.getProperty("user.dir") + "/the-file-name.txt");
		List<String> readAllLines = new ArrayList<>();
		try {
			readAllLines = Files.readAllLines(file, Charset.forName("UTF-8"));
		} catch (IOException e) {
			log.error("error al leer del fichero", e);
		}

		for (String line : readAllLines) {
			CookingType cookingType = new CookingType();
			cookingType.setName(line);
			log.info("showing cookingType:" + cookingType);
			listCookingType.add(cookingType);
		}
		return listCookingType;
	}


}
