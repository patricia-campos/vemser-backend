package aceitacao;

import aceitacao.dto.PetPayloadDTO;
import aceitacao.dto.ReturnDTO;
import aceitacao.service.PetService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PetAceitacao {


    PetService petService = new PetService();

    // MASSA DE DADOS PARA O SERVICE
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    //==================================================================================================================
    //                                                 POST
    //==================================================================================================================

    // ENDPOINT 2 : post/pet  INCLUI UM NOVO PET
    @Test
    public void incluirPet() throws IOException {

        String jsonBody = lerJson("src/test/resources/data/pet.json");

        PetPayloadDTO resulService = petService.adicionarPet(jsonBody);

        // VALIDAÇÃO
        Assert.assertEquals(resulService.getId(), "12345678");
        Assert.assertEquals(resulService.getName(), "Raul");
        Assert.assertEquals(resulService.getCategory().getName(), "Pug");
    }

    //==================================================================================================================
    //                                                 GET
    //==================================================================================================================

    // ENDPOINT 5 : get/pet/petId - CONSULTAR UM PET COM SEU ID POR PARÂMETRO

    @Test
    public void consultarPet() throws IOException {

        // Início do ciclo chamando o método de adicionar um pet
        incluirPet();

        // Parâmetro para a edição
        Integer idPet = 12345678;

        PetPayloadDTO resulService = petService.consultarPet(idPet);

        // VALIDAÇÃO
        Assert.assertEquals(resulService.getId(), "12345678");
        Assert.assertEquals(resulService.getName(), "Raul");
        Assert.assertEquals(resulService.getCategory().getName(), "Pug");

        // Final do ciclo excluindo o pet
        deletarPet();
    }

    //==================================================================================================================
    //                                                 PUT
    //==================================================================================================================

    // ENDPOINT 3 : put/pet - EFETUA A EDIÇÃO DO PET

    @Test
    public void editarPet() throws IOException {

        // Início do ciclo adicionando pet
        incluirPet();

        // Leitura da massa de dados
        String jsonBody = lerJson("src/test/resources/data/pet.json");


        //
        PetPayloadDTO resulService = petService.editarPet(jsonBody);

        // VALIDAÇÃO
        Assert.assertEquals(resulService.getId(), "12345678");
        Assert.assertEquals(resulService.getName(), "Raul");
        Assert.assertEquals(resulService.getCategory().getName(), "Pug");

        // Final do ciclo excluindo o pet
        deletarPet();
    }

    //==================================================================================================================
    //                                                 DELETE
    //==================================================================================================================

    // ENDPOINT 7 : delete/pet/petId - DELETA O PET

    @Test
    public void deletarPet() throws IOException {

        incluirPet();

        Integer idPet = 12345678;

        ReturnDTO resulService = petService.deletarPet(idPet);

        // VALIDAÇÃO do delete apenas retorna a confirmação do status
        Assert.assertEquals(resulService.getCode(), "200");
    }

    //==================================================================================================================
}
