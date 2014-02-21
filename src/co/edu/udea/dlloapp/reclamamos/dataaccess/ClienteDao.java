package co.edu.udea.dlloapp.reclamamos.dataaccess;

import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bson.BSONObject;

import co.edu.udea.dlloapp.reclamamos.dto.ClienteDto;
import co.edu.udea.dlloapp.reclamamos.dto.PolizaDto;







import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.util.JSON;

/*
 * 
 * @autor Juan Pa Noreña
 * 
 * 
 * */

public class ClienteDao {
	

	ClienteDto ClienteDto= new ClienteDto();
	PolizaDto PolizaDto= new PolizaDto();
	MongoClientURI uri= new MongoClientURI("mongodb://appempresariales:udea2014@ds027759.mongolab.com:27759/heroku_app21361040");
	public ClienteDto consultarCliente(String tipoDocumento,String numeroDocumento) throws Exception, UnknownHostException{
	
		
		MongoClient client= new MongoClient(uri);
		DB db = client.getDB(uri.getDatabase()); 
		DBCollection Clientes=db.getCollection("Clientes");

		BasicDBObject query= new BasicDBObject();
		query.put("numeroDocumento", numeroDocumento);
	    DBCursor cursor= Clientes.find(query);
		DBObject cliente = cursor.next();
	    
	    ClienteDto.setTipoDocumento(cliente.get("tipoDocumento").toString());
	    ClienteDto.setNumeroDocumento(cliente.get("numeroDocumento").toString());
	    ClienteDto.setPrimerNombre(cliente.get("primerNombre").toString());
	    ClienteDto.setSegundoNombre(cliente.get("segundoNombre").toString());
	    ClienteDto.setPrimerApellido(cliente.get("primerApellido").toString());
	    ClienteDto.setSegundoApellido(cliente.get("segundoApellido").toString());
	    ClienteDto.setTipoCliente(cliente.get("tipoCliente").toString());
	    DBObject Poliza= (BasicDBObject) cliente.get("Poliza");
	    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		Date dateNacimiento = null;
		Date dateInicioPoliza = null;
		Date dateFinPoliza = null;
		
		try {
	
			dateNacimiento = formatter.parse(cliente.get("fechaNacimiento").toString());
			dateInicioPoliza = formatter.parse(Poliza.get("fechaInicioVigencia").toString());
			dateFinPoliza = formatter.parse(Poliza.get("fechaFinVigencia").toString());
	 
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    ClienteDto.setFechaNacimiento(dateNacimiento);
	    PolizaDto.setTipoVehiculo(Poliza.get("tipoVehiculo").toString());
	    PolizaDto.setReferencia(Poliza.get("referencia").toString());
	   
	    PolizaDto.setTipoVehiculo(Poliza.get("tipoVehiculo").toString());
	    PolizaDto.setReferencia(Poliza.get("referencia").toString());
	    PolizaDto.setNumeroPoliza(Poliza.get("numeroPoliza").toString());
	    PolizaDto.setFechaInicioVigencia(dateInicioPoliza);
	    PolizaDto.setFechaFinVigencia(dateFinPoliza);
	    ClienteDto.setPoliza(PolizaDto);
	   
	    
	    return ClienteDto;
		

	
	}
	
}
