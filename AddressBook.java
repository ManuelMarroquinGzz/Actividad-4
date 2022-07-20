import java.util.*;
import java.io.*;

public class AddressBook {
  static HashMap<String, String> contactos = new HashMap<>(); // HashMap to save contacts
  static String archivoCSV = "contactos.csv"; // CSV file name that's on this repository

  public static void load() { // Loads CSV file into HashMap
    ArrayList<String> In1 = new ArrayList<String>();
    ArrayList<String> In2 = new ArrayList<String>();

    File currentFile = new File(archivoCSV); // Loading CSV file

    try { // Handling non existent file
      Scanner inputStream = new Scanner(currentFile);
      int readIndex = 0;
      while (inputStream.hasNext()) {
        String data = inputStream.next();
        if (readIndex % 2 == 0) {
          data = data.substring(0, data.length() - 1); // Removing comma
          In1.add(data);
          readIndex++;
        } else {
          In2.add(data);
          readIndex++;
        }
      }
      inputStream.close();
    } catch (FileNotFoundException Error) {
      Error.printStackTrace();
    }
    for (int i = 0; i < In1.size(); i++) { // Saving arrays to HashMap
      contactos.put(In1.get(i), In2.get(i));
    }
  }

  public static void save() { // Save changes to file
    try {
      FileWriter fileWtr = new FileWriter(archivoCSV, false);
      BufferedWriter buffWtr = new BufferedWriter(fileWtr);
      PrintWriter prntWtr = new PrintWriter(buffWtr);
      for (Map.Entry<String, String> set : contactos.entrySet()) {
        prntWtr.println(set.getKey() + ", " + set.getValue());
      }
      prntWtr.flush();
      prntWtr.close();
    } catch (Exception Error) {
      Error.printStackTrace();
    }
  }

  public static void create() { // Create a new contact on HashMap and CSV file
    Input inputScanner = new Input();
    System.out.print("\nIngresa el nombre de la persona: ");
    String nombre = inputScanner.scan();
    System.out.print("\nIngresa el número de la persona: ");
    String numero = inputScanner.scan();
    contactos.put(numero, nombre);
    save();
  }

  public static void list() { // Show all contacts on HashMap
    for (Map.Entry<String, String> set : contactos.entrySet()) {
      System.out.println(set.getKey() + " : " + set.getValue());
    }
  }

  public static void delete() { // Uses phone number to remove a contact from HashMap and CSV file
    Input inputScanner = new Input();
    System.out.print("\nIngresa el número de la persona a eliminar: ");
    String numero = inputScanner.scan();
    contactos.remove(numero);
    save();
  }

}
