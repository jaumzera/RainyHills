package br.com.joaomassan.crxrainyhills;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jaumzera
 */
public class SurfaceTest {

    public SurfaceTest() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotCreateAnEmptySurface() {
        Surface.of(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotCalculateNullSurface() {
        Surface.of(null);
    }

    @Test
    public void shouldReturn0ForFlatSurfaces() {
        Assert.assertEquals(
                0, Surface.of(new int[]{0, 0, 0}).getVolume());
        
        Assert.assertEquals(
                0, Surface.of(new int[]{1, 1, 1}).getVolume());
        
        Assert.assertEquals(
                0, Surface.of(new int[]{2, 2, 2}).getVolume());
        
        Assert.assertEquals(
                0, Surface.of(new int[]{1}).getVolume());
    }

    @Test
    public void shouldCreateAnSurfaceAndCalculateVolume() {
        Assert.assertEquals(
                5, Surface.of(new int[]{4, 1, 2, 1, 3}).getVolume());

        Assert.assertEquals(
                5, Surface.of(new int[]{4, 1, 4, 0, 2}).getVolume());

        Assert.assertEquals(
                5, Surface.of(new int[]{3, 1, 2, 1, 4}).getVolume());

        Assert.assertEquals(
                4, Surface.of(new int[]{4, 1, 4, 2, 1, 2}).getVolume());

        Assert.assertEquals(
                3, Surface.of(new int[]{4, 1, 4}).getVolume());
    }
}
