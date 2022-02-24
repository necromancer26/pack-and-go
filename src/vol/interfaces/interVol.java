package vol.interfaces;

import vol.model.modelVol;
import javafx.collections.ObservableList;

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