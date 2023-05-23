package com.codegym.view;

import com.codegym.model.*;
import com.codegym.service.CarService;
import com.codegym.service.RentalItemService;
import com.codegym.service.RentalOrderService;
import com.codegym.service.UserService;
import com.codegym.utils.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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

    public void launch(User user) {
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
                        showDetailOrderView();
                        break;
                    case 4:
                        createOrder(user);
                        break;
                    case 5:
                        returnCar();
                        break;
                    case 6:
                        getTotalProfit(rentalOrderService.getAllOrders());
                        break;
                    case 7:
                        adminView.launch(user);
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Wrong value! Please enter again!");
                        break;
                }
            }catch (NumberFormatException e) {
                System.out.println("Please enter only numbers! ");
            } catch (Exception e) {
                System.out.println("Wrong value! Please enter again! ");
            }
        } while (checkActionMenu);

    }

    public void showOrders(List<RentalOrder> rentalOrders) {
        System.out.println("╔═════════════════════════════════════════════════════════════════DANH SÁCH ĐƠN HÀNG═══════════════════════════════════════════════════════════╗");
        System.out.printf("║%15s║ %15s║ %15s║ %10s║ %15s║ %15s║ %15s║ %10s║ %16s║", "ID Order", "ID User", "Username", "Address", "Phone Number", "Rental Date", "Return Date", "Status", "Total");
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
                        System.out.println("╔═════════════════════════════════════════════════════════════════PAID ORDER LIST══════════════════════════════════════════════════════════════╗");
                        System.out.printf("║%15s║ %15s║ %15s║ %10s║ %15s║ %15s║ %15s║ %10s║ %16s║", "ID Order", "ID User", "Username", "Address", "Phone Number", "Rental Date", "Return Date", "Status", "Total");
                        System.out.println();
                        for (RentalOrder rentalOrder : rentalOrderList) {
                            System.out.printf(rentalOrder.toData()).println();
                        }
                        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
                        break;
                    case 2:
                        List<RentalOrder> rentalOrderList1 = rentalOrderService.findOrderByStatus(list, 2);
                        System.out.println("╔══════════════════════════════════════════════════════════════UNPAID ORDER LIST═══════════════════════════════════════════════════════════════╗");
                        System.out.printf("║%15s║ %15s║ %15s║ %10s║ %15s║ %15s║ %15s║ %10s║ %16s║", "ID Order", "ID User", "Username", "Address", "Phone Number", "Rental Date", "Return Date", "Status", "Total");
                        System.out.println();
                        for (RentalOrder rentalOrder : rentalOrderList1) {
                            System.out.printf(rentalOrder.toData()).println();
                        }
                        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
                        break;
                    case 3:
                        launch(user);
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
        } while (checkActionMenu);
    }





    public void createOrder(User user) {
        List<Car> carsList = carService.getAllCars();
        rentalOrder = new RentalOrder();
        rentalOrder.setOrderID(System.currentTimeMillis() / 1000);
        boolean checkDate = true;
        try {
            do {
                rentalOrder.setRentalDate(new Date());
                System.out.println("Enter the date you want to return the car:");
                rentalOrder.setReturnDate(inputDate());
                if (rentalOrder.getRentalDate().getTime() > rentalOrder.getReturnDate().getTime()) {
                    System.out.println("The return date must be after the rental date!!!");
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
                    System.out.println("Car is already rented! Please choose another car!");
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
            System.out.println("Error!");
            e.printStackTrace();
        }
    }

    public long checkIdCar() {
        boolean checkidcar;
        do {
            checkidcar = false;
            System.out.println("Input ID Car: ");
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
                System.out.println("ID does not exist! Please enter again!");
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
            System.out.println("Invalid date format!");
        }
        if (datestr != null) {
            System.out.println("The date you just entered is: " + DateUtils.convertDateToString(datestr));
        }
        return datestr;
    }

    public void showRentalItemsByOrder(RentalOrder rentalOrder, User user) {
        double depositFee = 1000000;
        double incurredFee = 500000;
        System.out.println("╔═════════════════════════════════════════════RENTAL CAR═══════════════════════════════════════════════╗");
        System.out.println("          User: " + user.getFullname() + "\t \tPhone number:" + user.getPhone() + "\t \t Address: " + user.getAddress());
        for (RentalItem rentalItem : rentalOrder.getRentalItems()) {
            Car car = carService.findCarById(rentalItem.getCarID());
            System.out.println(String.format("\t \t \t \t %-20s|%-20s", car.getName(), CurrencyUtils.convertPriceToString(rentalItem.getPrice())));
        }
        System.out.printf(" Rental date: %s ", DateUtils.convertDateToString(rentalOrder.getRentalDate())).println();
        System.out.printf(" Return date: %s ", DateUtils.convertDateToString(rentalOrder.getReturnDate())).println();
        System.out.printf(" Rental days: %s ", getRentalDays(rentalOrder)).println();
        System.out.printf(" Overdue fee: %s", CurrencyUtils.convertPriceToString(incurredFee)).println();
        System.out.println("                       \t \t \t \t\t Total: " + CurrencyUtils.convertPriceToString(getTotal1(rentalOrder)));
        System.out.println("                       \t \t \t \t\t Deposit fee: "+ CurrencyUtils.convertPriceToString(depositFee));
        System.out.println("                       \t \t \t \t\t The remaining amount to pay when returning the car: " + CurrencyUtils.convertPriceToString(getTotal1(rentalOrder) - depositFee));
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════════╝");
    }

    public void showDetailOrderView() {
        System.out.println("Input ID Order:");
        long idOrder = Integer.parseInt(scanner.nextLine());
        RentalOrder findedOrder = rentalOrderService.findById(idOrder);
        showDetailOrderViewByID(findedOrder);
    }

    public void showDetailOrderViewByID(RentalOrder rentalOrder) {
        double depositFee = 1000000;
        double incurredFee = 500000;
        System.out.println("╔══════════════════════════════════════════════BILL══════════════════════════════════════════════════════╗");
        System.out.println("\t" + "\t\t\t\t" + "ID Order: " + rentalOrder.getOrderID() + "\t\t\t\t\t\t" + "User: " + rentalOrder.getUserName());
        List<RentalItem> rentalItems = rentalItemService.getAllRentalItems();
        for (RentalItem rentalItem : rentalItems) {
            if (rentalItem.getOrderID() == rentalOrder.getOrderID()) {
                Car car1 = carService.findCarById(rentalItem.getCarID());
                System.out.println(String.format("\t \t \t \t %-20s|%-20s", car1.getName(), CurrencyUtils.convertPriceToString(car1.getRentalPrice())));
            }
        }
        System.out.printf(" Rental date: %s ", DateUtils.convertDateToString(rentalOrder.getRentalDate())).println();
        System.out.printf(" Return date: %s ", DateUtils.convertDateToString(rentalOrder.getReturnDate())).println();
        System.out.printf(" Rental days: %s ", getRentalDays(rentalOrder)).println();
        System.out.printf(" Deposit fee: %s ", CurrencyUtils.convertPriceToString(depositFee)).println();
        System.out.printf(" Overdue fee: %s", CurrencyUtils.convertPriceToString(incurredFee)).println();
        System.out.printf(" Status: %s", rentalOrder.getOrderStatus()).println();
        System.out.println("                        \t \t \t \t\t \t \tTotal: " + CurrencyUtils.convertPriceToString(rentalOrder.getGrandTotal()));
        System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
    }

    public long getRentalDays(RentalOrder rentalOrder) {
//        long diffInMillies = Math.abs(rentalOrder.getReturnDate().getTime() - rentalOrder.getRentalDate().getTime());
////        int daysDiff = (int) Math.ceil((diffInMillies / (1000 * 60 * 60 * 24)));
//        long daysDiff = DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        LocalDate date1 = LocalDate.of(rentalOrder.getRentalDate().getYear(), rentalOrder.getRentalDate().getMonth(), rentalOrder.getRentalDate().getDate());
        LocalDate date2 = LocalDate.of(rentalOrder.getReturnDate().getYear(), rentalOrder.getReturnDate().getMonth(), rentalOrder.getReturnDate().getDate());
        return ChronoUnit.DAYS.between(date1, date2);
//        return daysDiff;
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
                    double total1 = 0;
                    String date = null;
                    boolean checkDate = false;
                    do {
                        System.out.println("Enter the date you want to see the revenue: dd-MM-yyyy");
                        date = scanner.nextLine();
                        if (date.equals("0")) {
                            checkDate = true;
                            getTotalProfit(orderList);
                        }
                        checkDate = ValidateUtils.isDay(date);
                        if (!checkDate) {
                            System.out.println("The date you entered is not valid, please enter again: dd-MM-yyyy");
                        }
                    } while (!checkDate);

                    List<RentalOrder> orderList1 = new ArrayList<>();
                    for (RentalOrder rentalOrder1 : paidOrderList) {
                        if (getDataByDate(DateUtils.convertDateToString(rentalOrder1.getReturnDate())).equals(date)) {
                            total1 += rentalOrder1.getGrandTotal();
                            orderList1.add(rentalOrder1);
                        }
                    }
                    showOrders(orderList1);
                    System.out.print("■ Total:" + CurrencyUtils.convertPriceToString(total1) + "\n");
                    check = CheckUtils.checkContinueActionShowProfit();
                    break;
                case "2":
                    double total = 0;
                    String month = null;
                    boolean checkMonth = false;
                    do {
                        System.out.println("Enter the month you want to see revenue: MM-yyyy");
                        month = scanner.nextLine();
                        if (month.equals("0")) {
                            checkMonth = true;
                            getTotalProfit(orderList);
                        }
                        checkMonth = ValidateUtils.isMonth(month);
                        if (!checkMonth) {
                            System.out.println("The month you entered is not valid, please enter again: MM-yyyy");
                        }
                    } while (!checkMonth);

                    List<RentalOrder> orderList2 = new ArrayList<>();
                    for (RentalOrder rentalOrder1 : paidOrderList) {
                        if (getDataByMonth(DateUtils.convertDateToString(rentalOrder1.getReturnDate())).contains(month)) {
                            total += rentalOrder1.getGrandTotal();
                            orderList2.add(rentalOrder1);
                        }
                    }
                    showOrders(orderList2);
                    System.out.print("■ Total:" + CurrencyUtils.convertPriceToString(total) + "\n");
                    check = CheckUtils.checkContinueActionShowProfit();
                    break;
                case "3":
                    launch(user);
                    break;
                default:
                    System.out.println("Wrong value! Please enter again!");
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
            System.out.println("Input ID Order: ");
            long id = Long.parseLong(scanner.nextLine());
            for (RentalOrder order : rentalOrders) {
                if (order.getOrderID() == id) {
                    if (order.getOrderStatus() == EOrderStatus.Paid) {
                        System.out.println("This bill has already been paid!");
                        launch(user);
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
                         System.out.printf("    User is late %s days !", daysDiff).println();
                         System.out.printf("    User has to pay more %s than the original price", CurrencyUtils.convertPriceToString(expireFee)).println();
                         System.out.printf("    Remaining amount to be paid: %s", CurrencyUtils.convertPriceToString(order.getGrandTotal() + expireFee - depositFee)).println();
                         System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════╝");
                         order.setGrandTotal(order.getGrandTotal() + expireFee);
                         check = CheckUtils.checkActionConfirmReturn();
                         System.out.println("CAR RETURN SUCCESSFUL!");
                     }
                     if (order.getReturnDate().getTime() == returnDay.getTime() || order.getReturnDate().getTime() > returnDay.getTime()) {
                         System.out.printf("Remaining amount to be paid: %s", CurrencyUtils.convertPriceToString(order.getGrandTotal() - depositFee)).println();
                         check = CheckUtils.checkActionConfirmReturn();
                         System.out.println("CAR RETURN SUCCESSFUL!");
                     }
                     order.setOrderStatus(EOrderStatus.Paid);
                     FileUtils.writeDataToFile(rentalOrderService.filePath, rentalOrders);
                }
            }
        }while (check);
    }
}
