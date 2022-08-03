package aceitacao.service;

import aceitacao.dto.PetPayloadDTO;
import aceitacao.dto.ReturnDTO;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class PetService {

    String baseuri = "https://petstore.swagger.io/v2/pet";

    //==================================================================================================================

    // POST - ADICIONAR/ INCLUIR NOVO PET
    public PetPayloadDTO adicionarPet(String jsonBody) {

        PetPayloadDTO resul = given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .post(baseuri)
                .then()
                .log().all() //
                .statusCode(200)
                .extract().as(PetPayloadDTO.class);

        return resul;
    }

    //==================================================================================================================

    // GET - CONSULTAR PET
    public PetPayloadDTO consultarPet(Integer idPet) {

        String getUrl = baseuri + "/" + idPet;
        PetPayloadDTO result = given()
                .contentType(ContentType.JSON)
                .log().all()
                //.body(jsonBody)
                .when()
                .get(getUrl)
                .then()
                .log().all() //
                .statusCode(200)
                .extract().as(PetPayloadDTO.class);

        return result;
    }

    //==================================================================================================================

    // PUT - EDITAR PET
    public PetPayloadDTO editarPet(String jsonBody) {  //, Integer idPet

        //String putUrl = baseuri + "/" + idPet;

        PetPayloadDTO result = given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .put(baseuri)
                .then()
                .log().all() //
                .statusCode(200)
                .extract().as(PetPayloadDTO.class);

        return result;
    }

    //==================================================================================================================

    // DELETE - DELETAR PET
    public ReturnDTO deletarPet(Integer idPet) {

        String deleteUrl = baseuri + "/" + idPet;

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

}
