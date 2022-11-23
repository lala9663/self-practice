package util;




public class Gmail extends Authenticator {

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("lala96632040@gmail.com", "vchzkdukgjgdqjpv".toCharArray());
    }

}

