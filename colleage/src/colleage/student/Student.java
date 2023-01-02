package colleage.student;

public class Student {
    private String id;
    private String pw;
    private String name;
    private String phoneNum;
    private int age;

    public Student() {

    }

    public String userId() {
        return id;
    }

    public String userPw() {
        return pw;
    }

    public Student(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    public Student(String id, String pw, String name, String phoneNum, int age) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.phoneNum = phoneNum;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                ", id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", name='" + name + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", age=" + age +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
