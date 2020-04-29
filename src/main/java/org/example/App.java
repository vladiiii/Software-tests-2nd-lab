package org.example;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class App {
    App() {
    }

    public static double[][] ReadMatrix() throws Exception {
        FileReader fileReader = new FileReader("./src/main/java/resources/msize");
        Scanner scanner = new Scanner(fileReader);

        List<Double> matrix = new ArrayList<>();

        int row = 0, col = 0;
        while(scanner.hasNextLine()) {
            col = 0;
            Scanner rowScanner = new Scanner(scanner.nextLine());
            while(rowScanner.hasNextDouble()) {
                matrix.add(rowScanner.nextDouble());
                col++;
            }
            row++;
        }
        double[][] result = new double[row][col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                result[r][c] = matrix.get(r * c + c);
            }
        }
        fileReader.close();
        return result;
    }

    public static double[][] Summ(double[][] firstMatrix, double[][] secondMatrix) { double[][] result = new double[firstMatrix.length][secondMatrix[0].length];
        for (int row = 0; row < result.length; row++)
        {
            for (int col = 0; col < result[row].length; col++)
            {
                result[row][col] = firstMatrix[row][col] + secondMatrix[row][col];
            }
        }
        return result;
    }

    public static double[][] Division(double[][] firstMatrix, double[][] secondMatrix) {
        double[][] result = new double[firstMatrix.length][secondMatrix[0].length];
        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                for (int i = 0; i < secondMatrix.length; i++) {
                    result[row][col] += firstMatrix[row][i] * Math.pow(secondMatrix[i][col],-1);
                }
            }
        }
        return result;
    }

    public static double[][] Subtraction(double[][] firstMatrix, double[][] secondMatrix) {
        double[][] result = new double[firstMatrix.length][secondMatrix[0].length];
        for (int row = 0; row < result.length; row++)
        {
            for (int col = 0; col < result[row].length; col++)
            {
                result[row][col] = firstMatrix[row][col] - secondMatrix[row][col];
            }
        }
        return result;
    }

    public static int Comparison(double[][] firstMatrix, double[][] secondMatrix) {
        int result = 0;
        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if(firstMatrix[row][col] != secondMatrix[row][col]) {
                    result =-1;
                }
            }
        }
        return result;
    }

    public static double[][] Multiply(double[][] firstMatrix, double[][] secondMatrix) {
        double[][] result = new double[firstMatrix.length][secondMatrix[0].length];
        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] += MultiplyMatricesCell(firstMatrix, secondMatrix, row, col);
            }
        }
        return result;
    }
    private static double MultiplyMatricesCell(double[][] firstMatrix, double[][] secondMatrix, int row, int col) {
        double cell = 0;
        for (int i = 0; i < secondMatrix.length; i++) {
            cell = firstMatrix[row][i] * secondMatrix[i][col];
        }
        return cell;
    }

    public static double Determinant(double[][] matrix) {
        if (matrix.length != matrix[0].length)
            throw new IllegalStateException("invalid dimensions");

        if (matrix.length == 2)
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        double det = 0;
        for (int i = 0; i < matrix[0].length; i++)
            det += Math.pow(-1, i) * matrix[0][i]
                * Determinant(Minor(matrix, 0, i));
        return det;
    }

    public static double[][] Minor(double[][] matrix, int row, int column) {
        double[][] minor = new double[matrix.length - 1][matrix.length - 1];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; i != row && j < matrix[i].length; j++)
                if (j != column)

                    minor[i < row ? i : i - 1][j < column ? j : j - 1] = matrix[i][j];
        return minor;
    }

    static boolean Palindrome(String arr)
    {
        char[] chars = arr.toCharArray();
        int length = chars.length;
        for (int i = 0; i <= length / 2 && length != 0; i++) {
            if ( chars[i] != chars[length - i - 1]) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static double[][] Transpose(double[][] matrix) {
        double[][] transpose = new double[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                transpose[j][i] = matrix[i][j];
        return transpose;
    }

    public static void Print(double[][] matrix) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++)
                System.out.print(matrix[i][j]+" ");
            System.out.println();
        }
    }
}
