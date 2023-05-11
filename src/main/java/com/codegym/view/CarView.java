package com.codegym.view;

import com.codegym.comparator.ComparatorDecreasingByPrice;
import com.codegym.comparator.ComparatorIncreasingByPrice;
import com.codegym.utils.*;
import com.codegym.model.Car;
import com.codegym.model.ECarStatus;
import com.codegym.model.EType;
import com.codegym.service.CarService;

import java.util.List;
import java.util.Scanner;

public class CarView {
    private final String filePath = "F:\\BaoThi\\CaseStudy_Module2\\src\\main\\java\\com\\codegym\\data\\car.csv";
    private CarService carService;
    private FileUtils fileUtils;
    private CarView carView;
    private Scanner scanner = new Scanner(System.in);

    public CarView() {
        carService = new CarService();
    }

    public void launch() {
        AdminView adminView = new AdminView();
        boolean checkActionMenu = true;
        do {
            BannerUtils.menuBanner("CarView-Menu");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        showCar();
                        break;
                    case 2:
                        addCar();
                        break;
                    case 3:
                        updateCar();
                        break;
                    case 4:
                        removeCar();
                        break;
                    case 5:
                        sortCar();
                        break;
                    case 6:

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
                System.out.println("Vui lòng nhập số tương ứng với chức năng muốn chọn!");
                e.printStackTrace();
            }
        } while (checkActionMenu);
    }

    public void showCar() {
        List<Car> cars = carService.getAllCars();
        System.out.println("╔═════════════════════════════════════════════════DANH SÁCH XE═══════════════════════════════════════════════════╗");
        System.out.printf("║%10s║ %20s║ %15s║ %10s║ %15s║ %15s║ %15s║", "ID", "Tên xe", "Hãng", "Số lượng", "Loại", "Giá", "Tình trạng");
        System.out.println();
        for (Car car : cars) {
            System.out.printf("║%10s║ %20s║ %15s║ %10s║ %15s║ %15s║ %15s║\n",
                    car.getId(), car.getName(), car.getBrand(), car.getQuantity(), car.getType(), CurrencyUtils.convertPriceToString(car.getRentalPrice()), car.getStatus());
        }
        System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
    }

    public void addCar() {
        Car car = new Car();
        boolean checkAddCarMenu = false;
        do {
            checkAddCarMenu = false;
            try {
                car.setId(System.currentTimeMillis() / 100000);
                String carName = inputCarName();
                car.setName(carName);
                String brand = inputBrand();
                car.setBrand(brand);
                int quantity = inputQuantity();
                car.setQuantity(quantity);
                System.out.println("ID Loại xe: ");
                int idType = Integer.parseInt(scanner.nextLine());
                car.setType(EType.findTypeByID(idType));
                double price = inputPrice();
                car.setRentalPrice(price);
                System.out.print("Tình trạng xe: ");
                int idCarStatus = Integer.parseInt(scanner.nextLine());
                car.setStatus(ECarStatus.findCarStatusByID(idCarStatus));
                checkAddCarMenu = false;
                carService.addCar(car);
            } catch (Exception e) {
                System.out.println("Lỗi! Vui lòng nhập lại!");
                e.printStackTrace();
                checkAddCarMenu = true;
            }
        } while (checkAddCarMenu);
    }

    public String inputCarName() {
        String carName;
        boolean checkContinueAction = true;
        boolean checkValidname;
        do {
            System.out.print("Tên xe (Viết bằng chữ in hoa): ");
            carName = scanner.nextLine();
            checkValidname = ValidateUtils.isNameValid(carName);
            if (checkValidname) {
                if (!carService.existsByName(carName)) {
                    checkContinueAction = false;
                } else {
                    System.out.println("Tên sản phẩm này đã tồn tại. Vui lòng nhập tên khác");
                    checkContinueAction = true;
                }
            } else {
                System.out.println("Tên sản phẩm không đúng cú pháp! Vui lòng nhập lại");
            }

        }
        while (checkContinueAction);
        return carName;
    }

    private String inputBrand() {
        System.out.println("Nhập tên hãng (Viết bằng chữ in hoa): ");
        String brand;
        while (!ValidateUtils.isNameValid(brand = CheckUtils.isEmpty())) {
            System.out.println("Tên hãng không đúng định dạng, xin mời nhập lại!");
        }
        return brand;
    }

    private int inputQuantity() {
        System.out.println("Nhập số lượng xe: ");
        int quantity;
        do {
            quantity = CheckUtils.isIntFormatCheck();
            if (quantity <= 0 || quantity >= 100)
                System.out.println("Số lượng xe phải lớn hơn 0 và nhỏ hơn 100 chiếc");
            System.out.println("Nhập số lượng xe: ");
        } while (quantity <= 0 || quantity >= 100);
        return quantity;
    }

    private double inputPrice() {
        System.out.println("Nhập giá thuê: ");
        double price;
        do {
            price = CheckUtils.isDoubleFormatCheck();
            if (price <= 1000000 || price > 20000000)
                System.out.println("Giá thuê phải lớn hơn 1.000.000 VNĐ và nhỏ hơn 20.000.000 VNĐ");
        } while (price <= 1000000 || price > 20000000);
        return price;
    }

    public void updateCar() {
        int choice;
        boolean checkActionMenu = true;
        do {
            try {
                showCar();
                long id = inputId();
                Car car = carService.findCarById(id);
                BannerUtils.menuBanner("CarView-Update");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        String name = inputCarName();
                        car.setName(name);
                        checkActionMenu = CheckUtils.checkContinueUpdateMenu();
                        break;
                    case 2:
                        String brand = inputBrand();
                        car.setBrand(brand);
                        checkActionMenu = CheckUtils.checkContinueUpdateMenu();
                        break;
                    case 3:
                        int quantity = inputQuantity();
                        car.setQuantity(quantity);
                        checkActionMenu = CheckUtils.checkContinueUpdateMenu();
                        break;
                    case 4:
                        setEType(car);
                        checkActionMenu = CheckUtils.checkContinueUpdateMenu();
                        break;
                    case 5:
                        double price = inputPrice();
                        car.setRentalPrice(price);
                        checkActionMenu = CheckUtils.checkContinueUpdateMenu();
                    case 6:
                        setECarStatus(car);
                        checkActionMenu = CheckUtils.checkContinueUpdateMenu();
                        break;
                    case 7:
                        launch();
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Vui lòng nhập số tương ứng với chức năng muốn chọn!");
                        break;
                }
                carService.updateCar(car, id);
            } catch (Exception e) {
                System.out.println("Vui lòng nhập lại");
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
                    boolean isId = carService.existById(id);
                    if (isId) {
                        checkActionMenu = false;
                    } else {
                        System.out.println("Không tìm thấy xe! Vui lòng nhập đúng ID!");
                    }
                } catch (Exception e) {
                    System.out.println("Vui lòng nhập vào ID tương ứng và không để trống!");
                }

            } while (checkActionMenu);
            return id;
        }

    public void setEType(Car car) {
        System.out.println("╔═══════SET TYPE════════╗");
        System.out.println("║   1. 4 chỗ            ║");
        System.out.println("║   2. 5 chỗ            ║");
        System.out.println("║   3. 7 chỗ            ║");
        System.out.println("╚═══════════════════════╝");
        System.out.println("➔ Chọn chức năng: ");
        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case -1:
                    break;
                case 1:
                    car.setType(EType.FourSeats);
                    break;
                case 2:
                    car.setType(EType.FiveSeats);
                    break;
                case 3:
                    car.setType(EType.SevenSeats);
                    break;
                default:
                    System.out.println("Nhập không đúng! Vui lòng nhập lại");
                    setEType(car);
            }
        } catch (Exception e) {
            System.out.println("\t Lựa chọn phải là 1 số ");
            System.out.println("\t═════════════════════════");
            setEType(car);
        }
    }

    public void setECarStatus(Car car) {
        System.out.println("╔═══════SET CAR STATUS════════╗");
        System.out.println("║         1. Rented           ║");
        System.out.println("║         2. Unrented         ║");
        System.out.println("╚═════════════════════════════╝");
        System.out.println("➔ Chọn chức năng: ");
        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case -1:
                    break;
                case 1:
                    car.setStatus(ECarStatus.Rented);
                    break;
                case 2:
                    car.setStatus(ECarStatus.Unrented);
                    break;
                default:
                    System.out.println("Nhập không đúng! Vui lòng nhập lại");
                    setEType(car);
            }
        } catch (Exception e) {
            System.out.println("\t Lựa chọn phải là 1 số ");
            System.out.println("\t═════════════════════════");
            setEType(car);
        }
    }
    public void removeCar() {
        boolean isRetry = true;
        do {
            showCar();
            long id = inputId();
            boolean checkActionMenu = true;
            do {
                try {
                    System.out.println("Bạn có chắc chắn muốn xoá không? Y/N");
                    String choice = scanner.nextLine().trim().toLowerCase();
                    switch (choice) {
                        case "y":
                            carService.removeCarById(id);
                            System.out.println("Xoá sản phẩm thành công!");
                            checkActionMenu = false;
                            break;
                        case "n":
                            checkActionMenu = false;
                            break;
                        default:
                            System.out.println("Vui lòng chọn Y hoặc N!");
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("Nhập sai! Xin mời nhập lại!");
                }
            } while (checkActionMenu);
        }while (isRetry == CheckUtils.checkContinueRemoveAction());
    }
    public void sortCar() {
        BannerUtils.menuBanner("CarView-Sort");
        int choice;
            try {
                List<Car> cars = carService.getAllCars();
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        cars.sort(new ComparatorIncreasingByPrice());
                        FileUtils.writeDataToFile(filePath,cars);
                        showCar();
                        break;
                    case 2:
                        cars.sort(new ComparatorDecreasingByPrice());
                        FileUtils.writeDataToFile(filePath,cars);
                        showCar();
                        break;
                    case 3:
                        carView.launch();
                        break;
                    case 4:
                        System.exit(0);
                    default:
                        System.out.println("Vui lòng nhập số tương ứng với chức năng muốn chọn!");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Nhập sai! Vui lòng nhập lại!");
                e.printStackTrace();
            }
    }
    public void searchCar() {
        int choice;
        boolean checkActionMenu = true;
        do {
            try {

            }
        }
    }
}
