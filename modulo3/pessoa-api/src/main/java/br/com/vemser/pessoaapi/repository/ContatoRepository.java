package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entity.Contato;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class ContatoRepository {

    private static List<Contato> listaContatos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public ContatoRepository() {
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*1*/, 1, 2, "000333222", "Whatsapp"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*2*/, 2, 1, "000333255", "Código morse"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*3*/, 2, 2, "000333244", "Celular"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*4*/, 3, 1, "000333233", "Sinal de fumaça"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*4*/, 3, 2, "000333277", "Telegram"));
    }

    public Contato create(Contato contato) {
        contato.setIdContato(COUNTER.incrementAndGet());
        listaContatos.add(contato);
        return contato;
    }

    public List<Contato> list() {
        return listaContatos;
    }

    /*

    TRANSFERIDO PARA SERVICE POIS É REGRA DE NEGÓCIO

    public Contato update(Integer id,
                         Contato contatoAtualizar) throws Exception {

        Contato contatoRecuperado = listaContatos.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não localizado"));
        contatoRecuperado.setIdPessoa(contatoAtualizar.getIdPessoa());
        contatoRecuperado.setTipo(contatoAtualizar.getTipo());
        contatoRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());

        return contatoRecuperado;
    }
    */

    public void delete(Integer id) throws Exception {

        Contato contatoRecuperado = listaContatos.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não localizado"));
        listaContatos.remove(contatoRecuperado);
    }

    
    public List<Contato> listByIdPessoa(Integer idPessoa) {
        return listaContatos.stream()
                .filter(x -> x.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }
}
