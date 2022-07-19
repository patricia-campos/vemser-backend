package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.entity.TipoContato;
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
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*1*/, 1, TipoContato.RESIDENCIAL, "000333222", "Whatsapp"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*2*/, 2, TipoContato.COMERCIAL, "000333255", "Fixo"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*3*/, 2, TipoContato.COMERCIAL, "000333244", "Celular"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*4*/, 3, TipoContato.RESIDENCIAL, "000333233", "WhatsApp"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*4*/, 3, TipoContato.RESIDENCIAL, "000333277", "Apenas recados"));
    }

    public Contato create(Contato contato) {
        contato.setIdContato(COUNTER.incrementAndGet());
        listaContatos.add(contato);
        return contato;
    }

    public List<Contato> list() {
        return listaContatos;
    }

    public List<Contato> listByIdPessoa(Integer idPessoa) {
        return listaContatos.stream()
                .filter(x -> x.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }
}
