package xm1;

import android.app.Activity;
import android.os.Build;
import android.os.Looper;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutLoaderStrategy;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoaderFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi;
import com.tencent.mobileqq.guild.feed.util.GuildFeedHtmlOfflineUtil;
import com.tencent.mobileqq.guild.feed.util.u;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rr1.i;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001d\u001eB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R\u0018\u0010\r\u001a\u00060\nR\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001f"}, d2 = {"Lxm1/d;", "Lcom/tencent/mobileqq/guild/feed/part/d;", "", "E9", "I9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartPause", "onPartDestroy", "Lxm1/d$b;", "d", "Lxm1/d$b;", "mGestureListener", "", "e", "Z", "sPreloadRunning", "Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutPreLoader;", "f", "Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutPreLoader;", "preloadLoader", "Ljava/lang/Runnable;", h.F, "Ljava/lang/Runnable;", "preloadRunnable", "<init>", "()V", "i", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d extends com.tencent.mobileqq.guild.feed.part.d {

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final HashMap<Integer, Integer> f448162m;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private volatile boolean sPreloadRunning;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile RFWLayoutPreLoader preloadLoader;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mGestureListener = new b();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable preloadRunnable = new Runnable() { // from class: xm1.a
        @Override // java.lang.Runnable
        public final void run() {
            d.G9(d.this);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lxm1/d$b;", "Lrr1/a;", "Lrr1/i;", "notifyData", "", "c", "<init>", "(Lxm1/d;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private final class b extends rr1.a {
        public b() {
        }

        @Override // rr1.a
        public void c(@NotNull i notifyData) {
            Intrinsics.checkNotNullParameter(notifyData, "notifyData");
            if (notifyData.c() == 1 && notifyData.f() == 3) {
                ThreadManagerV2.getUIHandlerV2().removeCallbacks(d.this.preloadRunnable);
                ThreadManagerV2.getUIHandlerV2().post(d.this.preloadRunnable);
            }
        }
    }

    static {
        HashMap<Integer, Integer> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(Integer.valueOf(R.layout.epg), 1), TuplesKt.to(Integer.valueOf(R.layout.eou), 4), TuplesKt.to(Integer.valueOf(R.layout.f168080ep2), 4), TuplesKt.to(Integer.valueOf(R.layout.f168081ep3), 4), TuplesKt.to(Integer.valueOf(R.layout.eow), 4), TuplesKt.to(Integer.valueOf(R.layout.f168184f91), 4), TuplesKt.to(Integer.valueOf(R.layout.f8z), 4), TuplesKt.to(Integer.valueOf(R.layout.eom), 4), TuplesKt.to(Integer.valueOf(R.layout.er7), 2));
        f448162m = hashMapOf;
    }

    private final void E9() {
        if (this.preloadLoader == null) {
            return;
        }
        if (Build.VERSION.SDK_INT > 27) {
            try {
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
            } catch (Throwable th5) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "initPreloadHelper error " + th5;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("GuildFeedLayoutPreloadPart", 1, (String) it.next(), th5);
                }
            }
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: xm1.c
            @Override // java.lang.Runnable
            public final void run() {
                d.F9(d.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(final d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.sPreloadRunning) {
            return;
        }
        this$0.sPreloadRunning = true;
        if (!((IGuildFeedNativeDetailApi) QRoute.api(IGuildFeedNativeDetailApi.class)).isLongFeedNativeSwitchOpen()) {
            GuildFeedHtmlOfflineUtil.f();
        }
        if (!gj1.a.a().b()) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("isSupportAsyncLayoutInflater false! so return! ");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildFeedLayoutPreloadPart", 1, (String) it.next(), null);
            }
            return;
        }
        RFWLayoutLoaderStrategy c16 = gj1.a.a().c();
        Intrinsics.checkNotNullExpressionValue(c16, "getInstance().layoutLoaderStrategy");
        this$0.preloadLoader = RFWLayoutPreLoaderFactory.getLayoutLoader(c16);
        if (this$0.preloadLoader != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: xm1.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.H9(d.this);
                }
            }, 16, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.E9();
    }

    private final void I9() {
        int i3;
        RFWLayoutPreLoader rFWLayoutPreLoader;
        Logger.f235387a.d().d("GuildFeedLayoutPreloadPart", 1, "[startPreloadView] preloadLoader " + this.preloadLoader + ", sPreloadRunning " + this.sPreloadRunning);
        if (this.preloadLoader == null) {
            return;
        }
        for (Map.Entry<Integer, Integer> entry : f448162m.entrySet()) {
            if (this.sPreloadRunning) {
                int intValue = entry.getKey().intValue();
                int intValue2 = entry.getValue().intValue();
                RFWLayoutPreLoader rFWLayoutPreLoader2 = this.preloadLoader;
                if (rFWLayoutPreLoader2 != null) {
                    Activity activity = getActivity();
                    Intrinsics.checkNotNullExpressionValue(activity, "activity");
                    i3 = rFWLayoutPreLoader2.getViewCountInCache(activity, intValue);
                } else {
                    i3 = 0;
                }
                int i16 = intValue2 - i3;
                Logger.f235387a.d().d("GuildFeedLayoutPreloadPart", 1, "preload layoutId " + intValue + ", preloadCount " + i16);
                if (i16 > 0 && (rFWLayoutPreLoader = this.preloadLoader) != null) {
                    Activity activity2 = getActivity();
                    Intrinsics.checkNotNullExpressionValue(activity2, "activity");
                    rFWLayoutPreLoader.preloadView(activity2, intValue, i16);
                }
            }
        }
        Logger.f235387a.d().d("GuildFeedLayoutPreloadPart", 1, "[startPreloadView] end! " + this.sPreloadRunning);
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        if (this.preloadRunnable != null) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.preloadRunnable);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartPause(activity);
        this.sPreloadRunning = false;
        if (getActivity() instanceof QBaseActivity) {
            u.c(this.mGestureListener);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartResume(activity);
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.preloadRunnable, 600L);
        if ((getActivity() instanceof QBaseActivity) && ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isGuildTabSelected()) {
            u.a(this.mGestureListener);
        }
    }
}
