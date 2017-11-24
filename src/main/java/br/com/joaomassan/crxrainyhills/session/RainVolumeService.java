package br.com.joaomassan.crxrainyhills.session;

import br.com.joaomassan.crxrainyhills.Surface;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * @author jaumzera
 */
@Stateless
public class RainVolumeService {

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public int caculateTheRainVolume(int[] surfaceArray) throws InvalidSurfaceException {
        try {

            return Surface.of(surfaceArray).getVolume();

        } catch (IllegalArgumentException ex) {
            throw new InvalidSurfaceException(ex);
        }
    }

}
