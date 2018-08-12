package Implementations;

import Interfaces.RomanNumeralGenerator;

import java.util.Map;

public class RomanNumeralGeneratorImpl implements RomanNumeralGenerator {
    @Override
    public String generate(int number) {

        RomanUtils romanUtils = new RomanUtils();
        StringBuilder romanRepresentation = new StringBuilder();

        for (Map.Entry<Integer, Integer> entry: romanUtils.getNumberDecomp(number).entrySet()
             ) {
            romanRepresentation.append(romanUtils.getRomanFromNumeral(entry.getValue(), entry.getKey()));
        }
        return romanRepresentation.toString();
    }
}
