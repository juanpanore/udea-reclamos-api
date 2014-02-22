package co.edu.udea.dlloapp.reclamamos.dataaccess;

/*
 * 
 * @autor Juan Pa Noreña
 * 
 * 
 * */

import java.rmi.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import co.edu.udea.dlloapp.reclamamos.dto.ClienteDto;
import co.edu.udea.dlloapp.reclamamos.dto.ReclamoDto;
import co.edu.udea.dlloapp.reclamamos.dto.ResponseReclamos;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.util.JSON;

public class ReclamacionDao {

	MongoClientURI uri = new MongoClientURI(
			"mongodb://appempresariales:udea2014@ds027759.mongolab.com:27759/heroku_app21361040");

	public ReclamoDto consultarDetalleReclamo(String codigo) throws Exception,
			UnknownHostException {
		
		ReclamoDto reclamoDto = new ReclamoDto();
		
		try {
			
			MongoClient client = new MongoClient(uri);
			DB db = client.getDB(uri.getDatabase());

			DBCollection reclamo = db.getCollection("ListaReclamos");
			BasicDBObject query = new BasicDBObject();
			query.put("codigo", codigo);

			DBCursor cursor = reclamo.find(query);
			DBObject reclamoJson = cursor.next();
			
			reclamoDto.convertJsonToDto(reclamoJson);			
			
			DBCollection clientes = db.getCollection("Clientes");
			BasicDBObject queryCliente = new BasicDBObject();
			query.put("tipoDocumento", reclamoDto.getTipoDocumento());
			query.put("numeroDocumento", reclamoDto.getNumeroDocumento());

			DBCursor cursorCliente = clientes.find(queryCliente);
			DBObject clienteJson = cursorCliente.next();

			ClienteDto clienteDto = new ClienteDto();
			
			clienteDto.convertJsonToDto(clienteJson);
			
			reclamoDto.setCliente(clienteDto);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reclamoDto;
	}

	public ResponseReclamos guardarIncidente(ReclamoDto incidente)
			throws Exception, UnknownHostException {
		ResponseReclamos rs = new ResponseReclamos();
		try {
			MongoClient client = new MongoClient(uri);
			DB db = client.getDB(uri.getDatabase());
			DBCollection listaReclamos = db.getCollection("ListaReclamos");
			
			String incidenteString = "{\"codigo\": \"" + incidente.getCodigo()	+ "\"," 
					+ "\"tipoDocumento\":{ "
					+ "\"id\": \"" + incidente.getTipoDocumento().getId() + "\", "
					+ "\"nombre\": \"" + incidente.getTipoDocumento().getNombre() + "\" " 
					+ "}, "
					+ "\"numeroDocumento\": \""
					+ incidente.getNumeroDocumento() + "\","
					+ "\"fechaIncidente\": \""
					+ incidente.getFechaIncidente().getTime() + "\","
					+ "\"motivo\":{ "
					+ "\"id\": \"" + incidente.getMotivo().getId() + "\", "
					+ "\"nombre\": \"" + incidente.getMotivo().getNombre() + "\" " 
					+ "}, "
					+ "\"descripcionIncidente\":\""
					+ incidente.getDescripcion() + "\","
					+ "\"valorReparacion\":\""
					+ incidente.getValorReparacion().toString() + "\","
					+ "\"culpable\":\"" + incidente.getCulpable().toString()
					+ "\"," + "\"lugarIncidente\":\""
					+ incidente.getLugarIncidente() + "\"}";

			DBObject incidenteObject = (DBObject) JSON.parse(incidenteString);
			listaReclamos.insert(incidenteObject);
			rs.setEstado(true);
			rs.setMensaje("El registro se ha guardado exitosamente");
		} catch (Exception e) {
			rs.setEstado(false);
			rs.setMensaje("El registro no ha sido guardado.");
			throw e;
		}
		return rs;
	}

	public List<ReclamoDto> consultarListaReclamos() throws Exception {
		List<ReclamoDto> listaReclamosDto = new ArrayList<ReclamoDto>();
		MongoClient client;
		try {
			client = new MongoClient(uri);
			DB db = client.getDB(uri.getDatabase()); 
			DBCollection listaReclamos = db.getCollection("ListaReclamos");
			DBCursor cursor = listaReclamos.find();
			
		
			while(cursor.hasNext()){
				DBObject reclamoJson =cursor.next();
				
				ReclamoDto reclamoDto = new ReclamoDto();
				
				reclamoDto.convertJsonToDto(reclamoJson);
	
				listaReclamosDto.add(reclamoDto);
			
			}
		} catch (Exception e) {
			throw e;
		}
		return 	listaReclamosDto;
	}

}
