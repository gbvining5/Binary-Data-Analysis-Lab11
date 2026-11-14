 
public class CheckObjects {
public static void main(String[] args) {
       try (java.io.ObjectInputStream oin = new java.io.ObjectInputStream(
               new java.io.BufferedInputStream(
                   new java.io.FileInputStream("src/people-salary-sorted-objects.dat")))) {
           while (true) {
               Person p = (Person) oin.readObject();   // read one whole Person back
               System.out.println(p);                  // prints using your toString()
           }
       } catch (java.io.EOFException e) {
           System.out.println("Done.");
       } catch (java.io.IOException | ClassNotFoundException e) {
           e.printStackTrace();
       }
   }
}