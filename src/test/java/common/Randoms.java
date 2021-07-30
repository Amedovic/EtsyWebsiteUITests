package common;

import org.apache.commons.lang3.RandomStringUtils;

public class Randoms {

    public Randoms(){

    }

    public String generateRandomEmail(){
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        String email = RandomStringUtils.random( 6, characters );
        return email + "@mail.com";
    }

    public String generateRandomName(){
        String characters = "abcdefghijklmnopqrstuvwxyz";
        String name = RandomStringUtils.random( 8, characters );
        return name;
    }

    public String generateRandomPassword(){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
        String password = RandomStringUtils.random( 12, characters );
        return password;
    }
}
