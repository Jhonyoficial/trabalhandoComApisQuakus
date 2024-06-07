package org.acme;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Form;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.ConsultaBoletoDTO;
import org.acme.dto.ConsultaResponseDTO;
import org.acme.dto.PaymentResponseDTO;
import org.acme.dto.TokenDTO;
import org.acme.model.Payment;
import org.acme.model.Token;
import org.acme.repository.RepositoryPayment;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/api")
public class GreetingResource {

    @Inject
    @RestClient
    MyRemoteService restClient;

    @Inject
    RepositoryPayment paymentRepository;

    public TokenDTO getToken(){
        Form form = new Form();
        form.param("client_id", "41b44ab9a56440.teste.celcoinapi.v5");
        form.param("grant_type", "client_credentials");
        form.param("client_secret", "e9d15cde33024c1494de7480e69b7a18c09d7cd25a8446839b3be82a56a044a3");

        return restClient.getToken(form);
    }

    @GET
    @Path("/token")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response gerarToken() {
        TokenDTO tokenDTO = getToken();

        Token tokenEntity = new Token();
        tokenEntity.setDsToken(tokenDTO.getAccessToken());
        tokenEntity.persist();

        return Response.ok(tokenDTO).build();
    }

    @POST
    @Path("/consulta")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultDadosConta(ConsultaBoletoDTO consultaBoletoDTO){

        TokenDTO tokenDTO = getToken();
        ConsultaResponseDTO response = restClient.consultarDadosConta("Bearer " + tokenDTO.getAccessToken() , consultaBoletoDTO);
        return Response.ok(response).build();
    }

    @POST
    @Path("/pagamento")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response efeturarPagamento(ConsultaBoletoDTO consultaBoletoDTO){

        TokenDTO tokenDTO = getToken();
        PaymentResponseDTO response = restClient.EfetuarPagamento("Bearer " + tokenDTO.getAccessToken(), consultaBoletoDTO);

        Payment paymenteEntity = new Payment();
        paymenteEntity.setAmount(consultaBoletoDTO.getBill().getNmValue());
        paymenteEntity.setDigitable(consultaBoletoDTO.getData().getDsDigitable());
        paymenteEntity.setReceipt(response.getReceipt().getReceiptformatted());
        paymentRepository.persist(paymenteEntity);


        return Response.ok(response).build();
    }

    @GET
    @Path("/pagamento/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listPayments(){
        return Response.ok().entity(paymentRepository.listAll()).build();
    }


    @GET
    @Path("/pagamento/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id ){
        return Response.ok().entity(paymentRepository.findById(id)).build();
    }

    @DELETE
    @Path("/pagamento/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response delete(@PathParam("id") Long id){
        return Response.ok().entity(paymentRepository.deleteById(id)).build();
    }

    @PATCH
    @Path("/pagamento/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") String id) {
        return Response.ok().entity(paymentRepository.update(id)).build();
    }
}
