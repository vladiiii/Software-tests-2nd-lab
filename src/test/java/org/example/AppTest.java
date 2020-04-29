package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;;
import java.io.FileNotFoundException;

class AppTest {

    private App application;

    @Before
    public void init() {
        application= new App();
    }

    @After
    public void tearDown() {
        application = null;
    }

    @Test
    void TestApp() {
        assertEquals(1, 1);
    }

    @ParameterizedTest

    @ValueSource(strings = { "5, 5, 5, 5, 5 ", "1, 5, 5, 1, 0 ", "5, 1, 5, 5, 1 ", "5, 1, 5, 1, 5 "})
    void Palindrome(String date) {
        assertTrue(App.Palindrome(date));
    }

    @Test
    public void Transpose() {
        double[][] matrix = {{8,7},{1,4}};
        double[][] result = {{8,1},{7,4}};
        assertArrayEquals(result, application.Transpose(matrix));
    }

    @Test
    public void Determinant() throws FileNotFoundException {
        double[][] matrix = {{6,12},{4,6}};
        assertEquals(-12, application.Determinant(matrix));
    }

    @Test
    public void Minor() {
        double[][] matrixfirst = {{2,1},{5,7}};
        double[][] matrixsecond = {{2}};
        assertArrayEquals(matrixsecond, application.Minor(matrixfirst,1,1));
    }

    @Test
    public void Сomparison() {
        double[][] matrixfirst = {{21,5},{7,4}};
        double[][] matrixsecond = {{1,5},{3,52}};
        int result = application.Comparison(matrixfirst, matrixsecond);
        Assert.assertEquals(-1, result);
    }

    @Test
    public void ReadMatrix() throws Exception {
        double[][] matrix = {{1,1},{1,1}};
        assertArrayEquals(matrix, application.ReadMatrix());
    }

    @Test
    public void Summ() {
        double[][] matrixfirst = {{24,23},{52,34}};
        double[][] matrixsecond = {{423,22},{44,22}};
        double[][] result = {{447,45},{96,56}};
        assertArrayEquals(result, application.Summ(matrixfirst, matrixsecond));
    }

    @Test
    public void Multiply() {
        double[][] matrixfirst = {{212,44},{4122,453}};
        double[][] matrixsecond = {{75,245},{56,324}};
        double[][] result = {{2464,14256},{25368,146772}};
        assertArrayEquals(result, application.Multiply(matrixfirst, matrixsecond));
    }

    @Test
    public void Subtraction() {
        double[][] matrixfirst = {{54,345},{324,12}};
        double[][] matrixsecond = {{324,423},{421,4}};
        double[][] result = {{-270,-78},{-97,8}};
        assertArrayEquals(result, application.Subtraction(matrixfirst, matrixsecond));
    }

    @Test
    public void Division() {
        double[][] matrixfirst = {{12,86},{214,9}};
        double[][] matrixsecond = {{4,2},{2,3}};
        double[][] result = {{46.0,34.666666666666664},{58.0,110.0}};
        assertArrayEquals(result, application.Division(matrixfirst, matrixsecond));
    }
}
