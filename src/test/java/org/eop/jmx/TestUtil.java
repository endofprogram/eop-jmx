package org.eop.jmx;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class TestUtil {

	private TestUtil() {
		
	}
	
	public static String getProjectPath() {
		return new File("").getAbsolutePath();
	}
	
	public static String getTestPath() {
		return "\\src\\test\\java\\";
	}
	
	public static String getFileName(Class<?> cls) {
		return cls.getName().replaceAll("\\.", "\\\\") + ".java";
	}
	
	public static String getFilePath(Class<?> cls) {
		return getProjectPath() + getTestPath() + getFileName(cls);
	}
	
	public static String getParamStr(Class<?> cls) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(getFilePath(cls)), "UTF-8"));
			StringBuilder sb = new StringBuilder();
			String line;
			boolean begin = false;
			do {
				line = br.readLine();
				if (!begin) {
					begin = line.trim().startsWith("/**");
					continue;
				}
				if (line.trim().endsWith("**/")) {
					break;
				}
				System.out.println(line);
				sb.append(line);
			} while(true);
			br.close();
			return sb.toString();
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
