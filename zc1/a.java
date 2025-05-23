package zc1;

import android.app.Activity;
import android.content.Context;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.app.friendlist.b;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.argus.ArgusPerformanceMonitor;
import com.tencent.richframework.argus.PerformanceData;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004J\u0018\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004J\u0018\u0010\u000e\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u0004J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lzc1/a;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/richframework/argus/PerformanceData;", "performanceData", "", "scene", "", "A9", "sourcePage", "z9", "Landroid/content/Context;", "context", "startMonitor", "B9", "x9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "", "d", "Z", "hasStart", "e", "hasEnd", "f", "Ljava/lang/String;", "mPageSource", "<init>", "()V", "qqfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean hasStart;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean hasEnd;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String mPageSource = "";

    public final void B9(String sourcePage) {
        Intrinsics.checkNotNullParameter(sourcePage, "sourcePage");
        this.mPageSource = sourcePage;
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
    }

    public final void startMonitor(Context context, String scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (this.hasStart) {
            return;
        }
        this.hasStart = true;
        if (context != null) {
            ArgusPerformanceMonitor.INSTANCE.startMonitor(context, scene);
        }
    }

    public final void x9(Context context, String scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (!this.hasStart || this.hasEnd || context == null) {
            return;
        }
        this.hasEnd = true;
        A9(ArgusPerformanceMonitor.INSTANCE.stopMonitor(context, scene), scene);
    }

    public final void z9(String sourcePage) {
        Intrinsics.checkNotNullParameter(sourcePage, "sourcePage");
        this.mPageSource = sourcePage;
    }

    private final void A9(PerformanceData performanceData, String scene) {
        double averageOfFloat;
        if (performanceData == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        averageOfFloat = CollectionsKt___CollectionsKt.averageOfFloat(performanceData.getFps());
        hashMap.put(scene, String.valueOf(averageOfFloat));
        hashMap.put("source", this.mPageSource);
        b.b(hashMap);
    }
}
