package com.codegym.view;

import com.codegym.model.Car;
import com.codegym.model.RentalItem;
import com.codegym.model.RentalOrder;
import com.codegym.service.CarService;
import com.codegym.service.RentalItemService;
import com.codegym.service.RentalOrderService;
import com.codegym.utils.BannerUtils;
import com.codegym.utils.CurrencyUtils;
import com.codegym.utils.DateUtils;

import java.util.List;
import java.util.Scanner;

public class RentalOrderView {
    private Scanner scanner =new Scanner(System.in);
    private CarService carService;
    private RentalOrderService rentalOrderService;
    private RentalItemService rentalItemService;
    public RentalOrderView() {
        carService = new CarService();
        rentalItemService = new RentalItemService();
        rentalOrderService = new RentalOrderService();
    }
    public void launch() {
        boolean checkActionMenu = true;
        do {
            BannerUtils.menuBanner("OrderView");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        showOrders(rentalOrderService.getAllOrders());
                        break;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 0:

                }
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số tương ứng với chức năng muốn chọn và không để trống! ");
            }
        } while (checkActionMenu);

    }
    public void showOrders(List<RentalOrder> rentalOrders) {
        System.out.println("╔═════════════════════════════════════════════════DANH SÁCH XE═══════════════════════════════════════════════════╗");
        System.out.printf("║%10s║ %20s║ %15s║ %10s║ %15s║ %15s║ %15s║ %10s║ %10s║", "ID Order", "ID User", "Username", "Địa chỉ", "Số điện thoại", "Ngày thuê", "Ngày trả","Tình trạng","Tổng tiền");
        System.out.println();
        for (RentalOrder rentalOrder : rentalOrders) {
            System.out.printf("║%10s║ %20s║ %15s║ %10s║ %15s║ %15s║ %15s║ %10s║ %10s║\n",
                    rentalOrder.getOrderID(),rentalOrder.getUserID(),rentalOrder.getUserName(),rentalOrder.getAddress(), rentalOrder.getPhone(), DateUtils.convertDateToString(rentalOrder.getRentalDate()),DateUtils.convertDateToString(rentalOrder.getReturnDate()),rentalOrder.getOrderStatus(),CurrencyUtils.convertPriceToString(rentalOrder.getGrandTotal()));
        }
        System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
    }
}
