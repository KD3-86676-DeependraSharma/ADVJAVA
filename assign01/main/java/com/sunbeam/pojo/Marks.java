package com.sunbeam.pojo;

public class Marks {

	String Subject;
	double marks;
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	public Marks(String subject, double marks) {
		super();
		Subject = subject;
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Marks [Subject=" + Subject + ", marks=" + marks + "]";
	}
	
}
