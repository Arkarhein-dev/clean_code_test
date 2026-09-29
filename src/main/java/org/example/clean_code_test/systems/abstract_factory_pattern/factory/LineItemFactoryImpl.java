package org.example.clean_code_test.systems.abstract_factory_pattern.factory;

import org.example.clean_code_test.systems.abstract_factory_pattern.DefaultLineItem;
import org.example.clean_code_test.systems.abstract_factory_pattern.LineItem;

public class LineItemFactoryImpl implements LineItemFactory{
    @Override
    public LineItem createLineItem(String name) {
        return new DefaultLineItem(name);
    }
}
