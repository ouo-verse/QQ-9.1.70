package yd;

import com.tencent.gdtad.aditem.GdtAd;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tencent.gdt.access;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\"\u0010#R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010 \u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0013\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001c\u001a\u0004\b\u000b\u0010\u001d\"\u0004\b\u001b\u0010\u001f\u00a8\u0006$"}, d2 = {"Lyd/a;", "", "Lcom/tencent/gdtad/aditem/GdtAd;", "a", "Lcom/tencent/gdtad/aditem/GdtAd;", "()Lcom/tencent/gdtad/aditem/GdtAd;", "g", "(Lcom/tencent/gdtad/aditem/GdtAd;)V", "gdtAd", "", "Ltencent/gdt/access$ExpInfo;", "b", "Ljava/util/List;", "getExt", "()Ljava/util/List;", "f", "(Ljava/util/List;)V", "ext", "", "c", "I", "getMDPAClickItemPosition", "()I", "setMDPAClickItemPosition", "(I)V", "MDPAClickItemPosition", "", "d", "Z", "()Z", "e", "(Z)V", "isCGIExposureReport", "isC2SExposureReported", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private GdtAd gdtAd = new GdtAd();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private List<access.ExpInfo> ext = new ArrayList();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int MDPAClickItemPosition = Integer.MIN_VALUE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isCGIExposureReport;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isC2SExposureReported;

    /* renamed from: a, reason: from getter */
    public final GdtAd getGdtAd() {
        return this.gdtAd;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsC2SExposureReported() {
        return this.isC2SExposureReported;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsCGIExposureReport() {
        return this.isCGIExposureReport;
    }

    public final void d(boolean z16) {
        this.isC2SExposureReported = z16;
    }

    public final void e(boolean z16) {
        this.isCGIExposureReport = z16;
    }

    public final void f(List<access.ExpInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.ext = list;
    }

    public final void g(GdtAd gdtAd) {
        Intrinsics.checkNotNullParameter(gdtAd, "<set-?>");
        this.gdtAd = gdtAd;
    }
}
