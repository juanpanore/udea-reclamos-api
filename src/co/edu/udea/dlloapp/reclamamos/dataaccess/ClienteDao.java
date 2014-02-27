package co.edu.udea.dlloapp.reclamamos.dataaccess;


import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import co.edu.udea.dlloapp.reclamamos.dto.ClienteDto;


import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/*
 * 
 * @autor Juan Pa Nore�a
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
			

			
			DBCollection Clientes = db.getCollection("Clientes");
			BasicDBObject andQuery= new BasicDBObject();
			List<BasicDBObject> query = new ArrayList<BasicDBObject>();
			query.add(new BasicDBObject("tipoDocumento.id", idTipoDocumento.toString()));
			query.add(new BasicDBObject("numeroDocumento", numeroDocumento));
			andQuery.put("$and", query);
			DBCursor cursor = Clientes.find(andQuery);
			DBObject clienteJson = cursor.next();

			ClienteDto clienteDto = new ClienteDto();
		

			clienteDto.convertJsonToDto(clienteJson);

			return clienteDto;
		} catch (Exception e) {
			throw e;
		}
	}

}
