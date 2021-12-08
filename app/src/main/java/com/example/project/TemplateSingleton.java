package com.example.project;

import java.util.ArrayList;

public class TemplateSingleton {
    private ArrayList<TemplateModels> templates;
    private static final TemplateSingleton templateInstance = new TemplateSingleton();

    public static TemplateSingleton getInstance() {
        return templateInstance;
    }

    private TemplateSingleton() {
        templates = new ArrayList<TemplateModels>();
        templates.add(new TemplateModels("Upper body", "Bench press", "Bent-over row", "Overhead press", "Biceps curl"));
        templates.add(new TemplateModels("Lower body", "Leg press", "jodsiof", "ifjgiofjd", "dijd"));
        templates.add(new TemplateModels("Abs", "blaablaa", "oijdfoigf", "jotain", "jotainjotain"));

    }

    public ArrayList<TemplateModels> getTemplates() {
        return templates;
    }

    public TemplateModels getTemplate(int i) {
        return templates.get(i);
    }

    public void saveTemplate(TemplateModels templateModels) {
        templates.add(templateModels);
    }

}
