import java.util.Scanner;
public class ContactManager {
    public static void main(String[] args){
    // Módulo principal - Monta menu de opções
        ContactList Contacts = new ContactList();
        String nameAux, phoneNumberAux, eMailAux, nameOrPhoneAux;
        
        try(Scanner input = new Scanner(System.in)){
            int opt = 0;
            while (opt != 5) {
                System.out.println("Esolha a opção Desejada \n" + 
                "1 - Adicionar Contato \n" +
                "2 - Buscar Contato \n" +
                "3 - Excluir Contato \n" +
                "4 - Listar Contatos \n" +
                "5 - Sair");

                if (input.hasNextInt()) {
                    opt = input.nextInt();
                    switch (opt) {
                        case 1:
                            System.out.println("Informe o nome do contato: ");
                            nameAux = input.next();
                            System.out.println("Informe o telefone do contato: ");
                            phoneNumberAux = input.next();
                            System.out.println("Informe o e-mail do contato: ");
                            eMailAux = input.next();                       
                            Contacts.addContact(new Contact(nameAux, phoneNumberAux, eMailAux));
                            break;
                        
                        case 2:
                            System.out.println("Informe o nome ou telefone do contato para busca: ");
                            nameOrPhoneAux = input.next();
                            int posAux = Contacts.searchContact(nameOrPhoneAux); 
                            if ( posAux < 0) {
                                System.out.println("Não encontrado!");
                            }else{
                                System.out.println("Posição: " + posAux);
                            }
                            break;
                        
                        case 3:
                            System.out.println("Informe o nome ou telefone do contato a excluir: ");
                            nameOrPhoneAux = input.next();
                            Contacts.removeContact(nameOrPhoneAux); 
                            break;
                        
                        case 4:
                            Contacts.listContacts();
                            break;
                        
                        case 5:
                            System.exit(0);
                            break;

                        default:
                            System.out.println("Opção inválida. Tente novamente.");

                    }
                    
                }else{
                    System.out.println("Entrada inválida. Digite um número válido.");
                    input.next();
                    opt = 0;
                }
            }
            input.close();  
        }       
    }
}