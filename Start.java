public class Start {
  public static void main(String[] args) {

    AddressBook.load();
    Input inputScanner = new Input();

    while (true) {
      System.out.println("\nMenú principal (elija una opción)");
      System.out.println("- 0. Salir de la aplicación");
      System.out.println("- 1. Mostrar contactos");
      System.out.println("- 2. Crear nuevo contacto");
      System.out.println("- 3. Eliminar contacto");

      System.out.print("\nIngrese el número de opción: ");
      String userText = inputScanner.scan();
      System.out.println("");

      if (userText.equals("0")) { // Stop application
        break;
      }

      switch (userText) {
        case "1":
          AddressBook.list();
          break;
        case "2":
          AddressBook.create();
          break;
        case "3":
          AddressBook.delete();
          break;
        default:
          System.out.println("***** Opción inválida *****");
          break;
      }
    }

    inputScanner.close();
  }
}
