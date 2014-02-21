package co.edu.udea.dllapp.reclamamos.testClienteWs;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class TestClientWs {

	public static final String URI_RECLAMOS = "http://localhost:8080/Api-Reclamamos-UdeA/webservices/ReclamamosApiService/guardarIncidenteJson";

	@Test
	public void testGuardarReclamo() {
		Client client = Client.create();

		WebResource webResource = client.resource(URI_RECLAMOS);

		String input = "{\"cliente\":{ "
				+ "\"fechaNacimiento\":\"2014-02-04T21:10:35.257-05:00\", "
				+ "\"numeroDocumento\":\"12345\", " + "\"poliza\": " + "{ "
				+ "\"fechaFinVigencia\":\"2014-02-04T21:10:35.257-05:00\", "
				+ "\"fechaInicioVigencia\":\"2014-02-04T21:10:35.257-05:00\", "
				+ "\"numeroPoliza\":\"234235\", "
				+ "\"referencia\":\"HER564\", "
				+ "\"tipoVehiculo\":\"Campero\" " + "}, "
				+ "\"primerApellido\":\"Perez\", "
				+ "\"primerNombre\":\"Pepito\", "
				+ "\"segundoApellido\":\"Zuleta\", "
				+ "\"segundoNombre\":\"P.\", "
				+ "\"tipoCliente\":\"Afiliado\", "
				+ "\"tipoDocumento\":\"CC\" " + "},"
				+ "\"fechaIncidente\":\"2014-02-04T21:10:35.257-05:00\", "
				+ "\"motivo\":{ " + "\"id\": \"1\", "
				+ "\"nombre\": \"Choque\" " + "}, "
				+ "\"descripcion\": \"Descripción del choque\", "
				+ "\"valorReparacion\": \"300000.0\", "
				+ "\"culpable\": \"true\", "
				+ "\"lugarIncidente\": \"Envigado\" " + "}";

		ClientResponse response = webResource.type("application/json").post(
				ClientResponse.class, input);

		if (response.getStatus() != 201) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

		System.out.println("Output from Server .... \n");
		String output = response.getEntity(String.class);
		System.out.println(output);
	}

}
