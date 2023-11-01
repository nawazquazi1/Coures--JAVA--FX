package application;

public class User {
	
	private String name;
	private int age;
	private String animal;
	
	public User(String name, int age, String animal) {
		this.name = name;
		this.age = age;
		this.animal = animal;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getAnimal() {
		return animal;
	}
}
