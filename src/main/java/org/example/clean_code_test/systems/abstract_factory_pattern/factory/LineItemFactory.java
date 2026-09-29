package org.example.clean_code_test.systems.abstract_factory_pattern.factory;

import org.example.clean_code_test.systems.abstract_factory_pattern.LineItem;

public interface LineItemFactory {
    LineItem createLineItem(String name);
}
