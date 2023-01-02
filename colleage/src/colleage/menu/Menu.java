package colleage.menu;


import java.util.Scanner;

public class Menu {

    private int menuCountMin = 1;
    private int menuCountMax = 4;

    public void start() {
        System.out.println("대학교 관리");
    }

    public void showMenu() {
        System.out.println("====================");
        System.out.println("1. 관리자 모드\n" + "2.교수 모드\n" + "3.학생 모드\n" + "4. 종료");
        System.out.println("====================");
        System.out.print("Choose One: ");
    }

    public Menu setMenu(int chooseNum, Scanner sc) {
        while (true) {
            if (chooseNum == 1) {
            } else if (chooseNum == 2) {
            } else if (chooseNum == 3) {
                return new StudentMenu();
            } else {
                System.out.println("Program Finished.");
                return new FinishMenu();
            }

        }
    }
    public int getMenuCountMin() {
        return menuCountMin;
    }

    public int getMenuCountMax() {
        return menuCountMax;
    }


}
