package ie.cit.video;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.h2.jdbc.JdbcResultSet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;

@Secured("ROLE_USER")
public class JdbcVideoRepository {

	private JdbcTemplate jdbcTemplate;

	public JdbcVideoRepository(DataSource dataSource) {

		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// empty constructor for proxy
	JdbcVideoRepository() {

	}

	public void save(Videostore videostore) {

		jdbcTemplate.update(
				"insert into VIDEO (text, stocknum, owner) values(?,?,?)",
				videostore.getText(), videostore.getStocknum(), getCurrentUser());
	}

	public Videostore get(int id) {

		return jdbcTemplate.queryForObject(
				"select id, text, stocknum from VIDEO where id=? and owner=?", new VideoStoreMapper(), id, getCurrentUser());
	}
	
	public List<Videostore> getAll(){
		return jdbcTemplate.query(
				"select id, text, stocknum from VIDEO where owner=?",  new VideoStoreMapper(), getCurrentUser());
	}
	
	// DELETE, LOOK
	public void delete(int id){
		jdbcTemplate.update("delete from VIDEO where id=? and owner=?", id, getCurrentUser());
	}
	
	public void update(Videostore videostore){
		jdbcTemplate.update("update VIDEO set text=?, stocknum=? where id=? and owner=?", videostore.getText(), videostore.getStocknum(), videostore.getId(), getCurrentUser());
	}
	
	public String getCurrentUser(){
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
}

class VideoStoreMapper implements RowMapper<Videostore> {

	public Videostore mapRow(ResultSet rs, int rowNum) throws SQLException {
		Videostore videostore = new Videostore();
		videostore.setText(rs.getString("text"));
		videostore.setStocknum(rs.getInt("stocknum"));
		videostore.setId(rs.getInt("id"));
		return videostore;
	}
}
