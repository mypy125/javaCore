package org.example.javaCor.homework2;

import org.example.javaCor.homework2.ProgramExeptions.IllegalArgument;
import org.example.javaCor.homework2.ProgramExeptions.NullPointerException;

import java.util.*;

import static org.example.javaCor.homework2.Account.isValidAccount;

public class AccountManager {
    //Compositor variant
    Account account = null;
    AccountManager manager;
    public Map<String,Account> accountList;
    public AccountManager(){
        this.accountList = new HashMap<>();
    }

    public void addAccount(Account account, String name){
        accountList.put(name,account);
    }
    public void deleteAccount(Account account,String name){
        accountList.remove(name,account);
    }

    public void registerUser(String username, String usersurname,double chack,String password) throws IllegalArgument, NullPointerException {
        if(!isValidAccount(username,usersurname,password))throw new NullPointerException("Нельзя создать аккоунт без заполнени полей",0);
        if (!accountList.containsKey(username)){
            account = account.createAccount(username,usersurname,chack,password);
            accountList.put(username,account);
            System.out.printf("Регистрация успешна. %s\n",username);
        }
        else {
            System.out.printf("Пользователь с таким именем %s уже существует.",username);
        }
    }

    public void registerUserDebit(String username, String usersurname,double chack,String password) throws IllegalArgument, NullPointerException {
        if(!isValidAccount(username,usersurname,password))throw new NullPointerException("Нельзя создать аккоунт без заполнени полей",0);
        if (!accountList.containsKey(username)){
            DebitAccount account = new DebitAccount(username,usersurname,chack,password);
            accountList.put(username,account);
            System.out.printf("Регистрация %s Debit Account успешна. \n",username);
        }
        else {
            System.out.printf("Пользователь с таким именем %s уже существует.",username);
        }
    }

    public void registerUserCredit(String username, String usersurname,double chack,String password) throws IllegalArgument, NullPointerException {
        if(!isValidAccount(username,usersurname,password))throw new NullPointerException("Нельзя создать аккоунт без заполнени полей",0);
        if (!accountList.containsKey(username)){
            DebitAccount account = new DebitAccount(username,usersurname,chack,password);
            accountList.put(username,account);
            System.out.printf("Регистрация %s Credit Account успешна. ",username);
            System.out.println();
        }
        else {
            System.out.printf("Пользователь с таким именем %s уже существует.",username);
        }
    }
    public Account loginUser(String usrName, String password){
        Account account = accountList.get(usrName);
        if (account != null && account.checkPassword(password)){
            System.out.printf("Вход в систему успешен. %s",usrName);
            System.out.println();
            return account;
        }
        else{
            System.out.println("Неверное имя пользователя или пароль.");
            return null;
        }
    }


}
