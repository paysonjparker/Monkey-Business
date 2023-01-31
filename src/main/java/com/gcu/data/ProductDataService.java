package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.model.ProductModel;

/**
 * Access products from database.
 *
 */
@Service
public class ProductDataService implements DataAccessInterface<ProductModel>
{
	@Autowired
	@SuppressWarnings("unused")
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplateObject;

	/**
	 * Construcotr for the class. Creates an instance of this class.
	 * @param dataSource Source of the product data.
	 */
	public ProductDataService(DataSource dataSource)
	{

		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<ProductModel> findAll()
	{
		String sql = "SELECT * FROM product";
		List<ProductModel> products = new ArrayList<ProductModel>();
		try 
		{
			// Executes SQL query
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			// Loops through results of query
			while(srs.next()) 
			{
				products.add(new ProductModel(srs.getString("name"), 
											srs.getString("description"),
											srs.getString("size"),
											srs.getDouble("price"),
											srs.getInt("productId")));
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		return products;
	}

	@Override
	public ProductModel findById(int id)
	{
		String sql = "SELECT * FROM product WHERE productId LIKE " + id;
		// Initializes product as empty model
		ProductModel product = null;
		try 
		{
			// Executes SQL query
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			// Creates new product using results of query
			while(srs.next()) 
			{
				product = new ProductModel(srs.getString("name"), srs.getString("description"), srs.getString("size"), srs.getDouble("price"), id);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
				
		return product;
	}

	@Override
	public boolean create(ProductModel product)
	{
		String sql = "INSERT INTO product (name, description, size, price) VALUES (?, ?, ?, ?)";
		try
		{
		   // Execute SQL Insert
		   int rows = jdbcTemplateObject.update(sql,
		                                         	product.getName(),
		                                         	product.getDescription(),
		                                         	product.getSize(),
		                                         	product.getPrice());
		    
		   // Return result of Insert
		    return rows == 1 ? true : false;
		}
		catch (Exception e)
		{
		    e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(ProductModel product)
	{
		// SQL Update string
		String sql = String.format("UPDATE product SET name='%s', description='%s', size='%s', price=%f WHERE productId=%d;",
				product.getName(),
				product.getDescription(),
				product.getSize(),
				product.getPrice(),
				product.getProductId());
		try
		{
			// Executes SQL query
			int rows = jdbcTemplateObject.update(sql);
			// Return result of Insert
		    return rows == 1 ? true : false;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(ProductModel product)
	{
		String sql = "DELETE FROM product WHERE productId=" + product.getProductId();
		try
		{
		   // Execute SQL
			jdbcTemplateObject.execute(sql);
			return true;
		}
		catch (Exception e)
		{
		    e.printStackTrace();
		}
		return false;
	}

	// I need to tweak this interface contract
	@Override
	public ProductModel findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
