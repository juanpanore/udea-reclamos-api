package co.edu.udea.dlloapp.reclamamos.dataaccess;

import java.net.UnknownHostException;

import co.edu.udea.dlloapp.reclamamos.dto.ClienteDto;
import co.edu.udea.dlloapp.reclamamos.dto.TipoDocumentoDto;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/*
 * 
 * @autor Juan Pa Noreña
 * 
 * 
 * */

public class ClienteDao {

	MongoClientURI uri = new MongoClientURI(
			"mongodb://appempresariales:udea2014@ds027759.mongolab.com:27759/heroku_app21361040");

	public ClienteDto consultarCliente(Integer idTipoDocumento,
			String numeroDocumento) throws Exception, UnknownHostException {

		try {
			MongoClient client = new MongoClient(uri);
			DB db = client.getDB(uri.getDatabase());
			
			DBCollection tiposDocumentos = db.getCollection("TipoDocumento");
			BasicDBObject queryTipoDocumento = new BasicDBObject();
			queryTipoDocumento.put("id", idTipoDocumento);
			DBCursor cursorTiposDocumentos = tiposDocumentos.find(queryTipoDocumento);
			DBObject tipoDocumentoJson = cursorTiposDocumentos.next();

			TipoDocumentoDto tipoDto = new TipoDocumentoDto();
			tipoDto.setId(Integer.parseInt(tipoDocumentoJson.get("id").toString()));
			tipoDto.setNombre(tipoDocumentoJson.get("nombre").toString());
			
			DBCollection Clientes = db.getCollection("Clientes");
			BasicDBObject query = new BasicDBObject();
			query.put("tipoDocumento", tipoDto);
			query.put("numeroDocumento", numeroDocumento);
			DBCursor cursor = Clientes.find(query);
			DBObject clienteJson = cursor.next();

			ClienteDto clienteDto = new ClienteDto();

			clienteDto.convertJsonToDto(clienteJson);

			return clienteDto;
		} catch (Exception e) {
			throw e;
		}
	}

}
