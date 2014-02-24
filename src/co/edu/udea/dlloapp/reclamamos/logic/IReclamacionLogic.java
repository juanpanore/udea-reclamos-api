
package co.edu.udea.dlloapp.reclamamos.logic;

import java.util.Date;
import java.util.List;

import co.edu.udea.dlloapp.reclamamos.dto.ReclamoDto;
import co.edu.udea.dlloapp.reclamamos.dto.ResponseReclamos;

/**
 * Interface lógica de negocios para las reclamaciones.
 * 
 * @author Cristian Correa
 *
 */
public interface IReclamacionLogic {

	/**
	 * Método que permite consultar un reclamo determinado
	 * 
	 * @author Cristian Correa
	 * @return Reclamo {@link ReclamoDto}
	 * @throws Exception
	 */
	ReclamoDto consultarDetalleReclamo(String codigo) throws Exception;

	/**
	 * Método que permite guardar la información de un incidente o reclamación con un objeto reclamoDto
	 * 
	 * @author Cristian Correa
	 * @param reclamo Reclamo o incidente {@link ReclamoDto}
	 * @return Response de Reclamos donde almacena un estado y un mensaje {@link ResponseReclamos}
	 * @throws Exception
	 */
	ResponseReclamos guardarIncidenteJson(ReclamoDto reclamo)throws Exception;

	/**
	 * Método que permite consultar la lista de reclamos en general
	 * 
	 * @author Cristian Correa
	 * @return Lista de reclamos {@link ReclamoDto}
	 * @throws Exception
	 */
	List<ReclamoDto> consultarListaReclamos()throws Exception;
	
}
