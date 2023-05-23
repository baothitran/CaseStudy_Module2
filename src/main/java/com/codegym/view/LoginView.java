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
                    case 2:
                        Launcher.launch();
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Wrong value! Please enter again!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Wrong value! Please enter again!");
            }
        }
        while (checkLogin);
    }
    private void loginProgram(ERole role) {
        String username, password;
        System.out.println("Username: ");
        username = CheckUtils.isEmpty();
        System.out.println("Password: ");
        password = CheckUtils.isEmpty();
        user = userService.login(username, password, role);
        if (user == null) {
            System.out.println("Incorrect username or password!");
            CheckUtils.pressEnterToContinue();
        } else {
            System.out.println("SUCCESSFUL LOGIN!");
            CheckUtils.pressEnterToContinue();
            if (role == ERole.ADMIN) {
                System.out.println("You are logged in as ADMIN");
                AdminView adminView = new AdminView();
                adminView.launch(user);
            } else {
                System.out.println("You are logged in as USER");
                UserView userView = new UserView();
                userView.launch(user);
            }
        }
    }

}
