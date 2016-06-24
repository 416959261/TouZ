package com.cysd.bocai.utils;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;

import com.cysd.bocai.Activator;

public class SqlHelper {
	
	private static final String LOG_RELATIVE_PATH="config/sqlconfig.properties";
	
	private static final String H2_RELATIVE_PATH="h2df/cysd.mv.db";
	
	private static File configFile;
	
	private static File h2File;
	
	private static Properties jdbcProperties = new Properties();
	
	private static Properties jdbcMap = new Properties();
	
	static{
		try{
			FileInputStream inputStream = new FileInputStream(getConfigFile());
			jdbcProperties.load(inputStream);
			inputStream.close();
			
			String jdbc_url = jdbcProperties.get("jdbc_url").toString();
			String h2path = getH2Path().getCanonicalPath().replaceAll("\\.mv\\.db", "");
			jdbc_url = String.format(jdbc_url,h2path);
			jdbcProperties.put("jdbc_url", jdbc_url);
			
			jdbcMap.put("user",jdbcProperties.get("user"));
			jdbcMap.put("password",jdbcProperties.get("password"));
			
			Class.forName(jdbcProperties.getProperty("driver"));
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private static File getConfigFile(){
		if(configFile==null){
			String current_dir = System.getProperty("user.dir");
			StringBuffer configpath = new StringBuffer();
			if(current_dir.indexOf("eclipse")!=-1){
				try {
					configpath.append(FileLocator.toFileURL(Platform.getBundle(Activator.PLUGIN_ID).getEntry(LOG_RELATIVE_PATH)).getPath());
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			else{
				try{
					configpath.append(current_dir).append("/").append(LOG_RELATIVE_PATH);
					File configfile = new File(configpath.toString());
					if(!configfile.exists()){
						if(!configfile.getParentFile().exists()){
							configfile.getParentFile().mkdirs();
						}
//						BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FileLocator.toFileURL(Platform.getBundle(Activator.PLUGIN_ID).getEntry(LOG_RELATIVE_PATH)).getPath())));
//						PrintWriter pw = new PrintWriter(configfile);
//						String line = null;
//						while((line= br.readLine())!=null){
//							pw.println(line);
//						}
//						pw.close();
//						br.close();
//						FileLocator.toFileURL(Platform.getBundle(Activator.PLUGIN_ID).getEntry(LOG_RELATIVE_PATH)).getPath());
						FileUtils.copyFileToDirectory(new File(FileLocator.toFileURL(Platform.getBundle(Activator.PLUGIN_ID).getEntry(LOG_RELATIVE_PATH)).getPath()),configfile.getParentFile());
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			
			configFile = new File(configpath.toString());
		}
		
		return configFile;
	}
	
	private static File getH2Path(){
		if(h2File==null){
			String current_dir = System.getProperty("user.dir");
			StringBuffer configpath = new StringBuffer();
			if(current_dir.indexOf("eclipse")!=-1){
				try {
					configpath.append(FileLocator.toFileURL(Platform.getBundle(Activator.PLUGIN_ID).getEntry(H2_RELATIVE_PATH)).getPath());
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			else{
				try{
					configpath.append(current_dir).append("/").append(H2_RELATIVE_PATH);
					File configfile = new File(configpath.toString());
					if(!configfile.exists()){
						if(!configfile.getParentFile().exists()){
							configfile.getParentFile().mkdirs();
						}
//						FileInputStream fis = new FileInputStream(FileLocator.toFileURL(Platform.getBundle(Activator.PLUGIN_ID).getEntry(H2_RELATIVE_PATH)).getPath());
//						FileOutputStream outs = new FileOutputStream(configfile);
//						byte[] bt = new byte[4096];
//						for(int i=0;(i=fis.read(bt))!=-1;){
//							outs.write(bt, 0, i);
//							outs.flush();
//						}
//						fis.close();
//						outs.close();
						FileUtils.copyFileToDirectory(new File(FileLocator.toFileURL(Platform.getBundle(Activator.PLUGIN_ID).getEntry(H2_RELATIVE_PATH)).getPath()),configfile.getParentFile());
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			
			h2File = new File(configpath.toString());
		}
		
		return h2File;
	}
	
	public static Connection getConnection() throws Exception{
		return DriverManager.getConnection(jdbcProperties.getProperty("jdbc_url").toString(),jdbcMap);
	}
	
	public static void freeConnection(Connection connection){
		try{
			if(connection!=null)
			 connection.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
