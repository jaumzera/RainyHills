package br.com.joaomassan.crxrainyhills.session;

import javax.ejb.EJB;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author jaumzera
 */
@RunWith(Arquillian.class)
public class RainVolumeServiceTest {
    
    @EJB
    private RainVolumeService rainVolumeService;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar")
                .addClasses(RainVolumeService.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void shouldCalculateTheRainVolume() throws Exception {
        int[] test1 = new int[]{4, 1, 2, 1, 3};
        assertEquals(5, rainVolumeService.caculateTheRainVolume(test1));

        int[] test2 = new int[]{4, 1, 4, 0, 2};
        assertEquals(5, rainVolumeService.caculateTheRainVolume(test2));
    }

    @Test
    public void shouldThrowAnInvalidSurfaceException() {
        RainVolumeService rvs = new RainVolumeService();
        try {
            rvs.caculateTheRainVolume(null);
            Assert.assertTrue(false);
        } catch (InvalidSurfaceException ex) {
            Assert.assertTrue(ex instanceof InvalidSurfaceException);
        }
    }
}
