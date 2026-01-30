package be.vdab;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvPersoonRepository implements PersoonRepository {

    @Override
    public List<BigDecimal> findAllWeddes() {
        try (var stream = Files.lines(Path.of("/data/personen.csv"))) {
            return stream.map(regel -> new BigDecimal(regel.split(",")[3])).toList();
        } catch (IOException ex) {
            throw new RepositoryException(ex);
        }
    }
}
