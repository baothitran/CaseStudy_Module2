package com.codegym.view;

import com.codegym.utils.BannerUtils;
import com.codegym.model.ERole;

import java.util.Scanner;

public class Launcher {
    private static final LoginView loginView = new LoginView();
    public static void mainLaucher(ERole role) {
        loginView.login(role);
    }
    public static void launch() {
        Scanner scanner = new Scanner(System.in);
        boolean checkActionMenu = true;
        do {
            try{
                BannerUtils.menuBanner("LoginView-Role");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        Launcher.mainLaucher(ERole.ADMIN);
                        break;
                    case 2:
                        Launcher.mainLaucher(ERole.USER);
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Wrong value! Please enter again!");
                }
            } catch (Exception e) {
                System.out.println("Wrong value! Please enter again!");
            }
        } while (checkActionMenu);

    }
}


