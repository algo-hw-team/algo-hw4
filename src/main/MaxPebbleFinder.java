package main;

import java.util.ArrayList;

public class MaxPebbleFinder {

    private int N;
    private int [][]boardValues;

    public MaxPebbleFinder(int _N, int [][]_boardValues) {
        N = _N;
        boardValues = _boardValues;
    }

    public int getMaxPlacementSum() {
        return getMaxPlacementSumAfterCurrent(0, null);
    }

    private int getMaxPlacementSumAfterCurrent(int currentColumnIndex,
                                               PebbleColumnCase previousCase) {

        // base case: board의 범위를 넘어선 경우에는 0을 return
        if (currentColumnIndex == N) {
            return 0;
        }

        ArrayList<PebbleColumnCase> availableCases = PebbleColumnCase.getAvailableCases(previousCase);
        int maxSum = 0;

        for (PebbleColumnCase availableCase : availableCases) {
            int currentCaseSum = availableCase.getSum(boardValues[currentColumnIndex]);
            int maxSumAfterCurrent = getMaxPlacementSumAfterCurrent(currentColumnIndex + 1, availableCase);
            int _maxSum = currentCaseSum + maxSumAfterCurrent;

            if (_maxSum > maxSum) maxSum = _maxSum;
        }

        return maxSum;
    }

}
