
package co.edu.udea.dlloapp.reclamamos.logic;

import java.util.Date;
import java.util.List;

import co.edu.udea.dlloapp.reclamamos.dto.ReclamoDto;

/**
 * Interface lógica de negocios para las reclamaciones.
 * 
 * @author Cristian Correa
 *
 */
public interface IReclamacionLogic {

	/**
	 * Método que permite conslutar la lista de reclamos en general.
	 * 
	 * @author Cristian Correa
	 * @return Lista Reclamos Dto
	 * @throws Exception
	 */
	List<ReclamoDto> consultarListaReclamos() throws Exception;

	/**
	 * Método que permite guardar la información de un incidente o reclamación con un objeto reclamoDto
	 * 
	 * @author Cristian Correa
	 * @param reclamo Reclamo o incidente
	 * @return Estado del proceso. True si es correcto, False si no es correcto.
	 * @throws Exception
	 */
	Boolean guardarIncidenteJson(ReclamoDto reclamo)throws Exception;

	/**
	 * Método que permite guardar la información de un incidente o reclamación recibiendo los parámetros.
	 * 
	 * @param numeroDocumento
	 * @param tipoDocumento 
	 * @param fechaIncedente
	 * @param motivoIncidente
	 * @param descripcionIncidente
	 * @param valorReparacion
	 * @param culpable
	 * @param lugarIncidente
	 * @return
	 * @throws Exception
	 */
	Boolean guardarIncidente(String tipoDocumento, String numeroDocumento, Date fechaIncedente,
			String motivoIncidente, String descripcionIncidente,
			Double valorReparacion, Boolean culpable, String lugarIncidente)throws Exception;

}
