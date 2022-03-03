package src.services;

import javafx.collections.ObservableList;
import src.models.modelBillet;
import src.models.modelVol;

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