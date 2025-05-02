import java.util.ArrayList;

public class Agenda {
    private ArrayList<Contato> contatos;

    public Agenda() {
        contatos = new ArrayList<>();
    }

    public boolean adicionarContato(Contato contato) {
        for (Contato c : contatos) {
            if (c.getNome().equalsIgnoreCase(contato.getNome())) {
                return false;
            }
        }
        contatos.add(contato);
        return true;
    }

    public boolean removerContato(String nome) {
        for (Contato c : contatos) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                contatos.remove(c);
                return true;
            }
        }
        return false;
    }

    public Contato buscarContato(String nome) {
        for (Contato c : contatos) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        return null;
    }
    
    public void listarContatos() {
        if (contatos.isEmpty()) {
            System.out.println("Agenda vazia.");
        } else {
            for (Contato c : contatos) {
                System.out.println(c);
            }
        }
    }

    public boolean editarContato(String nome, Contato novoContato) {
        for (int i = 0; i < contatos.size(); i++) {
            if(contatos.get(i).getNome().equalsIgnoreCase(nome)) {
                contatos.set(i, novoContato);
                return true;
            }
        }
        return false;
    }
}
