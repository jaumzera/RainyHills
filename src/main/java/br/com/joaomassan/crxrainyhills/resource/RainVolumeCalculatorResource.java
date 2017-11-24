package br.com.joaomassan.crxrainyhills.resource;

import br.com.joaomassan.crxrainyhills.session.RainVolumeService;
import br.com.joaomassan.crxrainyhills.session.InvalidSurfaceException;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jaumzera
 */
@Path("/rain")
@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class RainVolumeCalculatorResource {

    @Inject
    protected RainVolumeService rainVolumeService;

    @GET
    @Path("volume")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject calculateRainVolume(
            @QueryParam("surface") List<Integer> surfaceValues) {

        assert (surfaceValues != null) : "Surfaces must not be null";

        JsonObject returnValue;

        try {
            returnValue = Json.createObjectBuilder()
                    .add("status", "OK")
                    .add("rainVolume",
                            rainVolumeService.caculateTheRainVolume(
                                    surfaceValues.stream()
                                            .mapToInt((value) -> {
                                                return value != null
                                                        ? value.intValue()
                                                        : 0;
                                            }).toArray())
                    ).build();
        } catch (InvalidSurfaceException | EJBException ex) {
            returnValue = Json.createObjectBuilder()
                    .add("status", "NOK")
                    .add("error", ex.getMessage())
                    .build();
        }

        return returnValue;
    }
}
