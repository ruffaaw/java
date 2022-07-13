package pl.retsuz.conversions.urnfield;

import pl.retsuz.conversions.GenericNumeralSystem;

public class Urnfield implements GenericNumeralSystem {
    @Override
    public String fromArabic(int val) {
        String result;
        int forwardSlash = 0; // /
        int backslash = 0; // \
        if (val > 0 && val < 30){
            forwardSlash = val%5;
            backslash = val/5;
        }else{
            System.out.println("Number out of range!!");
            System.exit(0);
        }
        result = "/".repeat(forwardSlash) + "\\".repeat(backslash);
        return result;

    }

    @Override
    public int toArabic(String val) {
        int result = 0;
        boolean bool = false;
        char[] urnfield = new char[val.length()];
        for(int i = 0; i < val.length(); i++){
            urnfield[i] = val.charAt(i);
            if(urnfield[i] == '/')
                result +=1;
            else if(urnfield[i] == '\\') {
                result += 5;
                bool = true;
            }
            if(bool){
                if(urnfield[i] == '/'){
                    System.out.println("Wrong signs!!");
                    System.exit(0);
                }
            }
        }
        if(result > 0 && result < 30){
            return result;
        }
        else{
            System.out.println("Number out of range!!");
            System.exit(0);
            return 0;
        }
    }
}
