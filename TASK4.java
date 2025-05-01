import java.util.*;
import java.util.concurrent.TimeUnit;

public class TASK4 {

    // Question class to store quiz question, options, and the correct answer
    static class Question {
        String questionText;
        String[] options;
        int correctAnswer; // The correct answer's option index (1-based)

        Question(String questionText, String[] options, int correctAnswer) {
            this.questionText = questionText;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Store questions
        List<Question> questions = new ArrayList<>();

        // Adding questions
        questions.add(new Question("What is the capital of France?",
                new String[] { "1. Paris", "2. Rome", "3. Berlin", "4. Madrid" }, 1));
        questions.add(new Question("Which programming language is used for Android?",
                new String[] { "1. Java", "2. Python", "3. C++", "4. Swift" }, 1));
        questions.add(new Question("Who invented Java?",
                new String[] { "1. James Gosling", "2. Mark Zuckerberg", "3. Bill Gates", "4. Steve Jobs" }, 1));

        int score = 0;
        Map<Integer, Boolean> results = new HashMap<>();

        // Loop through each question
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\nQuestion " + (i + 1) + ": " + q.questionText); // Display question

            // Display options
            for (String option : q.options) {
                System.out.println(option);
            }

            // Timer for 30 seconds per question
            long startTime = System.currentTimeMillis();
            long endTime = startTime + TimeUnit.SECONDS.toMillis(30);

            System.out.print("\nYour answer (1-4): ");
            int userAnswer = 0;
            boolean answered = false;

            // Wait for user input within the time limit
            while (System.currentTimeMillis() < endTime) {
                if (sc.hasNextInt()) {
                    userAnswer = sc.nextInt();
                    if (userAnswer >= 1 && userAnswer <= 4) {
                        answered = true;
                        break;
                    }
                }
            }

            if (!answered) {
                System.out.println("\nTime's up! Moving to the next question...");
                userAnswer = 0; // Default for time-up scenario
            }

            // Check the answer and calculate score
            if (userAnswer == q.correctAnswer) {
                score++;
                results.put(i + 1, true);
            } else {
                results.put(i + 1, false);
            }
        }

        // Display final results
        System.out.println("\nQuiz finished!");
        System.out.println("Your score: " + score + "/" + questions.size());
        System.out.println("\nDetailed results:");

        for (Map.Entry<Integer, Boolean> entry : results.entrySet()) {
            System.out.println("Question " + entry.getKey() + ": " + (entry.getValue() ? "Correct" : "Incorrect"));
        }

        sc.close();
    }
}