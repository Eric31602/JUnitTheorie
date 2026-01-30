package be.vdab;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class XmlPersoonRepository implements PersoonRepository {

    @Override
    public List<BigDecimal> findAllWeddes() {
        var factory = XMLInputFactory.newInstance();
        var weddes = new ArrayList<BigDecimal>();
        try (var bufferedReader =
                     Files.newBufferedReader(Path.of("/data/personen.xml"))) {
            var reader = factory.createXMLStreamReader(bufferedReader);
            while (reader.hasNext()) {
                reader.next();
                if (reader.isStartElement() &&
                        "persoon".equals(reader.getLocalName())) {
                    var wedde = new BigDecimal(reader.getAttributeValue(3));
                    weddes.add(wedde);
                }
            }
            return weddes;
        } catch (IOException | XMLStreamException ex) {
            throw new RepositoryException(ex);
        }
    }
}

