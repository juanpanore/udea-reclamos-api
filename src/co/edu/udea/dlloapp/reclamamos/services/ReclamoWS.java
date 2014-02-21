package co.edu.udea.dlloapp.reclamamos.services;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.mongodb.util.JSON;

import co.edu.udea.dlloapp.reclamamos.dto.ClienteDto;
import co.edu.udea.dlloapp.reclamamos.dto.MotivoDto;
import co.edu.udea.dlloapp.reclamamos.dto.ReclamoDto;
import co.edu.udea.dlloapp.reclamamos.dto.TipoDocumentoDto;
import co.edu.udea.dlloapp.reclamamos.logic.ClienteLogic;
import co.edu.udea.dlloapp.reclamamos.logic.IClienteLogic;
import co.edu.udea.dlloapp.reclamamos.logic.IMaestrosLogic;
import co.edu.udea.dlloapp.reclamamos.logic.IReclamacionLogic;
import co.edu.udea.dlloapp.reclamamos.logic.MaestrosLogic;
import co.edu.udea.dlloapp.reclamamos.logic.ReclamacionLogic;

@Path("/ReclamamosApiService")
public class ReclamoWS implements Serializable {

	IMaestrosLogic maestrosLogic;
	IClienteLogic clienteLogic;
	IReclamacionLogic reclamacionLogic;
	
	@GET
	@Path("/consultarListaMotivos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MotivoDto> consultarListaMotivos() {
		List<MotivoDto> listaMotivos = null;
		maestrosLogic = new MaestrosLogic();
		try {
			listaMotivos = maestrosLogic.consultarListaMotivos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaMotivos;
	}

	@GET
	@Path("/consultarTiposDocumentos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TipoDocumentoDto> consultarTiposDocumentos() {
		List<TipoDocumentoDto> listaTiposDocumentos = null;
		maestrosLogic = new MaestrosLogic();
		try {
			listaTiposDocumentos = maestrosLogic.consultarTiposDocumentos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaTiposDocumentos;
	}

	@GET
	@Path("/consultarCliente/{tipoDocumento}/{numeroDocumento}")
	@Produces(MediaType.APPLICATION_JSON)
	public ClienteDto consultarCliente(
			@PathParam("tipoDocumento") String tipoDocumento,
			@PathParam("numeroDocumento") String numeroDocumento) {
		ClienteDto clienteDto = null;
		clienteLogic = new ClienteLogic();
		try {
			clienteDto = clienteLogic.consultarCliente(tipoDocumento, numeroDocumento);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return clienteDto;
	}
	
	@GET
	@Path("/consultarListaReclamos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ReclamoDto> consultarListaReclamos(){
		List<ReclamoDto> listaReclamos = null;
		reclamacionLogic = new ReclamacionLogic();
		try {
			listaReclamos = reclamacionLogic.consultarListaReclamos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaReclamos;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/guardarIncidente/{reclamoId}")
	public Boolean guardarIncidente(ReclamoDto reclamo) {
		Boolean estado = false;
		reclamacionLogic = new ReclamacionLogic();
		try {
			estado = reclamacionLogic.guardarIncidente(reclamo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
	}
}
