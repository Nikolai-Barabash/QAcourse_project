package core.parser;

import core.parser.model.Customer;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StaxParserCustomer {

    private static final String AGE = "age";
    private static final String NAME = "name";
    private static final String GENDER = "gender";
    private static final String ID = "id";
    private static final String CUSTOMER = "customer";
    private static final String EMAIL = "email";
    private static final String VKID = "VKid";
    private Customer customer;
    List<Customer> customers = new ArrayList<>();

    public List<Customer> parse(XMLEventReader xmlEventReader) throws FileNotFoundException, XMLStreamException
    {
        while (xmlEventReader.hasNext())
        {
            XMLEvent xmlEvent = xmlEventReader.nextEvent();
            proceedStartElement(xmlEvent, xmlEventReader);
            proceedEndElement(xmlEvent);
        }
        return customers;
    }

    private void proceedStartElement(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws XMLStreamException
    {
        if (xmlEvent.isStartElement())
        {
            StartElement startElement = xmlEvent.asStartElement();
            if (isTagNameEqual(startElement, CUSTOMER))
            {
                customer = new Customer();
                Attribute attribute = startElement.getAttributeByName(new QName(ID));
                if (attribute != null)
                {
                    customer.setId(Integer.parseInt(attribute.getValue()));
                }
            }

            else if (isTagNameEqual(startElement, AGE))
            {
                customer.setAge(Integer.parseInt(xmlEventReader.nextEvent().asCharacters().getData()));
            }
            else if (isTagNameEqual(startElement, NAME))
            {
                customer.setName(xmlEventReader.nextEvent().asCharacters().getData());
            }
            else if (isTagNameEqual(startElement, GENDER))
            {
                customer.setGender(xmlEventReader.nextEvent().asCharacters().getData());
            }
            else if (isTagNameEqual(startElement, EMAIL))
            {
                customer.setEmail(xmlEventReader.nextEvent().asCharacters().getData());
            }
            else if (isTagNameEqual(startElement, VKID))
            {
                customer.setVkId(Integer.parseInt(xmlEventReader.nextEvent().asCharacters().getData()));
            }
        }
    }

    private void proceedEndElement(XMLEvent xmlEvent)
    {
        if (xmlEvent.isEndElement())
        {
            EndElement endElement = xmlEvent.asEndElement();
            if (endElement.getName().getLocalPart().equals(CUSTOMER))
            {
                customers.add(customer);
            }
        }
    }

    private boolean isTagNameEqual(StartElement startElement, String tagName)
    {
        return startElement.getName().getLocalPart().equals(tagName);
    }
}

