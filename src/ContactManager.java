import javax.swing.JOptionPane;
// import java.util.Scanner;
public class ContactManager {
    public static void main(String[] args){
    // Módulo principal - Monta menu de opções
        ContactList Contacts = new ContactList();
        int opt = 0;
        String nameAux, phoneNumberAux, eMailAux, nameOrPhoneAux;
        while (opt != 5) {
            opt = Integer.parseInt(JOptionPane.showInputDialog(
                "Esolha a opção Desejada \n" + 
                "1 - Adicionar Contato \n" +
                "2 - Buscar Contato \n" +
                "3 - Excluir Contato \n" +
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
                
                case 2:
                    nameOrPhoneAux = JOptionPane.showInputDialog("Informe o nome ou telefone do contato para busca: ");
                    int posAux = Contacts.searchContact(nameOrPhoneAux); 
                    if ( posAux < 0) {
                        JOptionPane.showMessageDialog
                            (null, "Não encontrado!");
                    }else{
                        JOptionPane.showMessageDialog
                            (null, "Posição: " + posAux);
                    }
                break;
                
                case 3:
                    nameOrPhoneAux = JOptionPane.showInputDialog("Informe o nome ou telefone do contato a excluir: ");
                    Contacts.removeContact(nameOrPhoneAux); 
                    break;
                
                case 4:
                    Contacts.listContacts();
                    break;
                
                case 5:
                    System.exit(0);
                    break;
            }
        }
        
    }
}