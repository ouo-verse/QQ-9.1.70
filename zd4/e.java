package zd4;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lzd4/e;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "renderAssetDir", "", "b", "I", "()I", "d", "(I)V", "renderType", "<init>", "()V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int renderType;

    /* renamed from: c, reason: collision with root package name */
    public static final e f452395c = new e();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String renderAssetDir = "";

    e() {
    }

    @NotNull
    public final String a() {
        return renderAssetDir;
    }

    public final int b() {
        return renderType;
    }

    public final void c(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        renderAssetDir = str;
    }

    public final void d(int i3) {
        renderType = i3;
    }
}
