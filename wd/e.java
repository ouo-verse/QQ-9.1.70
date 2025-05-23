package wd;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lwd/e;", "", "Luc/a;", "a", "Luc/a;", "()Luc/a;", "d", "(Luc/a;)V", "blankData", "", "b", "I", "()I", "f", "(I)V", "topPartHeight", "", "c", "Z", "()Z", "e", "(Z)V", "isShowError", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private uc.a blankData = new uc.a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int topPartHeight;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isShowError;

    /* renamed from: a, reason: from getter */
    public final uc.a getBlankData() {
        return this.blankData;
    }

    /* renamed from: b, reason: from getter */
    public final int getTopPartHeight() {
        return this.topPartHeight;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsShowError() {
        return this.isShowError;
    }

    public final void d(uc.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.blankData = aVar;
    }

    public final void e(boolean z16) {
        this.isShowError = z16;
    }

    public final void f(int i3) {
        this.topPartHeight = i3;
    }
}
