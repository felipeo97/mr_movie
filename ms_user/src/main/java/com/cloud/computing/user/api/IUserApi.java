package com.cloud.computing.user.api;

import com.cloud.computing.user.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface IUserApi {

    @Operation(summary = "Retorna HTTP 200 al consultar exitosamente todos los usuarios.",
            description = "Ver todos los usuarios.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuarios Consultados Exitasamente",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Bad Request") })
    @RequestMapping(value = "/users",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<User>> user();


    @Operation(summary = "Retorna HTTP 200 al crear exitosamente un usuario.",
            description = "Crear usuario.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario Creado Exitasamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request") })
    @RequestMapping(value = "/users",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<String> createUser(@RequestBody @Valid User user);

    @Operation(summary = "Retorna HTTP 200 al eliminar exitosamente un usuario.",
            description = "Eliminar un usuario.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario Eliminado Exitasamente",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Bad Request") })
    @RequestMapping(value = "/users/{id}",
            produces = { "application/json" },
            method = RequestMethod.DELETE)
    ResponseEntity<String> deleteUser(@Parameter(in = ParameterIn.PATH,
            description = "Id del Usuario", required=true) @PathVariable("id") Long id);

}
