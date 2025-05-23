package u64;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lu64/a;", "", "", "b", "", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setFILE_PATH", "(Ljava/lang/String;)V", "FILE_PATH", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f438505a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String FILE_PATH;

    static {
        FILE_PATH = "";
        FILE_PATH = MobileQQ.sMobileQQ.getCacheDir().getAbsolutePath() + "/babyQ/video/";
    }

    a() {
    }

    @JvmStatic
    public static final boolean b() {
        return true;
    }

    @NotNull
    public final String a() {
        return FILE_PATH;
    }
}
