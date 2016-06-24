package com.cysd.bocai.dao;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.cysd.bocai.pojo.QiShu;
import com.cysd.bocai.utils.SqlHelper;

public class SqlDao {
	
	public <T> List<T> getDbObjectList(Map<String,String> where_express,Class<T> dbObjClass){
		Connection connection = null;
		List<T> objList = new ArrayList<T>();
		try{
			connection = SqlHelper.getConnection();
			StringBuffer sqlBuffer = new StringBuffer("select * from  ").append(dbObjClass.getSimpleName());
			if(where_express.size()>0){
				sqlBuffer.append(" where ");
				int i = 0;
				for(Entry<String, String> entry:where_express.entrySet()){
					if(i>0){
						sqlBuffer.append(" and ");
					}
					sqlBuffer.append(entry.getKey()).append("'").append("").append("'");
					i++;
				}
			}
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sqlBuffer.toString());
			while(rs.next()){
				@SuppressWarnings("unchecked")
				Constructor<T>[] cons = (Constructor<T>[]) dbObjClass.getDeclaredConstructors();
				T t = null;
				for(Constructor<T> con:cons){
					if(con.getParameterTypes().length==0){
						t = (T) con.newInstance();
					}
				}
				Field[] fields = dbObjClass.getDeclaredFields();
				for(Field field:fields){
					field.setAccessible(true);
					field.set(t,rs.getObject(field.getName()));
				}
				objList.add(t);
			}
			rs.close();
			stmt.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			SqlHelper.freeConnection(connection);
		}
		return objList;
	}
	
	public <T> void addDbObject(Object dbObj){
		Connection connection = null;
		try{
			Field[] fields = dbObj.getClass().getDeclaredFields();
			StringBuffer insertinto_sqlbuffer = new StringBuffer();
			StringBuffer values_sqlbuffer = new StringBuffer();
			insertinto_sqlbuffer.append("insert into ").append(dbObj.getClass().getSimpleName()).append("(");
			values_sqlbuffer.append(" values(");
			int i = 0;
			for(Field field:fields){
				field.setAccessible(true);
				if(i>0){
					insertinto_sqlbuffer.append(",");
					values_sqlbuffer.append(",");
				}
				insertinto_sqlbuffer.append(field.getName());
				if(field.getType()==Date.class&&field.get(dbObj)!=null){
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					values_sqlbuffer.append("'").append(dateFormat.format((Date)field.get(dbObj))).append("'");
				}
				else{
					values_sqlbuffer.append("'").append(field.get(dbObj)).append("'");
				}
				if(i==fields.length-1){
					insertinto_sqlbuffer.append(")");
					values_sqlbuffer.append(")");
				}
				i++;
			}
			
			connection = SqlHelper.getConnection();
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(insertinto_sqlbuffer.append(values_sqlbuffer.toString()).toString());
			stmt.close();
//			System.out.println(insertinto_sqlbuffer.append(values_sqlbuffer.toString()).toString());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			SqlHelper.freeConnection(connection);
		}
	}
	
	public  <T> void updateDbObj(Map<String,String> change_express,Map<String,String> where_express,Class<T> dbObjClass){
		Connection connection = null;
		try{
			StringBuffer update_sqlbuffer = new StringBuffer();
			update_sqlbuffer.append("update ").append(dbObjClass.getSimpleName());
			if(change_express.size()>0){
				update_sqlbuffer.append(" set ");
				int i = 0;
				for(Entry<String, String> entry:change_express.entrySet()){
					if(i>0){
						update_sqlbuffer.append(" and ");
					}
					update_sqlbuffer.append(entry.getKey()).append("=").append("'").append(entry.getValue()).append("'");
					i++;
				}
			}
			if(where_express.size()>0){
				update_sqlbuffer.append(" where ");
				int i = 0;
				for(Entry<String, String> entry:where_express.entrySet()){
					if(i>0){
						update_sqlbuffer.append(" and ");
					}
					update_sqlbuffer.append(entry.getKey()).append("=").append("'").append(entry.getValue()).append("'");
					i++;
				}
			}
			
			connection = SqlHelper.getConnection();
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(update_sqlbuffer.toString());
			stmt.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			SqlHelper.freeConnection(connection);
		}
	}
	
	public <T> void deleteDbObj(Map<String,String> express,Class<T> classObj){
		Connection connection = null;
		try{
			connection = SqlHelper.getConnection();
			StringBuffer sqlBuffer = new StringBuffer("delete from  ").append(classObj.getSimpleName());
			if(express.size()>0){
				sqlBuffer.append(" where ");
				int i = 0;
				for(Entry<String, String> entry:express.entrySet()){
					if(i>0){
						sqlBuffer.append(" and ");
					}
					sqlBuffer.append(entry.getKey()).append("'").append("").append("'");
					i++;
				}
			}
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sqlBuffer.toString());
			stmt.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			SqlHelper.freeConnection(connection);
		}
	}
	
	public static void main(String[] args){
		SqlDao dao = new SqlDao();
		QiShu qishu = new QiShu();
		qishu.setQs_id("123");
		qishu.setCreatedatetime(new Date());
		dao.addDbObject(qishu);
	}
}
