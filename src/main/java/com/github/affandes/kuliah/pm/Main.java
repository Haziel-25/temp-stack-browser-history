package com.github.affandes.kuliah.pm;

import java.util.ArrayList;
import java.util.Scanner;

public class BrowserHistory {
    private ArrayList<String> history;

    public BrowserHistory() {
        history = new ArrayList<>();
    }

    public void visit(String url) {
        history.add(url);
        System.out.println("Visited: " + url);
    }

    public void showHistory() {
        if (history.isEmpty()) {
            System.out.println("No history available.");
        } else {
            System.out.println("Browser History:");
            for (int i = 0; i < history.size(); i++) {
                System.out.println((i + 1) + ". " + history.get(i));
            }
        }
    }

    public void clearHistory() {
        history.clear();
        System.out.println("Browser history cleared.");
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Browser History Menu ---");
            System.out.println("1. Visit a site");
            System.out.println("2. Show history");
            System.out.println("3. Clear history");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter URL to visit: ");
                    String url = scanner.nextLine();
                    browserHistory.visit(url);
                    break;
                case 2:
                    browserHistory.showHistory();
                    break;
                case 3:
                    browserHistory.clearHistory();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
