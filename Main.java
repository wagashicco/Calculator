package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    try (Scanner scanner = new Scanner(System.in)) {

      System.out.print("1番目の数字を入れてください: ");
      double num1 = scanner.nextDouble();

      System.out.print("演算子を入力してください (+, -, *, /): ");
      char operator = scanner.next().charAt(0);

      System.out.print("2番目の数字を入力してください: ");
      double num2 = scanner.nextDouble();

      double result;

      switch (operator) {
        case '+':
          result = num1 + num2;
          break;
        case '-':
          result = num1 - num2;
          break;
        case '*':
          result = num1 * num2;
          break;
        case '/':
          if (num2 != 0) {
            result = num1 / num2;
          } else {
            System.out.println("０の割り算は出来ません.");
            return;
          }
          break;
        default:
          System.out.println("有効な演算子を入力していません.");
          return;
      }
      System.out.println("結果は: " + result);

    } catch (InputMismatchException e) {

      System.out.println("無効な文字が入力されました.");
    }
  }
}