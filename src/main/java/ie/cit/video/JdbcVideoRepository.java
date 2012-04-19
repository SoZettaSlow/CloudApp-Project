package ie.cit.video;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JdbcVideoRepository {

	private JdbcTemplate jdbcTemplate;

	public JdbcVideoRepository(DataSource dataSource) {

		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// empty constructor for proxy
	JdbcVideoRepository() {

	}

	public void save(Videostore videostore) {
		jdbcTemplate.update("insert into VIDEO (text, stocknum) values(?,?)",
				videostore.getText(), videostore.getStocknum());
	}

	public Videostore get(int id) {
		// System.out.println("cccc " +id);
		return jdbcTemplate.queryForObject(
				"select id, text, stocknum from VIDEO where id=?", new VideoStoreMapper(), id);
	}
	
	public List<Videostore> getAll(){
		return jdbcTemplate.query(
				"select id, text, stocknum from VIDEO",  new VideoStoreMapper());
	}
	
	// DELETE, LOOK
	public void delete(int id){
		jdbcTemplate.update("delete from VIDEO where id=?", id);
	}
	
	public void update(Videostore videostore){
		jdbcTemplate.update("update VIDEO set text=?, stocknum=? where id=?", videostore.getText(), videostore.getStocknum(), videostore.getId());
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
