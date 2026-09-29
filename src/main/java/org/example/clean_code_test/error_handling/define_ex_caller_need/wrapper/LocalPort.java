package org.example.clean_code_test.error_handling.define_ex_caller_need.wrapper;

import org.example.clean_code_test.error_handling.define_ex_caller_need.exception.ATM1212UnlockedException;
import org.example.clean_code_test.error_handling.define_ex_caller_need.exception.DeviceResponseException;
import org.example.clean_code_test.error_handling.define_ex_caller_need.exception.GMXError;
import org.example.clean_code_test.error_handling.define_ex_caller_need.exception.PortDeviceFailure;
import org.example.clean_code_test.error_handling.define_ex_caller_need.third_Party_lib.ACMEPort;

public class LocalPort {
    private ACMEPort acmePort;

    public LocalPort(int portNumber) {
        this.acmePort = new ACMEPort(portNumber);
    }

    public void open(){
        try{
            acmePort.openPort();
        }catch (DeviceResponseException | ATM1212UnlockedException | GMXError e){
            throw new PortDeviceFailure(e);
        }
    }
}
