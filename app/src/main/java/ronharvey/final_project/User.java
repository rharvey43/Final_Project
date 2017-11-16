package ronharvey.final_project;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ron on 11/5/2017.
 */

public class User implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(this.getName());
        out.writeString(this.getPassword());
        out.writeString(this.getEmail());
        out.writeString(this.getStreet());
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };

    // example constructor that takes a Parcel and gives you an object populated with it's values
    private User(Parcel in) {
        this.setName(in.readString());
        this.setPassword(in.readString());
        this.setEmail(in.readString());
        this.setStreet(in.readString());
    }
}