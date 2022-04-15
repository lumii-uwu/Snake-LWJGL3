package moe.lumii.snake.utils;

public final class ColorUtils {
    public static float[] rgba(final int color) {
        return new float[]{((color >> 16) & 0xff) / 255f, ((color >> 8) & 0xff) / 255f, ((color) & 0xff) / 255f,
                ((color >> 24) & 0xff) / 255f};
    }

    public static int toDez(final float r, final float g, final float b, final float a) {
        return (((int) (a * 255) & 0xFF) << 24) |
                (((int) (r * 255) & 0xFF) << 16) |
                (((int) (g * 255) & 0xFF) << 8) |
                (((int) (b * 255) & 0xFF));
    }

    public static int toDez(final float[] rgba) {
        return toDez(rgba[0], rgba[1], rgba[2], rgba[3]);
    }
}
