package es.salesianos.repository;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import es.salesianos.model.CookingType;

@Repository
public class CookingTypeRepository {

	private static Logger log = LogManager.getLogger(CookingTypeRepository.class);

	@Autowired
	private JdbcTemplate template;

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	public void insert(CookingType cookingType) {
		String sql = "INSERT INTO COOKINGTYPE (name)" + "VALUES ( :name)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", cookingType.getName());
		namedJdbcTemplate.update(sql, params);

	}

	public List<CookingType> listAll() {
		String sql = "SELECT * FROM COOKINGTYPE";
		List<CookingType> cookingTypes = template.query(sql, new BeanPropertyRowMapper(CookingType.class));
		return cookingTypes;
	}

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public NamedParameterJdbcTemplate getNamedJdbcTemplate() {
		return namedJdbcTemplate;
	}

	public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
		this.namedJdbcTemplate = namedJdbcTemplate;
	}


}
