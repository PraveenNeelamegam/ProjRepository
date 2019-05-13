package com.deloitte.model;

import org.springframework.stereotype.Component;

@Component
public class UserResponse {

		private String user_name;
		private String project_name;
		private int dept_num;
		private String msg;
		public String getUser_name() {
			return user_name;
		}
		public void setUser_name(String user_name) {
			this.user_name = user_name;
		}
		public String getProject_name() {
			return project_name;
		}
		public void setProject_name(String project_name) {
			this.project_name = project_name;
		}
		public int getDept_num() {
			return dept_num;
		}
		public void setDept_num(int dept_num) {
			this.dept_num = dept_num;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
}
