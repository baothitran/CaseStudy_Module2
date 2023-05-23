package com.codegym.view;

import com.codegym.model.ERole;
import com.codegym.model.User;
import com.codegym.service.UserService;
import com.codegym.utils.BannerUtils;
import com.codegym.utils.CheckUtils;
import com.codegym.utils.ValidateUtils;

import java.util.List;
import java.util.Scanner;


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
                        System.out.println("Wrong value! Please enter again!");

                }
            } catch (Exception e) {
                System.out.println("Wrong value! Please enter again!");
            }
        } while (checkActionMenu);
    }

    public void showUser(List<User> users) {
        System.out.println("╔═════════════════════════════════════════════════════════USER LIST═════════════════════════════════════════════════════════╗");
        System.out.printf("║%15s║ %19s║ %15s║ %11s║ %15s║ %20s║ %15s║\n", "ID", "Name", "ID Card Number", "Phone Number", "Address", "Email", "Role");
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
                System.out.println("Wrong value! Please enter again!");
            }
        }while (CheckUtils.checkContinueAddAction());
    }

    private String inputUsername() {
        System.out.println("Input username: ");
        String username;
        do {
            if (!ValidateUtils.isUsernameValid(username = CheckUtils.isEmpty())) {
                System.out.println(username + " is not in the correct format. Must be at least three characters and do not include capital letters!");
                continue;
            }
            if (userService.existByUsername(username)) {
                System.out.println(username + " already exists. Please enter again!");
                continue;
            }
            break;
        } while (true);
        return username;
    }

    private String inputPassword() {
        System.out.println("Input password: ");
        String password;
        while (!ValidateUtils.isPassValid(password = CheckUtils.isEmpty())) {
            System.out.println("Must be at least six characters, at least one uppercase letter, one lowercase letter, one digit and one special character!");
        }
        return password;
    }

    private String inputIdCardNum() {
        System.out.println("Input ID card number: ");
        String idcardnum;
        do {
            if (!ValidateUtils.isIdCardNumValid(idcardnum = CheckUtils.isEmpty())) {
                System.out.println("Must include 12 digits and start with the digit 0!");
                continue;
            }
            if (userService.existByIdCardNum(idcardnum)) {
                System.out.println(idcardnum + " already exists. Please enter again!");
                continue;
            }
            break;
        }
        while (true);
        return idcardnum;
    }

    private String inputFullname() {
        System.out.println("Input name: ");
        String fullname;
        while (!ValidateUtils.isNameValid(fullname = CheckUtils.isEmpty())) {
            System.out.println("First letter capital required!");
        }
        return fullname;
    }

    private String inputAddress() {
        System.out.println("Input address: ");
        String address;
        while (!ValidateUtils.isAddressValid(address = CheckUtils.isEmpty())) {
            System.out.println("First letter capital required!");
        }
        return address;
    }

    private String inputPhone() {
        System.out.println("Input phone number: ");
        String phone;
        do {
            if (!ValidateUtils.isPhoneValid(phone = CheckUtils.isEmpty())) {
                System.out.println("Requires a 10 digit phone number starting with 0!");
                continue;
            }
            if (userService.existByPhone(phone)) {
                System.out.println("Phone number already exists. Please enter again!");
                continue;
            }
            break;
        } while (true);
        return phone;
    }

    private String inputEmail() {
        System.out.println("Input email: ");
        String email;
        do {
            if (!ValidateUtils.isEmailValid(email = CheckUtils.isEmpty())) {
                System.out.println("Do not include capital letters and must include the @ sign!");
                continue;
            }
            if (userService.existByEmail(email)) {
                System.out.println("Email already exists. Please enter again!");
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
                        System.out.println("Wrong value! Please enter again!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Wrong value! Please enter again!");
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
                        System.out.println("Wrong value! Please enter again!");
                        break;
                } checkActionMenu = CheckUtils.checkContinueUpdateAction();
            } catch (Exception e) {
                System.out.println("Wrong value! Please enter again!");
            }
        } while (checkActionMenu);
    }
    private long inputId() {
        long id = 0;
        boolean checkActionMenu = true;
        do {
            System.out.println("Input ID: ");
            try {
                id = CheckUtils.isLongFormatCheck();
                boolean isId = userService.existById(id);
                if (isId) {
                    checkActionMenu = false;
                } else {
                    System.out.println("User not found! Please enter the correct ID!");
                }
            } catch (Exception e) {
                System.out.println("Wrong value! Please enter again!");
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
                System.out.println("Are you sure to delete? Y/N");
                choice = scanner.nextLine().trim().toLowerCase();
                switch (choice) {
                    case "y":
                        if (user.getRole() == ERole.ADMIN) {
                            System.out.println("Admin account cannot be deleted!");
                        } else {
                            userService.removeById(id);
                            System.out.println("DELETE SUCCESS!");
                        }
                        checkActionMenu = false;
                        break;
                    case "n" :
                        System.exit(0);
                    default:
                        System.out.println("Please choose Y or N!");
                }
            } catch (Exception e) {
                System.out.println("Wrong value! Please enter again!");
            }
        } while (checkActionMenu);
    }

}
