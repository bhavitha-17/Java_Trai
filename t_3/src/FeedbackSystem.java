public class FeedbackSystem {
    private Map<Integer, Customer> customers = new HashMap<>();
    private Map<Integer, List<Feedback>> feedbacks = new HashMap<>();
    private int feedbackIdCounter = 1;

    public void registerCustomer(int id, String name) {
        customers.put(id, new Customer(id, name));
        feedbacks.put(id, new ArrayList<>());
    }

    public void addFeedback(int customerId, String description) {
        List<Feedback> customerFeedbacks = feedbacks.get(customerId);
        if (customerFeedbacks != null) {
            Feedback feedback = new Feedback(feedbackIdCounter++, description, customerId);
            customerFeedbacks.add(feedback);
        } else {
            System.out.println("Customer with ID " + customerId + " not found.");
        }
    }

    public List<Feedback> getFeedbacksByCustomerId(int customerId) {
        return feedbacks.getOrDefault(customerId, new ArrayList<>());
    }
}


