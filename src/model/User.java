package model;

/**
 * @author lfy
 * users表所对应的实体类
 */
public class User {

    //实体类的属性和表的字段名称一一对应
    private String id;
    private String name;
    private int age;

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}