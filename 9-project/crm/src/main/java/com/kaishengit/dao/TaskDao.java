package com.kaishengit.dao;

import java.util.List;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.kaishengit.entity.Task;
import com.kaishengit.util.DbHelp;

public class TaskDao {

	public void save(Task task) {
		String sql = "insert into t_task (title, finish_time, status, account_id) values (?,?,?,?)";
		DbHelp.executeUpdate(sql, task.getTitle(), task.getFinishTime(), task.getStatus(), task.getAccountId());
	}

	public List<Task> findListByAccountId(int accountId) {
		String sql = "select * from t_task where account_id = ?";
		return DbHelp.query(sql, new BeanListHandler<>(Task.class,new BasicRowProcessor(new GenerousBeanProcessor())), accountId);
	}

}
