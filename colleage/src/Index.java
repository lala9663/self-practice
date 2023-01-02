import colleage.exceptions.Exceptions;
import colleage.menu.FinishMenu;
import colleage.menu.Menu;

import java.util.Scanner;

public class Index {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String chooseNum;
    Menu menu = new Menu();

    menu.start();
    while (true) {
        menu.showMenu();
        chooseNum = sc.nextLine();
        System.out.println();
        if (Exceptions.check(chooseNum, menu.getMenuCountMin(),menu.getMenuCountMax()))
            menu = menu.setMenu(Integer.parseInt(chooseNum), sc);
        if (menu.getClass() == FinishMenu.class) {
            break;
            }
        }
    }
}