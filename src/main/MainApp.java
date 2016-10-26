package main;

import java.util.ArrayList;

public class MainApp {

    public static void main(String[] args) {
        int [][]boardValues = {
                {3, 1, 2, 8},
                {1, 9, 2, 30},
                {3, 2, 4, 3},
                {2, 4, 1, 1},
                {2, 1, 9, 20}
        };
        int [][]boardValues2 = {
                {14, 32, 16, 39},
                {11, 30, 43, 38},
                {40, 39, 46, 25},
                {3, 28, 45, 23},
                {9, 1, 44, 29},
                {42, 36, 41, 29},
                {6, 32, 47, 29}
        };
        int N = 7;

        MaxPebbleFinder finder = new MaxPebbleFinder(N, boardValues2);

        System.out.println(finder.getMaxPlacementSum());
    }
}