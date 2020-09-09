package core.parser.model;

public class Customer {

    private int id;
    private int age;
    private String gender;
    private String name;
    private String email;
    private int vkId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getVkId() {
        return vkId;
    }

    public void setVkId(int vkId) {
        this.vkId = vkId;
    }

    @Override
    public String toString() {
        return "Customer:  ID=" + this.id + "  Age=" + this.age + "  Name=" + this.name + "  Gender=" + this.gender +
                "  Email=" + this.email + "  VKid=" + this.vkId;
    }



}
