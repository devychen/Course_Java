package st8;

import org.junit.Test;
import static org.junit.Assert.*;

public class STArraysTest {

    @Test
    public void testToString() {
        int[] arr = { 5, 7, 9, 2 };
        String expected = "[5, 7, 9, 2]";
        String actual = STArrays.toString(arr);
        assertEquals(expected, actual);
    }

    @Test
    public void testToString1() {
        int[] arr = {};
        String expected = "[]";
        String actual = STArrays.toString(arr);
        assertEquals(expected, actual);
    }

    @Test
    public void testToString2() {
        int[] arr = {5};
        String expected = "[5]";
        String actual = STArrays.toString(arr);
        assertEquals(expected, actual);
    }

    @Test
    public void testSlice1normal(){
        int[] arr = { 5, 7, 9, 2 };
        int start = 1;
        int end = 3;
        int[] expected = { 7, 9 };
        int[] actual = STArrays.slice(arr, start, end);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSlice2normal(){
        int[] arr = { 5, 7, 9, 2 };
        int start = 1;
        int end = 1;
        int[] expected = {};
        int[] actual = STArrays.slice(arr, start, end);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSlice3normal(){
        int[] arr = { 5, 7, 9, 2 };
        int start = 1;
        int end = 2;
        int[] expected = {7};
        int[] actual = STArrays.slice(arr, start, end);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSlice4_EndOFB(){
        int[] arr = { 5, 7, 9, 2 };
        int start = 3;
        int end = 7;
        int[] expected = null;
        int[] actual = STArrays.slice(arr, start, end);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSlice5_StartOFB(){
        int[] arr = { 5, 7, 9, 2 };
        int start = 4;
        int end = 5;
        int[] expected = null;
        int[] actual = STArrays.slice(arr, start, end);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSlice5_StartBigger(){
        int[] arr = { 5, 7, 9, 2 };
        int start = 3;
        int end = 1;
        int[] expected = null;
        int[] actual = STArrays.slice(arr, start, end);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSlice6_ArrNull(){
        int[] arr = null;
        int start = 1;
        int end = 2;
        int[] expected = null;
        int[] actual = STArrays.slice(arr, start, end);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSlice6_StartBelow0(){
        int[] arr = { 5, 7, 9, 2 };
        int start = -1;
        int end = 2;
        int[] expected = null;
        int[] actual = STArrays.slice(arr, start, end);
        assertArrayEquals(expected, actual);
    }
}