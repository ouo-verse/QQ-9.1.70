package wd;

import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonComment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lwd/b;", "Lwd/c;", "Lcom/tencent/gdtad/aditem/GdtAd;", "j", "Lcom/tencent/gdtad/aditem/GdtAd;", "o", "()Lcom/tencent/gdtad/aditem/GdtAd;", "ad", "", "k", "I", "p", "()I", "index", "<init>", "(Lcom/tencent/gdtad/aditem/GdtAd;I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b extends c {

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final GdtAd ad;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final int index;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(GdtAd ad5, int i3) {
        super(new CommonComment());
        Intrinsics.checkNotNullParameter(ad5, "ad");
        this.ad = ad5;
        this.index = i3;
    }

    /* renamed from: o, reason: from getter */
    public final GdtAd getAd() {
        return this.ad;
    }

    /* renamed from: p, reason: from getter */
    public final int getIndex() {
        return this.index;
    }
}
