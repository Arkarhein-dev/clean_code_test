package org.example.clean_code_test.error_handling.dont_return_null.student_example;

// ==========================================
// 1. DOMAIN INTERFACE
// ==========================================
interface UserProfile {
    double calculateDiscount();
    String getMembershipType();
}

// ==========================================
// 2. SPECIAL CASE OBJECT & REGULAR OBJECT
// Encapsulates special-case behavior so the caller doesn't have to check for errors
// ==========================================

// Special Case Object: Handles the fallback flow seamlessly
class StandardUser implements UserProfile {
    @Override
    public double calculateDiscount() {
        // Standard user gets 0% discount, keeping normal math operations flowing cleanly
        return 0.0;
    }

    @Override
    public String getMembershipType() {
        return "STANDARD";
    }
}

// Regular Object: Handles a fully active premium user
class PremiumUser implements UserProfile {
    private final double discountRate;

    public PremiumUser(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public double calculateDiscount() {
        return discountRate;
    }

    @Override
    public String getMembershipType() {
        return "PREMIUM";
    }
}

// ==========================================
// 3. REPOSITORY / DATA ACCESS
// ==========================================
class UserRepository {
    /**
     * Instead of throwing a UserNotFoundException or returning null when a user
     * record is missing, it returns the Special Case object (StandardUser).
     */
    public UserProfile findUser(String userId) {
        if (isPremiumMember(userId)) {
            return new PremiumUser(0.20); // 20% discount for premium members
        } else {
            // Returns the Special Case object to maintain the normal flow[cite: 1]
            return new StandardUser();
        }
    }

    private boolean isPremiumMember(String userId) {
        // Simulated database check (e.g., ID "USER-PREM-007" exists as premium)
        return userId.equals("USER-PREM-007");
    }
}

// ==========================================
// 4. THE CLIENT / BUSINESS LOGIC
// ==========================================
public class BillingService {
    private final UserRepository userRepository = new UserRepository();

    public double processCheckout(String userId, double subtotal) {
        // Clean flow: No try-catch exceptions or null-checking clutter[cite: 1]!
        UserProfile profile = userRepository.findUser(userId);

        double discountRate = profile.calculateDiscount();
        double finalAmount = subtotal - (subtotal * discountRate);

        System.out.println("Processed user type: " + profile.getMembershipType());
        return finalAmount;
    }

    // Main execution test
    public static void main(String[] args) {
        BillingService service = new BillingService();

        // Scenario A: A user who is NOT in the premium database
        double standardTotal = service.processCheckout("USER-REG-123", 100.0);
        System.out.println("Final Price: $" + standardTotal + "\n");
        // Output: Processed user type: STANDARD | Final Price: $100.0
        // (Handled smoothly by the StandardUser Special Case object without crashing or throwing errors)

        // Scenario B: A user who IS in the premium database
        double premiumTotal = service.processCheckout("USER-PREM-007", 100.0);
        System.out.println("Final Price: $" + premiumTotal);
        // Output: Processed user type: PREMIUM | Final Price: $80.0 (20% discount applied)
    }
}
