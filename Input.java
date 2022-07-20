import java.util.Scanner;

public class Input {
  Scanner s;

  public Input() {
    s = new Scanner(System.in);
  }

  public String scan() {
    String input;
    if (s.hasNextLine()) {
      input = s.nextLine();
    } else {
      input = "ERROR";
    }
    return input;
  }

  public void close() {
    s.close();
  }
}
