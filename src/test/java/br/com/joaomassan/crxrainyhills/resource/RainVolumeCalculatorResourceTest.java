package br.com.joaomassan.crxrainyhills.resource;

import br.com.joaomassan.crxrainyhills.session.InvalidSurfaceException;
import br.com.joaomassan.crxrainyhills.session.RainVolumeService;
import java.util.Arrays;
import javax.ejb.EJBException;
import javax.json.JsonObject;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jaumzera
 */
public class RainVolumeCalculatorResourceTest {

    private RainVolumeCalculatorResource createMock() {
        return new RainVolumeCalculatorResource() {
            {
                this.rainVolumeService = new RainVolumeService();
            }
        };
    }

    private RainVolumeCalculatorResource createUnresolvedEJBMock() {
        return new RainVolumeCalculatorResource() {
            {
                this.rainVolumeService = new RainVolumeService() {

                    @Override
                    public int caculateTheRainVolume(int[] surfaceArray)
                            throws InvalidSurfaceException {

                        throw new EJBException("EJB problem");

                    }
                };
            }
        };
    }

    @Test(expected = AssertionError.class)
    public void shouldNotAcceptNullSurfaces() {
        createMock().calculateRainVolume(null);
    }

    @Test
    public void shouldReturnOk() {
        RainVolumeCalculatorResource resource = createMock();
        JsonObject result
                = resource.calculateRainVolume(
                        Arrays.asList(3, 4, 2, 1, 0, 3, 5));
        assertEquals("OK", result.getString("status"));
    }

    @Test
    public void shouldReturnNOK() {
        JsonObject result = 
                createUnresolvedEJBMock().calculateRainVolume(
                        Arrays.asList(1));
        assertEquals(result.getString("status"), "NOK");
    }

}
