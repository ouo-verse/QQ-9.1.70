package t64;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0002J\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0003\u00a8\u0006\t"}, d2 = {"Lt64/b;", "", "", "Ljava/io/File;", "b", "", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f435501a = new b();

    b() {
    }

    public final boolean a(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        if (file.exists()) {
            return true;
        }
        return file.mkdirs();
    }

    @NotNull
    public final File b(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new File(str);
    }
}
