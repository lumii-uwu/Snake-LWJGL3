package moe.lumii.snake.render.vertex;

import moe.lumii.snake.Snake;

import java.util.Arrays;

/**
 * @author KitsuneAlex
 * thanks <3
 */
public class VertexFormat {
    private final Element[] elements;

    public VertexFormat(final Element... elements) {
        this.elements = elements;
    }

    public Element getElement(final int index) {
        if (index <= 0 || index >= elements.length) Snake.getLogger().error("This element isn't indexed!",
                new IndexOutOfBoundsException());
        return elements[index];
    }

    public int getSize() {
        return Arrays.stream(elements).mapToInt(Element::getSize).sum();
    }

    public static final class Element {
        //@formatter:off
        public static final Element
                POSITION_2F = new Element(DataType.FLOAT, (short) 2),
                POSITION_3F = new Element(DataType.FLOAT, (short) 3),
                 TEXTURE_2F = new Element(DataType.FLOAT, (short) 2),
                 TEXTURE_3F = new Element(DataType.FLOAT, (short) 3),
                LIGHTMAP_2F = new Element(DataType.FLOAT, (short) 2),
                  NORMAL_3F = new Element(DataType.FLOAT, (short) 3);
        //@formatter:on

        private final DataType dataType;
        private final short dimensions;

        public Element(final DataType dataType, final short dimensions) {
            this.dataType = dataType;
            this.dimensions = dimensions;
        }

        public int getSize() {
            return dataType.size * dimensions;
        }
    }

    public enum DataType {
        //@formatter:off
        SHORT(2),
        INT  (4),
        FLOAT(4);
        //@formatter:on

        public final int size;

        DataType(final int size) {
            this.size = size;
        }
    }
}
