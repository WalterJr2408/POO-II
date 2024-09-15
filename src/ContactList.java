//import javax.swing.JOptionPane;

public class ContactList {
    private Node first, last;

    public ContactList(){
        first = null;
        last = null;
    }

    public int countNodes(){
        int quantity = 0;
        Node nodeTemp = first;
        while (nodeTemp != null) {
            quantity++;
            nodeTemp = nodeTemp.next;
        }
        return quantity;
    }

    public void addContact(Contact contact){
        Node newNode = new Node(contact);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else{
            last.next = newNode;
            last = newNode;
        }
    }

    public int searchContact(String nameOrPhone){
        int i = 0;
        Node nodeTemp = first;
        boolean found = false;
        while (nodeTemp != null) {
            if (nodeTemp.contact.getName().equalsIgnoreCase(nameOrPhone) ||
                nodeTemp.contact.getPhoneNumber().contains(nameOrPhone)) {
                found = true;
                break;
            }
            nodeTemp = nodeTemp.next;
            i++;
        }
        // Se não encontrado, retorna -1
        if (!found) i = -1;
        // Se encontrador, retorna a posição
        return i;
    }

    public void removeContact(String nameOrPhone){
        Node nodeTemp = new Node((null));
        nodeTemp.next = first;
        int position = searchContact(nameOrPhone);
        int posAux = 0;
        String msg = "";
        if (position >= 0) {
            while (nodeTemp.next != null && position != posAux) {
                nodeTemp = nodeTemp.next;
                posAux++;
            }
            if (last == nodeTemp.next) 
                    last = nodeTemp;
            if (first == nodeTemp.next)
                first = nodeTemp.next.next;
            msg = nodeTemp.next.contact + " excluído!";
            nodeTemp.next =nodeTemp.next.next;
        }else{
            msg = "item não encontrado.";
        }
        //JOptionPane.showMessageDialog(null, msg);
        System.out.println(msg);
    }

    public void listContacts(){
        int i = 0 ;
        Node nodeTemp = first;
        String msg = "";
        while (nodeTemp != null) {
            msg = msg + "Posição: " + i + ", contato: " + nodeTemp.contact + "\n";
            nodeTemp = nodeTemp.next;
            i++;
        }
        if (i == 0) 
            /*JOptionPane.showMessageDialog
                (null, "Lista vazia");*/
            System.out.println("Lista vazia!");
        else
            /*JOptionPane.showMessageDialog(null, msg);*/
            System.out.println(msg);
    }
    
}
