package deepu.example;

import org.restlet.Restlet;
import org.restlet.ext.swagger.SwaggerApplication;
import org.restlet.routing.Router;

public class DemoApplication extends SwaggerApplication {

	public Restlet createInboundRoot() {
        // Router for the API's resources
        /*Router apiRouter = new Router(getContext());
        attachSwaggerSpecificationRestlet(apiRouter, "/docs");
        apiRouter.attach("register", DemoResource.class);
        return apiRouter;*/
		
		Router baseRouter = new Router(getContext());
		DemoResource demoRestlet = new DemoResource(
                getContext());
		demoRestlet.setApiInboundRoot(this);
        attachSwaggerDocumentationRestlets(baseRouter, "/api-docs",
        		demoRestlet, "/api-docs/demo", demoRestlet);
        return baseRouter;
    }
}
