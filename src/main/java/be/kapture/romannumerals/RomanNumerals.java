package be.kapture.romannumerals;

import static be.kapture.romannumerals.Roman.*;

public class RomanNumerals {

    public static String toRoman(int input) {
        checkInput(input);

        StringBuilder builder = new StringBuilder();
        buildRoman(builder, input, Roman.getHighest());

        return builder.toString();
    }

    private static void buildRoman(StringBuilder builder, int value, Roman highest) {
        int remainder;

        if (shouldIncludeNumeral(value, highest)) {
            int numberOfNumerals = value / highest.value();
            remainder = value % highest.value();
            append(highest, numberOfNumerals, builder);
        } else {
            remainder = value;
        }


        if (highest != I) { // base case not yet reached
            buildRoman(builder, remainder, highest.getOneLower());
        }
    }

    private static boolean shouldIncludeNumeral(int value, Roman numeral) {
        return !shouldSkipNumeral(value, numeral);
    }

    // E.g. the "V" should be skipped when writing 9 (IX)
    private static boolean shouldSkipNumeral(int value, Roman numeral) {
        return String.valueOf(value).startsWith("9") && numeral.isaFive();
    }

    private static void append(Roman toAppend, int times, StringBuilder builder) {
        if (times <= 3) {
            for (int i = 0; i < times; i++) {
                builder.append(toAppend.representation());
            }
        } else {
            Roman subtractFrom = calculateSubtractFrom(toAppend, times);
            builder.append(toAppend.representation())
                    .append(subtractFrom.representation());
        }
    }

    private static Roman calculateSubtractFrom(Roman toAppend, int times) {
        return times == 4 ? toAppend.getOneHigher() : toAppend.getTwoHigher();
    }

    private static void checkInput(int input) {
        if (input > Roman.getHighestRepresentableValue()) {
            throw new IllegalArgumentException("Input (" + input + ") too high. Max is " +
                    Roman.getHighestRepresentableValue());
        }
    }
}
