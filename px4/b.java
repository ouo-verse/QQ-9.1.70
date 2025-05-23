package px4;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b {
    public static Thread a(Runnable runnable, String str, int i3) {
        Thread thread = new Thread(runnable, str);
        thread.setPriority(i3);
        return thread;
    }
}
