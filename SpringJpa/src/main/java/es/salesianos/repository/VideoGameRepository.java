package es.salesianos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.salesianos.model.VideoGame;
@Repository
public interface VideoGameRepository extends JpaRepository<VideoGame, Integer> {

	public List<VideoGame> findByName(String name);

	public List<VideoGame> findByYearBetween(Integer from, Integer to);

	public List<VideoGame> findByConsole(Integer console);

}
