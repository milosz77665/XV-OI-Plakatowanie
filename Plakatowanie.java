import java.util.Scanner;

public class Plakatowanie {

    public static int solution() {
        Scanner scanner = new Scanner(System.in);
        int result = 0;
        int numberOfBuildings = scanner.nextInt();
        int[] stack = new int[numberOfBuildings];
        scanner.nextLine();
        stack[0] = Integer.parseInt(scanner.nextLine().split(" ")[1]);
        int height;
        int lastElementIndex = 0;
        for (int i = 1; i < numberOfBuildings; i++) {
            height = Integer.parseInt(scanner.nextLine().split(" ")[1]);
            if (lastElementIndex >= 0) {
                while (stack[lastElementIndex] > height) {
                    result++;
                    lastElementIndex--;
                    if (lastElementIndex < 0) {
                        break;
                    }
                }
            }
            if (lastElementIndex >= 0) {
                if (stack[lastElementIndex] != height) {
                    lastElementIndex++;
                    stack[lastElementIndex] = height;
                }
            } else {
                lastElementIndex++;
                stack[lastElementIndex] = height;
            }
        }
        result += lastElementIndex + 1;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution());
    }
}