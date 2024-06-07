package org.acme;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Form;
import jakarta.ws.rs.core.MediaType;
import org.acme.dto.ConsultaBoletoDTO;
import org.acme.dto.ConsultaResponseDTO;
import org.acme.dto.PaymentResponseDTO;
import org.acme.dto.TokenDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = " https://sandbox.openfinance.celcoin.dev")
public interface MyRemoteService {

    @POST
    @Path("/v5/token")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    TokenDTO getToken(Form form );


    @POST
    @Path("/v5/transactions/billpayments/authorize")
    @Produces(MediaType.APPLICATION_JSON)
    ConsultaResponseDTO consultarDadosConta(@HeaderParam("Authorization") String accessToken, ConsultaBoletoDTO consultaBoletoDTO);


    @POST
    @Path("/v5/transactions/billpayments")
    @Produces(MediaType.APPLICATION_JSON)
    PaymentResponseDTO EfetuarPagamento(@HeaderParam("Authorization") String AccessToken, ConsultaBoletoDTO consultaBoletoDTO);
}
