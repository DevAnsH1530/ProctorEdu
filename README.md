# Online Exam System
## Project Description
The Online Exam System is a Java-based application designed for conducting online exams. It
allows educators to create exams, set questions, and evaluate student performance. Students
can log in, take exams, and receive immediate results. This project leverages Java SE 8,
collections framework, multithreading, and exception handling to create a robust and responsive
online exam platform.
### Key Features
1. **User Authentication:** Authenticate users as educators or students to access their
respective functionalities.
2. **Exam Creation:** Educators can create and customize exams with various question types
(e.g., multiple-choice, true/false).
3. **Exam Taking:** Students can log in and take exams under a time limit.
4. **Real-time Exam Evaluation:** Immediate evaluation of student answers with scores and
feedback.
5. **Multithreading:** Utilizes multithreading to allow multiple students to take exams
concurrently.
6. **Exception Handling:** Robust error handling ensures system stability and user-friendly error
messages.
### Technologies Used
- **Java Version:** Java SE 8
- **Collections Framework:** Utilized for efficient data storage and retrieval of questions and
student data.
- **Multithreading:** Java's `ExecutorService` is used for managing concurrent exam sessions.
- **Exception Handling:** Java's exception handling mechanisms for graceful error reporting.
### How to Run the Application
1. Clone this repository to your local machine.
2. Compile the Java code: `javac OnlineExamSystem.java`.
3. Run the application: `java OnlineExamSystem`.

### Directory Structure
- `OnlineExamSystem.java`: Main application code.
- `User.java`: User class for user authentication.
- `Exam.java`: Exam class for exam creation.
- `Question.java`: Question class for defining exam questions.
- `ExamSession.java`: Multithreaded exam session handling.
### Usage
1. Educators should create exams and questions using the provided menu.
2. Students log in with their credentials and take available exams.
3. Exam results are displayed immediately upon completion.
### Contributors
- Devansh Gupta
### Acknowledgments
Special thanks to the Java development community for providing resources and support during
the project.
