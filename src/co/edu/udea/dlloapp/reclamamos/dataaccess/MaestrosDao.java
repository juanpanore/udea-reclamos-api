package co.edu.udea.dlloapp.reclamamos.dataaccess;

 /*
  * 
  * @autor Juan Pa Nore�a
  * 
  * 
  * */
import java.rmi.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import co.edu.udea.dlloapp.reclamamos.dto.MotivoDto;
import co.edu.udea.dlloapp.reclamamos.dto.TipoDocumentoDto;

public class MaestrosDao {
	

	List<MotivoDto> Motivos = new ArrayList<MotivoDto>();
	
	List<TipoDocumentoDto> TipoDocumentos = new ArrayList<TipoDocumentoDto>();
	
	MongoClientURI uri= new MongoClientURI("mongodb://appempresariales:udea2014@ds027759.mongolab.com:27759/heroku_app21361040");
    

	public List<MotivoDto>  consultarListaMotivos() throws Exception, UnknownHostException {
		MongoClient client= new MongoClient(uri);
		DB db = client.getDB(uri.getDatabase()); 
		DBCollection motivos =db.getCollection("ListaMotivos");
		DBCursor cursor = motivos.find();
		
	
		while(cursor.hasNext()){
			DBObject motivo =cursor.next();
			MotivoDto Motivo=new MotivoDto() ;
			Motivo.setId((Integer)motivo.get("id"));
			Motivo.setNombre(motivo.get("nombre").toString());
			Motivos.add(Motivo);
		
		}
		return Motivos;
	
	}

	public List<TipoDocumentoDto> consultarTiposDocumentos() throws Exception,UnknownHostException {
		
		MongoClient client= new MongoClient(uri);
		DB db = client.getDB(uri.getDatabase()); 
		DBCollection tipoDocumentos =db.getCollection("TipoDocumento");
		DBCursor cursor = tipoDocumentos.find();
		
		while(cursor.hasNext()){
			DBObject Documento =cursor.next();
			TipoDocumentoDto DocumentoDto= new TipoDocumentoDto();
			DocumentoDto.setId((Integer)Documento.get("id"));
			DocumentoDto.setNombre(Documento.get("nombre").toString());
			TipoDocumentos.add(DocumentoDto);
	
		}	
		return TipoDocumentos;

	}
}
