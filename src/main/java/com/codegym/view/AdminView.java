package com.codegym.view;

import com.codegym.model.User;
import com.codegym.utils.BannerUtils;
import com.codegym.utils.CheckUtils;

import java.util.Scanner;

public class AdminView {
    CarView carView = new CarView();
    RentalOrderView rentalOrderView = new RentalOrderView();
    UserManagerView userManagerView = new UserManagerView();
    public void launch(User user) {
        Scanner scanner = new Scanner(System.in);
        boolean checkActionMenu = true;
        do {
            try{
                BannerUtils.menuBanner("AdminView-Menu");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        carView.launch(user);
                        checkActionMenu = CheckUtils.checkContinueActionMenu();
                        break;
                    case 2:
                        rentalOrderView.launch(user);
                        checkActionMenu = CheckUtils.checkContinueActionMenu();
                        break;
                    case 3:
                        userManagerView.launch(user);
                        checkActionMenu = CheckUtils.checkContinueActionMenu();
                        break;
                    case 4:
                        Launcher.launch();
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Wrong value! Please enter again!");

                }
            } catch (Exception e) {
                System.out.println("Error!");
            }
        } while (checkActionMenu);
    }
}
