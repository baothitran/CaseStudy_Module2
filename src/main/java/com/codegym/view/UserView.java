package com.codegym.view;

import com.codegym.model.Car;
import com.codegym.model.RentalOrder;
import com.codegym.model.User;
import com.codegym.service.CarService;
import com.codegym.utils.BannerUtils;

import java.util.List;
import java.util.Scanner;

public class UserView {
    CarService carService;
    CarView carView = new CarView();
    RentalOrderView rentalOrderView;
    Scanner scanner = new Scanner(System.in);

    RentalOrder rentalOrder;
    User user;
    public UserView() {
        carService = new CarService();
        rentalOrderView = new RentalOrderView();
    }
    public void launch(User user) {
        boolean checkActionMenu = true;
        do {
            try {
                BannerUtils.menuBanner("UserView-Menu");
                int choice;
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        carView.showCar(carService.getAllCars());
                        launch(user);
                        break;
                    case 2:
                        rentalOrderView.createOrder(user);
                        launch(user);
                        break;
                    case 3:
                        carView.sortCar();
                        launch(user);
                        break;
                    case 4:
                        carView.searchCar();
                        launch(user);
                        break;
                    case 5:
                        Launcher.launch();
                        break;
                    case 0:
                        System.exit(5);
                    default:
                        System.out.println("Vui lòng nhập số tương ứng với chức năng muốn chọn!");
                }
            } catch (Exception e) {
                System.out.println("Lỗi! Vui lòng nhập lại");
                e.printStackTrace();
            }
        }while (checkActionMenu);
    }
    }

