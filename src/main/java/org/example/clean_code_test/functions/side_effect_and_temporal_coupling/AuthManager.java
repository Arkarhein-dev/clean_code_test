package org.example.clean_code_test.functions.side_effect_and_temporal_coupling;

public class AuthManager {
    private Session currentSession;

    // ❌ BAD: Side Effect & Hidden Temporal Coupling
    public boolean checkPassword(String userName, String password) {
        if (passwordEncoder.matches(userName, password)) {
            // SIDE EFFECT! The function promises to *check* the password,
            // but secretly initializes/erases the session behind the scenes.
            Session.initialize();
            return true;
        }
        return false;
    }


    // ✅ GOOD: Pure Query (No side effects, just checks and returns true/false)
    public boolean isValidPassword(String userName, String password) {
        return passwordEncoder.matches(userName, password);
    }

    // ✅ GOOD: Explicit Command (Clearly states it changes state)
    public void initializeUserSession(String userName) {
        Session.initialize();
    }
}

// Caller code makes the sequence explicit and impossible to accidentally hide:
 if (authManager.isValidPassword(user, pass)) {
     authManager.initializeUserSession(user);
 }

}
