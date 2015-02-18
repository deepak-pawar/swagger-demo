package deepu.example;

import java.io.IOException;

import org.restlet.Context;
import org.restlet.ext.apispark.internal.conversion.swagger.v1_2.model.ApiDeclaration;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.ext.swagger.SwaggerSpecificationRestlet;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class DemoResource extends SwaggerSpecificationRestlet {

	String name = "Demo Example";
	
	/*@Get
	public String getName()
	{
		return name;
	}*/
	
	public DemoResource(Context context) {
        super(context);
    }

    @Override
    public Representation getApiDeclaration(String category) {
        try {
            ApiDeclaration apiDeclaration = new JacksonRepresentation<ApiDeclaration>(
                    super.getApiDeclaration(category), ApiDeclaration.class)
                    .getObject();
            // manipulate the API declaration object as you wish
            apiDeclaration.setBasePath("demo");
            return new JacksonRepresentation<ApiDeclaration>(apiDeclaration);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
