package co.edu.udea.dlloapp.reclamamos.dataaccess;


/*
 * 
 * @autor Juan Pa Noreña
 * 
 * 
 * */

import java.rmi.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.edu.udea.dlloapp.reclamamos.dto.ClienteDto;
import co.edu.udea.dlloapp.reclamamos.dto.MotivoDto;
import co.edu.udea.dlloapp.reclamamos.dto.PolizaDto;
import co.edu.udea.dlloapp.reclamamos.dto.ReclamoDto;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.util.JSON;




public class ReclamacionDao {
	
	private List<ReclamoDto> listaReclamos=new ArrayList<ReclamoDto>();
	
	
	
	
	MongoClientURI uri= new MongoClientURI("mongodb://appempresariales:udea2014@ds027759.mongolab.com:27759/heroku_app21361040");
	
	public List<ReclamoDto> consultarListaReclamos() throws Exception,UnknownHostException{
		
		MongoClient client= new MongoClient(uri);
		DB db = client.getDB(uri.getDatabase()); 
		
		DBCollection Clientes =db.getCollection("Clientes");
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		DBCursor cursor = Clientes.find();
	
		
		while(cursor.hasNext()){
			DBObject Cliente= cursor.next();
			ClienteDto cliente =new ClienteDto();
			ReclamoDto reclamo =new ReclamoDto();
			
			try {
				 cliente.setTipoDocumento(Cliente.get("tipoDocumento").toString());
				 cliente.setNumeroDocumento(Cliente.get("numeroDocumento").toString());
				 cliente.setPrimerNombre(Cliente.get("primerNombre").toString());
				 cliente.setSegundoNombre(Cliente.get("segundoNombre").toString());
				 cliente.setPrimerApellido(Cliente.get("primerApellido").toString());
				 cliente.setSegundoApellido(Cliente.get("segundoApellido").toString());
				 cliente.setTipoCliente(Cliente.get("tipoCliente").toString());
				
				 DBObject Poliza= (BasicDBObject) Cliente.get("Poliza");
				 PolizaDto poliza=new PolizaDto();
				 poliza.setTipoVehiculo(Poliza.get("tipoVehiculo").toString());
				 poliza.setReferencia(Poliza.get("referencia").toString());
				 poliza.setNumeroPoliza(Poliza.get("numeroPoliza").toString());
				 poliza.setFechaInicioVigencia(formatter.parse(Poliza.get("fechaInicioVigencia").toString()));
				 poliza.setFechaFinVigencia(formatter.parse(Poliza.get("fechaFinVigencia").toString()));
				 cliente.setPoliza(poliza);
				 if(Cliente.get("Incidente")!=null){
					 DBObject Reclamo= (BasicDBObject) Cliente.get("Incidente");
					 boolean Culpable =false;
					 if (Reclamo.get("culpable").toString().equals("Si")){
						 Culpable =true;
					 }
					
					
					 reclamo.setCulpable(Culpable);
					 reclamo.setDescripcion(Reclamo.get("motivoIncidente").toString());
					 reclamo.setFechaIncidente(formatter.parse(Reclamo.get("fechaIncidente").toString()));
					 reclamo.setLugarIncidente(Reclamo.get("lugarIncidente").toString());
					reclamo.setValorReparacion((Double)Reclamo.get("valorReparacion"));
					 MotivoDto motivo = new MotivoDto();
					 motivo.setNombre(Reclamo.get("motivoIncidente").toString());
					 reclamo.setMotivo(motivo);
				
				
					
				
					 
				 }	 
			} catch (ParseException e) {
				e.printStackTrace();
			}
			reclamo.setCliente(cliente);
			listaReclamos.add(reclamo);
			
		}
	
		
		return listaReclamos; 
	}

	public Boolean guardarIncidente(ReclamoDto incidente ) throws Exception , UnknownHostException{
		Boolean estado=false;
		try{
		MongoClient client= new MongoClient(uri);
		DB db = client.getDB(uri.getDatabase()); 
		DBCollection Clientes =db.getCollection("Clientes");
		BasicDBObject documento= new BasicDBObject();
		documento.put("numeroDocumento", incidente.getCliente().getNumeroDocumento());
		DBCursor cursor = Clientes.find(documento);
		
		String incidenteString="'Incidente':{'fechaIncidente':'"+incidente.getFechaIncidente()+"','motivoIncidente':'"+incidente.getMotivo()
				+"','descripcionIncidente':'"+incidente.getDescripcion()+"','valorReparacion':'"+incidente.getValorReparacion()
				+"','culpable':'"+incidente.getCulpable()+"','lugarIncidente':'"+incidente.getLugarIncidente()+"'}";
		DBObject incidenteObject= (DBObject) JSON.parse(incidenteString);
		cursor.getCollection().insert(incidenteObject);
		estado=true;
		}catch(Exception e){
			
			estado=false;
		}
		return estado;
		
	}

}
