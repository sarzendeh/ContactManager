package ir.asta.training.contacts.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import ir.asta.training.contacts.entities.ContactEntity;
import ir.asta.wise.core.datamanagement.ActionResult;

@Path("/contact")
public interface ContactService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/load/{pk}")
	public ContactEntity load(@PathParam("pk") Long id);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/search")
	public List<ContactEntity> search(@QueryParam("name") String name, @QueryParam("id") String id);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/findall")
	public List<ContactEntity> findAll();

	@POST
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ActionResult<Long> save(ContactEntity entity);

	@POST
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ActionResult<Long> update(ContactEntity entity);
}
