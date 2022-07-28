package com.cloud.computing.showtime.api;

import com.cloud.computing.showtime.model.Showtime;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@FeignClient(value = "showtimes")
public interface IShowtimeApi {

    @Operation(summary = "Retorna HTTP 200 al consultar exitosamente todos las programaciones.",
            description = "Ver todas las programaciones.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Programaciones Consultados Exitasamente",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Bad Request") })
    @RequestMapping(value = "/showtimes",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Showtime>> movie();

    @Operation(summary = "Retorna HTTP 200 al crear exitosamente una programacion.",
            description = "Crear una programacion.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Programacion Creada Exitasamente",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Bad Request") })
    @RequestMapping(value = "/showtimes",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<String> createShowTime(@RequestBody @Valid Showtime showtime);


    @Operation(summary = "Retorna HTTP 200 al consultar exitosamente una programacion.",
            description = "Consultar una programacion.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Programacion Consultada Exitasamente",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Bad Request") })
    @RequestMapping(value = "/showtimes/{id}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<String> getShowTimeId(@Parameter(in = ParameterIn.PATH,
            description = "Id de la programacion", required=true) @PathVariable("id") long id);


    @Operation(summary = "Retorna HTTP 200 al actualizar exitosamente una programacion.",
            description = "Actualiza una programacion.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Programacion Actualizada Exitasamente",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Bad Request") })
    @RequestMapping(value = "/showtimes/{id}",
            produces = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity<String> updateShowTimeId(@Parameter(in = ParameterIn.PATH,
            description = "Id de la programacion", required=true) @PathVariable("id") long id,
                                            @RequestBody @Valid Showtime showtime);

}
