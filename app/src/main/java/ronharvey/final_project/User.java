package ronharvey.final_project;

/**
 * Created by Ron on 11/5/2017.
 */

public class User {

    //private variables
    int _id;
    String _name;
    String _password;
    String _email;
    String _street;

    // Empty constructor
    public User(){

    }
    // constructor
    public User(int id, String name, String password, String email, String street){
        this._id = id;
        this._name = name;
        this._password = password;
        this._email = email;
        this._street = street;
    }

    // constructor
    public User(String name, String password, String email, String street){
        this._name = name;
        this._password = password;
        this._email = email;
        this._street = street;
    }
    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }

    // getting password
    public String getPassword(){
        return this._password;
    }

    // setting password
    public void setPassword(String password){
        this._password = password;
    }
    // getting password
    public String getEmail(){
        return this._email;
    }

    // setting password
    public void setEmail(String email){
        this._email = email;
    }

    public String getStreet(){
        return this._street;
    }

    // setting password
    public void setStreet(String street){
        this._street = street;
    }
}