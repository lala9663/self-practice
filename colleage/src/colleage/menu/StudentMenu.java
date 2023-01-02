package colleage.menu;

import colleage.student.Students;
import colleage.student.*;

import java.util.Scanner;

public class StudentMenu extends Menu {

    private int menuCountMin = 1;
    private int menuCountMax = 5;

    @Override
    public void showMenu() {
        System.out.print("==============================\n" +
                " 1. 로그인\n" +
                " 2. 회원가입\n" +
                " 3. 아이디/비밀번호 찾기\n" +
                " 5. Back\n" +
                "==============================\n" +
                "Choose One: ");
    }

    public Menu setMenu(int chooseNum, Students students, Scanner sc) {
        if (chooseNum == 1) {
            students.run(sc);
            return this;
        }
        return null;
    }

}
