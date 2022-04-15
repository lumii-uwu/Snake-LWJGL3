package moe.lumii.snake.utils;

import moe.lumii.snake.render.MeshBuilder;
import moe.lumii.snake.render.state.DefaultStates;
import moe.lumii.snake.render.vertex.DefaultVertexFormats;

import static org.lwjgl.opengl.GL11.*;

public final class RenderUtils {
    public static final class Rectangle {
        public static void fill(final float x, final float y, final float x1, final float y1, final int color) {
            final float[] rgba = ColorUtils.rgba(color);
        }

        public static void border(final float x, final float y, final float x1, final float y1, final int color) {
            final MeshBuilder mesher = MeshBuilder.get();
            mesher.begin(GL_LINE_LOOP, DefaultVertexFormats.POSITION_COLOR.getVertexFormat(), DefaultStates.FANCY.getState());
            mesher.vertexTwoD.vertex(x, y1).color(color).end();
            mesher.vertexTwoD.vertex(x1, y1).color(color).end();
            mesher.vertexTwoD.vertex(x1, y).color(color).end();
            mesher.vertexTwoD.vertex(x, y).color(color).end();
            mesher.end();
        }
    }
}
