package ronharvey.final_project;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by NirushanM on 11/19/2017.
 */

public class PizzaTop implements Parcelable {

    boolean _pepperoni;
    boolean _peppers;
    boolean _pineapple;
    boolean _onions;



    public void PizzaTop(){}

    public void PizzaTop(boolean pepperoni, boolean peppers,boolean pineapple, boolean onions){

        this._pepperoni=pepperoni;
        this._peppers=peppers;
        this._pineapple=pineapple;
        this._onions=onions;

    }

    public boolean getPepperoni(){return this._pepperoni;}
    public void setPepperoni(boolean pepperoni) {this._pepperoni=pepperoni;}

    public boolean getPeppers(){return this._peppers;}
    public void setPeppers(boolean peppers) {this._peppers=peppers;}

    public boolean getPineapple(){return this._pineapple;}
    public void set_pineapple(boolean pineapple) {this._pineapple=pineapple;}

    public boolean getOnions(){return this._onions;}
    public void setOnions(boolean onions) {this._onions=onions;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeValue(this.getPepperoni());
        parcel.writeValue(this.getPeppers());
        parcel.writeValue(this.getPineapple());
        parcel.writeValue(this.getOnions());

    }

    protected PizzaTop(Parcel in) {
        _pepperoni = (Boolean) in.readValue(null) ;
        _peppers = (Boolean) in.readValue(null) ;
        _pineapple = (Boolean) in.readValue(null) ;
        _onions = (Boolean) in.readValue(null) ;;
    }

    public static final Creator<PizzaTop> CREATOR = new Creator<PizzaTop>() {
        @Override
        public PizzaTop createFromParcel(Parcel in) {
            return new PizzaTop(in);
        }

        @Override
        public PizzaTop[] newArray(int size) {
            return new PizzaTop[size];
        }
    };
}
