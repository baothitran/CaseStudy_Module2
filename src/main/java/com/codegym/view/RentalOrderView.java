package com.codegym.view;

import com.codegym.model.*;
import com.codegym.service.CarService;
import com.codegym.service.RentalItemService;
import com.codegym.service.RentalOrderService;
import com.codegym.service.UserService;
import com.codegym.utils.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.DAYS;


public class RentalOrderView {
    private Scanner scanner = new Scanner(System.in);
    private CarService carService;
    RentalOrder rentalOrder;
    private RentalOrderService rentalOrderService;
    private RentalItemService rentalItemService;
    private UserService userService;
    private User user;
    private Car car;
    public final String filePathCar = "F:\\BaoThi\\CaseStudy_Module2\\src\\main\\java\\com\\codegym\\data\\car.csv";

    public RentalOrderView() {
        carService = new CarService();
        rentalItemService = new RentalItemService();
        rentalOrderService = new RentalOrderService();
        userService = new UserService();
    }

    public void launch() {
        AdminView adminView = new AdminView();
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
                        searchOrderByStatus(rentalOrderService.getAllOrders());
                        break;
                    case 3:
                        showOrders(rentalOrderService.getAllOrders());
                        long id = inputId();
                        RentalOrder rentalOrder = rentalOrderService.findById(id);
                        setEOrderStatus(rentalOrder);
                        rentalOrderService.updateOrder(rentalOrder, id);
                        break;
                    case 4:
                        showDetailOrderView();
                        break;
                    case 5:
                        returnCar();
                        break;
                    case 6:
                        getTotalProfit(rentalOrderService.getAllOrders());
                        break;
                    case 7:
                        adminView.launch();
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Vui lòng nhập số tương ứng với chức năng muốn chọn!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số tương ứng với chức năng muốn chọn và không để trống! ");
            }
        } while (checkActionMenu);

    }

    public void showOrders(List<RentalOrder> rentalOrders) {
        System.out.println("╔═════════════════════════════════════════════════════════════════DANH SÁCH ĐƠN HÀNG═══════════════════════════════════════════════════════════╗");
        System.out.printf("║%15s║ %15s║ %15s║ %10s║ %15s║ %15s║ %15s║ %10s║ %16s║", "ID Order", "ID User", "Username", "Địa chỉ", "Số điện thoại", "Ngày thuê", "Ngày trả", "Tình trạng", "Tổng tiền");
        System.out.println();
        for (RentalOrder rentalOrder : rentalOrders) {
            System.out.printf("║%15s║ %15s║ %15s║ %10s║ %15s║ %15s║ %15s║ %10s║ %16s║\n",
                    rentalOrder.getOrderID(), rentalOrder.getUserID(), rentalOrder.getUserName(), rentalOrder.getAddress(), rentalOrder.getPhone(), DateUtils.convertDateToString(rentalOrder.getRentalDate()), DateUtils.convertDateToString(rentalOrder.getReturnDate()), rentalOrder.getOrderStatus(), CurrencyUtils.convertPriceToString(rentalOrder.getGrandTotal()));
        }
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
    }

    public void searchOrderByStatus(List<RentalOrder> list) {
        boolean checkActionMenu;
        do {
            checkActionMenu = false;
            try {
                BannerUtils.menuBanner("RentalOrderView-SearchByStatus");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        List<RentalOrder> rentalOrderList = rentalOrderService.findOrderByStatus(list, 1);
                        System.out.println("DANH SÁCH ĐƠN HÀNG ĐÃ ĐƯỢC THANH TOÁN");
                        System.out.printf("║%10s║ %20s║ %15s║ %10s║ %15s║ %15s║ %15s║ %10s║ %10s║", "ID Order", "ID User", "Username", "Địa chỉ", "Số điện thoại", "Ngày thuê", "Ngày trả", "Tình trạng", "Tổng tiền");
                        System.out.println();
                        for (RentalOrder rentalOrder : rentalOrderList) {
                            System.out.printf(rentalOrder.toData()).println();
                        }
                        break;
                    case 2:
                        List<RentalOrder> rentalOrderList1 = rentalOrderService.findOrderByStatus(list, 2);
                        System.out.println("DANH SÁCH ĐƠN HÀNG CHƯA ĐƯỢC THANH TOÁN");
                        System.out.printf("║%10s║ %20s║ %15s║ %10s║ %15s║ %15s║ %15s║ %10s║ %10s║", "ID Order", "ID User", "Username", "Địa chỉ", "Số điện thoại", "Ngày thuê", "Ngày trả", "Tình trạng", "Tổng tiền");
                        System.out.println();
                        for (RentalOrder rentalOrder : rentalOrderList1) {
                            System.out.printf(rentalOrder.toData()).println();
                        }
                        break;
                    case 3:
                        launch();
                        break;
                    case 4:
                        System.exit(0);
                    default:
                        System.out.println("Vui lòng nhập số tương ứng với chức năng muốn chọn và không để trống!");
                }

            } catch (Exception e) {
                System.out.println("Vui lòng nhập số tương ứng với chức năng muốn chọn và không để trống!");
            }
        } while (checkActionMenu);
    }

    //    public void updateOrderStatus(List<RentalOrder> rentalOrderList) {
