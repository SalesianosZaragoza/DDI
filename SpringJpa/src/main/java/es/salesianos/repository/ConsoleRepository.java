package es.salesianos.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.salesianos.model.Console;

@Repository("consolerepository")
@Profile("CORRECTO")
public interface ConsoleRepository extends JpaRepository<Console, Integer> {

	public Console findByName(String name);

}
