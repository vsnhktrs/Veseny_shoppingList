package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.service.Action;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

    private final List<Action> actions;

    public ConsoleUI(List<Action> actions) {
        this.actions = actions;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int response = 0;

        while (response >= 0) {
            printMenu();
            try {
                response = scanner.nextInt();
                actions.get(response).execute();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception f) {
                System.out.println("Error! Please try again.");
            }
        }
    }

    private void printMenu() {
        for (int i = 0; i < actions.size(); i++) {
            System.out.println(i + ". " + actions.get(i));
        }
    }
}
