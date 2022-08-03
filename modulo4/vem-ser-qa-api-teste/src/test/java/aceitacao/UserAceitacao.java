package aceitacao;

import aceitacao.dto.ReturnDTO;
import aceitacao.dto.UserPayloadDTO;
import aceitacao.service.UserService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UserAceitacao {

    UserService userService = new UserService();

    // MASSA DE DADOS PARA O SERVICE
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    //==================================================================================================================
    //                                                 POST
    //==================================================================================================================

    // ENDPOINT 1 : post/user/CreateWithArray - INCLUI UM NOVO USUÁRIO COM ARRAY

    @Test
    public void incluirUserArray() throws IOException {

        String jsonBody = lerJson("src/test/resources/data/userList.json");

        // VALIDAÇÃO
        ReturnDTO resultService = userService.adicionarWithArray(jsonBody);
        Assert.assertEquals(resultService.getCode(), "200");
        Assert.assertEquals(resultService.getType(), "unknown");
        Assert.assertEquals(resultService.getMessage(), "ok");
    }

    //------------------------------------------------------------------------------------------------------------------

    // ENDPOINT 2 : post/user/CreateWithList - INCLUI UM NOVO USUÁRIO COM LIST

    @Test
    public void incluirUserList() throws IOException {

        String jsonBody = lerJson("src/test/resources/data/userList.json");

        // VALIDAÇÃO
        ReturnDTO resultService = userService.adicionarWithList(jsonBody);
        Assert.assertEquals(resultService.getCode(), "200");
        Assert.assertEquals(resultService.getType(), "unknown");
        Assert.assertEquals(resultService.getMessage(), "ok");
    }

    //------------------------------------------------------------------------------------------------------------------

    // ENDPOINT 8 : post/user - INCLUI UM NOVO USUÁRIO

    @Test
    public void incluirUser() throws IOException {

        String jsonBody = lerJson("src/test/resources/data/user.json");

        ReturnDTO resulService = userService.adicionarUser(jsonBody);

        // VALIDAÇÃO
        Assert.assertEquals(resulService.getCode(), "200");
        Assert.assertEquals(resulService.getType(), "unknown");
        Assert.assertEquals(resulService.getMessage(), "50");

    }

    //==================================================================================================================
    //                                                 GET
    //==================================================================================================================

    // ENDPOINT 3 : get/user/username - CONSULTAR UM USUÁRIO COM SEU USERNAME POR PARÂMETRO

    @Test
    public void consultarUser() throws IOException {


        // Iniciando o ciclo adicionando um user
        incluirUser();

        // Inserindo o parâmetro necessário para a consulta
        String username = "coraline";

        UserPayloadDTO resulService = userService.consultarUser(username);

        // VALIDAÇÃO
        Assert.assertEquals(resulService.getId(), "50");
        Assert.assertEquals(resulService.getFirstName(), "Coraline");
        Assert.assertEquals(resulService.getLastName(), "Jones");
        Assert.assertEquals(resulService.getEmail(), "coraline@neilgaiman.com");
        Assert.assertEquals(resulService.getPassword(), "gatoPreto");
        Assert.assertEquals(resulService.getPhone(), "111222333");
        Assert.assertEquals(resulService.getUserStatus(), "0");

        // Finalizando o ciclo excluindo o user adicionado
        deletarUser();
    }

    //------------------------------------------------------------------------------------------------------------------

    // ENDPOINT 6 : get/user/login - EFETUA LOGIN

    @Test
    public void logarUser() throws IOException {

        // Iniciando o ciclo adicionando um user
        incluirUser();

        // Inserindo os parâmetros necessários para a consulta
        String userName = "coraline";
        String password = "gatoPreto";

        ReturnDTO resulService = userService.logarUser(userName, password);

        // VALIDAÇÃO
        Assert.assertEquals(resulService.getCode(), "200");
        Assert.assertEquals(resulService.getType(), "unknown");

        // Finalizando o ciclo excluindo o user adicionado
        deletarUser();
    }

    //------------------------------------------------------------------------------------------------------------------

    // ENDPOINT 7 : get/user/logout - EFETUA LOGOUT

    @Test
    public void logoutUser() throws IOException {

        // Iniciando o ciclo adicionando um user
        incluirUser();

        // Efetuando seu login
        logarUser();

        ReturnDTO resulService = userService.logoutUser();

        // VALIDAÇÃO
        Assert.assertEquals(resulService.getCode(), "200");
        Assert.assertEquals(resulService.getType(), "unknown");
        Assert.assertEquals(resulService.getMessage(), "ok");

        // Finalizando o ciclo excluindo o user adicionado
        deletarUser();
    }

    //==================================================================================================================
    //                                                 PUT
    //==================================================================================================================

    // ENDPOINT 4 : put/user/username - EFETUA A EDIÇÃO DO USUÁRIO

    @Test
    public void editarUser() throws IOException {

        // Iniciando o ciclo adicionando um user
        incluirUser();

        // Inserindo o parâmetro necessário para editar
        String username = "coraline";

        // Leitura da massa de dados
        String jsonBody = lerJson("src/test/resources/data/user.json"); //todo json editado


        ReturnDTO resulService = userService.editarUser(username, jsonBody);

        // VALIDAÇÃO
        Assert.assertEquals(resulService.getCode(), "200");
        Assert.assertEquals(resulService.getType(), "unknown");
        Assert.assertEquals(resulService.getMessage(), "50");

        // Finalizo o ciclo excluindo
        deletarUser();
    }

    //==================================================================================================================
    //                                                 DELETE
    //==================================================================================================================

    // ENDPOINT 5 : delete/user/username - DELETA O USUÁRIO

    @Test
    public void deletarUser() throws IOException {

        // Iniciando o ciclo adicionando um user
        incluirUser();

        // Inserindo o parâmetro necessário para deletar
        String username = "coraline";

        ReturnDTO resulService = userService.deletarUser(username);

        // VALIDAÇÃO
        Assert.assertEquals(resulService.getCode(), "200");
        Assert.assertEquals(resulService.getType(), "unknown");
        Assert.assertEquals(resulService.getMessage(), "coraline");
    }

    //==================================================================================================================
}