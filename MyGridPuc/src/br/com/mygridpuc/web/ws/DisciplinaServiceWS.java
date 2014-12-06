package br.com.mygridpuc.web.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.mygridpuc.web.ws.transaction.TransactionDisciplina;

@Component
@Path("/disciplina")
public class DisciplinaServiceWS {
	
	@Autowired
	TransactionDisciplina trsDisciplina;
	
	@GET
	@Path("{idMatriz}")
	@Produces("application/json; charset=UTF-8")
	public Response getDisciplinas(@PathParam("idMatriz")int idMatriz){
		
		String result  = trsDisciplina.getByIdMatriz(idMatriz);
		return Response.status(200).entity(result).build();
	}
	
	@GET
	@Path("{idMatriz}/{periodo}")
	@Produces("application/json; charset=UTF-8")
	public Response getDisciplinas(@PathParam("idMatriz")int idMatriz, @PathParam("periodo")int periodo){
		
		String result  = trsDisciplina.getByIdMatrizPeriodo(idMatriz, periodo);
		return Response.status(200).entity(result).build();
	}

}
