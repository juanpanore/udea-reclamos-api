
package co.edu.udea.dlloapp.reclamamos.logic;


import java.util.List;

import co.edu.udea.dlloapp.reclamamos.dto.ReclamoDto;
import co.edu.udea.dlloapp.reclamamos.dto.ResponseReclamos;

/**
 * Interface l�gica de negocios para las reclamaciones.
 * 
 * @author Cristian Correa
 *
 */
public interface IReclamacionLogic {

	/**
	 * M�todo que permite consultar un reclamo determinado
	 * 
	 * @author Cristian Correa
	 * @return Reclamo {@link ReclamoDto}
	 * @throws Exception
	 */
	ReclamoDto consultarDetalleReclamo(String codigo) throws Exception;

	/**
	 * M�todo que permite guardar la informaci�n de un incidente o reclamaci�n con un objeto reclamoDto
	 * 
	 * @author Cristian Correa
	 * @param reclamo Reclamo o incidente {@link ReclamoDto}
	 * @return Response de Reclamos donde almacena un estado y un mensaje {@link ResponseReclamos}
	 * @throws Exception
	 */
	ResponseReclamos guardarIncidenteJson(ReclamoDto reclamo)throws Exception;

	/**
	 * M�todo que permite consultar la lista de reclamos en general
	 * 
	 * @author Cristian Correa
	 * @return Lista de reclamos {@link ReclamoDto}
	 * @throws Exception
	 */
	List<ReclamoDto> consultarListaReclamos()throws Exception;
	
}
