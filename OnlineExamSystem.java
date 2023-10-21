import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

class User {

    private String username;
    private String password;
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}


class Question {
    private String question;
    private String correctAnswer;
    
    public Question(String question, String correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}


class Exam {

    private List<Question> questions;
    private int timeLimit;

    public Exam(List<Question> questions, int timeLimit) {
        this.questions = questions;
        this.timeLimit = timeLimit;
    }

    public List<Question> getQuestions() {
        return questions;
    }
    public int getTimeLimit() {
        return timeLimit;
    }
}

public class OnlineExamSystem {
    private static List<User> users = new ArrayList<>();
    private static List<Question> questionBank = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Create sample users
        users.add(new User("user1", "password1"));
        users.add(new User("user2", "password2"));
        // Create sample questions
        questionBank.add(new Question("What is 2 + 2?", "4"));
        questionBank.add(new Question("What is the capital of France?", "Paris"));
        questionBank.add(new Question("What is 10 * 5?", "50"));
        System.out.println("Welcome to the Online Exam System!");
        System.out.print("Username: ");

        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        User currentUser = authenticateUser(username, password);
        if (currentUser != null) {
            System.out.println("Authentication successful. You are logged in as: " +
            currentUser.getUsername());
            startExam(currentUser);
        } else {
            System.out.println("Authentication failed. Invalid username or password.");
        }
    }
    private static User authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    private static void startExam(User user) {
        System.out.println("Select an exam:");
    // For simplicity, we only have one exam in this example
        Exam exam = createSampleExam();
        System.out.println("You have " + exam.getTimeLimit() + " minutes to complete the exam.");
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        try {
            Future<Integer> result = executorService.submit(() -> conductExam(exam));
            int score = result.get();
            System.out.println("Exam completed. Your score: " + score);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    private static Exam createSampleExam() {
        List<Question> selectedQuestions = new ArrayList<>();
        selectedQuestions.add(questionBank.get(0)); // Sample question 1
        selectedQuestions.add(questionBank.get(2)); // Sample question 2
        return new Exam(selectedQuestions, 10); // 10-minute time limit
    
    }
    private static int conductExam(Exam exam) {
        int score = 0;
        long startTime = System.currentTimeMillis();
        long endTime = startTime + exam.getTimeLimit() * 60 * 1000; // Calculate end time
        Scanner scanner = new Scanner(System.in);
        for (Question question : exam.getQuestions()) {
            System.out.println("Question: " + question.getQuestion());
            System.out.print("Your Answer: ");
            String userAnswer = scanner.nextLine();
            if (userAnswer.equalsIgnoreCase(question.getCorrectAnswer())) {
                score++;
            }
            long currentTime = System.currentTimeMillis();
            if (currentTime >= endTime) {
                break; // Time's up
            }
        }
        return score;
    }
}