/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author Berkay BADANOZ
 */
public class Triangles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner b = new Scanner(System.in);
        boolean matrix[][] = new boolean[51][51];// I crated 51*51 2d array
        System.out.println("Enter 6 numbers coordinate to draw triangle");

        int x0 = b.nextInt();
        int y0 = b.nextInt();
        int x1 = b.nextInt();
        int y1 = b.nextInt();
        int x2 = b.nextInt();
        int y2 = b.nextInt();
        if (x0 == 0 && y0 == 0 && x1 == 0 && y1 == 0 && x2 == 0 && y2 == 0) {
            clearMatrix(matrix);
            System.out.println("invalid imput");
            System.exit(1);

        }
        clearMatrix(matrix);
        matrix = drawLine(matrix, x0, y0, x1, y1, x2, y2);
        printMatrix(matrix);

    }

    public static boolean[][] printMatrix(boolean matrix[][]) {

        for (int i = 0; i <= 50; i++) {
            for (int j = 0; j <= 50; j++) {
                if (matrix[i][j] == false) {
                    System.out.print(" ");
                } else if (matrix[i][j] == true) {
                    System.out.print("*");
                }
            }
            System.out.println(" ");
        }
        return matrix;
    }

    public static boolean[][] clearMatrix(boolean matrix[][]) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = false;
            }

        }
        return matrix;
    }

    public static boolean[][] drawLine(boolean matrix[][], int x0, int y0, int x1, int y1, int x2, int y2) {

        int dx = x1 - x0;
        int dy = y1 - y0;
        int dx2 = x2 - x1;
        int dy2 = y2 - y1;
        int dx1 = x2 - x0;
        int dy1 = y2 - y0;

        for (int X = 0; X < matrix.length; X++) {
            for (int Y = 0; Y < matrix[X].length; Y++) {
                if (Y >= y0 && X >= x0 && Y <= y1 && X <= x1 || Y >= y0 && X >= x1 && Y <= y1 && X <= x0) {// first one  normal situation Second one  is i use where the slope is minus
                    if (dx == 0 && Y >= y0 && X >= x0 && Y <= y1 && X <= x1) {// if dx equals 0 will be  horizantal writing.

                        matrix[X][Y] = true;

                    } else if (dx != 0 && Y == y0 + dy * (X - x0) / dx) {

                        matrix[X][Y] = true;

                    } else if (dy != 0 && X == x0 + dx * (Y - y0) / dy) {
                        matrix[X][Y] = true;

                    }

                }
                if (Y >= y1 && X >= x1 && Y <= y2 && X <= x2 || Y >= y1 && X >= x2 && Y <= y2 && X <= x1) {
                    if (dx2 == 0 && Y >= y1 && X >= x1 && Y <= y2 && X <= x2) {

                        matrix[X][Y] = true;

                    } else if (dx2 != 0 && Y == y1 + dy2 * (X - x1) / dx2) {

                        matrix[X][Y] = true;

                    } else if (dy2 != 0 && X == x1 + dx2 * (Y - y1) / dy2) {
                        matrix[X][Y] = true;

                    }

                }

                if (Y >= y0 && X >= x0 && Y <= y2 && X <= x2 || Y >= y0 && X >= x2 && Y <= y2 && X <= x0) {
                    if (dx1 == 0 && Y >= y0 && X >= x0 && Y <= y2 && X <= x2) {

                        matrix[X][Y] = true;

                    } else if (dx1 != 0 && Y == y0 + dy1 * (X - x0) / dx1) {

                        matrix[X][Y] = true;

                    } else if (dy1 != 0 && X == x0 + dx1 * (Y - y0) / dy1) {
                        matrix[X][Y] = true;
                    }
                }
            }
        }

        return matrix;
    }
}
