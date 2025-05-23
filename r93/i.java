package r93;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\t"}, d2 = {"Lr93/i;", "", "", "abTestName", "mmkvCacheKey", "", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f430994a = new i();

    i() {
    }

    public static /* synthetic */ boolean b(i iVar, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        return iVar.a(str, str2);
    }

    public final boolean a(@NotNull String abTestName, @Nullable String mmkvCacheKey) {
        Intrinsics.checkNotNullParameter(abTestName, "abTestName");
        com.tencent.mobileqq.wink.editor.util.h hVar = com.tencent.mobileqq.wink.editor.util.h.f322638a;
        return com.tencent.mobileqq.wink.editor.util.h.k(hVar, abTestName, hVar.a(abTestName), true, false, 8, null);
    }
}
