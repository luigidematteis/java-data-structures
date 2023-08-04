import arrays.MatrixZeroes;

import java.util.HashMap;
import java.util.Map;

import static funny.Compression.betterCompression;

public class Main {
    public static void main(String[] args) {
        MatrixZeroes matrixZeroes = new MatrixZeroes();
        int[][] array = {{1,1,1},{1,0,1},{1,1,1}};
        matrixZeroes.setZeroesBruteForce(array);
    }
}