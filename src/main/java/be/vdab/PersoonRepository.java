package be.vdab;

import java.math.BigDecimal;
import java.util.List;

public interface PersoonRepository {
    List<BigDecimal> findAllWeddes();
}
