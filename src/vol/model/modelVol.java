package vol.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.beans.property.*;

/**
 *
 * @author kjpsaycon
 */
public class modelVol {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty compagnie_aerien = new SimpleStringProperty();
    private final StringProperty depart = new SimpleStringProperty();
    private final StringProperty destination = new SimpleStringProperty();
    private final StringProperty type_avion = new SimpleStringProperty();
    private final StringProperty image = new SimpleStringProperty();
    private final StringProperty duree = new SimpleStringProperty();
    private final FloatProperty prix = new SimpleFloatProperty();
    
    private final ObjectProperty<Date> date_depart = new SimpleObjectProperty<>();
    private final ObjectProperty<Date> date_arrive = new SimpleObjectProperty<>();
    private String dateFormat;

    public modelVol() {
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
   
    public String get_compagnie_aerien() {
        return compagnie_aerien.get();
    }

    public void set_compagnie_aerien(String value) {
        compagnie_aerien.set(value);
    }
public StringProperty compagnie_aerienProperty() {
        return compagnie_aerien;
    }

    public String get_depart() {
        return depart.get();
    }
   
    public void set_depart(String value) {
        depart.set(value);
    }
    
public StringProperty departProperty() {
        return depart;
    }



    public String get_destination() {
        return destination.get();
    }

public void set_destination(String value) {
        destination.set(value);
    }

public StringProperty destinationProperty() {
        return destination;
    }

   
    public String get_type_avion() {
        return type_avion.get();
    }

    public void set_type_avion(String value) {
        type_avion.set(value);
    }

public StringProperty type_avionProperty() {
        return type_avion;
    }

    public String get_image() {
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
    }

public Date get_date_arrive() {
        return date_arrive.get();
    }

public void set_date_arrive(Date value) {
        date_arrive.set(value);
    }

public ObjectProperty date_arriveProperty() {
        return date_arrive;
    }

public Date get_date_depart() {
        return date_depart.get();
    }

public void set_date_depart(Date value) {
        date_depart.set(value);
    }

public ObjectProperty date_departProperty() {
        return date_depart;
    }
   
    public String get_date_depart_format() {
        Date date = get_date_depart();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMMM-yyyy");
        String format = df.format(date);
        return format;
    }

    public void set_date_depart_format (String dateFormat) {
        this.dateFormat = dateFormat;
    }

public String get_date_arrive_format() {
        Date date = get_date_arrive();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMMM-yyyy");
        String format = df.format(date);
        return format;
    }
   public void set_date_arrive_format (String dateFormat) {
        this.dateFormat = dateFormat;
    }
   
   
}
