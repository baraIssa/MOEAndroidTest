

package utils.database;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class PropertiesUtils {

	public static final String PROP_NAME_DB_URL = "url";
	public static final String PROP_NAME_DB_USER_NAME = "username";
	public static final String PROP_NAME_DB_PASSWORD = "password";
	public static final String PROP_NAME_DB_VENDOR = "dbType";

	private static Properties props;

	private PropertiesUtils() {
	}

	private static Properties getProperties() {
		if (props == null) {
			init();
		}
		return props;
	}

	public static String getProperty(String propName) {
		return getProperties().getProperty(propName);
	}

	public static String getProperty(String propName, String defaultValue) {
		return getProperties().getProperty(propName, defaultValue);
	}

	private static void init() {
		props = new Properties();
		try {
			File file = new File(("src/main/resources/database.properties"));
			FileInputStream fileInputStream = new FileInputStream(file);
			props.load(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		validatePropsFileValues();
	}

	private static void validatePropsFileValues() {
		String url = getProperty(PROP_NAME_DB_URL);
		if (StringUtils.isEmpty(url)) {
			throw new IllegalArgumentException("The URL is empry or null  please check the props file provided");
		}
		String username = getProperty(PROP_NAME_DB_USER_NAME);
		if (StringUtils.isEmpty(username)) {
			throw new IllegalArgumentException("The username is empry or null  please check the props file provided");
		}
		String password = getProperty(PROP_NAME_DB_PASSWORD);
		if (StringUtils.isEmpty(password)) {
			throw new IllegalArgumentException("The password is empry or null  please check the props file provided");
		}
		String vendorName = getProperty(PROP_NAME_DB_VENDOR);
		if (StringUtils.isEmpty(vendorName)) {
			throw new IllegalArgumentException(
					"The Vendor Name is empry or null  please check the props file provided");
		}
	}
}
