package aceitacao.service;

import aceitacao.dto.UserPayloadDTO;
import aceitacao.dto.ReturnDTO;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class UserService {

    String baseuri = "https://petstore.swagger.io/v2/user";

    //==================================================================================================================
    // POST - ADICIONAR/ INCLUIR NOVO USUÁRIO

    public ReturnDTO adicionarUser(String jsonBody) {

        ReturnDTO resul = given() //given - dado
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when() //when - quando
                .post(baseuri)
                .then() //then -então
                .log().all()
                .statusCode(200) //statusCode - resultado
                .extract().as(ReturnDTO.class);

        return resul;
    }
    //==================================================================================================================

    // POST COM LISTA

    public ReturnDTO adicionarWithList(String jsonBody) {

        String getUrl = baseuri + "/createWithList";

        ReturnDTO result = given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .post(getUrl)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(ReturnDTO.class);
        return result;
    }

    //==================================================================================================================

    // POST COM ARRAY

    public ReturnDTO adicionarWithArray(String jsonBody) {

        String getUrl = baseuri + "/createWithArray";

        ReturnDTO result = given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .post(getUrl)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(ReturnDTO.class);
        return result;
    }

    //==================================================================================================================

    // PUT - EDITAR USER

    public ReturnDTO editarUser(String username, String jsonBody) {

        String putUrl = baseuri + "/" + username;

        ReturnDTO result = given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .put(putUrl)
                .then()
                .log().all() //
                .statusCode(200)
                .extract().as(ReturnDTO.class);

        return result;
    }

    //==================================================================================================================

    // DELETE USER

    public ReturnDTO deletarUser(String username) {

        String deleteUrl = baseuri + "/" + username;

        ReturnDTO resul = given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .delete(deleteUrl)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(ReturnDTO.class);

        return resul;
    }

    //==================================================================================================================

    // GET - CONSULTAR USER POR USERNAME

    public UserPayloadDTO consultarUser(String username) {

        String getUrl = baseuri + "/" + username;

        UserPayloadDTO result = given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(getUrl)
                .then()
                .log().all() //
                .statusCode(200)
                .extract().as(UserPayloadDTO.class);

        return result;
    }

    //==================================================================================================================

    // GET - LOGIN USUÁRIO

    public ReturnDTO logarUser(String username, String password) {

        String getUrl = baseuri + "/login?username=" + username + "&password=" + password;

        ReturnDTO result = given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(getUrl)
                .then()
                .log().all() //
                .statusCode(200)
                .extract().as(ReturnDTO.class);

        return result;
    }

    //==================================================================================================================

    //GET LOGOUT

    public ReturnDTO logoutUser() {

        String getUrl = baseuri + "/logout";

        ReturnDTO result = given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(getUrl)
                .then()
                .log().all() //
                .statusCode(200)
                .extract().as(ReturnDTO.class);

        return result;
    }


}
