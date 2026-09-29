package org.example.clean_code_test.systems.abstract_factory_pattern;

public class DefaultLineItem implements LineItem{
    private final String name;

    public DefaultLineItem(String name) {
        this.name = name;
    }

    @Override
    public String getLineName() {
        return name;
    }
}
