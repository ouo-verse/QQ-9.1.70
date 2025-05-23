package sh;

import android.content.Context;
import com.qzone.reborn.feedx.widget.halfscreen.QZoneFeedxBaseFloatingView;
import com.qzone.reborn.feedx.widget.halfscreen.QZoneFeedxGuideFloatingView;
import com.qzone.reborn.util.k;
import cooperation.qzone.QZoneHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lsh/a;", "", "", "b", "Lcom/qzone/reborn/feedx/widget/halfscreen/QZoneFeedxBaseFloatingView;", "a", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", "Ljava/lang/String;", "getRefer", "()Ljava/lang/String;", "refer", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String refer;

    public a(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.refer = str;
    }

    public final QZoneFeedxBaseFloatingView a() {
        if (b() == 1) {
            return new QZoneFeedxGuideFloatingView(this.context, null);
        }
        return null;
    }

    public final int b() {
        return (k.f59549a.c() || Intrinsics.areEqual(this.refer, QZoneHelper.QZoneAppConstants.REFER_QQ_ACTIVE_FEED)) ? 1 : 0;
    }
}
