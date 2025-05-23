package rx.internal.util.unsafe;

/* compiled from: P */
/* loaded from: classes29.dex */
abstract class SpscArrayQueueColdField<E> extends ConcurrentCircularArrayQueue<E> {
    private static final Integer MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    protected final int lookAheadStep;

    public SpscArrayQueueColdField(int i3) {
        super(i3);
        this.lookAheadStep = Math.min(i3 / 4, MAX_LOOK_AHEAD_STEP.intValue());
    }
}
