package com.example.demo.form;

import java.time.LocalDateTime;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

//画面で入力された値をまとめるクラス
//src/main/resouce/messages.propertiesにバリデーションチェックメッセージ
public class TaskForm {

	// タスクID
	private int taskId;

	// タイトルは1文字以上100文字以下
	@NotBlank
	@Size(min = 1, max = 100)
	private String title;

	// 説明は最大200文字
	@Size(max = 200)
	private String description;

	// デッドラインは必須項目
	@NotNull
	private LocalDateTime deadline;

	// ステータスは1から3の範囲
	@Min(value = 0)
	@Max(value = 3)
	private int status;

	// 更新日時
	private LocalDateTime updatedAt;

	private String detail;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDateTime deadline) {
		this.deadline = deadline;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
