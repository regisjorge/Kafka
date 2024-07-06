package xom.regis.Json_sr_producer.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Employee {
    private String emp_id;
    private String name;
    private int age;
    private String title;
    private BigDecimal height;
    private Map<String, Integer> children;
    private List<String> friends;
    private Address address;

    public Employee() {
    }

    public Employee(String emp_id, String name, int age, String title, BigDecimal height,
                    Map<String, Integer> children, List<String> friends, Address address) {
        this.emp_id = emp_id;
        this.name = name;
        this.age = age;
        this.title = title;
        this.height = height;
        this.children = children;
        this.friends = friends;
        this.address = address;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public Map<String, Integer> getChildren() {
        return children;
    }

    public void setChildren(Map<String, Integer> children) {
        this.children = children;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
