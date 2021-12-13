/**
 * Singleton-luokka, josta TemplateActivity saa Listviewiin nimet ja TemplateWorkOuts-
 * activity saa treeniliikkeiden nimet. Profiiliin tallennettujen treenien nimet saadaan
 * myös tästä luokasta.
 * @author Karoliina Multas
 * @version 0.1
 */

package com.example.project;

import java.util.ArrayList;

public class TemplateSingleton {

    private ArrayList<TemplateModels> templates;
    private static final TemplateSingleton templateInstance = new TemplateSingleton();

    /**
     *
     * @return palauttaa templateInstancen
     */
    public static TemplateSingleton getInstance() {
        return templateInstance;
    }

    /**
     * Tallentaa treenien nimen ja liikkeiden nimet templates arraylistiin
     */
    private TemplateSingleton() {
        templates = new ArrayList<TemplateModels>();
        templates.add(new TemplateModels("Upper body", "Bench press", "Bent-over row", "Overhead press", "Biceps curl"));
        templates.add(new TemplateModels("Lower body", "Leg press", "Squat", "Leg extension", "Deadlift"));
        templates.add(new TemplateModels("Back muscles", "Pull-up", "Lat pulldown", "Back extension", "Barbell row"));

    }

    /**
     *
     * @return palauttaa koko arraylistin sisällön
     */
    public ArrayList<TemplateModels> getTemplates() {
        return templates;
    }

    /**
     *
     * @param i templates arraylistin indeksi
     * @return palauttaa yhden treenin arraylististä
     */
    public TemplateModels getTemplate(int i) {
        return templates.get(i);
    }


}
