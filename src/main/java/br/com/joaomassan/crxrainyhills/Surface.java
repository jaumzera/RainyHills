package br.com.joaomassan.crxrainyhills;

import lombok.EqualsAndHashCode;

/**
 *
 * @author jaumzera
 */
@EqualsAndHashCode(of = "surface")
public class Surface {

    private static final int MIN_SURFACE_LENGTH = 3;

    public static Surface of(int[] surface) {
        return new Surface(surface);
    }

    private int[] surface;

    private Integer volume;

    private Surface(int[] surface) {
        if (surface == null) {
            throw new IllegalArgumentException("Surface array can't be null.");
        }

        this.surface = surface;

        if (surface.length == 0) {
            this.volume = 0;
        }
    }

    private int calculateVolume() {

        if (surface.length < MIN_SURFACE_LENGTH) {
            return 0;
        }

        int[] maxRight = new int[surface.length];
        int maxLeft = 0;
        int max = 0;
        int water = 0;

        for (int i = surface.length - 1; i >= 0; i--) {
            if (surface[i] > max) {
                max = surface[i];
                maxRight[i] = max;
            } else {
                maxRight[i] = max;
            }
        }

        for (int i = 0; i < surface.length; i++) {
            water += Integer.max(
                    Integer.min(maxLeft, maxRight[i]) - surface[i], 0);

            if (surface[i] > maxLeft) {
                maxLeft = surface[i];
            }
        }

        return water;
    }

    public int getVolume() {
        if (this.volume == null) {
            this.volume = calculateVolume();
        }

        return this.volume;
    }
}
