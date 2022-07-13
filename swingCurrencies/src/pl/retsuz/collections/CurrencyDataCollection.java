package pl.retsuz.collections;

import pl.retsuz.currency.ICurrency;

import java.util.ArrayList;
import java.util.List;

public class CurrencyDataCollection implements IDataCollection{

    List<ICurrency> c_list;

    public CurrencyDataCollection(){
        c_list = new ArrayList<>();
    }

    @Override
    public String ToString() {
        String ret = "";
        for (int i = 0; i < c_list.size(); i++){
            ret += "Waluta numer " + i + ": " + c_list.get(i).getName() + " " + c_list.get(i).getCode() + " " + c_list.get(i).getFactor() +" "+ c_list.get(i).getRate() + "\n";
        }
        return ret;
    }

    @Override
    public List<ICurrency> getCurrencyList() {
        return c_list;
    }

    @Override
    public ICurrency getCurrencyByCode(ICurrency currency) {
        ICurrency ret = null;

        for(int i = 0; i < c_list.size(); i++){
            if (c_list.get(i).getCode().equals(currency.getCode())){
                ret = c_list.get(i);
            }
        }

        return ret;
    }
}
