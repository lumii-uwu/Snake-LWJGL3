package moe.lumii.snake.render;

import moe.lumii.snake.Snake;
import moe.lumii.snake.render.state.State;
import moe.lumii.snake.render.vertex.VertexFormat;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;

public final class MeshBuilder {
    private static final ThreadLocal<MeshBuilder> MESH_BUILDER = ThreadLocal.withInitial(MeshBuilder::new);

    private int drawMode;
    private VertexFormat vertexFormat;
    private boolean isDrawing = false;

    private final ByteBuffer buffer = ByteBuffer.allocateDirect(200000).order(ByteOrder.nativeOrder());

    public final Vertex2D vertexTwoD = new Vertex2D();
    public final Vertex3D vertexThreeD = new Vertex3D();

    private boolean isThreeD() {
        return false;
    }

    public MeshBuilder begin(final int drawMode, final VertexFormat vertexFormat, final State state) {
        if (this.isDrawing) Snake.getLogger().error("Rendering already!", new IllegalStateException());
        this.drawMode = drawMode;
        this.vertexFormat = vertexFormat;
        this.isDrawing = true;
        return this;
    }

    public void end() {
        if (!this.isDrawing) Snake.getLogger().error("Not rendering!", new IllegalStateException());
        glBegin(drawMode);
        glEnd();
        this.isDrawing = false;
    }

    public static MeshBuilder get() {
        return MESH_BUILDER.get();
    }

    public static final class Vertex2D {
        float x, y;
        float texU, texV;
        float lightU, lightV;
        int color = -1;
        float[] rgbaColor = new float[4];

        public Vertex2D texture(final float u, final float v) {
            texU = u;
            texV = v;
            return this;
        }

        public Vertex2D lightmap(final float u, final float v) {
            lightU = u;
            lightV = v;
            return this;
        }

        public Vertex2D vertex(final float x, final float y) {
            this.x = x;
            this.y = y;
            return this;
        }

        public Vertex2D color(float r, float g, float b, float a) {
            this.rgbaColor[0] = r = Math.max(0, Math.min(r, 1));
            this.rgbaColor[1] = g = Math.max(0, Math.min(g, 1));
            this.rgbaColor[2] = b = Math.max(0, Math.min(b, 1));
            this.rgbaColor[3] = a = Math.max(0, Math.min(a, 1));
            this.color = (((int) (a * 255) & 0xFF) << 24) | // shifting with offset 24
                    (((int) (r * 255) & 0xFF) << 16) | // shifting with offset 16
                    (((int) (g * 255) & 0xFF) << 8) | // shifting with offset 8
                    (((int) (b * 255) & 0xFF));  // shifting with no offset
            return this;
        }

        public Vertex2D color(final int color) {
            this.color = color;
            this.rgbaColor = new float[]{
                    ((color >> 16) & 0xff) / 255f,
                    ((color >> 8) & 0xff) / 255f,
                    ((color) & 0xff) / 255f,
                    ((color >> 24) & 0xff) / 255f
            };
            return this;
        }

        public MeshBuilder builder() {
            return MeshBuilder.get();
        }

        //@formatter:off todo...
        public void end() {}
        //@formatter:on
    }

    public static final class Vertex3D {
        float x, y, z;
        float texU, texV;
        float normalsX, normalsY, normalsZ;
        float lightU, lightV;

        int color = -1;
        float[] rgbaColor = new float[4];

        public Vertex3D texture(final float u, final float v) {
            this.texU = u;
            this.texV = v;
            return this;
        }

        public Vertex3D normals(final float x, final float y, final float z) {
            this.normalsX = x;
            this.normalsY = y;
            this.normalsZ = z;
            return this;
        }

        public Vertex3D lightmap(final float u, final float v) {
            this.lightU = u;
            this.lightV = v;
            return this;
        }

        public Vertex3D vertex(final float x, final float y, final float z) {
            this.x = x;
            this.y = y;
            this.z = z;
            return this;
        }

        public Vertex3D color(float r, float g, float b, float a) {
            rgbaColor[0] = r = Math.max(0, Math.min(r, 1));
            rgbaColor[1] = g = Math.max(0, Math.min(g, 1));
            rgbaColor[2] = b = Math.max(0, Math.min(b, 1));
            rgbaColor[3] = a = Math.max(0, Math.min(a, 1));
            this.color = (((int) (a * 255) & 0xFF) << 24) | // shifting with offset 24
                    (((int) (r * 255) & 0xFF) << 16) | // shifting with offset 16
                    (((int) (g * 255) & 0xFF) << 8) | // shifting with offset 8
                    (((int) (b * 255) & 0xFF));  // shifting with no offset
            return this;
        }

        public Vertex3D color(final int color) {
            this.color = color;
            this.rgbaColor = new float[]{
                    ((color >> 16) & 0xff) / 255f,
                    ((color >> 8) & 0xff) / 255f,
                    ((color) & 0xff) / 255f,
                    ((color >> 24) & 0xff) / 255f
            };
            return this;
        }

        public MeshBuilder builder() {
            return MeshBuilder.get();
        }

        //@formatter:off todo...
        public void end() {}
        //@formatter:on
    }
}
