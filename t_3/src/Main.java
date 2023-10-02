
public class Main {
    public static void main(String[] args) {
        FeedbackSystem feedbackSystem = new FeedbackSystem();

        // Register customers
        feedbackSystem.registerCustomer(1, "Alice");
        feedbackSystem.registerCustomer(2, "Bob");

        // Add feedbacks
        feedbackSystem.addFeedback(1, "Great service!");
        feedbackSystem.addFeedback(2, "Could be improved.");

        // Fetch all feedbacks by customer id
        int customerId = 1;
        List<Feedback> feedbacks = feedbackSystem.getFeedbacksByCustomerId(customerId);
        for (Feedback feedback : feedbacks) {
            System.out.println("Feedback ID: " + feedback.getId() + ", Description: " + feedback.getDescription());
        }
    }
}