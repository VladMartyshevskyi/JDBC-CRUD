package com.vlad.dao.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.vlad.dao.interfaces.BookDao;
import com.vlad.dao.models.Book;

public class BookDaoImpl implements BookDao {
	private static final String QUERY_INSERT = "INSERT INTO Books (name, author, price) VALUES (?,?,?)";
	private static final String QUERY_UPDATE = "UPDATE Books SET name = ?, author = ?, price = ? WHERE id = ?";
	private static final String QUERY_SELECT_ALL = "SELECT * FROM Books";
	private static final String QUERY_SELECT_BY_ID = "SELECT * FROM Books WHERE id = ?";
	private static final String QUERY_DELETE_BY_ID = "DELETE FROM Books WHERE id = ?";

	@Autowired
	@Qualifier("secondDBTemplate")
	private JdbcTemplate jdbcTemplate;

	@Override
	public void add(Book book) {
		jdbcTemplate.update(QUERY_INSERT, book.getName(), book.getAuthor(), book.getPrice());
	}

	@Override
	public void remove(Integer id) {
		jdbcTemplate.update(QUERY_DELETE_BY_ID, id);
	}

	@Override
	public void update(Book book) {
		jdbcTemplate.update(QUERY_UPDATE, book.getName(), book.getAuthor(), book.getPrice(), book.getId());
	}

	@Override
	public List<Book> getAll() {
		List<Book> books = jdbcTemplate.query(QUERY_SELECT_ALL, new BookMapper());
		return books;
	}

	@Override
	public Book getById(Integer id) {
		Book book = (Book) jdbcTemplate.queryForObject(QUERY_SELECT_BY_ID, new Object[] { id }, new BookMapper());
		return book;
	}

	private class BookMapper implements RowMapper {

		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Book book = new Book();
			book.setId(rs.getInt("id"));
			book.setName(rs.getString("name"));
			book.setAuthor(rs.getString("author"));
			book.setPrice(rs.getDouble("price"));
			return book;
		}

	}
}
