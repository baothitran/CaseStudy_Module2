package com.codegym.view;

import com.codegym.utils.BannerUtils;
import com.codegym.utils.CheckUtils;

import java.util.Scanner;

public class AdminView {
    CarView carView = new CarView();
    RentalOrderView rentalOrderView = new RentalOrderView();
    UserManagerView userManagerView = new UserManagerView();
    public  void launch() {
        Scanner scanner = new Scanner(System.in);
        boolean checkActionMenu = true;
        do {
            try{
                BannerUtils.menuBanner("AdminView-Menu");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        carView.launch();
                        checkActionMenu = CheckUtils.checkContinueActionMenu();
                        break;
                    case 2:
                        rentalOrderView.launch();
                        checkActionMenu = CheckUtils.checkContinueActionMenu();
                        break;
                    case 3:
                        userManagerView.launch();
                        checkActionMenu = CheckUtils.checkContinueActionMenu();
                        break;
                    case 4:
                        Launcher.launch();
                        break;
                    case 5:
                        System.exit(0);
                    default:
                        System.out.println("Nhập sai! Vui lòng nhập lại!");

                }
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số tương ứng với chức năng đã cho!");
                e.printStackTrace();
            }
        } while (checkActionMenu);
    }
}
