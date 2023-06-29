import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.NumberFormatException;
public class VentanaPrincipal {
    private JTextField txtNombre;
    private JTextField txtNumero;
    private JButton btnCrear;
    private JButton btnLeer;
    private JButton btnEliminar;
    private JButton btnActualizar;
    private JLabel Nombre;
    private JLabel Numero;



    public JPanel PanelPrincipal;
public VentanaPrincipal() {
    btnCrear.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {

                String newName = String.valueOf(txtNombre.getText());

                long newNumber = Long.parseLong(String.valueOf(txtNumero.getText()));

                String nameNumberString;
                String name;
                long number;
                int index;

                File file = new File("contactos.txt");

                if (!file.exists()) {

                    file.createNewFile();
                }


                RandomAccessFile raf
                        = new RandomAccessFile(file, "rw");
                boolean found = false;


                while (raf.getFilePointer() < raf.length()) {


                    nameNumberString = raf.readLine();


                    String[] lineSplit
                            = nameNumberString.split("!");

                    name = lineSplit[0];
                    number = Long.parseLong(lineSplit[1]);

                    if (name == newName
                            || number == newNumber) {
                        found = true;
                        break;
                    }
                }

                if (found == false) {


                    nameNumberString
                            = newName + "!"
                            + String.valueOf(newNumber);


                    raf.writeBytes(nameNumberString);


                    raf.writeBytes(System.lineSeparator());

                    System.out.println(" contacto añadido. ");

                    raf.close();
                }

                else {

                    raf.close();

                    System.out.println(" Input name"
                            + " does not exists. ");
                }
            }

            catch (IOException ioe) {

                System.out.println(ioe);
            }
            catch (NumberFormatException nef) {

                System.out.println(nef);
            }
        }





    });
    btnEliminar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {

                String newName = String.valueOf(txtNombre.getText());

                long newNumber = Long.parseLong(String.valueOf(txtNumero.getText()));

                String nameNumberString;
                String name;
                long number = 0;
                int index;

                File file = new File("contactos.txt");

                if (!file.exists()) {

                    file.createNewFile();
                }

                RandomAccessFile raf
                        = new RandomAccessFile(file, "rw");
                boolean found = false;

                while (raf.getFilePointer() < raf.length()) {

                    nameNumberString = raf.readLine();

                    String[] lineSplit
                            = nameNumberString.split("!");

                    name = lineSplit[0];
                    number = Long.parseLong(lineSplit[1]);

                    if (name.equals(newName) && number == newNumber ) {
                        found = true;
                        break;
                    }
                }

                if (found == true) {

                    File tmpFile = new File("temp.txt");

                    RandomAccessFile tmpraf
                            = new RandomAccessFile(tmpFile, "rw");

                    raf.seek(0);

                    while (raf.getFilePointer()
                            < raf.length()) {

                        nameNumberString = raf.readLine();

                        index = nameNumberString.indexOf('!');
                        name = nameNumberString.substring(
                                0, index);


                        if (name.equals(newName)) {

                            continue;
                        }

                        tmpraf.writeBytes(nameNumberString);

                        tmpraf.writeBytes(
                                System.lineSeparator());
                    }

                    raf.seek(0);
                    tmpraf.seek(0);

                    while (tmpraf.getFilePointer()
                            < tmpraf.length()) {
                        raf.writeBytes(tmpraf.readLine());
                        raf.writeBytes(System.lineSeparator());
                    }

                    raf.setLength(tmpraf.length());

                    tmpraf.close();
                    raf.close();

                    tmpFile.delete();

                    System.out.println(" contacto eliminado. ");
                }


                else {

                    raf.close();

                    System.out.println(" Input name"
                            + " does not exists. ");
                }
            }

            catch (IOException ioe) {
                System.out.println(ioe);
            }
        }


    });
    btnLeer.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {
                String newName = String.valueOf(txtNombre.getText());

                String nameNumberString;
                String name;
                long number;
                int index;

                File file = new File("contactos.txt");

                if (!file.exists()) {

                    file.createNewFile();
                }


                RandomAccessFile raf
                        = new RandomAccessFile(file, "rw");
                boolean found = false;

                while (raf.getFilePointer() < raf.length()) {

                    nameNumberString = raf.readLine();

                    String[] lineSplit
                            = nameNumberString.split("!");

                    name = lineSplit[0];
                    number = Long.parseLong(lineSplit[1]);
                    if (name.equals(newName) ) {
                        txtNombre.setText(String.valueOf(name));
                        txtNumero.setText(String.valueOf(number));
                        found = true;
                    }

                }
            }
            catch (IOException ioe)
                {

                    System.out.println(ioe);
                }
            catch (NumberFormatException nef)
                {

                    System.out.println(nef);
                }
            }
        }

    );
    btnActualizar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {

                String newName = String.valueOf(txtNombre.getText());

                long newNumber = Long.parseLong(String.valueOf(txtNumero.getText()));



                String nameNumberString;
                String name;
                long number;
                int index;

                File file = new File("contactos.txt");

                if (!file.exists()) {

                    file.createNewFile();
                }

                RandomAccessFile raf
                        = new RandomAccessFile(file, "rw");
                boolean found = false;

                while (raf.getFilePointer() < raf.length()) {

                    nameNumberString = raf.readLine();

                    String[] lineSplit
                            = nameNumberString.split("!");

                    name = lineSplit[0];
                    number = Long.parseLong(lineSplit[1]);

                    if (name == newName
                            || number == newNumber) {
                        found = true;
                        break;
                    }
                }

                if (found == true) {

                    File tmpFile = new File("temp.txt");

                    RandomAccessFile tmpraf
                            = new RandomAccessFile(tmpFile, "rw");

                    raf.seek(0);

                    while (raf.getFilePointer()
                            < raf.length()) {

                        nameNumberString = raf.readLine();

                        index = nameNumberString.indexOf('!');
                        name = nameNumberString.substring(
                                0, index);

                        if (name.equals(newName)) {

                            nameNumberString
                                    = name + "!"
                                    + String.valueOf(newNumber);
                        }

                        tmpraf.writeBytes(nameNumberString);

                        tmpraf.writeBytes(
                                System.lineSeparator());
                    }


                    raf.seek(0);
                    tmpraf.seek(0);

                    while (tmpraf.getFilePointer()
                            < tmpraf.length()) {
                        raf.writeBytes(tmpraf.readLine());
                        raf.writeBytes(System.lineSeparator());
                    }

                    raf.setLength(tmpraf.length());

                    tmpraf.close();
                    raf.close();

                    tmpFile.delete();

                    System.out.println(" contacto actualizado. ");
                }

                else {

                    raf.close();

                    System.out.println(" Input name"
                            + " does not exists. ");
                }
            }

            catch (IOException ioe) {
                System.out.println(ioe);
            }

            catch (NumberFormatException nef) {
                System.out.println(nef);
            }
        }
    }

    );
}

}
