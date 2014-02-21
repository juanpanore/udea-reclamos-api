package co.edu.udea.dlloapp.reclamamos.logic;

import java.util.List;

import co.edu.udea.dlloapp.reclamamos.dto.MotivoDto;
import co.edu.udea.dlloapp.reclamamos.dto.TipoDocumentoDto;

/**
 * Interface de la l�gica de negocio para los maestros.
 * 
 * @author Cristian Correa
 *
 */
public interface IMaestrosLogic {

	/**
	 * M�todo que permite consultar la lista de motivos de incidentes.
	 * 
	 * @author Cristian Correa
	 * @return Lista Motivos Dto
	 * @throws Exception
	 */
	List<MotivoDto> consultarListaMotivos()throws Exception;

	/**
	 * M�todo que permite conslutar la lista de tipos de documentos.
	 * 
	 * @author Cristian Correa
	 * @return Lista Tipos Documentos Dto
	 * @throws Exception
	 */
	List<TipoDocumentoDto> consultarTiposDocumentos()throws Exception;

}
