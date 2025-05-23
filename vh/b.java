package vh;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0018\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0014\u001a\u0004\b\r\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lvh/b;", "", "", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "groupId", "b", "f", "albumId", "c", "g", "batchId", "e", "j", "llocId", "", "Z", "()Z", h.F, "(Z)V", "fromArk", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String groupId = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String albumId = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String batchId = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String llocId = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean fromArk;

    /* renamed from: a, reason: from getter */
    public final String getAlbumId() {
        return this.albumId;
    }

    /* renamed from: b, reason: from getter */
    public final String getBatchId() {
        return this.batchId;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getFromArk() {
        return this.fromArk;
    }

    /* renamed from: d, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    /* renamed from: e, reason: from getter */
    public final String getLlocId() {
        return this.llocId;
    }

    public final void f(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumId = str;
    }

    public final void g(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.batchId = str;
    }

    public final void h(boolean z16) {
        this.fromArk = z16;
    }

    public final void i(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.groupId = str;
    }

    public final void j(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.llocId = str;
    }
}
