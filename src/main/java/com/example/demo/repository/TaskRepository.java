package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Task;
import com.example.demo.mapper.TaskMapper;

@Repository
public class TaskRepository {

	private final TaskMapper taskMapper;

	public TaskRepository(TaskMapper taskMapper) {// Mapperクラスの関数を使いたいので、mapperクラスのオブジェクトを作成したいので、インジェクション
		this.taskMapper = taskMapper;
	}

	public List<Task> findAll() {
		return taskMapper.findAll();
	}

	public void save(Task task) {
		taskMapper.save(task);
	}

	//ここでnullを返してしまっているっぽい
	public Task getTask(int taskId) {
		// TODO 自動生成されたメソッド・スタブ
		Task task = taskMapper.getTask(taskId);
	    if (task == null) {
	        throw new RuntimeException("Task not found for ID: " + taskId);
	    }//nullの場合例外を投げるように処理
		return task;
	}

	public int update(Task task) {
		// TODO 自動生成されたメソッド・スタブ
		return taskMapper.update(task);
	}

	public int delete(int taskId) {
		// TODO 自動生成されたメソッド・スタブ
		//データベースとのやり取りを行う。Ｍａｐｐｅｒクラスを介してSQLクエリを定義
		return taskMapper.delete(taskId);
		
	}

}
