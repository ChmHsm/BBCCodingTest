package Implementations;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class RomanUtils {

    //Input number format
    private static String NUMBER_FORMAT = "0000";

    //Used a LinkedHashMap instead of a Hashmap in order to keep Map index as inputted
    private LinkedHashMap<Integer, Integer> decomp;

    //Logistical need at line 47
    private HashMap<Integer, Integer> decompIndex;

    //Roman mapping of numbers 1 to 1000
    private static HashMap<Integer, String> romanRepresentation;

    //Constructor, initializing private properties
    public RomanUtils() {
        decomp = new LinkedHashMap<>();
        decomp.put(1000, 0);
        decomp.put(100, 0);
        decomp.put(10, 0);
        decomp.put(1, 0);

        decompIndex = new HashMap<>();
        decompIndex.put(3, 1);
        decompIndex.put(2, 10);
        decompIndex.put(1, 100);
        decompIndex.put(0, 1000);

        romanRepresentation = new HashMap<>();
        romanRepresentation.put(1, "I");
        romanRepresentation.put(5, "V");
        romanRepresentation.put(10, "X");
        romanRepresentation.put(50, "L");
        romanRepresentation.put(100, "C");
        romanRepresentation.put(500, "D");
        romanRepresentation.put(1000, "M");
    }


    /**
     * @param number (required) Number we wish to decompose to 1000s, 100s 10s and 1s. Length
     * must not exceed property "NUMBER_FORMAT".
     * Must be in range <tt>1..3999</tt>.
     * @return 1000s, 100s, 10s and 1s of @number.
     */
    public HashMap<Integer, Integer> getNumberDecomp(Integer number){

        if(number <= 0) return decomp;
        String stringNumber = formatNumber(number);
        for(int i = stringNumber.length() - 1; i >= 0; i--){
            decomp.replace(decompIndex.get(i), Integer.parseInt(String.valueOf(stringNumber.charAt(i))));
        }
        return decomp;
    }

    /**
     * @param factor (required) Number from 1 to 9.
     * @param unit (required) = 1000, 100, 10 or 1.
     * @return Roman representation of factor * unit (i.e. 9 * 100 returns "CM").
     */
    public String getRomanFromNumeral(Integer factor, Integer unit){

        if(factor == 0) return "";
        if(factor >= 5){
            if(factor == 10 - 1){
                return romanRepresentation.get(unit) + romanRepresentation.get(unit * 10);
            }
            else{
                return romanRepresentation.get(unit * 5) + getRomanFromNumeral(factor - 5, unit);
            }
        }
        else if(factor == 5 - 1){
            return romanRepresentation.get(unit) + romanRepresentation.get(unit * 5);
        }
        else{
            return romanRepresentation.get(unit) + getRomanFromNumeral(factor - 1, unit);
        }

    }

    /**
     * Logistical need.
     * @param number (required) Number from 1 to 3999.
     * @return Formatted version of @param number as per property NUMBER_FORMAT (i.e. : 499 returns "0499").
     */
    private String formatNumber(int number){
        String formattedNumber = NUMBER_FORMAT;
        int formattedStringLength = NUMBER_FORMAT.length();
        int numberLength = String.valueOf(number).length();
        formattedNumber = formattedNumber.substring(0, formattedStringLength - numberLength)
                .concat(String.valueOf(number));
        return  formattedNumber;
    }
}
