package com.hackosynth.matrix;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatrixTest {
    @Test
    public void extractRowFromOneNumberMatrix() {
        String matrixAsString = "1";
        int rowIndex = 1;
        List<Integer> expectedRow = Collections.singletonList(1);

        assertEquals(expectedRow, new Matrix(matrixAsString).row(rowIndex));
    }

    @Test
    public void extractRowFromMatrix() {
        String matrixAsString = "1 2\n3 4";
        int rowIndex = 2;
        List<Integer> expectedRow = Arrays.asList(3, 4);

        assertEquals(expectedRow, new Matrix(matrixAsString).row(rowIndex));
    }

    @Test
    public void extractRowFromDiffWidthsMatrix() {
        String matrixAsString = "1 2\n10 20";
        int rowIndex = 2;
        List<Integer> expectedRow = Arrays.asList(10, 20);

        assertEquals(expectedRow, new Matrix(matrixAsString).row(rowIndex));
    }

    @Test
    public void extractRowFromSquareMatrix() {
        String matrixAsString = String.join("\n",
                "1 2 3",
                "4 5 6",
                "7 8 9",
                "8 7 6"
        );
        int rowIndex = 4;
        List<Integer> expectedRow = Arrays.asList(8, 7, 6);

        assertEquals(expectedRow, new Matrix(matrixAsString).row(rowIndex));
    }

    @Test
    public void extractColumnFromOneNumberMatrix() {
        String matrixAsString = "1";
        int columnIndex = 1;
        List<Integer> expectedColumn = Collections.singletonList(1);

        assertEquals(expectedColumn, new Matrix(matrixAsString).column(columnIndex));
    }

    @Test
    public void extractColumnFromMatrix() {
        String matrixAsString = String.join("\n",
                "1 2 3",
                "4 5 6",
                "7 8 9"
        );
        int columnIndex = 3;
        List<Integer> expectedColumn = Arrays.asList(3, 6, 9);

        assertEquals(expectedColumn, new Matrix(matrixAsString).row(columnIndex));
    }

    @Test
    public void extractColumnFromNonSquareMatrix() {
        String matrixAsString = String.join("\n",
                "1 2 3 4",
                "5 6 7 8",
                "9 8 7 6"
        );
        int columnIndex = 4;
        List<Integer> expectedColumn = Arrays.asList(4, 8, 6);

        assertEquals(expectedColumn, new Matrix(matrixAsString).row(columnIndex));
    }

    @Test
    public void extractColumnFromDiffWidthsMatrix() {
        String matrixAsString = String.join("\n",
                "89 1903    3",
                "18    3   1",
                "9     4 800"
        );
        int columnIndex = 2;
        List<Integer> expectedColumn = Arrays.asList(1903, 3, 4);

        assertEquals(expectedColumn, new Matrix(matrixAsString).row(columnIndex));
    }
}
