package com.example.ben.cs2340.model;



import com.example.ben.cs2340.BuildConfig;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by robertwaters on 1/5/17.
 *
 * This is our facade to the Model.  We are using a Singleton design pattern to allow
 * access to the model from each controller.
 *
 *
 */

public class Model {
    /** Singleton instance */
    private static final Model _instance = new Model();
    public static Model getInstance() { return _instance; }

    /** holds the list of all Accountss */
    private List<Accounts> _accounts;

    /** the currently selected Accounts, defaults to first Accounts */
    private Accounts _currentAccount;

    /** Null Object pattern, returned when no Accounts is found */
//    private final Accounts theNullAccounts = new Accounts("No Such Accounts", "9999", SchoolCode.XX);


    /**
     * make a new model
     */
    private Model() {
        _accounts = new ArrayList<>();

        //comment this out after full app developed -- for homework leave in
//        loadDummyData();

    }

    /**
     * populate the model with some dummy data.  The full app would not require this.
     * comment out when adding new Accountss functionality is present.
     */
//    private void loadDummyData() {
//        _accounts.add(new Accounts("Objects and Design", "2340", SchoolCode.CS));
//        _accounts.add(new Accounts( "TQM", "4321", SchoolCode.IE));
//        _accounts.add(new Accounts("Concrete Ideas", "5432", SchoolCode.AR));
//        _accounts.add(new Accounts("Calc I", "2213", SchoolCode.MATH));
//        _accounts.get(0).getStudents().add(new Student("Bob", "CS"));
//        _accounts.get(0).getStudents().add(new Student("Sally", "ISYE"));
//        _accounts.get(1).getStudents().add(new Student("Fred", "Math"));
//        _accounts.get(1).getStudents().add(new Student("Edith", "CM"));
//        _currentAccounts = _accounts.get(0);
//    }

    /**
     * get the Accountss
     * @return a list of the Accountss in the app
     */
    public List<Accounts> getAccounts() { return _accounts; }

    /**
     * add a Accounts to the app.  checks if the Accounts is already entered
     *
     * uses O(n) linear search for Accounts
     *
     * @param account  the Accounts to be added
     * @return true if added, false if a duplicate
     */
    public boolean addAccount(Accounts account) {
        for (Accounts a : _accounts ) {
            if (a.equals(account)) return false;
        }
        _accounts.add(account);
        return true;
    }

    /**
     *
     * @return  the currently selected Accounts
     */
    public Accounts getCurrentAccount() { return _currentAccount;}

    public void setCurrentAccount(Accounts account) { _currentAccount = account; }

    /**
     * Return a Accounts that has matching number.
     * This uses an O(n) linear search.
     *
     * @param number the number of the Accounts to find
     * @return  the Accounts with that number or the NullAccounts if no such number exists.
     *
     */
//    public Accounts getAccountsByNumber (String number) {
//        for (Accounts c : _accounts ) {
//            if (c.getNumber().equals(number)) return c;
//        }
//        return theNullAccounts;
//    }

    /**
     * Return a Accounts that has the matching id
     * This uses a linear O(n) search
     *
     * @param id the id number of the Accounts
     * @return the Accounts with this id or theNullAccounts if no such id exists.
     */
//    public Accounts getAccountsById(int id) {
//        for (Accounts c : _accounts ) {
//            if (c.getId() == id) {
//                return c;
//            }
//        }
//        return theNullAccounts;
//    }

    /**
     * add a student to the current Accounts
     *
     * @param student the student to add
     * @return true if student added, false if not added
     */
//    public boolean addAccount(Accounts account) {
//        return _currentAccounts != null && _currentAccounts.addStudent(student);
//    }

    /**
     * Replace an existing students data with new data
     *
     * @param student the student being edited
     */
//    public void replaceAccountData(Accounts account) {
//        Accounts existing = _currentAccounts.findStudentById(student.getId());
//
//        //if existing comes back null, something is seriously wrong
//        if (BuildConfig.DEBUG && (existing == null)) { throw new AssertionError(); }
//
//        //update the name
//        existing.setName(account.getName());
//
//        //update the major
//        existing.setMajor(student.getMajor());
//
//        existing.setClassStanding(student.getClassStanding());
//    }
}
