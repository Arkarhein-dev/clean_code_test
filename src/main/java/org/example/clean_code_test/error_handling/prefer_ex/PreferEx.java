package org.example.clean_code_test.error_handling.prefer_ex;

import java.util.logging.Logger;

public class PreferEx {
    private static Logger logger = Logger.getLogger("PreferEx.class");

    // Bad Code
    public void deletePageAndAllReferences(Page page) {
        if (deletePage(page) == E_OK) {
            if (registry.deleteReference(page.name) == E_OK) {
                if (configKeys.deleteKey(page.name.makeKey()) == E_OK) {
                    logger.info("page deleted");
                } else {
                    logger.info("configKey not deleted");
                }
            } else {
                logger.info("deleteReference from registry failed");
            }
        } else {
            logger.info("delete failed");
        }
    }

    // Clean Code
    // ✅ Pure business logic without tangled error checks
    public void deletePageAndAllReferences(Page page) {
        deletePage(page);
        registry.deleteReference(page.name);
        configKeys.deleteKey(page.name.makeKey());
    }

    // ✅ Error handling is isolated into its own dedicated wrapper
    public void delete(Page page) {
        try {
            deletePageAndAllReferences(page);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

}
