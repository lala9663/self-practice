package colleage.student;

public class Login {
    public boolean userState = false;
    String session = new String();

    Student[] users = new Student[100];

    int index = 0;

    public void register(String id, String pw, String name, String phoneNum, String age) {
        Student user = new Student(id, pw, name, phoneNum, age);
        users[index++] = user;

        for (int i = 0; i < index; i++) {
            System.out.println(users[i].toString());
        }
    }

    public void login(String id, String pw) {
        int pwIndex = 0;

        for (int i = 0; i < index; i++) {
            if (users[i].userId().equals(id)) {
                pwIndex = i;
                if (users[pwIndex].userPw().equals(pw)) {
                    System.out.println("로그인 성공");

                    userCheck();

                    session = id;

                    return;
                } else {
                    System.out.println("비밀번호가 틀립니다.");
                    return;
                }
            }
        }
        System.out.println("아이디가 없습니다.");
    }

    public void userCheck() {
        userState = !userState;

        if (userState == false) {
            session = new String();
        }
    }

    public void out() {
        int gap = 0;
        for (int i = 0; i < index; i++) {
            if (users[i].userId().equals(session)) {
                gap = i;
            }
        }
        for (int i = gap; i < index; i++) {
            users[gap] = users[gap + 1];
        }
        index --;

        userCheck();
    }

}
