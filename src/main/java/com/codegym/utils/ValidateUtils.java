package com.codegym.utils;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class ValidateUtils {
    public static final String NAME_REGEX = "^([A-ZÀ-ỹ][a-zÀ-ỹ]*[ ]?){2,}$";
    //Không bao gồm chữ số
    public static final String PHONE_REGEX = "[0][1-9][0-9]{8,9}$";
    public static final String USERNAME_REGEX = "^[a-z0-9_-]{3,16}$";
    public static final String PASS_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,}$";
    //Tối thiểu sáu ký tự, ít nhất một chữ cái viết hoa, một chữ cái viết thường, một chữ số và một ký tự đặc biệt
    public static final String EMAIL_REGEX = "^[_a-z0-9-\\+]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9]+)*(\\.[a-z]{2,})$";
    public static final String ADDRESS_REGEX = "^([A-ZÀ-ỹ][a-zÀ-ỹ]*[ ]?){2,}$";
    public static boolean isNameValid(String name) {
        return Pattern.compile(NAME_REGEX).matcher(name).matches();
    }
    public static boolean isPhoneValid(String phone) {
        return Pattern.compile(PHONE_REGEX).matcher(phone).matches();
    }
    public static boolean isUsernameValid(String username) {
        return Pattern.compile(USERNAME_REGEX).matcher(username).matches();
    }
    public static boolean isPassValid(String pass) {
        return Pattern.compile(PASS_REGEX).matcher(pass).matches();
    }
    public static boolean isEmailRegex(String email) {
        return Pattern.compile(EMAIL_REGEX).matcher(email).matches();
    }
    public static boolean isAddressRegex(String address) {
        return Pattern.compile(ADDRESS_REGEX).matcher(address).matches();
    }


}
