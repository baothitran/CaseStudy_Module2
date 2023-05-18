package com.codegym.utils;

public class BannerUtils {
    public static void menuBanner(String option) {
        if (option.equals("LoginView")) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                         【1】Đăng nhập                                     ");
            System.out.println("                                         【2】Trở về                                     ");
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
            System.out.println("                               【1】Tên xe                          【5】Tình trạng xe                              ");
            System.out.println("                               【2】Hãng xe                         【6】Trở về                                  ");
            System.out.println("                               【3】Loại xe                         【0】Thoát                                  ");
            System.out.println("                               【4】Giá                                                           ");
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
            System.out.println("                         【1】Tìm kiếm theo ID sản phẩm          【4】Tìm kiếm theo tình trạng                                  ");
            System.out.println("                         【2】Tìm kiếm theo tên                  【5】Trở về                                                                                   ");
            System.out.println("                         【3】Tìm kiếm theo loại xe              【6】Thoát                                                                     ");
            System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Chọn chức năng:");
        }
        if (option.equals("CarView-SearchByType")) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                          TÌM KIẾM THEO LOẠI XE                                        ");
            System.out.println("                                     【1】Tìm kiếm xe 4 chỗ                                     ");
            System.out.println("                                     【2】Tìm kiếm xe 5 chỗ                                                   ");
            System.out.println("                                     【3】Tìm kiếm xe 7 chỗ                                                   ");
            System.out.println("                                     【4】Trở về                                                   ");
            System.out.println("                                     【0】Thoát                                                   ");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Chọn chức năng:");
        }
        if (option.equals("CarView-SearchByStatus")) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                     TÌM KIẾM THEO TÌNH TRẠNG XE                                        ");
            System.out.println("                                     【1】Tìm kiếm xe có thể cho thuê                                     ");
            System.out.println("                                     【2】Tìm kiếm xe đang được thuê                                                   ");
            System.out.println("                                     【3】Trở về                                                   ");
            System.out.println("                                     【0】Thoát                                                   ");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Chọn chức năng:");
        }
        if (option.equals("UserManagerView")) {
            System.out.println("╔═════════════════════════════════════════════════════════════════╗");
            System.out.println("                          QUẢN LÝ NGƯỜI DÙNG                                ");
            System.out.println("                    【1】Hiển thị tất cả khách hàng                                        ");
            System.out.println("                    【2】Thêm khách hàng                                       ");
            System.out.println("                    【3】Chỉnh sửa thông tin khách hàng                                     ");
            System.out.println("                    【4】Xoá khách hàng                                       ");
            System.out.println("                    【5】Trở về                                    ");
            System.out.println("                    【0】Thoát "                              );
            System.out.println("╚═════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Chọn chức năng:");
        }
        if (option.equals("SetRole")) {
            System.out.println("╔═══════════════════════════════╗");
            System.out.println("             VAI TRÒ                                ");
            System.out.println("           【1】ADMIN                                       ");
            System.out.println("           【2】USER                                       ");
            System.out.println("╚═══════════════════════════════╝");
            System.out.println("➔ Chọn chức năng:");
        }
        if (option.equals("UpdateUser")) {
            System.out.println("╔═════════════════════════════════════════════════════════════════╗");
            System.out.println("                          CHỈNH SỬA THÔNG TIN NGƯỜI DÙNG                                ");
            System.out.println("                    【1】Chỉnh sửa tên                                        ");
            System.out.println("                    【2】Chỉnh sửa số căn cước                                       ");
            System.out.println("                    【3】Chỉnh sửa địa chỉ                                     ");
            System.out.println("                    【4】Chỉnh sửa số điện thoại                                       ");
            System.out.println("                    【5】Chỉnh sửa email                                       ");
            System.out.println("                    【6】Chỉnh sửa vai trò truy cập                                       ");
            System.out.println("                    【7】Trở về                                    ");
            System.out.println("                    【0】Thoát "                              );
            System.out.println("╚═════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Chọn chức năng:");
        }
        if (option.equals("OrderView")) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                             QUẢN LÝ ĐƠN HÀNG                                            ");
            System.out.println("                【1】Hiển thị danh sách tất cả đơn hàng           【5】Trả xe                           ");
            System.out.println("                【2】Hiển thị đơn hàng theo trạng thái            【6】Hiển thị doanh thu                             ");
            System.out.println("                【3】Chỉnh sửa trạng thái đơn hàng                【7】Trở về                        ");
            System.out.println("                【4】Hiển thị chi tiết đơn hàng                   【0】Thoát                 ");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Chọn chức năng:");
        }
        if (option.equals("RentalOrderView-SearchByStatus")) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                     HIỂN THỊ THEO TÌNH TRẠNG ĐƠN HÀNG                                        ");
            System.out.println("                                     【1】Hiển thị đơn hàng theo tình trạng đã thanh toán                                     ");
            System.out.println("                                     【2】Hiển thị đơn hàng theo tình trạng chưa thanh toán                                                   ");
            System.out.println("                                     【3】Trở về                                                   ");
            System.out.println("                                     【0】Thoát                                                   ");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Chọn chức năng:");
        }
        if (option.equals("SetOrderStatus")) {
            System.out.println("╔═══════════════════════════════╗");
            System.out.println("             TRẠNG THÁI                                ");
            System.out.println("           【1】Paid                                       ");
            System.out.println("           【2】Unpaid                                       ");
            System.out.println("╚═══════════════════════════════╝");
            System.out.println("➔ Chọn chức năng:");
        }
        if (option.equals("profitMenu")) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                               DOANH THU                                        ");
            System.out.println("                                     【1】Hiển thị doanh thu theo ngày                                     ");
            System.out.println("                                     【2】Hiển thị doanh thu theo tháng                                                   ");
            System.out.println("                                     【3】Trở về                                                   ");
            System.out.println("                                     【0】Thoát                                                   ");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Chọn chức năng:");
        }
    }
}
