package com.xieyezi;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import DAO.ConnectionHelper;
import domain.Collect;

/* 对Collect的一些操作 */

public class CollectQuery {
	
	ConnectionHelper helper; //自定义数据库连接对象
	
	public CollectQuery() {
		helper = new ConnectionHelper();
		helper.checkAndInit();
	}
	//关闭连接
	public void closeConnection(){
		helper.closeConnection();
	}
	/* 获取用户所有收藏 
	 * @return 返回结果可能为空,但不是null*/
	@SuppressWarnings("finally")
	public Vector<Collect> getCollect(int id){
		Vector<Collect> collects = new Vector<>();
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			ps = helper.getPreparedStatement("select * from collect where id=?");
			ps.setInt(1, id);
			resultSet = ps.executeQuery();
			while(resultSet!=null && resultSet.next())
				collects.add(Collect.CreateCollet(resultSet));
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			helper.close(ps, resultSet);
			return collects;
		}
		
	}
	/* 删除一个收藏 */
	public boolean deleteCollect(int id, String modelName) {
		PreparedStatement ps ;
		try {
			ps = helper.getPreparedStatement("delete from collect where id=? and modelName=?;");
			ps.setInt(1, id);
			ps.setString(2, modelName);
			ps.execute();
			helper.closePreparedStatement(ps);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[删除收藏] 收藏删除失败!");
			return false;
		}
	}
	
	
}
