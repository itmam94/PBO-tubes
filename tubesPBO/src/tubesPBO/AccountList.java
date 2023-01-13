package tubesPBO;

import java.util.ArrayList;

public class AccountList {

    private ArrayList<Account> AccountList;

    public AccountList(){
        AccountList = new ArrayList<>();
    }

    public void addAccount(Account pg){
        AccountList.add(pg);
    }

    public Account getAccount(int idx){
        return AccountList.get(idx);
    }

    public int getNum(){
        return AccountList.size();
    }
}
