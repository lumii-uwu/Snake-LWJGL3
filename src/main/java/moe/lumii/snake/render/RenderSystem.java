package moe.lumii.snake.render;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;

public final class RenderSystem {
    public static final class RenderCall {
        private static final ConcurrentLinkedDeque<Runnable> RENDER_CALLS = new ConcurrentLinkedDeque<>();

        public static void recordRenderCall(final Runnable runnable) {
            RENDER_CALLS.addFirst(runnable);
        }

        public static void dispatchRenderCalls() {
            final Iterator<Runnable> runnableIterator = RENDER_CALLS.iterator();
            while (runnableIterator.hasNext()) {
                runnableIterator.next().run();
                runnableIterator.remove();
            }
        }
    }
}
