package club.banyuan.pojo;

import java.util.Map;

public class Student {

    private Integer id;
    private String name;
    private String username;
    private String password;
    private Map<String,Double> score;

    public Student() {
    }

    public Student(Integer id, String name, String username, String password, Map<String, Double> score) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, Double> getScore() {
        return score;
    }

    public void setScore(Map<String, Double> score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", score=" + score +
                '}';
    }
}
