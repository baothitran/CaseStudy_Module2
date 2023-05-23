package com.codegym.utils;

public class BannerUtils {
    public static void menuBanner(String option) {
        if (option.equals("LoginView")) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                         【1】Login                                     ");
            System.out.println("                                         【2】Return                                     ");
            System.out.println("                                         【0】Exit                                                   ");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Select:");
        }
        if (option.equals("LoginView-Role")) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                  WELCOME TO CAR RENTAL STORE                                        ");
            System.out.println("                                     【1】Admin login                          ");
            System.out.println("                                     【2】User login                                     ");
            System.out.println("                                     【0】Exit                                                   ");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Select:");
        }
        if (option.equals("AdminView-Menu")) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                             ADMIN PAGE                                        ");
            System.out.println("                                         【1】Car Management                                     ");
            System.out.println("                                         【2】Order Management                                                   ");
            System.out.println("                                         【3】User Management                                                   ");
            System.out.println("                                         【4】Return                                                   ");
            System.out.println("                                         【0】Exit                                                  ");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Select:");
        }
        if (option.equals("UserView-Menu")) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                             USER PAGE                                        ");
            System.out.println("                                         【1】Show all the rental cars                                     ");
            System.out.println("                                         【2】Rent                                                   ");
            System.out.println("                                         【3】Sort car                                                   ");
            System.out.println("                                         【4】Search car                                                   ");
            System.out.println("                                         【5】Return                                                   ");
            System.out.println("                                         【0】Exit                                                   ");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Select:");
        }
        if (option.equals("CarView-Menu")) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                             CAR MANAGEMENT PAGE                                            ");
            System.out.println("                         【1】Show all the rental cars           【5】Sort car                           ");
            System.out.println("                         【2】Add car                            【6】Search car                             ");
            System.out.println("                         【3】Update car                         【7】Return                   ");
            System.out.println("                         【4】Remove car                         【0】Exit                         ");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Select:");
        }
        if (option.equals("CarView-Update")) {
            System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                                   UPDATE CAR                                                     ");
            System.out.println("                               【1】Car name                          【5】Status                              ");
            System.out.println("                               【2】Brand                             【6】Return                                  ");
            System.out.println("                               【3】Car type                          【0】Exit                                  ");
            System.out.println("                               【4】Price                                                           ");
            System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Select:");
        }
        if (option.equals("CarView-Sort")) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                           SORT CAR                                        ");
            System.out.println("                                    【1】Sort car by ascending price                                      ");
            System.out.println("                                    【2】Sort car by descending price                                                   ");
            System.out.println("                                    【3】Return                                                   ");
            System.out.println("                                    【0】Exit                                                   ");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Select:");

        }
        if (option.equals("CarView-Search")) {
            System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                                  SEARCH CAR                                                     ");
            System.out.println("                         【1】Search by car ID                  【4】Search by car status                                  ");
            System.out.println("                         【2】Search by car name                【5】Return                                                                                   ");
            System.out.println("                         【3】Search by car type                【6】Exit                                                                     ");
            System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Select:");
        }
        if (option.equals("CarView-SearchByType")) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                          SEARCH BY CAR TYPE                                        ");
            System.out.println("                                     【1】Four-seater car                                     ");
            System.out.println("                                     【2】Five-seater car                                                   ");
            System.out.println("                                     【3】Seven-seater car                                                   ");
            System.out.println("                                     【4】Return                                                   ");
            System.out.println("                                     【0】Exit                                                   ");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Select:");
        }
        if (option.equals("CarView-SearchByStatus")) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                     SEARCH BY CAR STATUS                                        ");
            System.out.println("                                     【1】Unrented car                                     ");
            System.out.println("                                     【2】Rented car                                                   ");
            System.out.println("                                     【3】Return                                                   ");
            System.out.println("                                     【0】Exit                                                   ");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Select:");
        }
        if (option.equals("UserManagerView")) {
            System.out.println("╔═════════════════════════════════════════════════════════════════╗");
            System.out.println("                          USER MANAGEMENT                                ");
            System.out.println("                      【1】Show all users                                        ");
            System.out.println("                      【2】Add user                                       ");
            System.out.println("                      【3】Update user                                     ");
            System.out.println("                      【4】Delete user                                       ");
            System.out.println("                      【5】Return                                    ");
            System.out.println("                      【0】Exit "                              );
            System.out.println("╚═════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Select:");
        }
        if (option.equals("SetRole")) {
            System.out.println("╔═══════════════════════════════╗");
            System.out.println("             ROLE                                ");
            System.out.println("           【1】ADMIN                                       ");
            System.out.println("           【2】USER                                       ");
            System.out.println("╚═══════════════════════════════╝");
            System.out.println("➔ Select:");
        }
        if (option.equals("UpdateUser")) {
            System.out.println("╔═════════════════════════════════════════════════════════════════╗");
            System.out.println("                          UPDATE USER                                ");
            System.out.println("                    【1】Name                                        ");
            System.out.println("                    【2】ID Card Number                                       ");
            System.out.println("                    【3】Address                                     ");
            System.out.println("                    【4】Phone number                                       ");
            System.out.println("                    【5】Email                                       ");
            System.out.println("                    【6】Role                                       ");
            System.out.println("                    【7】Return                                    ");
            System.out.println("                    【0】Exit "                              );
            System.out.println("╚═════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Select:");
        }
        if (option.equals("OrderView")) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                             ORDER MANAGEMENT                                            ");
            System.out.println("                     【1】Show all orders                    【5】Return car                           ");
            System.out.println("                     【2】Show orders by status              【6】Show revenue                             ");
            System.out.println("                     【3】Show detail order                  【7】Return                        ");
            System.out.println("                     【4】Add new order                      【0】Exit                 ");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Select:");
        }
        if (option.equals("RentalOrderView-SearchByStatus")) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                     SHOW ORDERS BY STATUS                                        ");
            System.out.println("                                     【1】Paid                                      ");
            System.out.println("                                     【2】Unpaid                                                 ");
            System.out.println("                                     【3】Return                                                   ");
            System.out.println("                                     【0】Exit                                                  ");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Select:");
        }
        if (option.equals("SetOrderStatus")) {
            System.out.println("╔═══════════════════════════════╗");
            System.out.println("             Status                                ");
            System.out.println("           【1】Paid                                       ");
            System.out.println("           【2】Unpaid                                       ");
            System.out.println("╚═══════════════════════════════╝");
            System.out.println("➔ Select:");
        }
        if (option.equals("profitMenu")) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                               DOANH THU                                        ");
            System.out.println("                                         【1】Revenue by day                                     ");
            System.out.println("                                         【2】Revenue by month                                                   ");
            System.out.println("                                         【3】Return                                                   ");
            System.out.println("                                         【0】Exit                                                   ");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Select:");
        }
    }
}
