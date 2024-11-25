package Stu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudentManager {
  public static List<Student> students = new ArrayList<>();

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("1. 学生を追加");
      System.out.println("2. 学生を削除");
      System.out.println("3. 点数を更新");
      System.out.println("4. 平均点を計算");
      System.out.println("5. 全学生の情報を表示");
      System.out.println("6. 終了");
      System.out.print("選択してください: ");
      int choice = scanner.nextInt();
      scanner.nextLine(); // consume newline

      switch (choice) {
        case 1:
          addStudent(scanner);
          break;
        case 2:
          removeStudent(scanner);
          break;
        case 3:
          updateScore(scanner);
          break;
        case 4:
          calculateAverage();
          break;
        case 5:
          displayAllStudents();
          break;
        case 6:
          System.out.println("プログラムを終了します。");
          return;
        default:
          System.out.println("無効な選択です。もう一度試してください。");
      }
    }
  }

  private static void addStudent(Scanner scanner) {
    System.out.print("学生の名前を入力してください: ");
    String name = scanner.nextLine();
    System.out.print("学生の点数を入力してください: ");
    int score = scanner.nextInt();
    scanner.nextLine(); // consume newline
    students.add(new Student(name, score));
    System.out.println(name + "が追加されました。");
  }

  private static void removeStudent(Scanner scanner) {
    System.out.print("削除する学生の名前を入力してください: ");
    String name = scanner.nextLine();
    students = students.stream()
        .filter(student -> !student.getName().equals(name))
        .collect(Collectors.toList());
    System.out.println(name + "が削除されました。");
  }

  private static void updateScore(Scanner scanner) {
    System.out.print("点数を更新する学生の名前を入力してください: ");
    String name = scanner.nextLine();
    System.out.print(name + "の新しい点数を入力してください: ");
    int newScore = scanner.nextInt();
    scanner.nextLine(); // consume newline
    for (Student student : students) {
      if (student.getName().equals(name)) {
        student.setScore(newScore);
        System.out.println(name + "の点数が更新されました。");
        return;
      }
    }
    System.out.println(name + "が見つかりませんでした。");
  }

  private static void calculateAverage() {
    double average = students.stream()
        .mapToInt(Student::getScore)
        .average()
        .orElse(0.0);
    System.out.println("平均点: " + average);
  }


  private static void displayAllStudents() {
    System.out.println("学生一覧:");
    for (Student student : students) {
      System.out.println(student.getName() + ": " + student.getScore() + "点");
    }
  }
}

class Student {

  private String name;
  private int score;

  public Student(String name, int score) {
    this.name = name;
    this.score = score;
  }

  public String getName() {

    return name;
  }

  public int getScore() {

    return score;
  }

  public void setScore(int score) {

    this.score = score;
  }
}

