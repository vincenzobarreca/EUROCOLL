import model.Catalogo;
import model.Utente;
import view.Finestra;
import java.io.*;


public class Main {
    public static void main(String[] args) {
        File fileUtente = new File("src/utente.dat");
        File fileCatalogo = new File("src/catalogo.dat");
        Finestra finestra = null;

        if (fileUtente.exists() && fileUtente.length() > 0 && fileCatalogo.exists() && fileCatalogo.length() > 0) {
            try (ObjectInputStream inUtente = new ObjectInputStream(new FileInputStream(fileUtente));
                 ObjectInputStream inCatalogo = new ObjectInputStream(new FileInputStream(fileCatalogo))) {
                Utente utente = (Utente) inUtente.readObject();
                Catalogo catalogo = (Catalogo) inCatalogo.readObject();
                finestra = new Finestra(true, utente, catalogo);
            } catch (IOException  e) {
                System.out.println("PROBLEMI DI APERTURA");
            }
            catch (ClassNotFoundException e){
                System.out.println("PROBLEMI DI CLASSE");
            }
        } else {
            finestra = new Finestra();
        }

        synchronized (finestra) {
            try {
                finestra.wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        if(finestra.getUtente() != null && finestra.getCatalogo() != null) {
            try (ObjectOutputStream outUtente = new ObjectOutputStream(new FileOutputStream(fileUtente));
                 ObjectOutputStream outCatalogo = new ObjectOutputStream(new FileOutputStream(fileCatalogo))) {
                outUtente.writeObject(finestra.getUtente());
                outCatalogo.writeObject(finestra.getCatalogo());
            } catch (IOException e) {
                System.out.println("PROBLEMI");
            }
        }
    }
}