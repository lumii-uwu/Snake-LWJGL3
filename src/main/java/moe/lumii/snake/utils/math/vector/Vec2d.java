package moe.lumii.snake.utils.math.vector;

public final class Vec2d {
    private final double x, y;

    public Vec2d(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Vec2d add(final double x, final double y) {
        return new Vec2d(this.x + x, this.y + y);
    }

    public Vec2d remove(final double x, final double y) {
        return new Vec2d(this.x - x, this.y - y);
    }

    public Vec2d multiply(final double x, final double y) {
        return new Vec2d(this.x * x, this.y * y);
    }

    public Vec2d divide(final double x, final double y) {
        return new Vec2d(this.x / x, this.y / y);
    }
}
