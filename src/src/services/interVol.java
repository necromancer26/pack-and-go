package src.services;

import javafx.collections.ObservableList;
//import models.modelVol;
import src.models.modelVol;

/**
 *
 * @author kjpsaycon
 */
public interface interVol {
    ObservableList<modelVol> getAll();
  //  ObservableList<modelVol> likeByName(String a);
    void autoId(modelVol m);
    void insert(modelVol m);
    void delete(modelVol m);
    void update(modelVol m);
}