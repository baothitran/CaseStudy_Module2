package com.codegym.view;

import com.codegym.comparator.ComparatorDecreasingByPrice;
import com.codegym.comparator.ComparatorIncreasingByPrice;
import com.codegym.model.User;
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

    private Scanner scanner = new Scanner(System.in);

    public CarView() {
        carService = new CarService();
    }

    public void launch(User user) {
        AdminView adminView = new AdminView();
        boolean checkActionMenu = true;
        do {
            BannerUtils.menuBanner("CarView-Menu");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        showCar(carService.getAllCars());
                        break;
                    case 2:
                        addCar();
                        break;
                    case 3:
                        updateCar(user);
                        break;
                    case 4:
                        removeCar();
                        break;
                    case 5:
                        sortCar(user);
                        break;
                    case 6:
                        searchCar(user);
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
            } catch (Exception e) {
                System.out.println("Wrong value! Please enter again!");
            }
        } while (checkActionMenu);
    }

    public void showCar(List<Car> cars) {

        System.out.println("╔══════════════════════════════════════════════════════CAR LIST════════════════════════════════════════════════════════╗");
        System.out.printf("║%10s║ %38s║ %15s║ %15s║ %15s║ %15s║", "ID", "Car Name", "Brand", "Type", "Price", "Status");
        System.out.println();
        for (Car car : cars) {
            System.out.printf("║%10s║ %38s║ %15s║ %15s║ %15s║ %15s║\n",
                    car.getId(), car.getName(), car.getBrand(), car.getType(), CurrencyUtils.convertPriceToString(car.getRentalPrice()), car.getStatus());
        }
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
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
                int idType;
                do {
                    System.out.println("╔══════════TYPE══════════╗");
                    System.out.println("║   1. Four-seater car   ║");
                    System.out.println("║   2. Five-seater car   ║");
                    System.out.println("║   3. Seven-seater car  ║");
                    System.out.println("╚════════════════════════╝");
                    System.out.println("➔ Select:");
                    idType = Integer.parseInt(scanner.nextLine());
                    if (idType < 1 || idType > 3) {
                        System.out.println("Wrong value! Please enter again!");
                    }
                } while (idType < 1 || idType > 3);
                car.setType(EType.findTypeByID(idType));
                double price = inputPrice();
                car.setRentalPrice(price);
                car.setStatus(ECarStatus.Unrented);
                checkAddCarMenu = false;
                carService.addCar(car);
                System.out.println("ADD CAR SUCCESSFUL!");
            } catch (Exception e) {
                System.out.println("Wrong value! Please enter again!");
                checkAddCarMenu = true;
            }
        } while (checkAddCarMenu);
    }

    public String inputCarName() {
        String carName;
        boolean checkContinueAction = true;
        boolean checkValidname;
        do {
            System.out.print("Input car name (in capital letters): ");
            carName = scanner.nextLine();
            checkValidname = ValidateUtils.isCarNameValid(carName);
            if (checkValidname) {
                if (!carService.existsByName(carName)) {
                    checkContinueAction = false;
                } else {
                    System.out.println("This car name already exists. Please enter another name!");
                    checkContinueAction = true;
                }
            } else {
                System.out.println("The input car name is not in the correct format, please enter again!");
            }

        }
        while (checkContinueAction);
        return carName;
    }

    private String inputBrand() {
        System.out.println("Input brand (in capital letters): ");
        String brand;
        while (!ValidateUtils.isBrandNameValid(brand = CheckUtils.isEmpty())) {
            System.out.println("The input brand is not in the correct format, please enter again!");
        }
        return brand;
    }


    private double inputPrice() {
        System.out.println("Input rental price: ");
        double price;
        do {
            price = CheckUtils.isDoubleFormatCheck();
            if (price < 1000000 || price > 20000000)
                System.out.println("Rental price must be from 1,000,000 VND and less than or equal to 20,000,000 VND");
        } while (price < 1000000 || price > 20000000);
        return price;
    }

    public void updateCar(User user) {
        int choice;
        boolean checkActionMenu = true;
        do {
            try {
                showCar(carService.getAllCars());
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
                        setEType(car);
                        checkActionMenu = CheckUtils.checkContinueUpdateMenu();
                        break;
                    case 4:
                        double price = inputPrice();
                        car.setRentalPrice(price);
                        checkActionMenu = CheckUtils.checkContinueUpdateMenu();
                        break;
                    case 5:
                        setECarStatus(car);
                        checkActionMenu = CheckUtils.checkContinueUpdateMenu();
                        break;
                    case 6:
                        launch(user);
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Wrong value! Please enter again!");
                        break;
                }
                carService.updateCar(car, id);
            } catch (Exception e) {
                System.out.println("Error!");
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
                boolean isId = carService.existById(id);
                if (isId) {
                    checkActionMenu = false;
                } else {
                    System.out.println("Car not found! Please input the correct ID!");
                }
            } catch (Exception e) {
                System.out.println("Error! Please enter again!");
            }

        } while (checkActionMenu);
        return id;
    }

    public void setEType(Car car) {
        System.out.println("╔════════SET TYPE════════╗");
        System.out.println("║   1. Four-seater car   ║");
        System.out.println("║   2. Five-seater car   ║");
        System.out.println("║   3. Seven-seater car  ║");
        System.out.println("╚════════════════════════╝");
        System.out.println("➔ Select:");
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
                    System.out.println("Wrong value! Please enter again!");
                    setEType(car);
            }
        } catch (Exception e) {
            System.out.println("Wrong value! Please enter again!");
            setEType(car);
        }
    }

    public void setECarStatus(Car car) {
        System.out.println("╔═══════SET CAR STATUS════════╗");
        System.out.println("║         1. Rented           ║");
        System.out.println("║         2. Unrented         ║");
        System.out.println("╚═════════════════════════════╝");
        System.out.println("➔ Select:");
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
                    System.out.println("Wrong value! Please enter again!");
                    setEType(car);
            }
        } catch (Exception e) {
            System.out.println("Wrong value! Please enter again!");
            setEType(car);
        }
    }

    public void removeCar() {
        boolean isRetry = true;
        do {
            showCar(carService.getAllCars());
            long id = inputId();
            boolean checkActionMenu = true;
            do {
                try {
                    System.out.println("Are you sure to delete? Y/N");
                    String choice = scanner.nextLine().trim().toLowerCase();
                    switch (choice) {
                        case "y":
                            carService.removeCarById(id);
                            System.out.println("DELETE SUCCESSFUL!");
                            checkActionMenu = false;
                            break;
                        case "n":
                            checkActionMenu = false;
                            break;
                        default:
                            System.out.println("Please choose Y or N!");
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("Wrong value! Please enter again!");
                }
            } while (checkActionMenu);
        } while (isRetry == CheckUtils.checkContinueRemoveAction());
    }

    public void sortCar(User user) {
        CarView carView1 = new CarView();
        BannerUtils.menuBanner("CarView-Sort");
        int choice;
        try {
            List<Car> cars = carService.getAllCars();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    cars.sort(new ComparatorIncreasingByPrice());
                    FileUtils.writeDataToFile(filePath, cars);
                    showCar(carService.getAllCars());
                    break;
                case 2:
                    cars.sort(new ComparatorDecreasingByPrice());
                    FileUtils.writeDataToFile(filePath, cars);
                    showCar(carService.getAllCars());
                    break;
                case 3:
                    carView1.launch(user);
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
    }

    public void searchCar(User user) {
        CarView carView = new CarView();
        try {
            boolean checkActionMenu = false;
            do {
                Car car;
                checkActionMenu = false;
                BannerUtils.menuBanner("CarView-Search");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Input ID car: ");
                        long id = Long.parseLong(scanner.nextLine());
                        car = carService.findCarById(id);
                        System.out.println("╔══════════════════════════════════════════════════════CAR LIST════════════════════════════════════════════════════════╗");
                        System.out.printf("║%10s║ %38s║ %15s║ %15s║ %15s║ %15s║", "ID", "Car Name", "Brand", "Type", "Price", "Status");
                        System.out.println();
                        System.out.println(car.toData());
                        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
                        break;
                    case 2:
                        System.out.println("Input car name: ");
                        String name = scanner.nextLine().toUpperCase();
                        List<Car> cars = carService.findCarByName(name);
                        showCar(cars);
                        break;
                    case 3:
                        searchCarByType(carService.getAllCars(),user);
                        break;
                    case 4:
                        searchCarByStatus(carService.getAllCars(),user);
                        break;
                    case 5:
                        carView.launch(user);
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Wrong value! Please enter again!");
                        break;
                }
            } while (checkActionMenu);
        } catch (Exception e) {
            System.out.println("There are no matching car in the search results!");
        }
    }

    public void searchCarByType(List<Car> list,User user) {
        boolean checkActionMenu;
        do {
            checkActionMenu = false;
            try {
                BannerUtils.menuBanner("CarView-SearchByType");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        List<Car> carList = carService.findCarByType(list, 1);
                        System.out.println("╔═════════════════════════════════════════════════Four-seater Car List═════════════════════════════════════════════════╗");
                        System.out.printf("║%10s║ %38s║ %15s║ %15s║ %15s║ %15s║", "ID", "Car Name", "Brand", "Type", "Price", "Status");
                        System.out.println();
                        for (Car car : carList) {
                            System.out.printf(car.toData()).println();
                        }
                        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
                        break;
                    case 2:
                        List<Car> carList1 = carService.findCarByType(list, 2);
                        System.out.println("╔═════════════════════════════════════════════════Five-seater Car List═════════════════════════════════════════════════╗");
                        System.out.printf("║%10s║ %38s║ %15s║ %15s║ %15s║ %15s║", "ID", "Car Name", "Brand", "Type", "Price", "Status");
                        System.out.println();
                        for (Car car : carList1) {
                            System.out.printf(car.toData()).println();
                        }
                        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
                        break;
                    case 3:
                        List<Car> carList2 = carService.findCarByType(list, 3);
                        System.out.println("╔════════════════════════════════════════════════Seven-seater Car List═════════════════════════════════════════════════╗");
                        System.out.printf("║%10s║ %38s║ %15s║ %15s║ %15s║ %15s║", "ID", "Car Name", "Brand", "Type", "Price", "Status");
                        System.out.println();
                        for (Car car : carList2) {
                            System.out.printf(car.toData()).println();
                        }
                        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
                        break;
                    case 4:
                        searchCar(user);
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

    public void searchCarByStatus(List<Car> list,User user) {
        boolean checkActionMenu;
        do {
            checkActionMenu = false;
            try {
                BannerUtils.menuBanner("CarView-SearchByStatus");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        List<Car> carList = carService.findCarByStatus(list, 2);
                        System.out.println("╔═══════════════════════════════════════════════════UNRENTED CAR LIST══════════════════════════════════════════════════╗");
                        System.out.printf("║%10s║ %38s║ %15s║ %15s║ %15s║ %15s║", "ID", "Car Name", "Brand", "Type", "Price", "Status");
                        System.out.println();
                        for (Car car : carList) {
                            System.out.printf(car.toData()).println();
                        }
                        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
                        break;
                    case 2:
                        List<Car> carList1 = carService.findCarByStatus(list, 1);
                        System.out.println("╔═══════════════════════════════════════════════════RENTED CAR LIST════════════════════════════════════════════════════╗");
                        System.out.printf("║%10s║ %38s║ %15s║ %15s║ %15s║ %15s║", "ID", "Car Name", "Brand", "Type", "Price", "Status");
                        System.out.println();
                        for (Car car : carList1) {
                            System.out.printf(car.toData()).println();
                        }
                        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
                        break;
                    case 3:
                        searchCar(user);
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
}
