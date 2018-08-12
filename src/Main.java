import Implementations.RomanNumeralGeneratorImpl;
import Interfaces.RomanNumeralGenerator;

public class Main {

    public static void main(String[] args) {
        RomanNumeralGenerator romanNumeralGenerator = new RomanNumeralGeneratorImpl();
        System.out.println(romanNumeralGenerator.generate(20));
    }
}
