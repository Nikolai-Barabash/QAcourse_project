package core.parser;

import core.parser.model.Customer;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class StaxRunnerCustomer {
    private static final String CUSTOMERS_XML = "CustomersForProject.xml";

    public List<Customer> getListOfCustomers() throws IOException, XMLStreamException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(CUSTOMERS_XML));
        List<Customer> customers = new StaxParserCustomer().parse(xmlEventReader);
        return customers;
    }
}
