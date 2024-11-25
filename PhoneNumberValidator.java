import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public  class PhoneNumberValidator {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // regex = 正規表現のこと
    String regex = "^(080|090|070)-\\d{4}-\\d{4}$";

        Pattern pattern = Pattern.compile(regex);

    while (true) {
      System.out.println("携帯電話番号を入力してください　（終了するには 'exit'　と入力) : ");
      String input = scanner.nextLine();

      if (input.equalsIgnoreCase("exit")) {
        break;
      }
      Matcher matcher = pattern.matcher(input);
      if (matcher.matches()) {
        System.out.println(input + "有効な携帯電話番号です。");
      } else {
        System.out.println(input + "無効な携帯番号です。");
      }
    }
    scanner.close();
  }
}