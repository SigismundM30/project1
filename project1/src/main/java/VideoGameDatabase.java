import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class VideoGame {
    private String size;
    private String platform;
    private String title;
    private int year;
    private float price;

    public VideoGame(String size, String platform, String title, int year, float price) {
        this.size = size;
        this.platform = platform;
        this.title = title;
        this.year = year;
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public String getPlatform() {
        return platform;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public float getPrice() {
        return price;
    }
}

public class VideoGameDatabase {
    private static List<VideoGame> gameData = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("  _   _  U _____ u  _       _       U  ___ u  _   \n" +
                " |'| |'| \\| ___\"|/ |\"|     |\"|       \\/\"_ \\/U|\"|u \n" +
                "/| |_| |\\ |  _|\" U | | u U | | u     | | | |\\| |/ \n" +
                "U|  _  |u | |___  \\| |/__ \\| |/__.-,_| |_| | |_|  \n" +
                " |_| |_|  |_____|  |_____| |_____|\\_)-\\___/  (_)  \n" +
                " //   \\\\  <<   >>  //  \\\\  //  \\\\      \\\\    |||_ \n" +
                "(_\") (\"_)(__) (__)(_\")(\"_)(_\")(\"_)    (__)  (__)_)");

        while (true) {
            System.out.println("             ---Video Game Database ---\n" +
                    "            1. Add a new game\n" +
                    "            2. Compare games by size(GB)\n" +
                    "            3. Compare games by platform\n" +
                    "            4. Compare games by title\n" +
                    "            5. Compare games by year\n" +
                    "            6. Compare games by price(￥)\n" +
                    "            0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addGame(scanner);
                    break;
                case 2:
                    compareGamesBySize();
                    break;
                case 3:
                    compareGamesByPlatform();
                    break;
                case 4:
                    compareGamesByTitle();
                    break;
                case 5:
                    compareGamesByYear();
                    break;
                case 6:
                    compareGamesByPrice();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addGame(Scanner scanner) {
        System.out.print("Enter the size of the game: ");
        String size = scanner.nextLine();

        System.out.print("Enter the platform of the game: ");
        String platform = scanner.nextLine();

        System.out.print("Enter the title of the game: ");
        String title = scanner.nextLine();

        System.out.print("Enter the year the game was produced: ");
        int year = scanner.nextInt();

        System.out.print("Enter the price of the game: ");
        float price = scanner.nextFloat();

        VideoGame game = new VideoGame(size, platform, title, year, price);
        gameData.add(game);

        System.out.println("Game added successfully!");
    }

    private static void compareGamesBySize() {
        if (gameData.isEmpty()) {
            System.out.println("No games found!");
            return;
        }
        Collections.sort(gameData, Comparator.comparing(VideoGame::getSize));

        for (VideoGame game : gameData) {
            System.out.println(game.getTitle() + ": " + game.getSize());
        }
    }

    private static void compareGamesByPlatform() {
        if (gameData.isEmpty()) {
            System.out.println("No games found!");
            return;
        }
        Collections.sort(gameData, Comparator.comparing(VideoGame::getPlatform));

        for (VideoGame game : gameData) {
            System.out.println(game.getTitle() + ": " + game.getPlatform());
        }
    }

    private static void compareGamesByTitle() {
        if (gameData.isEmpty()) {
            System.out.println("No games found!");
            return;
        }
        Collections.sort(gameData, Comparator.comparing(VideoGame::getTitle));

        for (VideoGame game : gameData) {
            System.out.println(game.getTitle());
        }
    }

    private static void compareGamesByYear() {
        if (gameData.isEmpty()) {
            System.out.println("No games found!");
            return;
        }
        Collections.sort(gameData, Comparator.comparingInt(VideoGame::getYear));

        for (VideoGame game : gameData) {
            System.out.println(game.getTitle() + ": " + game.getYear());
        }
    }

    private static void compareGamesByPrice() {
        if (gameData.isEmpty()) {
            System.out.println("No games found!");
            return;
        }
        Collections.sort(gameData, Comparator.comparingDouble(VideoGame::getPrice));

        for (VideoGame game : gameData) {
            System.out.println(game.getTitle() + ": " + game.getPrice());
        }
    }
}
