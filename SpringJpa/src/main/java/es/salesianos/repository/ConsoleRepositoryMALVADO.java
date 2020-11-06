package es.salesianos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import es.salesianos.model.Console;

@Component("consolerepository")
@Profile("MALVADO")
public class ConsoleRepositoryMALVADO implements JpaRepository<Console, Integer> {

	@Override
	public Page<Console> findAll(Pageable pageable) {
		throw new RuntimeException();
	}

	@Override
	public <S extends Console> S save(S entity) {
		throw new RuntimeException();
	}

	@Override
	public Optional<Console> findById(Integer id) {
		throw new RuntimeException();
	}

	@Override
	public boolean existsById(Integer id) {
		throw new RuntimeException();
	}

	@Override
	public long count() {
		throw new RuntimeException();
	}

	@Override
	public void deleteById(Integer id) {
		throw new RuntimeException();
	}

	@Override
	public void delete(Console entity) {
		throw new RuntimeException();
	}

	@Override
	public void deleteAll(Iterable<? extends Console> entities) {
		throw new RuntimeException();
	}

	@Override
	public void deleteAll() {
		throw new RuntimeException();

	}

	@Override
	public <S extends Console> Optional<S> findOne(Example<S> example) {
		throw new RuntimeException();
	}

	@Override
	public <S extends Console> Page<S> findAll(Example<S> example, Pageable pageable) {
		throw new RuntimeException();
	}

	@Override
	public <S extends Console> long count(Example<S> example) {
		throw new RuntimeException();
	}

	@Override
	public <S extends Console> boolean exists(Example<S> example) {
		throw new RuntimeException();
	}

	@Override
	public List<Console> findAll() {
		throw new RuntimeException();
	}

	@Override
	public List<Console> findAll(Sort sort) {
		throw new RuntimeException();
	}

	@Override
	public List<Console> findAllById(Iterable<Integer> ids) {
		throw new RuntimeException();
	}

	@Override
	public <S extends Console> List<S> saveAll(Iterable<S> entities) {
		throw new RuntimeException();
	}

	@Override
	public void flush() {
		throw new RuntimeException();

	}

	@Override
	public <S extends Console> S saveAndFlush(S entity) {
		throw new RuntimeException();
	}

	@Override
	public void deleteInBatch(Iterable<Console> entities) {
		throw new RuntimeException();
	}

	@Override
	public void deleteAllInBatch() {
		throw new RuntimeException();
	}

	@Override
	public Console getOne(Integer id) {
		throw new RuntimeException();
	}

	@Override
	public <S extends Console> List<S> findAll(Example<S> example) {
		throw new RuntimeException();
	}

	@Override
	public <S extends Console> List<S> findAll(Example<S> example, Sort sort) {
		throw new RuntimeException();
	}

}
