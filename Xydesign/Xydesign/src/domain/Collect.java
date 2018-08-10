package domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Collect {
	private int id;
	private String modelName;
	
	public Collect(int id, String modelName) {
		this.id = id;
		this.modelName = modelName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
	/* 从一条结果记录中生成一个Collect对象,
	 * @Exception 当出现数据库异常时,返回null */
	public static Collect CreateCollet(ResultSet resultSet) {
		try {
			int id = resultSet.getInt("id");
			String modelName = resultSet.getString("modelName");
			return new Collect(id, modelName);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("[获取收藏] 实例化一个Collect对象失败!");
			return null;
		}
	}
}
