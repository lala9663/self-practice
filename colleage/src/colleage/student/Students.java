package colleage.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {
    Scanner sc = new Scanner(System.in);
    List<Student> students = new ArrayList<>();

    public Students() {
        students.add(new Student("lala9663", "xodbs2050", "김사과", "010", 27));
    }

    public void run(Scanner sc) {

        int key = sc.nextInt();
        while ((key = studentMenu()) != 0) {
            switch (key) {
                case 1:
                    Login();
                    break;
                case 2:
                    studentJoin();
                    break;
            }
        }
    }

    private int studentMenu() {
        return getNumInput("[1]로그인 [2]회원가입 [0]종료");
    }

    private void studentJoin() {
        sc.nextLine();
        String id = getStrInput("아이디: ");
        String pw = getStrInput("비밀번호: ");
        String pw2 = getStrInput("비밀번호 확인: ");
        String name = getStrInput("이름");
        int age = Integer.parseInt(getStrInput("나이"));
        String phoneNum = getStrInput("핸드폰 번호");

        if (idCheck(id)) {
            System.out.println("중복된 ID입니다.");
        } else if (pw.equals(pw2)) {
            students.add(new Student(id, pw, name, phoneNum, age));
        } else {
            System.out.println("비밀번호를 확인해주세요");
        }
    }

    private boolean idCheck(String id) {
        boolean check = true;
        Student student = FindById(id);
        if (student == null) {
            check = false;
        }
        return check;
    }

    private void Login() {
        sc.nextLine();
        String id = getStrInput("아이디: ");
        String pw = getStrInput("비밀번호:  ");

        Student student = FindById(id);
        if (student == null) {
            System.out.println("등록되지 않은 id입니다");
        } else if (student.getPw().equals(pw)) {
            System.out.println(student.getId() + "님 환영합니다");
        } else {
            System.out.println("비밀번호가 틀렸습니다.");
        }
    }

    private Student FindById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    private String getStrInput(String msg) {
        System.out.println(msg);
        return sc.nextLine();
    }



    private int getNumInput(String msg) {
        System.out.println(msg);
        return sc.nextInt();
    }

}

