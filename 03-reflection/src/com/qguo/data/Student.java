package com.qguo.data;

public class Student {

		private String name;
		private Integer id;
		private int score;
		
		private void privatemethod() {
			System.out.println("private medthod can not acess");
		}
		
		public Student(String name, Integer id, int score) {
			super();
			this.name = name;
			this.id = id;
			this.score = score;
			System.out.println("field has been set");
		}
		public Student() {
			super();
			
			System.out.println("constructor has been reach");
			// TODO Auto-generated constructor stub
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public int getScore() {
			return score;
		}
		public void setScore(int score) {
			this.score = score;
		}
		@Override
		public String toString() {
			return "Student [name=" + name + ", id=" + id + ", score=" + score + "]";
		}
		
		
}
