package co.edu.udea.dlloapp.reclamamos.logic;

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
	 * Método que permite guardar la información de un incidente o reclamación
	 * 
	 * @author Cristian Correa
	 * @param reclamo Reclamo o incidente
	 * @return Estado del proceso. True si es correcto, False si no es correcto.
	 * @throws Exception
	 */
	Boolean guardarIncidente(ReclamoDto reclamo)throws Exception;

}
