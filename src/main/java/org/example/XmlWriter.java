package org.example;

import org.example.model.StudInfo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XmlWriter {

    private static final Logger logger = Logger.getLogger(XmlWriter.class.getName());

    private XmlWriter() {
    }

    public static void exportXML(StudInfo studInfo, String filePath) {

        logger.log(Level.INFO, "XML export started");

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(StudInfo.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            OutputStream fileOut = new FileOutputStream(filePath);
            marshaller.marshal(studInfo, fileOut);

        } catch (Exception e) {
            logger.log(Level.SEVERE, "XML export error", e);
            return;
        }

        logger.log(Level.INFO, "XML export ended");
    }
}
