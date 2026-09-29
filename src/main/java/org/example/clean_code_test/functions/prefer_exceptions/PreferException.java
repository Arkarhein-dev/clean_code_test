package org.example.clean_code_test.functions.prefer_exceptions;

import java.util.logging.Logger;

// Prefer Exception to Returning Error Codes
public class PreferException {
    private static Logger logger = Logger.getLogger("Engine Start Logging...");

    public static void main(String[] args) {
        // Bad Code
        if (deletePage(page) == E_OK) {
            if (registry.deleteReference(page.name) == E_OK) {
                if (configKeys.deleteKey(page.name.makeKey()) == E_OK){
                    logger.info("page deleted");
                } else {
                    logger.info("configKey not deleted");
                }
            } else {
                logger.info("deleteReference from registry failed");
            }
        } else {
            logger.info("delete failed");
            return E_ERROR;
        }

//    Clean Code
        try {
            deletePage(page);
            registry.deleteReference(page.name);
            configKeys.deleteKey(page.name.makeKey());
        }
        catch(Exception e) {
            logger.info(e.getMessage());
        }
    }

    //Bad Code
    public void startEngine(){
        try{
            Engine engine = new Engine();
            engine.startEngine();
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    // Clean Code
    public void start(Engine engine){
        try {
            engine.startEngine();
        }catch (Exception e){
            logger.info(e.getMessage());
        }
    }
}

