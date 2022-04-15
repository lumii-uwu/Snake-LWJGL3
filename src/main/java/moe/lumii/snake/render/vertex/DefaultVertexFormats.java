package moe.lumii.snake.render.vertex;

public enum DefaultVertexFormats {
    POSITION(new VertexFormat()),
    POSITION_COLOR(new VertexFormat()),
    POSITION_TEXTURE(new VertexFormat()),
    POSITION_TEXTURE_COLOR(new VertexFormat());

    private final VertexFormat vertexFormat;

    DefaultVertexFormats(final VertexFormat vertexFormat) {
        this.vertexFormat = vertexFormat;
    }

    public VertexFormat getVertexFormat() {
        return vertexFormat;
    }
}
