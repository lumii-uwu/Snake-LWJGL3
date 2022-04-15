package moe.lumii.snake.render.state;

public enum DefaultStates {
    FANCY(null),
    FAST(null);

    private final State state;

    DefaultStates(final State state) {
        this.state = state;
    }

    public final State getState() {
        return state;
    }
}
