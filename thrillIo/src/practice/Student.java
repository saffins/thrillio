package practice;

import java.io.Serializable;

public class Student implements Serializable {

	/**
	 * 
	 */
 	 private static final long serialVersionUID = 1L;

 

	 @Override
	public String toString() {
		return "Student [  name=" + name + ", id=" + id + "]";
	}

	 private String gender;
	String name;
	static int age;
	transient  int id = 4;

	public int getAge() {
		return age;
	}

	public int getId() {
		return id;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		 this.name = name;
		 
	}

}
