package Lesson2;
class MyArraySizeException extends Exception { }
class MyArrayDataException extends Exception {
    int row;
    int column;
    public MyArrayDataException(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public String toString() {
        return "MyArrayDataException: invalid data in row " + row + " column " + column;
    }
}

public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            System.out.println("Sum of array elements: " + sumArrayElements(array));
        } catch (MyArraySizeException e) {
            System.out.println("MyArraySizeException: invalid array size");
        } catch (MyArrayDataException e) {
            System.out.println(e);
        }
    }

    public static int sumArrayElements(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException();
        }
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }

        return sum;
    }
}


