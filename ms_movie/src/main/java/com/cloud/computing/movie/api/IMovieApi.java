package com.cloud.computing.movie.api;

import com.cloud.computing.movie.model.Movie;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

public interface IMovieApi {

    @Operation(summary = "Retorna HTTP 200 al consultar exitosamente todos los peliculas.",
            description = "Ver todas las peliculas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Peliculas Consultados Exitasamente",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Bad Request") })
    @RequestMapping(value = "/movies",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Movie>> movie();

    @Operation(summary = "Retorna HTTP 200 al crear exitosamente una pelicula.",
            description = "Crear pelicula.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pelicula Creada Exitasamente",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Bad Request") })
    @RequestMapping(value = "/movies",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<String> createMovie(@RequestBody @Valid Movie movie);


    @Operation(summary = "Retorna HTTP 200 al consultar exitosamente una pelicula.",
            description = "Consultar pelicula.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pelicula Consultada Exitasamente",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Bad Request") })
    @RequestMapping(value = "/movies/{id}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<String> getMovieId(@Parameter(in = ParameterIn.PATH,
            description = "Id de la pelicula", required=true) @PathVariable("id") long id);


    @Operation(summary = "Retorna HTTP 200 al eliminar exitosamente una pelicula.",
            description = "Eliminar una pelicula.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pelicula Eliminada Exitasamente",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Bad Request") })
    @RequestMapping(value = "/movies/{id}",
            produces = { "application/json" },
            method = RequestMethod.DELETE)
    ResponseEntity<String> deleteMovie(@Parameter(in = ParameterIn.PATH,
            description = "Id de la pelicula", required=true) @PathVariable("id") long id);
}
