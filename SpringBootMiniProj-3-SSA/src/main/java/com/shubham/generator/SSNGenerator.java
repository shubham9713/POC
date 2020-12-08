package com.shubham.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class SSNGenerator implements IdentifierGenerator{

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		
		String prefix="4454";
		String suffix=null;
		String sql="select SSN_NO.nextval from dual";
		
		try {
			Connection con = session.connection();
			Statement statement = con.createStatement();
			
			
			
			ResultSet rs = statement.executeQuery(sql);
			if(rs.next())
			{
				String seqval = rs.getString(1);
				suffix = String.valueOf(seqval);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return prefix+suffix;
	}

}
