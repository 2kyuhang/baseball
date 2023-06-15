package hellojpa;

import java.util.Scanner;

public class Baseballgame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = new int[3];         // 컴터
        int[] userNumbers = new int[3];     // 나
        int count = 1;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 9 + 1);

            for (int j = 0; j < i; j++) {
                if (numbers[i] == numbers[j]) {
                    i--;
                    break;
                }
            }
        }
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");

        while (true) {
            int strike = 0;
            int ball = 0;
            String input = "";

            // userNumbers
            System.out.print(count + "번째 시도 : ");
            input = sc.nextLine();

            if (input.length() == 3) {
                userNumbers[0] = input.charAt(0) - '0';
                userNumbers[1] = input.charAt(1) - '0';
                userNumbers[2] = input.charAt(2) - '0';

                // 중복 숫자 체크
                if (userNumbers[0] == userNumbers[1] || userNumbers[1] == userNumbers[2] || userNumbers[0] == userNumbers[2]) {
                    System.out.println("중복된 숫자를 입력하셨습니다. 다시 입력해주세요.");
                    continue;
                }
            } else {
                System.out.println("3자리 숫자를 입력해주세요. 다시 입력해주세요.");
                continue;
            }

            // numbers, userNumbers 비교
            for (int i = 0; i < numbers.length; i++) {
                for (int j = 0; j < userNumbers.length; j++) {
                    if (numbers[i] == userNumbers[j] && i == j) {
                        strike++;
                    } else if (numbers[i] == userNumbers[j] && i != j) {
                        ball++;
                    }
                }
            }
            System.out.println(ball + "B" + strike + "S");

            // 끝
            if (strike == 3) {
                System.out.println(count + "번만에 맞히셨습니다.");
                System.out.println("게임을 종료합니다.");
                break;
            }
            count++;
        }
    }
}