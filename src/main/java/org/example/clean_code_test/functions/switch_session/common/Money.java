package org.example.clean_code_test.functions.switch_session.common;

import java.io.IOException;

public record Money(double amount) {

    @Override
    public String toString() {
        return "$" + amount;
    }
}
