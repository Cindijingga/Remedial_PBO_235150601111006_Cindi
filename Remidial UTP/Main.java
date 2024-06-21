import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membuat instance Cinema
        Cinema cinema = new Cinema("UTP A Cinema", 3);

        // Inisialisasi data studio
        cinema.init();

        // Menu utama
        while (true) {
            System.out.println("--------------------------------");
            System.out.println("UTP A Cinema");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Pick your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.println("--------------------------------");
                System.out.println("Login to our system");
                System.out.print("Email : ");
                String email = scanner.nextLine();
                System.out.print("Password : ");
                String password = scanner.nextLine();

                User loggedInUser = cinema.authenticateUser(email, password);
                if (loggedInUser != null) {
                    System.out.println("Login Success");
                    System.out.println("--------------------------------");
                    userMenu(cinema, loggedInUser, scanner);
                } else {
                    System.out.println("Invalid email or password.");
                }
            } else if (choice == 2) {
                System.out.println("--------------------------------");
                System.out.println("Register for our system");
                System.out.print("Fullname : ");
                String fullName = scanner.nextLine();
                System.out.print("Email : ");
                String email = scanner.nextLine();
                System.out.print("Password : ");
                String password = scanner.nextLine();
                System.out.print("Initial Balance : ");
                double balance = scanner.nextDouble();
                scanner.nextLine(); // Consume newline

                User newUser = new User(email, password, fullName, balance);
                if (cinema.registerUser(newUser)) {
                    System.out.println("Successfully registered User!");
                } else {
                    System.out.println("Registration failed.");
                }
                System.out.println("--------------------------------");
            } else if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }

    private static void userMenu(Cinema cinema, User user, Scanner scanner) {
        while (true) {
            System.out.println("Welcome " + user.getFullName() + " to " + cinema.getName() + "!");
            System.out.println("1. Pesan Tiket");
            System.out.println("2. Tampilkan Tiket milik Saya");
            System.out.println("3. Lihat Studio yang Ada");
            System.out.println("4. Lihat Detail Studio");
            System.out.println("5. Top Up Saldo");
            System.out.println("6. Exit Program");
            System.out.print("Pick your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.print("Enter studio number: ");
                int studioNumber = scanner.nextInt();
                System.out.print("Enter seat row: ");
                int row = scanner.nextInt();
                System.out.print("Enter seat column (A-Z): ");
                char col = scanner.next().charAt(0);
                scanner.nextLine(); // Consume newline

                if (cinema.bookTicket(user, studioNumber, row, col)) {
                    System.out.println("Ticket booked successfully.");
                } else {
                    System.out.println("Failed to book ticket.");
                }
            } else if (choice == 2) {
                user.displayAllTickets();
            } else if (choice == 3) {
                cinema.displayListStudio();
            } else if (choice == 4) {
                System.out.print("Enter studio number: ");
                int studioNumber = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                cinema.displayStudioDetail(studioNumber);
            } else if (choice == 5) {
                System.out.print("Masukkan saldo yang ingin ditopup: ");
                double amount = scanner.nextDouble();
                user.setBalance(user.getBalance() + amount);
                System.out.println("Top Up berhasil");
                System.out.println("Saldo anda sekarang Rp " + user.getBalance());
            } else if (choice == 6) {
                System.out.println("Logged out.");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
    }
}
