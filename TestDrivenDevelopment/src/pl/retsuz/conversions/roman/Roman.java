package pl.retsuz.conversions.roman;

import pl.retsuz.conversions.GenericNumeralSystem;

import java.util.Arrays;

public class Roman implements GenericNumeralSystem {
    @Override
    public String fromArabic(int number) {
        String [] answer = new String[4];
        if (number < 0 || number > 3999){
            System.out.println("The given number is outside the range of numbers");
            System.exit(0);
        }
        int thousands = number/1000;
        int hundreds = number%1000/100;
        int dozens = number%100/10;
        int units = number%10;
        answer[0] = convert(thousands, "M", "M", "M");
        answer[1] = convert(hundreds, "C", "D", "M");
        answer[2] = convert(dozens, "X", "L", "C");
        answer[3] = convert(units, "I", "V", "X");
        return answer[0]+answer[1]+answer[2]+answer[3];
    }

    @Override
    public int toArabic(String val) {
        int [] tab = new int[val.length()];
        int result = 0, previous = 0;
        char previousLetter = '\0';
        char x = '\0';
        int y = 0;
        String letters;
        StringBuilder sb = new StringBuilder();
        val.toUpperCase();
        for(int i = 0; i < val.length(); i++){
            char temp = val.charAt(i);
            if(x == temp)
                y = y + 1;
            else{
                x = temp;
                y = 1;
            }
            if(y > 3){
                System.out.println("Wrong number!");
                System.exit(0);
            }

            sb.append(temp);
            letters = sb.toString();
            if(!correctnessOfRomanNumbers(letters)){
                System.out.println("Enter a valid Roman Numeral or Integer from 1 to 3999");
                System.exit(0);
            }
            previousLetter = temp;
            sb.setLength(0);
            sb.append(previousLetter);
        }

        changeLettersToNumbers(val,tab);
        for (int i = tab.length - 1; i >= 0; i--){
            result = calculate(previous,tab[i], result);
            previous = tab[i];
        }
        return result;
    }

    private String convert(int number, String low, String mid, String high){
        if (number == 1){
            return low;
        } else if (number == 2) {
            return low + low;
        } else if (number == 3) {
            return low + low + low;
        } else if (number == 4) {
            return low + mid;
        } else if (number == 5) {
            return mid;
        } else if (number == 6) {
            return mid + low;
        }else if (number == 7) {
            return mid + low + low;
        } else if (number == 8) {
            return mid + low + low + low;
        } else if (number == 9) {
            return low + high;
        } else {
            return "";
        }
    }

    private boolean correctnessOfRomanNumbers(String val){
        String[] tab = new String[] {"M","D","C","L","X","V","I",
                "II","IV","VI","IX","XI","XV","XX",
                "LI","LV","XL","LX","XC","CI","CV","CX","CL","CC",
                "CD","DI","DV","DX","DL","DC",
                "CM","MI","MV","MX","ML","MC","MD","MM"};
        int result = 0;
        for(int i = 0; i < tab.length && result == 0; i++){
            if(tab[i].equals(val))
                result = 1;
        }
        if (result == 1)
            return true;
        else
            return false;
    }

    private void changeLettersToNumbers(String val, int[] tab){
        int m = 0, d = 0, c = 0, l = 0, x = 0, v = 0, i = 0;
        for(int j = 0; j < val.length(); j++){
            char temp = val.charAt(j);
            if (temp == 'M') {
                tab[j] = 1000;
                m++;
            } else if(temp == 'D') {
                tab[j] = 500;
                d++;
            } else if(temp == 'C') {
                tab[j] = 100;
                c++;
            } else if(temp == 'L') {
                tab[j] = 50;
                l++;
            } else if(temp == 'X') {
                tab[j] = 10;
                x++;
            } else if(temp == 'V') {
                tab[j] = 5;
                v++;
            }
            else if(temp == 'I') {
                tab[j] = 1;
                i++;
            }
            else{
                System.out.println("!Unknown symbol");
                System.exit(0);
            }
            if(i > 4 || v > 1 || x > 4 || l > 1 || c > 4 || d >1 || m > 4){
                System.out.println("Wrong number!");
                System.exit(0);
            }
        }
    }
    private int calculate(int previousNumber, int currentNumber, int result){
         if(previousNumber > currentNumber)
             result -= currentNumber;
         else
             result += currentNumber;
        return result;
    }
}

