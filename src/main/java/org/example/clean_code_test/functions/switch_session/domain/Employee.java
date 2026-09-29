package org.example.clean_code_test.functions.switch_session.domain;

import org.example.clean_code_test.functions.switch_session.common.Money;

public abstract class Employee {
    public abstract boolean isPayDay();
    public abstract Money calculatePay();
    public abstract void deliverPay(Money pay);
}
