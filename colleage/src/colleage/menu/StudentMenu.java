package colleage.menu;

import colleage.student.*;

import java.util.Scanner;

public class StudentMenu extends Menu {

    private int menuCountMin = 1;
    private int menuCountMax = 5;

    Login login;

    StudentMenu() {
        this.login = new Login();
    }

    void Run() {
        int cursor = 0;

        while (cursor == 0) {
            if (login.userState) {
                cursor = menuShowLogin();
            } else {
                cursor = menuShow();
            }
        }
    }

    int menuShow() {
        Scanner sc = new Scanner(System.in);

        System.out.println("안녕하세요.\n선택해주세요.");
        System.out.println("1. 로그인");
        System.out.println("2. 회원가입");
        System.out.println("3. 뒤로가기");

        int message = 0;
        message = sc.nextInt();

        switch (message) {
            case 1:
                menuLogin();
                return 0;
            case 2:
                menuRegister();
                return 0;
            case 3:

            default:
                System.out.println("잘못입력했습니다.");
                return 0;
        }
    }

    int menuShowLogin() {
        Scanner sc = new Scanner(System.in);

        System.out.println("안녕하세요.\n선택해주세요.");
        System.out.println("1. 로그아웃");
        System.out.println("2. 회원탈퇴");

        byte message = 0;
        message = sc.nextByte();

        switch(message) {
            case 1 :
                menuLogout();
                return 0;

            case 2 :
                menuWithDraw();
                return 0;

            default :
                System.out.println("잘못입력했습니다.");
                return 0;
            // 1 or 2 이외 값을 입력했을 경우 출력

        }
    }

    String menuInputId() {
        Scanner sc = new Scanner(System.in);
        String id = new String();
        id = sc.nextLine();

        return id;
    }

    String menuInputPw() {
        Scanner sc = new Scanner(System.in);
        String pw = new String();
        pw = sc.nextLine();

        return pw;
    }

    String menuInputName() {
        Scanner sc = new Scanner(System.in);
        String name = new String();
        name = sc.nextLine();

        return name;
    }

    String menuInputPhoneNum() {
        Scanner sc = new Scanner(System.in);
        String phoneNum = new String();
        phoneNum = sc.nextLine();

        return phoneNum;
    }

    String menuInputAge() {
        Scanner sc = new Scanner(System.in);
        String age = new String();
        age = sc.next();

        return age;
    }

    void menuLogin() {
        System.out.println("로그인 입니다.");
        String id = menuInputId();
        String pw = menuInputPw();

        login.login(id, pw);
    }

    void menuRegister() {
        System.out.println("회원가입 입니다.");
        String id = menuInputId();
        String pw = menuInputPw();
        String name = menuInputName();
        String phoneNum = menuInputPhoneNum();
        String age = menuInputAge();

        login.register(id, pw, name, phoneNum, age);
    }

    void menuLogout() {
        login.userCheck();
        System.out.println("로그아웃 입니다.");
    }

    void menuWithDraw() {
        login.out();
        System.out.println("회원 탈퇴입니다.");
    }

}
