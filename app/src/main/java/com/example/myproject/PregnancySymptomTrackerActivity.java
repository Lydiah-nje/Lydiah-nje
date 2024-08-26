package com.example.myproject;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class PregnancySymptomTrackerActivity {
    private static final Map<String, String> symptomPrecautions = new HashMap<>();

    public static void main(String[] args) {
        loadSymptomPrecautions("pregnancytracker.xml");
        // Use the symptomPrecautions map to track symptoms and provide precautions
    }

    private static void loadSymptomPrecautions(String fileName) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File(fileName));
            doc.getDocumentElement().normalize();

            NodeList symptomNodes = doc.getElementsByTagName("symptom");
            for (int i = 0; i < symptomNodes.getLength(); i++) {
                Element symptomElement = (Element) symptomNodes.item(i);
                String symptom = symptomElement.getElementsByTagName("name").item(0).getTextContent();
                String precaution = symptomElement.getElementsByTagName("precaution").item(0).getTextContent();
                symptomPrecautions.put(symptom, precaution);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
