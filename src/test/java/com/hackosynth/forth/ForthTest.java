package com.hackosynth.forth;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ForthTest {
    static class ParsingAndNumbersTest {
        @Test
        public void numbersJustGetPushedOntoTheStack() {
            assertIterableEquals(Arrays.asList(1, 2, 3, 4, 5), Forth.evaluate("1 2 3 4 5"));
        }
    }

    static class Addition {
        @Test
        public void canAddTwoNumbers() {
            assertIterableEquals(Collections.singleton(3), Forth.evaluate("1 2 +"));
        }

        @Test
        public void errorsIfThereIsNothingOnTheStack() {
            assertThrows(RuntimeException.class, () -> Forth.evaluate("+"));
        }

        @Test
        public void errorsIfThereIsOnlyOneValueOnTheStack() {
            assertThrows(RuntimeException.class, () -> Forth.evaluate("1 +"));
        }
    }

    static class Subtraction {
        @Test
        public void canSubtractTwoNumbers() {
            assertIterableEquals(Collections.singleton(-1), Forth.evaluate("3 4 -"));
        }

        @Test
        public void errorsIfThereIsNothingOnTheStack() {
            assertThrows(RuntimeException.class, () -> Forth.evaluate("-"));
        }

        @Test
        public void errorsIfThereIsOnlyOneValueOnTheStack() {
            assertThrows(RuntimeException.class, () -> Forth.evaluate("1 -"));
        }
    }

    static class Multiplication {
        @Test
        public void canMultiplyTwoNumbers() {
            assertIterableEquals(Collections.singleton(8), Forth.evaluate("2 4 *"));
        }

        @Test
        public void errorsIfThereIsNothingOnTheStack() {
            assertThrows(RuntimeException.class, () -> Forth.evaluate("*"));
        }

        @Test
        public void errorsIfThereIsOnlyOneValueOnTheStack() {
            assertThrows(RuntimeException.class, () -> Forth.evaluate("1 *"));
        }
    }

    static class Division {
        @Test
        public void canDivideTwoNumbers() {
            assertIterableEquals(Collections.singleton(4), Forth.evaluate("12 3 /"));
        }

        @Test
        public void performsIntegerDivision() {
            assertIterableEquals(Collections.singleton(2), Forth.evaluate("8 3 /"));
        }

        @Test
        public void errorsIfDividingByZero() {
            assertThrows(RuntimeException.class, () -> Forth.evaluate("4 0 /"));
        }

        @Test
        public void errorsIfThereIsNothingOnTheStack() {
            assertThrows(RuntimeException.class, () -> Forth.evaluate("/"));
        }

        @Test
        public void errorsIfThereIsOnlyOneValueOnTheStack() {
            assertThrows(RuntimeException.class, () -> Forth.evaluate("1 /"));
        }
    }

    static class CombinedArithmetic {
        @Test
        public void additionAndSubtraction() {
            assertIterableEquals(Collections.singleton(-1), Forth.evaluate("1 2 + 4 -"));
        }

        @Test
        public void multiplicationAndDivision() {
            assertIterableEquals(Collections.singleton(2), Forth.evaluate("2 4 * 3 /"));
        }
    }

    static class Dup {
        @Test
        public void copiesAValueOnTheStack() {
            assertIterableEquals(Arrays.asList(1, 1), Forth.evaluate("1 dup"));
        }

        @Test
        public void copiesTheTopValueOnTheStack() {
            assertIterableEquals(Arrays.asList(1, 2, 2), Forth.evaluate("1 2 dup"));
        }

        @Test
        public void errorsIfThereIsNothingOnTheStack() {
            assertThrows(RuntimeException.class, () -> Forth.evaluate("dup"));
        }
    }

    static class Drop {
        @Test
        public void removesTheTopValueOnTheStackIfItIsTheOnlyOne() {
            assertIterableEquals(Collections.emptyList(), Forth.evaluate("1 drop"));
        }

        @Test
        public void removesTheTopValueOnTheStackIfItIsNotTheOnlyOne() {
            assertIterableEquals(Collections.singleton(1), Forth.evaluate("1 2 drop"));
        }

        @Test
        public void errorsIfThereIsNothingOnTheStack() {
            assertThrows(RuntimeException.class, () -> Forth.evaluate("drop"));
        }
    }

    static class Swap {
        @Test
        public void swapsTheTopTwoValuesOnTheStackIfTheyAreTheOnlyOnes() {
            assertIterableEquals(Arrays.asList(2, 1), Forth.evaluate("1 2 swap"));
        }

        @Test
        public void swapsTheTopTwoValuesOnTheStackIfTheyAreNotTheOnlyOnes() {
            assertIterableEquals(Arrays.asList(1, 3, 2), Forth.evaluate("1 2 3 swap"));
        }

        @Test
        public void errorsIfThereIsNothingOnTheStack() {
            assertThrows(RuntimeException.class, () -> Forth.evaluate("swap"));
        }

        @Test
        public void errorsIfThereIsOnlyOneValueOnTheStack() {
            assertThrows(RuntimeException.class, () -> Forth.evaluate("1 swap"));
        }
    }

    static class Over {
        @Test
        public void copiesTheSecondElementIfThereAreOnlyTwo() {
            assertIterableEquals(Arrays.asList(1, 2, 1), Forth.evaluate("1 2 over"));
        }

        @Test
        public void copiesTheSecondElementIfThereAreMoreThanTwo() {
            assertIterableEquals(Arrays.asList(1, 2, 3, 2), Forth.evaluate("1 2 3 over"));
        }

        @Test
        public void errorsIfThereIsNothingOnTheStack() {
            assertThrows(RuntimeException.class, () -> Forth.evaluate("over"));
        }

        @Test
        public void errorsIfThereIsOnlyOneValueOnTheStack() {
            assertThrows(RuntimeException.class, () -> Forth.evaluate("1 over"));
        }
    }

    static class UserDefinedWords {
        @Test
        public void canConsistOfBuiltInWords() {
            assertIterableEquals(Arrays.asList(1, 1, 1), Forth.evaluate(": dup-twice dup dup;", "1 dup-twice"));
        }

        @Test
        public void executeInTheRightOrder() {
            assertIterableEquals(Arrays.asList(1, 2, 3), Forth.evaluate(": countup 1 2 3 ;", "countup"));
        }

        @Test
        public void canOverrideOtherUserDefinedWords() {
            assertIterableEquals(Arrays.asList(1, 1, 1), Forth.evaluate(": foo dup ;", ": foo dup dup ;", "1 foo"));
        }

        @Test
        public void canOverrideBuiltInWords() {
            assertIterableEquals(Arrays.asList(1, 1), Forth.evaluate(": swap dup ;", "1 swap"));
        }

        @Test
        public void canOverrideOtherBuiltInOperators() {
            assertIterableEquals(Collections.singletonList(12), Forth.evaluate(": + * ;", "3 4 +"));
        }

        @Test
        public void canUserDifferentWordsWithTheSameName() {
            assertIterableEquals(Arrays.asList(5, 6), Forth.evaluate(": foo 5 ;", ": bar foo ;", ": foo 6 ;", "bar foo"));
        }

        @Test
        public void canDefineWordThatUsesWordWithTheSameName() {
            assertIterableEquals(Collections.singletonList(11), Forth.evaluate(": foo 10 ;", ": foo foo 1 + ;", "foo"));
        }

        @Test
        public void cannotRedefineNumbers() {
            assertThrows(RuntimeException.class, () -> Forth.evaluate(": 1 2 ;"));
        }

        @Test
        public void errorsIfExecutingANonExistentWord() {
            assertThrows(RuntimeException.class, () -> Forth.evaluate("foo"));
        }
    }

    static class CaseInsensitivity {
        @Test
        public void DUPIsCaseInsensitive() {
            assertIterableEquals(Arrays.asList(1, 1, 1, 1), Forth.evaluate("1 DUP Dup dup"));
        }

        @Test
        public void DROPIsCaseInsensitive() {
            assertIterableEquals(Collections.singletonList(1), Forth.evaluate("1 2 3 4 DROP Drop drop"));
        }

        @Test
        public void SWAPIsCaseInsensitive() {
            assertIterableEquals(Arrays.asList(2, 3, 4, 1), Forth.evaluate("1 2 SWAP 3 Swap 4 swap"));
        }

        @Test
        public void OVERIsCaseInsensitive() {
            assertIterableEquals(Arrays.asList(1, 2, 1, 2, 1), Forth.evaluate("1 2 OVER Over over"));
        }

        @Test
        public void UserDefinedWordsAreCaseInsensitive() {
            assertIterableEquals(Arrays.asList(1, 1, 1, 1), Forth.evaluate(": foo dup ;", "1 FOO Foo foo"));
        }

        @Test
        public void DefinitionsAreCaseInsensitive() {
            assertIterableEquals(Arrays.asList(1, 1, 1, 1), Forth.evaluate(": SWAP DUP Dup dup ;", "1 swap"));
        }
    }
}
