package colleage.exceptions;

public class Exceptions {

    public static boolean
    check(String input, int rangeMin, int rangeMax){
        for (int i = 0; i <input.length(); i++) {
            if (input.charAt(i) < '0' || input.charAt(i) > '9'){
                System.out.printf("예외처리! 숫자만 입력해주세요.\n");
                return false;
            }
        }
        return true;
    }

}
