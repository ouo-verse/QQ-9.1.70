package zp2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0015\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\r\u0010\u0010\"\u0004\b\u0014\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lzp2/b;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "leftContent", "b", "f", "tipContent", "", "c", "I", "d", "()I", h.F, "(I)V", "tipTvVisible", "g", "tipLayoutVisible", "<init>", "()V", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String leftContent = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String tipContent = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int tipTvVisible = 8;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int tipLayoutVisible = 8;

    /* renamed from: a, reason: from getter */
    public final String getLeftContent() {
        return this.leftContent;
    }

    /* renamed from: b, reason: from getter */
    public final String getTipContent() {
        return this.tipContent;
    }

    /* renamed from: c, reason: from getter */
    public final int getTipLayoutVisible() {
        return this.tipLayoutVisible;
    }

    /* renamed from: d, reason: from getter */
    public final int getTipTvVisible() {
        return this.tipTvVisible;
    }

    public final void e(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.leftContent = str;
    }

    public final void f(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tipContent = str;
    }

    public final void g(int i3) {
        this.tipLayoutVisible = i3;
    }

    public final void h(int i3) {
        this.tipTvVisible = i3;
    }
}
