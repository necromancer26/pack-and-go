package models;

import javafx.beans.property.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author kjpsaycon
 */
public class modelBillet {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty nom = new SimpleStringProperty();
    private final StringProperty prenom = new SimpleStringProperty();
    private final IntegerProperty cin = new SimpleIntegerProperty();
    private final StringProperty classe = new SimpleStringProperty();
    private final IntegerProperty volid = new SimpleIntegerProperty();
    //private final StringProperty image = new SimpleStringProperty();
    //private final StringProperty duree = new SimpleStringProperty();
    //private final FloatProperty prix = new SimpleFloatProperty();

    private final ObjectProperty<Date> date_de_naissance = new SimpleObjectProperty<>();
    //private final ObjectProperty<Date> date_arrive = new SimpleObjectProperty<>();
    private String dateFormat;

    public Integer getVolid() {
        return volid.get();
    }

    public IntegerProperty volidProperty() {
        return volid;
    }

    public void setVolid(Integer volid) {
        this.volid.set(volid);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int value) {
        id.set(value);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String get_nom() {
        return nom.get();
    }

    public void set_nom(String value) {
        nom.set(value);
    }

    public StringProperty nomProperty() {
        return nom;
    }

    public String get_prenom() {
        return prenom.get();
    }

    public void set_prenom(String value) {
        prenom.set(value);
    }

    public StringProperty prenomProperty() {
        return prenom;
    }


    public Integer get_cin() {
        return cin.get();
    }

    public void set_cin(Integer value) {
        cin.set(value);
    }

    public IntegerProperty cinProperty() {
        return cin;
    }


    public String get_classe() {
        return classe.get();
    }

    public void set_classe(String value) {
        classe.set(value);
    }

    public StringProperty classeProperty() {
        return classe;
    }


   /* public String get_image() {
        return image.get();
    }

 public void set_image(String value) {
        image.set(value);
    }

public StringProperty imageProperty() {
        return image;
    }

public String get_duree() {
        return duree.get();
    }

public void set_duree(String value) {
        duree.set(value);
    }


public StringProperty dureeProperty() {
        return duree;
    }

public Float get_prix() {
        return prix.get();
    }

public void set_prix(Float value) {
        prix.set(value);
    }
public FloatProperty prixProperty() {
        return prix;
    }*/

/*public Date get_date_de_naissance() {
        return date_de_naissance.get();
    }

public void set_date_de_naissance(Date value) {
    date_de_naissance.set(value);
    }

public ObjectProperty date_de_naissanceProperty() {
        return date_de_naissance;
    }*/

public Date get_date_de_naissance() {
        return date_de_naissance.get();
    }

public void set_date_de_naissance(Date value) {
        date_de_naissance.set(value);
    }

public ObjectProperty date_de_naissanceProperty() {
        return date_de_naissance;
    }
   
    public String get_date_de_naissance_format() {
        Date date = get_date_de_naissance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMMM-yyyy");
        String format = df.format(date);
        return format;
    }

    public void set_date_de_naissance_format (String dateFormat) {
        this.dateFormat = dateFormat;
    }

/*public String get_date_de_naissance_format() {
        Date date = date_de_naissance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMMM-yyyy");
        String format = df.format(date);
        return format;
    }*/


  /*  public void set_date_de_naissance_format (String dateFormat) {
        this.dateFormat = dateFormat;
    }*/
   
   
}
