package com.codegym.view;

import com.codegym.model.ERole;
import com.codegym.model.User;
import com.codegym.service.UserService;
import com.codegym.utils.BannerUtils;
import com.codegym.utils.CheckUtils;
import com.codegym.utils.ValidateUtils;

import java.util.List;
import java.util.Scanner;

import static com.codegym.view.LoginView.user;

public class UserManagerView {
    public UserService userService;
    public Scanner scanner = new Scanner(System.in);

    public UserManagerView() {
        userService = new UserService();
    }

    public void launch(User user) {
        AdminView adminView = new AdminView();
        boolean checkActionMenu = true;
        do {
            BannerUtils.menuBanner("UserManagerView");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        showUser(userService.getAllUsers());
                        break;
                    case 2:
                        addUser();
                        break;
                    case 3:
                        updateUser(user);
                        break;
                    case 4:
                        removeUser();
                    case 5:
                        adminView.launch(user);
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Vui lòng nhập số tương ứng với chức năng đã chọn!");

                }
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số tương ứng với chức năng muốn chọn!");
                e.printStackTrace();
            }
        } while (checkActionMenu);
    }

    public void showUser(List<User> users) {
        System.out.println("╔═════════════════════════════════════════════════DANH SÁCH NGƯỜI SỬ DỤNG═══════════════════════════════════════════════════╗");
        System.out.printf("║%15s║ %20s║ %15s║ %11s║ %15s║ %20s║ %15s║\n", "ID", "Tên", "Số căn cước", "Điện thoại", "Địa chỉ", "Email", "Vai trò");
        for (User user : users) {
            System.out.print(user.toData());
        }
        System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
    }

    public void addUser() {
        User user = new User();
        do {
            try {
                long id = System.currentTimeMillis() / 10000;
                user.setUserID(id);
                String username = inputUsername();
                user.setUsername(username);
                String password = inputPassword();
                user.setPassword(password);
                String fullname = inputFullname();
                user.setFullname(fullname);
                String idcardnum = inputIdCardNum();
                user.setIdcardnum(idcardnum);
                String address = inputAddress();
                user.setAddress(address);
                String phone = inputPhone();
                user.setPhone(phone);
                String email = inputEmail();
                user.setEmail(email);
                setRole(user);
                userService.addUser(user);
            } catch (Exception e) {
                System.out.println("Lỗi! Vui lòng nhập lại!");
                e.printStackTrace();
            }
        }while (CheckUtils.checkContinueAddAction());
    }

    private String inputUsername() {
        System.out.println("Nhập username: ");
        String username;
        do {
            if (!ValidateUtils.isUsernameValid(username = CheckUtils.isEmpty())) {
                System.out.println(username + " không đúng định dạng. Yêu cầu tối thiểu ba ký tự và không bao gồm chữ viết hoa!");
                continue;
            }
            if (userService.existByUsername(username)) {
                System.out.println(username + " đã tồn tại. Vui lòng nhập lại!");
                continue;
            }
            break;
        } while (true);
        return username;
    }

    private String inputPassword() {
        System.out.println("Nhập mật khẩu: ");
        String password;
        while (!ValidateUtils.isPassValid(password = CheckUtils.isEmpty())) {
            System.out.println("Yêu cầu tối thiểu sáu ký tự, ít nhất một chữ cái viết hoa, một chữ cái viết thường, một chữ số và một ký tự đặc biệt!");
        }
        return password;
    }

    private String inputIdCardNum() {
        System.out.println("Nhập số căn cước: ");
        String idcardnum;
        do {
            if (!ValidateUtils.isIdCardNumValid(idcardnum = CheckUtils.isEmpty())) {
                System.out.println("Yêu cầu bao gồm 12 chữ số và bắt đầu bằng chữ số 0!");
                continue;
            }
            if (userService.existByIdCardNum(idcardnum)) {
                System.out.println("Số" + idcardnum + "đã tồn tại.Vui lòng nhập lại!");
                continue;
            }
            break;
        }
        while (true);
        return idcardnum;
    }

    private String inputFullname() {
        System.out.println("Nhập tên: ");
        String fullname;
        while (!ValidateUtils.isNameValid(fullname = CheckUtils.isEmpty())) {
            System.out.println("Yêu cầu phải viết hoa chữ cái đầu ");
        }
        return fullname;
    }

    private String inputAddress() {
        System.out.println("Nhập địa chỉ: ");
        String address;
        while (!ValidateUtils.isAddressValid(address = CheckUtils.isEmpty())) {
            System.out.println("Yêu cầu viết hoa chữ cái đầu!");
        }
        return address;
    }

    private String inputPhone() {
        System.out.println("Nhập số điện thoại: ");
        String phone;
        do {
            if (!ValidateUtils.isPhoneValid(phone = CheckUtils.isEmpty())) {
                System.out.println("Yêu cầu số điện thoại gồm 10 chữ số và bắt đầu chữ số 0");
                continue;
            }
            if (userService.existByPhone(phone)) {
                System.out.println("Số điện thoại đã tồn tại. Vui lòng nhập lại!");
                continue;
            }
            break;
        } while (true);
        return phone;
    }

    private String inputEmail() {
        System.out.println("Nhập email: ");
        String email;
        do {
            if (!ValidateUtils.isEmailValid(email = CheckUtils.isEmpty())) {
                System.out.println("Yêu cầu không bao gồm chữ viết hoa và phải bao gồm dấu @!");
                continue;
            }
            if (userService.existByEmail(email)) {
                System.out.println("Email đã tồn tại. Vui lòng nhập lại!");
                continue;
            }
            break;
        } while (true);
        return email;
    }
    private void setRole(User user) {
        boolean isTrue = true;
        int choice;
        BannerUtils.menuBanner("SetRole");
        do {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        user.setRole(ERole.ADMIN);
                        isTrue = false;
                        break;
                    case 2:
                        user.setRole(ERole.USER);
                        isTrue = false;
                        break;
                    default:
                        System.out.println("Vui lòng nhập số tương ứng với chức năng đã chọn!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số và không để trống!");
            }
        } while (isTrue);
    }
    public void updateUser(User user) {
        int choice;
        boolean checkActionMenu = true;
        do {
            try {
                showUser(userService.getAllUsers());
                long id = inputId();
                User newUser = userService.findById(id);
                BannerUtils.menuBanner("UpdateUser");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        String name = inputFullname();
                        newUser.setFullname(name);
                        userService.updateUser(newUser);
                        break;
                    case 2:
                        String idcardnum = inputIdCardNum();
                        newUser.setIdcardnum(idcardnum);
                        userService.updateUser(newUser);
                        break;
                    case 3:
                        String address = inputAddress();
                        newUser.setAddress(address);
                        userService.updateUser(newUser);
                        break;
                    case 4:
                        String phone = inputPhone();
                        newUser.setPhone(phone);
                        userService.updateUser(newUser);
                        break;
                    case 5:
                        String email = inputEmail();
                        newUser.setEmail(email);
                        userService.updateUser(newUser);
                        break;
                    case 6:
                        setRole(newUser);
                        userService.updateUser(newUser);
                        break;
                    case 7:
                        launch(user);
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Vui lòng nhập số tương ứng với chức năng muốn chọn và không để trống!");
                        break;
                } checkActionMenu = CheckUtils.checkContinueUpdateAction();
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số tương ứng với chức năng muốn chọn và không để trống!");
                e.printStackTrace();
            }
        } while (checkActionMenu);
    }
    private long inputId() {
        long id = 0;
        boolean checkActionMenu = true;
        do {
            System.out.println("Nhập ID: ");
            try {
                id = CheckUtils.isLongFormatCheck();
                boolean isId = userService.existById(id);
                if (isId) {
                    checkActionMenu = false;
                } else {
                    System.out.println("Không tìm thấy người dùng! Vui lòng nhập đúng ID!");
                }
            } catch (Exception e) {
                System.out.println("Vui lòng nhập vào ID tương ứng và không để trống!");
            }

        } while (checkActionMenu);
        return id;
    }
    public void removeUser() {
        boolean checkActionMenu = true;
        do {
            showUser(userService.getAllUsers());
            long id = inputId();
            User user = userService.findById(id);
            String choice;

            try {
                System.out.println("Bạn có chắc chắn muốn xoá không? Y/N");
                choice = scanner.nextLine().trim().toLowerCase();
                switch (choice) {
                    case "y":
                        if (user.getRole() == ERole.ADMIN) {
                            System.out.println("Không thể xoá tài khoản Admin");
                        } else {
                            userService.removeById(id);
                            System.out.println("Xoá thành công!");
                        }
                        checkActionMenu = false;
                        break;
                    case "n" :
                        System.exit(0);
                    default:
                        System.out.println("Vui lòng nhập Y hoặc N tương ứng với chức năng muốn chọn!");
                }
            } catch (Exception e) {
                System.out.println("Vui lòng nhập Y hoặc N tương ứng với chức năng muốn chọn và không để trống! ");
            }
        } while (checkActionMenu);
    }

}
