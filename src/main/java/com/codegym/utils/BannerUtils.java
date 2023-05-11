package com.codegym.utils;

public class BannerUtils {
    public static void menuBanner(String option) {
        if (option.equals("LoginView")) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                         【1】Đăng nhập                                     ");
            System.out.println("                                         【0】Thoát                                                   ");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Chọn chức năng:");
        }
        if (option.equals("LoginView-Role")) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                           CHÀO MỪNG ĐẾN VỚI CỬA HÀNG CHO THUÊ XE TỰ LÁI                                        ");
            System.out.println("                                     【1】Đăng nhập Admin                          ");
            System.out.println("                                     【2】Đăng nhập User                                     ");
            System.out.println("                                     【0】Thoát                                                   ");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Chọn chức năng:");
        }
        if (option.equals("AdminView-Menu")) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                       TRANG QUẢN LÝ ADMIN                                        ");
            System.out.println("                                         【1】Quản lý sản phẩm                                     ");
            System.out.println("                                         【2】Quản lý đơn hàng                                                   ");
            System.out.println("                                         【3】Quản lý user                                                   ");
            System.out.println("                                         【4】Trở về                                                   ");
            System.out.println("                                         【0】Thoát                                                   ");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Chọn chức năng:");
        }
        if (option.equals("UserView-Menu")) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                             TRANG USER                                        ");
            System.out.println("                                         【1】Hiển thị xe cho thuê                                     ");
            System.out.println("                                         【2】Thuê xe                                                   ");
            System.out.println("                                         【3】Sắp xếp xe                                                   ");
            System.out.println("                                         【4】Tìm kiếm xe                                                   ");
            System.out.println("                                         【5】Trở về                                                   ");
            System.out.println("                                         【0】Thoát                                                   ");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Chọn chức năng:");
        }
        if (option.equals("CarView-Menu")) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                             QUẢN LÝ SẢN PHẨM                                            ");
            System.out.println("                    【1】Hiển thị danh sách sản phẩm           【5】Sắp xếp sản phẩm                           ");
            System.out.println("                    【2】Thêm sản phẩm                         【6】Tìm kiếm sản phẩm                             ");
            System.out.println("                    【3】Cập nhật sản phẩm                     【7】Trở về                   ");
            System.out.println("                    【4】Xoá sản phẩm                          【0】Thoát                         ");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Chọn chức năng:");
        }
        if (option.equals("CarView-Update")) {
            System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                                CẬP NHẬT SẢN PHẨM                                                     ");
            System.out.println("                               【1】Tên xe                          【5】Giá                              ");
            System.out.println("                               【2】Hãng xe                         【6】Tình trạng xe                                  ");
            System.out.println("                               【3】Số lượng xe                     【7】Trở về                                  ");
            System.out.println("                               【4】Loại xe                         【0】Thoát                                  ");
            System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Chọn chức năng:");
        }
        if (option.equals("CarView-Sort")) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                          SẮP XẾP SẢN PHẨM                                        ");
            System.out.println("                                     【1】Sắp xếp sản phẩm theo giá tăng dần                                     ");
            System.out.println("                                     【2】Sắp xếp sản phẩm theo giá giảm dần                                                   ");
            System.out.println("                                     【3】Trở về                                                   ");
            System.out.println("                                     【0】Thoát                                                   ");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Chọn chức năng:");

        }
        if (option.equals("CarView-Search")) {
            System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                                TÌM KIẾM SẢN PHẨM                                                     ");
            System.out.println("                         【1】Tìm kiếm theo ID sản phẩm              【2】Tìm kiếm theo tên                              ");
            System.out.println("                         【3】Tìm kiếm theo loại xe                  【4】Tìm kiếm theo tình trạng                                                                                   ");
            System.out.println("                         【3】                                                                                   ");
            System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Chọn chức năng:");
        }
    }
}
