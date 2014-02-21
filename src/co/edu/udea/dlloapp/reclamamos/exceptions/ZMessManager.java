package co.edu.udea.dlloapp.reclamamos.exceptions;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura/ support
 *         Andrés Mauricio Cárdenas mauriciocardenasp@gmail.com
 */
public class ZMessManager extends Exception {
	private static final long serialVersionUID = 1L;

	public final static String ALL = "All ";
	public final static String ENTCHILD = "related tables(childs)";
	public final static String FOREIGNDATA = "foreign classes data: ";
	public static String ENTITY_SUCCESFULLYSAVED = "¡El registro se ha guardado con éxito!";
	public static String ENTITY_SUCCESFULLYDELETED = "¡El registro se ha borrado con éxito!";
	public static String ENTITY_SUCCESFULLYMODIFIED = "¡El registro se ha modificado con éxito!";
	public static String ENTITY_WITHSAMEKEY = "El registro ya existe.";
	public static String ENTITY_WITHSAMENAME = "Existe otro registro con el mismo nombre.";
	public static String ENTITY_NOENTITYTOUPDATE = "No Entity was found, with the typed key ";
	public static String DATANOFOUND = "Registro no encontrado";
	public static String DATAREQUIERED = "Debe ingresar el dato que desea buscar";
	public static String EMAIL_INVALID = "El Email es invalido";
	public static String WITHSAMEPRIORITY = "La prioridad se encuentra repetida";
	public static String WITHSAMEPRIORITYIGUAL0 = "La prioridad a ingresar debe de ser mayor a cero (0) o (0.01)";
	public static String WITHSAMENOMBREEXISTENTE = "La Especie agregada ya es existente";
	public static String USERNOFOUND = "El Nombre de Usuario ingresado no existe. Por favor Verifique.";
	public static String PASSNOMATCH = "La Contraseña no coincide con el Nombre de Usuario. Por favor verifique.";
	public static String ENTITY_WITHSAMEEMAIL = "Existe otro registro con el mismo email.";
	public static String ENTITY_CANTIDADIGUAL0 = "La Cantidad ingresada debe de ser mayor a (0).";
	public static String USERNULL = "El campo Nombre de Usuario es nulo o vacio. Por favor verifique.";
	public static String PASSNULL = "El campo Contraseña es nulo o vacio. Por favor verifique.";

	public ZMessManager() {
	}

	public ZMessManager(String exception) {
		super(exception);
	}

	public class NotValidFieldException extends ZMessManager {
		private static final long serialVersionUID = 1L;

		public NotValidFieldException(String info) {
			super("El valor para el campo: \"" + info + "\" no es válido");
		}
	}

	public class EmptyFieldException extends ZMessManager {
		private static final long serialVersionUID = 1L;

		public EmptyFieldException(String info) {
			super("El valor para el campo: \"" + info + "\" es nulo o vacío");
		}
	}

	public class NotValidFormatException extends ZMessManager {
		private static final long serialVersionUID = 1L;

		public NotValidFormatException(String info) {
			super("El formato o longitud para el campo: \"" + info
					+ "\" no es válido");
		}
	}

	public class DeletingException extends ZMessManager {
		private static final long serialVersionUID = 1L;

		public DeletingException(String info) {
			super("El registro que está tratando de eliminar "
					+ "puede tener información relacionada, "
					+ "compruebe la información de \"" + info + "\" que posee.");
		}
	}

	public class ForeignException extends ZMessManager {
		private static final long serialVersionUID = 1L;

		public ForeignException(String info) {
			super("No se encontró una relación registrada con \"" + info + "\"");
		}
	}

	public class GettingException extends ZMessManager {
		private static final long serialVersionUID = 1L;

		public GettingException(String info) {
			super("Ha ocurrido un error " + info
					+ ". Verifique o comuníquese con soporte técnico.");
		}
	}

	public class FindingException extends ZMessManager {
		private static final long serialVersionUID = 1L;

		public FindingException(String info) {
			super("No se encontraron registros de " + info);
		}
	}

}
