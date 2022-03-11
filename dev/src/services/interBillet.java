package services;

import javafx.collections.ObservableList;
import models.modelBillet;

/**
 *
 * @author kjpsaycon
 */
public interface interBillet {
    ObservableList<modelBillet> getAll();
  //  ObservableList<modelVol> likeByName(String a);
    void autoId(modelBillet m);
    void insert(modelBillet m);
    void delete(modelBillet m);
    void update(modelBillet m);
}