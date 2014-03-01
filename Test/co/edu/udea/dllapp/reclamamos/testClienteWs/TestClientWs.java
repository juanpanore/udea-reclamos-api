package co.edu.udea.dllapp.reclamamos.testClienteWs;



import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class TestClientWs {

	public static final String URI_RECLAMOS = "http://udea-reclamamos-api.herokuapp.com/rest/ReclamamosApiService/guardarIncidenteJson";

	@Test
	public void testGuardarReclamo() {
		Client client = Client.create();

		WebResource webResource = client.resource(URI_RECLAMOS);

		String input = "{"
				+ "\"tipoDocumento\":{ " 
				+ "\"id\": \"1\", "
				+ "\"nombre\": \"C.C.\" " 
				+ "}, "
				+ "\"numeroDocumento\":\"81028869\"," 
				+ "\"fechaIncidente\":\"2014-03-01T21:10:35.257-05:00\", "
				+ "\"motivo\":{ " 
				+ "\"id\": \"1\", "
				+ "\"nombre\": \"Choque\" " 
				+ "}, "
				+ "\"descripcion\": \"Descripci�n del choque\", "
				+ "\"valorReparacion\": \"300000.0\", "
				+ "\"culpable\": \"true\", "
				+ "\"lugarIncidente\": \"Envigado\" "
				+ "}";

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