//        System.out.println("Nhập ID đơn hàng: ");
//        long id = Long.parseLong(scanner.nextLine());
//        RentalOrder rentalOrder = rentalOrderService.findById(id);
//        if (rentalOrder != null) {
//            System.out.println("Nhập trạng thái đơn hàng: ");
//            BannerUtils.menuBanner("SetOrderStatus");
//            int idstatus = Integer.parseInt(scanner.nextLine());
//            EOrderStatus status = EOrderStatus.findOrderStatusByID(idstatus);
//            if (status != null) {
//                rentalOrder.setOrderStatus(status);
//            }
//            FileUtils.writeDataToFile();
//        }
//    }
    public void setEOrderStatus(RentalOrder rentalOrder) {
        int choice;
        try {
            BannerUtils.menuBanner("SetOrderStatus");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case -1:
                    break;
                case 1:
                    rentalOrder.setOrderStatus(EOrderStatus.Paid);
                    break;
                case 2:
                    rentalOrder.setOrderStatus(EOrderStatus.Unpaid);
                    break;
                default:
                    System.out.println("Nhập không đúng! Vui lòng nhập lại");
                    setEOrderStatus(rentalOrder);
            }
        } catch (Exception e) {
            System.out.println("Vui lòng nhập số tương ứng với chức năng muốn chọn và không để trống");
            setEOrderStatus(rentalOrder);
        }
    }

    private long inputId() {
        long id = 0;
        boolean checkActionMenu = true;
        do {
            System.out.println("Nhập ID Order: ");
            try {
                id = CheckUtils.isLongFormatCheck();
                boolean isId = rentalOrderService.existById(id);
                if (isId) {
                    checkActionMenu = false;
                } else {
                    System.out.println("Không tìm thấy đơn hàng! Vui lòng nhập đúng ID!");
                }
            } catch (Exception e) {
                System.out.println("Vui lòng nhập vào ID cần tìm kiếm và không để trống!");
            }

        } while (checkActionMenu);
        return id;
    }

    public void createOrder(User user) {
        List<Car> carsList = carService.getAllCars();
        rentalOrder = new RentalOrder();
        rentalOrder.setOrderID(System.currentTimeMillis() / 1000);
        boolean checkDate = true;
        try {
            do {
                rentalOrder.setRentalDate(new Date());
                System.out.println("Nhập ngày bạn muốn trả: ");
                rentalOrder.setReturnDate(inputDate());
                if (rentalOrder.getRentalDate().getTime() > rentalOrder.getReturnDate().getTime()) {
                    System.out.println("Ngày trả phải sau ngày thuê!!!");
                    checkDate = true;
                } else {
                    checkDate = false;
                }
            } while (checkDate);
            rentalOrder.setOrderStatus(EOrderStatus.Unpaid);
            rentalOrder.setUserID(user.getUserID());
            boolean checkActionMenu;
            do {
                checkActionMenu = true;
                CarView carView1 = new CarView();
                carView1.showCar(carService.getAllCars());
                long idCar = checkIdCar();

                Car car = carService.findCarById(idCar);
                if (car.getStatus() == ECarStatus.Rented) {
                    System.out.println("Xe đã có người thuê! Vui lòng chọn xe khác!");
                    checkActionMenu = true;
                    continue;
                }
                RentalItem newRentalItem = new RentalItem(System.currentTimeMillis() / 1000000, car.getId(), rentalOrder.getOrderID(), car.getRentalPrice());
                rentalOrder.addRentalItem(newRentalItem);
                showRentalItemsByOrder(rentalOrder, user);
                for (Car car1 : carsList) {
                    if (car.getId() == car1.getId()) {
                        car1.setStatus(ECarStatus.Rented);
                    }
                }
                checkActionMenu = CheckUtils.checkContinueAddOrder();
            } while (checkActionMenu);
            rentalOrder.setGrandTotal(getTotal1(rentalOrder));
            rentalOrder.setUserName(user.getFullname());
            rentalOrder.setAddress(user.getAddress());
            rentalOrder.setPhone(user.getPhone());
            rentalItemService.addRentalItem(rentalOrder.getRentalItems());
            rentalOrderService.add(rentalOrder);
            FileUtils.writeDataToFile(filePathCar, carsList);
        } catch (Exception e) {
            System.out.println("Lỗi!");
        }
    }

    public long checkIdCar() {
        boolean checkidcar;
        do {
            checkidcar = false;
            System.out.println("Nhập ID xe: ");
            long id = Long.parseLong(scanner.nextLine());
            int check = 0;
            for (Car car : carService.getAllCars()) {
                if (car.getId() == id) {
                    return id;
                } else {
                    check = -1;
                }
            }
            if (check == -1) {
                System.out.println("ID không tồn tại! Vui lòng nhập lại!");
                checkidcar = true;
            }
        } while (checkidcar);
        return -1;
    }

    public Date inputDate() {
        System.out.print("dd-mm-yyyy: ");
        String date = scanner.nextLine();
        Date datestr = null;
        try {
            datestr = DateUtils.convertStringToDate(date);
        } catch (Exception e) {
            System.out.println("Định dạng ngày tháng không hợp lệ!");
        }
        if (datestr != null) {
            System.out.println("Ngày bạn vừa nhập là: " + DateUtils.convertDateToString(datestr));
        }
        return datestr;
    }

    public void showRentalItemsByOrder(RentalOrder rentalOrder, User user) {
        double depositFee = 1000000;
        double incurredFee = 500000;
        System.out.println("╔═════════════════════════════════════════SẢN PHẨM ĐƯỢC THUÊ═══════════════════════════════════════════╗");
        System.out.println("          Khách hàng: " + user.getFullname() + "\tĐiện thoại:" + user.getPhone() + "\tĐịa chỉ: " + user.getAddress());
        for (RentalItem rentalItem : rentalOrder.getRentalItems()) {
            Car car = carService.findCarById(rentalItem.getCarID());
            System.out.println(String.format("\t \t \t \t %-20s|%-20s", car.getName(), CurrencyUtils.convertPriceToString(rentalItem.getPrice())));
        }
        System.out.printf(" Ngày thuê: %s ", DateUtils.convertDateToString(rentalOrder.getRentalDate())).println();
        System.out.printf(" Ngày trả: %s ", DateUtils.convertDateToString(rentalOrder.getReturnDate())).println();
        System.out.printf(" Số ngày thuê: %s ", getRentalDays(rentalOrder)).println();
        System.out.printf(" Cọc: %s", CurrencyUtils.convertPriceToString(depositFee)).println();
        System.out.printf(" Phí quá hạn: %s", CurrencyUtils.convertPriceToString(incurredFee)).println();
        System.out.println("                        \t \t \t \t\t \t \tTổng tiền: " + CurrencyUtils.convertPriceToString(getTotal1(rentalOrder)));
        System.out.println("                        \t \t \t \t\t \t \tSố tiền cần thanh toán: " + CurrencyUtils.convertPriceToString(getTotal1(rentalOrder) - depositFee));
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════════╝");
    }

    public void showDetailOrderView() {
        System.out.println("Nhập ID đơn hàng:");
        long idOrder = Integer.parseInt(scanner.nextLine());
        RentalOrder findedOrder = rentalOrderService.findById(idOrder);
        showDetailOrderViewByID(findedOrder);
    }

    public void showDetailOrderViewByID(RentalOrder rentalOrder) {
        double depositFee = 1000000;
        double incurredFee = 500000;
        System.out.println("╔════════════════════════════════════════════HOÁ ĐƠN═════════════════════════════════════════════════════╗");
        System.out.println("\t" + "\t" + "ID Đơn hàng: " + rentalOrder.getOrderID() + "\t" + "Khách hàng: " + rentalOrder.getUserName());
        List<RentalItem> rentalItems = rentalItemService.getAllRentalItems();
        for (RentalItem rentalItem : rentalItems) {
            if (rentalItem.getOrderID() == rentalOrder.getOrderID()) {
                Car car1 = carService.findCarById(rentalItem.getCarID());
                System.out.println(String.format("\t \t \t \t %-20s|%-20s", car1.getName(), CurrencyUtils.convertPriceToString(car1.getRentalPrice())));
            }
        }
        System.out.printf(" Ngày thuê: %s ", DateUtils.convertDateToString(rentalOrder.getRentalDate())).println();
        System.out.printf(" Ngày trả: %s ", DateUtils.convertDateToString(rentalOrder.getReturnDate())).println();
        System.out.printf(" Số ngày thuê: %s ", getRentalDays(rentalOrder)).println();
        System.out.printf(" Đã cọc: %s ", CurrencyUtils.convertPriceToString(depositFee)).println();
        System.out.printf(" Phí quá hạn: %s", CurrencyUtils.convertPriceToString(incurredFee)).println();
        System.out.printf(" Trạng thái: %s", rentalOrder.getOrderStatus()).println();
        System.out.println("                        \t \t \t \t\t \t \tTổng tiền: " + CurrencyUtils.convertPriceToString(rentalOrder.getGrandTotal()));
        System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
    }

    public long getRentalDays(RentalOrder rentalOrder) {
        long diffInMillies = Math.abs(rentalOrder.getReturnDate().getTime() - rentalOrder.getRentalDate().getTime());
        int daysDiff = (int) Math.ceil((diffInMillies / (1000 * 60 * 60 * 24)));
//        long daysDiff = DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        return daysDiff;
    }

    public double getTotal(RentalOrder rentalOrder) {
        double total = 0;
        List<RentalItem> rentalItems = rentalItemService.getAllRentalItems();
        for (RentalItem rentalItem : rentalItems) {
            if (rentalItem.getOrderID() == rentalOrder.getOrderID()) {
                total += rentalItem.getPrice() * getRentalDays(rentalOrder);
            }
        }
        return total;
    }

    public double getTotal1(RentalOrder rentalOrder) {
        double total = 0;
        for (RentalItem rentalItem : rentalOrder.getRentalItems()) {
            if (rentalItem.getOrderID() == rentalOrder.getOrderID()) {
                total += rentalItem.getPrice() * getRentalDays(rentalOrder);
            }
        }
        return total;
    }

    public String getDataByDate(String date) {
        date = date.trim();
        if (date.indexOf(" ") >= 0) {
            int index = date.lastIndexOf(" ");
            return date.substring(index + 1);
        } else return date;
    }

    public String getDataByMonth(String month) {
        month = month.trim();
        if (month.indexOf(" ") >= 0) {
            int index = month.lastIndexOf(" ");
            return month.substring(index + 4, index + 6);
        } else return month;
    }

    public void getTotalProfit(List<RentalOrder> orderList) {
        boolean check;
        do {
            BannerUtils.menuBanner("profitMenu");
            check = false;
            List<RentalOrder> paidOrderList = rentalOrderService.findOrderByStatus(orderList, 1);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Nhập ngày bạn muốn xem (dd-mm-yyyy):");
                    double total1 = 0;
                    String day = scanner.nextLine();
                    List<RentalOrder> orderList1 = new ArrayList<>();
                    for (RentalOrder rentalOrder1 : paidOrderList) {
                        if (getDataByDate(DateUtils.convertDateToString(rentalOrder1.getReturnDate())).equals(day)) {
//                            total1 += getTotal(rentalOrder1);
                            total1 += rentalOrder1.getGrandTotal();
                            orderList1.add(rentalOrder1);
                        }
                    }
                    showOrders(orderList1);
                    System.out.print("■ Tổng:" + CurrencyUtils.convertPriceToString(total1) + "\n");
                    check = CheckUtils.checkContinueActionShowProfit();
                    break;
                case "2":
                    System.out.println("Nhập tháng bạn muốn xem:");
                    double total = 0;
                    String month = scanner.nextLine();
                    List<RentalOrder> orderList2 = new ArrayList<>();
                    for (RentalOrder rentalOrder1 : paidOrderList) {
                        if (getDataByMonth(DateUtils.convertDateToString(rentalOrder1.getReturnDate())).contains(month)) {
                            total += rentalOrder1.getGrandTotal();
                            orderList2.add(rentalOrder1);
                        }
                    }
                    showOrders(orderList2);
                    System.out.print("■ Tổng:" + CurrencyUtils.convertPriceToString(total) + "\n");
                    check = CheckUtils.checkContinueActionShowProfit();
                    break;
                case "3":
                    launch();
                    break;
                default:
                    System.out.println("Lỗi! Vui lòng nhập lại");
                    check = true;
            }
        }
        while (check);
    }
    public void returnCar() {
        List<RentalOrder> rentalOrders = rentalOrderService.getAllOrders();
        double depositFee = 1000000;
        double incurredFee = 500000;
        boolean check;
        do {
            check = false;
            Date returnDay = new Date();
            System.out.println("Nhập ID Order: ");
            long id = Long.parseLong(scanner.nextLine());
            for (RentalOrder order : rentalOrders) {
                if (order.getOrderID() == id) {
                    if (order.getOrderStatus() == EOrderStatus.Paid) {
                        System.out.println("Hoá đơn này đã được thanh toán trước đó!");
                        launch();
                    }
                    long diffInMillies = Math.abs(returnDay.getTime() - order.getReturnDate().getTime());
                    int daysDiff = (int) Math.ceil((diffInMillies / (1000 * 60 * 60 * 24)));
                     showDetailOrderViewByID(order);
                     double expireFee = 0;
                     List<RentalItem> rentalItems = rentalItemService.getAllRentalItems();
                     for (RentalItem rentalItem : rentalItems) {
                         if (rentalItem.getOrderID() == id) {
                             expireFee = daysDiff*(incurredFee + rentalItem.getPrice());
                         }
                     }
                     if (order.getReturnDate().getTime() < returnDay.getTime()) {
                         CurrencyUtils.convertPriceToString(expireFee);
                         System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════════╗");
                         System.out.printf("    Khách hàng đã trễ hạn %s ngày !", daysDiff).println();
                         System.out.printf("    Khách hàng phải trả thêm %s so với giá ban đầu", CurrencyUtils.convertPriceToString(expireFee)).println();
                         System.out.printf("    Tổng tiền phải thanh toán: %s", CurrencyUtils.convertPriceToString(order.getGrandTotal() + expireFee - depositFee)).println();
                         System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                         order.setGrandTotal(order.getGrandTotal() + expireFee);
                         check = CheckUtils.checkActionConfirmReturn();
                     }
                     if (order.getReturnDate().getTime() == returnDay.getTime() || order.getReturnDate().getTime() > returnDay.getTime()) {
                         System.out.printf("Tổng tiền phải thanh toán: %s", CurrencyUtils.convertPriceToString(order.getGrandTotal() - depositFee)).println();
                         check = CheckUtils.checkActionConfirmReturn();
                     }
                     order.setOrderStatus(EOrderStatus.Paid);
                     FileUtils.writeDataToFile(rentalOrderService.filePath, rentalOrders);

                }
            }

        }while (check);
    }
}
