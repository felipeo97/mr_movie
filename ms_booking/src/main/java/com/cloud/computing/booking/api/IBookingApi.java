package com.cloud.computing.booking.api;

import com.cloud.computing.booking.model.Booking;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface IBookingApi {

    @Operation(summary = "Retorna HTTP 200 al consultar exitosamente todos las reservas.",
            description = "Ver todas las reservas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reservas Consultados Exitasamente",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Bad Request") })
    @RequestMapping(value = "/bookings",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Booking>> booking();

    @Operation(summary = "Retorna HTTP 200 al crear exitosamente una reserva.",
            description = "Crear reserva.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reserva Creada Exitasamente",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Bad Request") })
    @RequestMapping(value = "/bookings",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<String> createBooking(@Valid @RequestBody Booking booking);


    @Operation(summary = "Retorna HTTP 200 al consultar exitosamente una reserva por Id.",
            description = "Consultar reserva por Id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reserva Consultada Exitasamente",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Bad Request") })
    @RequestMapping(value = "/bookings/{id}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<String> getBookingId(@Parameter(in = ParameterIn.PATH,
            description = "Id del booking", required=true) @PathVariable("id") long id);


    @Operation(summary = "Retorna HTTP 200 al eliminar exitosamente una reserva.",
            description = "Eliminar una reserva.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reserva Eliminada Exitasamente",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Bad Request") })
    @RequestMapping(value = "/bookings/{id}",
            produces = { "application/json" },
            method = RequestMethod.DELETE)
    ResponseEntity<String> deleteBooking(@Parameter(in = ParameterIn.PATH,
            description = "Id del booking", required=true) @PathVariable("id") long id);

    @Operation(summary = "Retorna HTTP 200 al consultar exitosamente una reserva por UserId.",
            description = "Consultar reserva por UserId.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reserva Consultada por UserId Exitasamente",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Bad Request") })
    @RequestMapping(value = "/bookings/",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<String> getBookingUserId(@Parameter(in = ParameterIn.PATH,
            description = "Id del usuario", required=true) @RequestParam(value="userid") long userid);
}
