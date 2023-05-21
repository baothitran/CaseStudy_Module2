package com.codegym.utils;

import java.util.Scanner;

public class CheckUtils {
    private static Scanner scanner = new Scanner(System.in);
    public static void pressEnterToContinue() {
        System.out.print("Nhấn Enter để tiếp tục!");
        scanner.nextLine();
    }
    public static String isEmpty() {
        String result;
        while(((result = scanner.nextLine()).trim()).isEmpty()) {
            System.out.println("Không được để trống! Vui lòng nhập lại!");
        }
        return result;
    }
    public static int isIntFormatCheck() {
        int result;
        do{
            try{
                result = Integer.parseInt(scanner.nextLine());
                return result;
            } catch (Exception e) {
                System.out.println("Vui lòng nhập định dạng chữ số và không để trống!");
            }
        } while (true);
    }
    public static double isDoubleFormatCheck() {
        double result;
        do {
            try{
                result = Double.parseDouble(scanner.nextLine());
                return result;
            } catch (Exception e) {
                System.out.println("Vui lòng nhập định dạng chữ số và không để trống!");
            }
        } while (true);
    }
    public static long isLongFormatCheck() {
        long result;
        do {
            try {
                result = Long.parseLong(scanner.nextLine());
                return result;
            } catch (Exception e) {
                System.out.println("Vui lòng nhập định dạng chữ số và không để trống!");
            }
        } while (true);
    }
    public static boolean checkContinueActionMenu() {
        boolean check = true;
        do {
            System.out.println("Bạn có muốn tiếp tục thao tác quản lý không? Y/N");
            String choiceContinueAction = scanner.nextLine().trim().toLowerCase();
            switch (choiceContinueAction) {
                case "y":
                    return true;
                case "n":
                    return false;
                default:
                    System.out.println("Vui lòng chọn đúng cú pháp Y hoặc N!");
                    check = true;
            }
        } while(check);
       return false;
    }
    public static boolean checkContinueUpdateMenu() {
        boolean check = true;
        System.out.println("Đã chỉnh sửa thành công!");
        do {
            System.out.println("Bạn có muốn tiếp tục chỉnh sửa không? Y/N");
            String choiceContinueUpdateAction = scanner.nextLine().trim().toLowerCase();
            switch (choiceContinueUpdateAction) {
                case "y":
                    return true;
                case "n":
                    return false;
                default:
                    System.out.println("Vui lòng chọn đúng cú pháp Y hoặc N!");
                    check = true;
            }
        } while (check);
        return false;
    }
    public static boolean checkContinueRemoveAction() {
        boolean check =  true;
        do {
            System.out.println("Bạn có muốn tiếp tục thao tác xoá không? Y/N");
            String choiceContinueRemoveAction = scanner.nextLine().trim().toLowerCase();
            switch (choiceContinueRemoveAction) {
                case "y":
                    return true;
                case "n":
                    return false;
                default:
                    System.out.println("Vui lòng chọn đúng cú pháp Y hoặc N!");
                    check = true;
            }
        }while (check);
        return false;
    }
    public static boolean checkContinueAddAction() {
        boolean check = true;
        do {
            System.out.println("Bạn có muốn tiếp tục thêm không? Y/N");
            String choiceContinueAction = scanner.nextLine().trim().toUpperCase();;
            switch (choiceContinueAction){
                case "Y":
                    return true;
                case "N":
                    return false;
                default:
                    System.out.println("Vui lòng chọn đúng cú pháp Y hoặc N!");
                    check = true;
            }
        }while (check);
        return false;
    }
    public static boolean checkContinueUpdateAction(){
        boolean check = true;
        do {
            System.out.println("Bạn có muốn tiếp tục chỉnh sửa không? Y/N");
            String choiceContinueActionUser = scanner.nextLine().trim().toUpperCase();
            switch (choiceContinueActionUser){
                case "Y":
                    return true;
                case "N":
                    return false;
                default:
                    System.out.println("Vui lòng chọn đúng cú pháp Y hoặc N!");
                    check = true;
            }
        } while (check);
        return false;
        }

    public static boolean checkContinueAddOrder() {
        boolean check = true;
        do {
            System.out.println("Bạn có muốn tiếp tục thuê thêm không? Y/N");
            String choiceContinueAction = scanner.nextLine().trim().toUpperCase();
            switch (choiceContinueAction){
                case "Y":
                    return true;
                case "N":
                    return false;
                default:
                    System.out.println("Vui lòng chọn đúng cú pháp Y hoặc N!");
                    check = true;
            }
        } while (check);
        return false;
    }
    public static boolean checkContinueActionShowProfit() {
        boolean check = true;
        do {
            System.out.println("Bạn có muốn tiếp tục xem doanh thu không? Y/N");
            String choiceContinueAction = scanner.nextLine().trim().toLowerCase();
            switch (choiceContinueAction) {
                case "y":
                    return true;
                case "n":
                    return false;
                default:
                    System.out.println("Vui lòng chọn đúng cú pháp Y hoặc N!");
                    check = true;
            }
        } while (check);
        return false;
    }
    public static boolean checkActionConfirmReturn() {
        boolean check = true;
        do {
            System.out.println("Bạn có muốn xác nhận thanh toán không? Y/N");
            String choiceContinueAction = scanner.next().trim().toLowerCase();
            switch (choiceContinueAction) {
                case "y":
                    return false;
                case "n":
                    return true;
                default:
                    System.out.println("Vui lòng chọn đúng cú pháp Y hoặc N!");
                    check = true;
            }
        }while (check);
        return false;
    }
}
