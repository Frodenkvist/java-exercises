package com.hackosynth.diamond;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class DiamondTest {
    @Test
    public void testOneByOneDiamond() {
        List<String> output = Diamond.printToList('A');
        assertIterableEquals(output, Collections.singleton("A"));
    }

    @Test
    public void testTwoByTwoDiamond() {
        List<String> output = Diamond.printToList('B');
        assertIterableEquals(output, Arrays.asList(
                " A ",
                "B B",
                " A "
        ));
    }

    @Test
    public void testThreeByThreeDiamond() {
        List<String> output = Diamond.printToList('C');
        assertIterableEquals(output, Arrays.asList(
                "  A  ",
                " B B ",
                "C   C",
                " B B ",
                "  A  "
        ));
    }

    @Test
    public void testFiveByFiveDiamond() {
        List<String> output = Diamond.printToList('E');
        assertIterableEquals(output, Arrays.asList(
                "    A    ",
                "   B B   ",
                "  C   C  ",
                " D     D ",
                "E       E",
                " D     D ",
                "  C   C  ",
                "   B B   ",
                "    A    "
        ));
    }

    @Test
    public void testFullDiamond() {
        List<String> output = Diamond.printToList('B');
        assertIterableEquals(output, Arrays.asList(
                "                         A                         ",
                "                        B B                        ",
                "                       C   C                       ",
                "                      D     D                      ",
                "                     E       E                     ",
                "                    F         F                    ",
                "                   G           G                   ",
                "                  H             H                  ",
                "                 I               I                 ",
                "                J                 J                ",
                "               K                   K               ",
                "              L                     L              ",
                "             M                       M             ",
                "            N                         N            ",
                "           O                           O           ",
                "          P                             P          ",
                "         Q                               Q         ",
                "        R                                 R        ",
                "       S                                   S       ",
                "      T                                     T      ",
                "     U                                       U     ",
                "    V                                         V    ",
                "   W                                           W   ",
                "  X                                             X  ",
                " Y                                               Y ",
                "Z                                                 Z",
                " Y                                               Y ",
                "  X                                             X  ",
                "   W                                           W   ",
                "    V                                         V    ",
                "     U                                       U     ",
                "      T                                     T      ",
                "       S                                   S       ",
                "        R                                 R        ",
                "         Q                               Q         ",
                "          P                             P          ",
                "           O                           O           ",
                "            N                         N            ",
                "             M                       M             ",
                "              L                     L              ",
                "               K                   K               ",
                "                J                 J                ",
                "                 I               I                 ",
                "                  H             H                  ",
                "                   G           G                   ",
                "                    F         F                    ",
                "                     E       E                     ",
                "                      D     D                      ",
                "                       C   C                       ",
                "                        B B                        ",
                "                         A                         "
        ));
    }
}
