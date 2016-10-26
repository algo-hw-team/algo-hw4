package main;

import java.util.ArrayList;

public class PebbleColumnCase {

    /**
     * 해당 case에 돌이 어떻게 배치되어있는지를 bitmask 로 표현한다.
     * 4 bit의 숫자 abcd에서 a는 row1, b는 row2, c는 row3, d는 row4에 돌이 놓여 있는지 여부를
     * 나타낸다. 이 값이 1이면 놓여있고, 0이면 놓여있지 않는 경우이다.
     */
    private int caseValue;

    /**
     * 보드에서 하나의 세로줄에서, 돌을 배치하는 하나의 case에 해당
     *  ----
     * |row1|
     *  ----
     * |row2|
     *  ----
     * |row3|
     *  ----
     * |row4|
     *  ----
     * 위와 같이 해당하고, 이를 위에서 설명한 caseValue 형식으로 나타내어 저장한다.
     *
     */
    PebbleColumnCase(int _caseValue) {
        caseValue = _caseValue;
    }

    /**
     * @return caseValue
     */
    public int getCaseValue() {
        return caseValue;
    }

    public int getSum(int []values) {
        int sum = 0;

        if ((caseValue & 0b1000) > 0) sum += values[0];
        if ((caseValue & 0b0100) > 0) sum += values[1];
        if ((caseValue & 0b0010) > 0) sum += values[2];
        if ((caseValue & 0b0001) > 0) sum += values[3];

        return sum;
    }

    /**
     * 왼쪽 column의 돌의 상황을 바탕으로 현재 column에서 나올 수 있는 모든 case를 구함
     * @param previousCase
     * @return
     */
    public static ArrayList<PebbleColumnCase> getAvailableCases(PebbleColumnCase previousCase) {
        int availableCaseValues[] = {
                0b0000, 0b0001, 0b0010, 0b0100,
                0b1000, 0b1010, 0b1001, 0b0101
        };
        ArrayList<PebbleColumnCase> availableCases = new ArrayList<>();
        int previousCaseValue = (previousCase == null) ?
                0b0000 :
                previousCase.caseValue;

        for (int availableCaseValue : availableCaseValues) {
            // previous의 column과 같은 row에는 돌을 놓을 수 없으므로, xor 연산값이 0인 caseValue만 add한다.
            if ((availableCaseValue & previousCaseValue) == 0) {
                availableCases.add(new PebbleColumnCase(availableCaseValue));
            }
        }

        return availableCases;
    }

}
