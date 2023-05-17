package com.codegym.view;

import com.codegym.utils.BannerUtils;
import com.codegym.model.ERole;
import com.codegym.model.User;
import com.codegym.service.IUserService;
import com.codegym.service.UserService;
import com.codegym.utils.CheckUtils;

import java.util.Scanner;

public class LoginView {
    private final static Scanner scanner = new Scanner(System.in);
    private IUserService userService;
    public static User user = new User();
    public LoginView() {
        userService = new UserService();
    }
    public void login(ERole role) {
        boolean checkLogin = false;
        do {
            BannerUtils.menuBanner("LoginView");
            int choice = Integer.parseInt(scanner.nextLine());
            try {
                switch (choice) {
                    case 1:
                        loginProgram(role);
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Nhập sai! Vui lòng nhập lại!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Sai cú pháp! Vui lòng nhập lại");
            }
        }
        while (checkLogin);
    }
    private void loginProgram(ERole role) {
        String username, password;
        System.out.println("Tài khoản: ");
        username = CheckUtils.isEmpty();
        System.out.println("Mật khẩu: ");
        password = CheckUtils.isEmpty();
        user = userService.login(username, password, role);
//        long userId = user.getUserID();
        if (user == null) {
            System.out.println("Tài khoản hoặc mật khẩu không đúng!");
            CheckUtils.pressEnterToContinue();
        } else {
            System.out.println("BẠN ĐÃ ĐĂNG NHẬP THÀNH CÔNG");
            CheckUtils.pressEnterToContinue();
            if (role == ERole.ADMIN) {
                System.out.println("Bạn đang đăng nhập với vai trò ADMIN");
                AdminView adminView = new AdminView();
                adminView.launch();
            } else {
                System.out.println("Bạn đang đăng nhập với vai trò USER");
                UserView userView = new UserView();
                userView.launch(user);
            }
        }
    }

}
