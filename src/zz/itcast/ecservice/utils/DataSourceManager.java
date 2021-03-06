package zz.itcast.ecservice.utils;

import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSourceFactory;

public class DataSourceManager {
	private static DataSource ds;
	static {
		try {
			InputStream in = DataSourceManager.class.getClassLoader()
					.getResourceAsStream("dbcpconfig.properties");
			Properties props = new Properties();
			props.load(in);
			ds = BasicDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			e.printStackTrace();
			// throw new ExceptionInInitializerError();
		}
	}

	public static DataSource getDataSource() {
		return ds;
	}
}
