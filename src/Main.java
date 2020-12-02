public class Main {

    public static void main(String[] args) {
        int tableSize = 10;
        int row = 0;
        int column = 0;

        for (row = 0; row < tableSize; row++) {
            for (column = 0; column < tableSize; column++) {
                if (row > column) {
                    System.out.print(tableSize - 1 - row);
                } else {
                    System.out.print(tableSize - 1 - column);
                }
            }
            System.out.println();
        }
    }
}
