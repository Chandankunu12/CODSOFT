package CodSoft_4th_Java_Program;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class QuizQuestion {
    private String question;
    private String[] options;
    private int correctAnswerIndex;

    public QuizQuestion(String question, String[] options, int correctAnswerIndex) {
        this.question = question;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}

public class Quiz_Application_With_Timer {
    private static int score = 0;
    private static int questionIndex = 0;
    private static QuizQuestion[] questions;

    public static void main(String[] args) {
        initializeQuestions();

        Scanner scanner = new Scanner(System.in);
        Timer timer = new Timer();

        System.out.println("Welcome to the Quiz Application!");

        while (questionIndex < questions.length) {
            QuizQuestion currentQuestion = questions[questionIndex];

            System.out.println("\nQuestion: " + currentQuestion.getQuestion());
            String[] options = currentQuestion.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }

            TimerTask task = new TimerTask() {
                public void run() {
                    System.out.println("\nTime's up! Moving to the next question.");
                    questionIndex++;
                }
            };
            timer.schedule(task, 10000);

            System.out.print("\nEnter your answer (1-" + options.length + "): ");
            int userAnswer = scanner.nextInt();
            timer.cancel();

            if (userAnswer == currentQuestion.getCorrectAnswerIndex() + 1) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
            }

            questionIndex++;
        }

        System.out.println("\nQuiz ended. Your final score: " + score + "/" + questions.length);
        scanner.close();
    }

    private static void initializeQuestions() {
        questions = new QuizQuestion[3];
        questions[0] = new QuizQuestion("What is the capital of France?",
                new String[]{"Paris", "London", "Berlin", "Madrid"}, 0);
        questions[1] = new QuizQuestion("What is the largest planet in our solar system?",
                new String[]{"Jupiter", "Saturn", "Mars", "Earth"}, 0);
        questions[2] = new QuizQuestion("Who wrote 'To Kill a Mockingbird'?",
                new String[]{"Harper Lee", "J.K. Rowling", "Stephen King", "George Orwell"}, 0);
    }
}
