import javax.swing.JOptionPane;
// import java.util.Scanner;
public class ContactManager {
    public static void main(String[] args){
    //
        ContactList Contacts = new ContactList();
        //int position, opt = 0;
        int opt = 0;
        String nameAux, phoneNumberAux, eMailAux;
        //Node contact;
        while (opt != 5) {
            opt = Integer.parseInt(JOptionPane.showInputDialog(
                "Esolha a opção Desejada \n" + 
                "1 - Adicionar Contato \n" +
                // "2 - Buscar Contato \n" +
                // "3 - Excluir Contato \n" +
                "4 - Listar Contatos \n" +
                "5 - Sair"
            ));
            switch (opt) {
                case 1:
                    nameAux = JOptionPane.showInputDialog("Informe o nome do contato: ");
                    phoneNumberAux = JOptionPane.showInputDialog("Informe o telefone do contato: ");
                    eMailAux = JOptionPane.showInputDialog("Informe o e-mail do contato: ");
                    Contacts.addContact(new Contact(nameAux, phoneNumberAux, eMailAux));
                    break;
                
                case 4:
                    /*if (Contacts.countNodes() == 0) 
                        JOptionPane.showMessageDialog
                            (null, "Lista vazia");
                    else
                        JOptionPane.showMessageDialog(null, Contacts.showList());*/
                    Contacts.listContacts();
                    break;
                
                case 5:
                    System.exit(0);
                    break;
            }
        }
        
    }
}