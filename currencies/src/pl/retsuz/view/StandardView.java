package pl.retsuz.view;

import pl.retsuz.collections.IDataCollection;
import pl.retsuz.currency.Currency;
import pl.retsuz.currency.ICurrency;
import pl.retsuz.exchange.IExchange;
import java.util.Scanner;

public class StandardView implements ICurrencyView{
    IExchange exch;
    IDataCollection coll;

    @Override
    public void setExchange(IExchange exchange) {
        exch = exchange;
    }

    @Override
    public void setDataCollection(IDataCollection collection) {
        coll = collection;
    }

    @Override
    public void ViewAll(IDataCollection coll) {
        System.out.println(coll.toString());
    }

    @Override
    public ICurrency StringToCurrency(String code) {
        ICurrency ret = new Currency();
        ret.setCode(code);
        ret = coll.getCurrencyByCode(ret);
        return ret;
    }

    @Override
    public ICurrency ChooseCurrency(String label) {
        Scanner sc = new Scanner(System.in);
        ICurrency ret = null;
        String code = sc.nextLine();
        ret = StringToCurrency(code);
        return ret;
    }

    @Override
    public void exchange() {
        System.out.println("Podaj walute zrodlowa:");
        ICurrency zrodlo = ChooseCurrency("");
        System.out.println("Podaj ilosc:");
        Scanner sc = new Scanner(System.in);
        double amt = sc.nextDouble();
        System.out.println("podaj walute docelowa:");
        ICurrency docel = ChooseCurrency("");
        System.out.println(exch.exchange(zrodlo, docel, amt));
    }

    @Override
    public void menu() {
        System.out.println("Pokaz waluty      ->    1");
        System.out.println("Dokonaj wymiany   ->    2");
        System.out.println("Dokonaj wyboru:");

        Scanner sc = new Scanner(System.in);
        int wybor = sc.nextInt();

        if (wybor == 1) {
            System.out.println(coll.getCurrencyList());
        } else if (wybor == 2) {
            exchange();
        } else {
            System.out.println("Zly wybor");
        }
    }
}
