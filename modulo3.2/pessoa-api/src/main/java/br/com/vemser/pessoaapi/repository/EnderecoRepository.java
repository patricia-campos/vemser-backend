package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.entity.TipoEndereco;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class EnderecoRepository {

    private static List<Endereco> listaEnderecos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public EnderecoRepository() {
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet() /*1*/, 1, TipoEndereco.RESIDENCIAL,"Rua dos Cataventos", 200,"Fundos","94935570", "Cachoeirinha", "RS", "Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet() /*2*/, 2,TipoEndereco.COMERCIAL,"Rua dos Bobos", 0,"","94935000", "Porto Alegre", "RS", "Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet() /*3*/, 3,TipoEndereco.COMERCIAL,"Avenida das Américas", 200,"Fundos","94935570", "São Paulo", "SP", "Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet() /*4*/, 4,TipoEndereco.RESIDENCIAL,"Rua 2", 820,"201","94935851", "Rio de Janeiro", "RJ", "Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet() /*5*/, 5,TipoEndereco.COMERCIAL,"Rua Dr. Flores", 1050,"901","94935859", "Porto ALegre", "RS", "Brasil"));
    }

    //INSERIR ENDEREÇO
    public Endereco create(Endereco endereco) {
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        listaEnderecos.add(endereco);
        return endereco;
    }

    //Listar tudo
    public List<Endereco> list() {
        return listaEnderecos;
    }

    //Lista endereço por Id Endereco
    public List<Endereco> listByIdEndereco(Integer idEndereco) {
        return listaEnderecos.stream()
                .filter(x -> x.getIdEndereco().equals(idEndereco))
                .collect(Collectors.toList());
    }

    //Lista endereço por id pessoa
    public List<Endereco> listByIdPessoa(Integer idPessoa) {
        return listaEnderecos.stream()
                .filter(x -> x.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }

}