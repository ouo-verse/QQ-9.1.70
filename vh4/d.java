package vh4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.floatwindow.FloatPosFixHelper;
import com.tencent.timi.game.floatwindow.impl.FloatWindowContainer;
import com.tencent.timi.game.floatwindow.impl.FloatingStatusReceiver;
import com.tencent.timi.game.liveroom.impl.ipc.TGLiveClientQIPCModule;
import com.tencent.timi.game.liveroom.impl.ipc.TGLiveServerQIPCModule;
import com.tencent.timi.game.utils.l;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import uh4.c;
import uh4.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 )2\u00020\u0001:\u0003+3!B\u0007\u00a2\u0006\u0004\bI\u0010JJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\"\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u001e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nJ\u0016\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fJ\u0016\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\nJ\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004J-\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u000f2\u0016\u0010\u001d\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u001c\"\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010 J\u000e\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"J\u000e\u0010%\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010(\u001a\u00020\u00062\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0&2\b\b\u0002\u0010'\u001a\u00020\u000fJ\u000e\u0010)\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"J\u0006\u0010\r\u001a\u00020\u0006R\"\u00101\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00109\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R.\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020;0:8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010H\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010G\u00a8\u0006K"}, d2 = {"Lvh4/d;", "", "", "key", "Landroid/view/View;", "customView", "", "g", "Luh4/c;", "floatParams", "", "d", "w", h.F, ReportConstant.COSTREPORT_PREFIX, "", "canFreeDrag", "r", "Lxh4/a;", "listener", "o", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLOSE_REASON, "i", "childView", "k", NodeProps.VISIBLE, "", "views", "p", "(Z[Landroid/view/View;)V", "Luh4/g;", "c", "Lcom/tencent/timi/game/floatwindow/FloatPosFixHelper$FloatPosItem;", "floatItem", "j", "l", "", "notify", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "e", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mContext", "Lcom/tencent/timi/game/floatwindow/impl/FloatingStatusReceiver;", "b", "Lcom/tencent/timi/game/floatwindow/impl/FloatingStatusReceiver;", "getFloatingStatusReceiver", "()Lcom/tencent/timi/game/floatwindow/impl/FloatingStatusReceiver;", "setFloatingStatusReceiver", "(Lcom/tencent/timi/game/floatwindow/impl/FloatingStatusReceiver;)V", "floatingStatusReceiver", "", "Lvh4/d$b;", "Ljava/util/Map;", "getFloatItemMap", "()Ljava/util/Map;", "setFloatItemMap", "(Ljava/util/Map;)V", "floatItemMap", "Lcom/tencent/timi/game/floatwindow/FloatPosFixHelper;", "Lcom/tencent/timi/game/floatwindow/FloatPosFixHelper;", "getFloatPosFixHelper", "()Lcom/tencent/timi/game/floatwindow/FloatPosFixHelper;", "setFloatPosFixHelper", "(Lcom/tencent/timi/game/floatwindow/FloatPosFixHelper;)V", "floatPosFixHelper", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class d {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final String f441701f = "Open_Live|YesFloatWindowManager";

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final d f441702g = c.f441710a.a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Context mContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FloatingStatusReceiver floatingStatusReceiver;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, FloatingItem> floatItemMap = new HashMap();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FloatPosFixHelper floatPosFixHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lvh4/d$a;", "", "", "TAG", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "Lvh4/d;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lvh4/d;", "a", "()Lvh4/d;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: vh4.d$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final d a() {
            return d.f441702g;
        }

        @NotNull
        public final String b() {
            return d.f441701f;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lvh4/d$c;", "", "Lvh4/d;", "b", "Lvh4/d;", "a", "()Lvh4/d;", "holder", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    private static final class c {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final c f441710a = new c();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final d holder = new d();

        c() {
        }

        @NotNull
        public final d a() {
            return holder;
        }
    }

    public d() {
        MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
        Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
        this.mContext = sMobileQQ;
    }

    private final void g(String key, View customView) {
        FloatingItem floatingItem = this.floatItemMap.get(key);
        if (floatingItem != null) {
            floatingItem.getMFloatingWidgetWrapper().removeAllViews();
            k(key, customView);
            floatingItem.getMFloatingWidgetWrapper().addView(customView, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public static /* synthetic */ void n(d dVar, List list, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        dVar.m(list, z16);
    }

    public final void c(@Nullable g listener) {
        if (this.floatingStatusReceiver == null) {
            FloatingStatusReceiver floatingStatusReceiver = new FloatingStatusReceiver(this.mContext);
            this.floatingStatusReceiver = floatingStatusReceiver;
            floatingStatusReceiver.a(listener);
        }
    }

    public final int d(@NotNull String key, @Nullable uh4.c floatParams, @Nullable View customView) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (customView == null) {
            return 2;
        }
        if (!com.tencent.timi.game.utils.g.c(this.mContext)) {
            return 1;
        }
        if (floatParams == null) {
            floatParams = new c.a().b(true).a();
        }
        if (this.floatItemMap.get(key) == null) {
            this.floatItemMap.put(key, new FloatingItem(key, null, null, 6, null));
        }
        FloatingItem floatingItem = this.floatItemMap.get(key);
        if (floatingItem != null) {
            g(key, customView);
            k(key, floatingItem.getMFloatingWidgetWrapper());
            floatingItem.getMFloatingContainer().g(key, floatingItem.getMFloatingWidgetWrapper(), customView, floatParams);
            if (this.floatPosFixHelper == null) {
                this.floatPosFixHelper = new FloatPosFixHelper(-floatingItem.getMFloatingContainer().k(), floatingItem.getMFloatingContainer().i());
                j(floatingItem.getMFloatingContainer().h(floatParams.getMFloatingCenterX(), floatParams.getMFloatingCenterY()));
            }
            q(key);
            return 0;
        }
        return 0;
    }

    public final void e(@NotNull FloatPosFixHelper.FloatPosItem floatItem) {
        FloatWindowContainer mFloatingContainer;
        Intrinsics.checkNotNullParameter(floatItem, "floatItem");
        FloatingItem floatingItem = this.floatItemMap.get(floatItem.key);
        if (floatingItem != null && (mFloatingContainer = floatingItem.getMFloatingContainer()) != null) {
            mFloatingContainer.p(floatItem.centerX, floatItem.centerY);
        }
    }

    public final void f(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        FloatingItem floatingItem = this.floatItemMap.get(key);
        if (floatingItem != null) {
            l.i(f441701f, "hideFloatingView " + key);
            p(false, floatingItem.getMFloatingContainer());
        }
    }

    public final void h() {
        Object first;
        Object first2;
        FloatPosFixHelper.FloatPosItem floatPosItem;
        boolean contains$default;
        Map<String, FloatingItem> map = this.floatItemMap;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, FloatingItem> entry : map.entrySet()) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) entry.getKey(), (CharSequence) "keep", false, 2, (Object) null);
            if (!contains$default) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            FloatPosFixHelper floatPosFixHelper = this.floatPosFixHelper;
            if (floatPosFixHelper != null) {
                floatPosItem = floatPosFixHelper.c((String) entry2.getKey());
            } else {
                floatPosItem = null;
            }
            arrayList.add(floatPosItem);
        }
        if (!arrayList.isEmpty()) {
            if (MobileQQ.sProcessId == 7) {
                TGLiveServerQIPCModule b16 = TGLiveServerQIPCModule.f377291e.b();
                first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
                Intrinsics.checkNotNull(first2);
                b16.n((Serializable) first2);
                return;
            }
            TGLiveClientQIPCModule c16 = TGLiveClientQIPCModule.f377285e.c();
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
            Intrinsics.checkNotNull(first);
            c16.k((Serializable) first);
        }
    }

    public final void i(@NotNull String key, int closeReason) {
        Intrinsics.checkNotNullParameter(key, "key");
        FloatingItem floatingItem = this.floatItemMap.get(key);
        if (floatingItem != null) {
            l.i(f441701f, "quitWindowFloat " + key);
            if (floatingItem.getMFloatingContainer() != null && floatingItem.getMFloatingContainer().v()) {
                k(key, floatingItem.getMFloatingWidgetWrapper());
                if (floatingItem.getMFloatingWidgetWrapper() != null) {
                    floatingItem.getMFloatingWidgetWrapper().removeAllViews();
                }
                p(false, floatingItem.getMFloatingContainer());
            }
            this.floatItemMap.remove(key);
        }
        if (this.floatItemMap.isEmpty()) {
            FloatingStatusReceiver floatingStatusReceiver = this.floatingStatusReceiver;
            if (floatingStatusReceiver != null) {
                floatingStatusReceiver.b();
            }
            this.floatingStatusReceiver = null;
        }
    }

    public final void j(@NotNull FloatPosFixHelper.FloatPosItem floatItem) {
        Intrinsics.checkNotNullParameter(floatItem, "floatItem");
        FloatPosFixHelper floatPosFixHelper = this.floatPosFixHelper;
        if (floatPosFixHelper != null) {
            floatPosFixHelper.f(floatItem);
        }
    }

    public final void k(@NotNull String key, @Nullable View childView) {
        ViewGroup viewGroup;
        Intrinsics.checkNotNullParameter(key, "key");
        if (this.floatItemMap.get(key) != null && childView != null) {
            try {
                ViewParent parent = childView.getParent();
                if (parent instanceof ViewGroup) {
                    viewGroup = (ViewGroup) parent;
                } else {
                    viewGroup = null;
                }
                if (viewGroup != null) {
                    viewGroup.removeView(childView);
                }
            } catch (ClassCastException e16) {
                e16.printStackTrace();
            }
        }
    }

    public final void l(@NotNull String key) {
        FloatWindowContainer mFloatingContainer;
        Intrinsics.checkNotNullParameter(key, "key");
        FloatingItem floatingItem = this.floatItemMap.get(key);
        if (floatingItem != null && (mFloatingContainer = floatingItem.getMFloatingContainer()) != null) {
            mFloatingContainer.x();
        }
    }

    public final void m(@NotNull List<? extends FloatPosFixHelper.FloatPosItem> floatItem, boolean notify) {
        Intrinsics.checkNotNullParameter(floatItem, "floatItem");
        FloatPosFixHelper floatPosFixHelper = this.floatPosFixHelper;
        if (floatPosFixHelper != null) {
            floatPosFixHelper.g(floatItem, notify);
        }
    }

    public final void o(@NotNull String key, @NotNull xh4.a listener) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(listener, "listener");
        FloatingItem floatingItem = this.floatItemMap.get(key);
        if (floatingItem != null) {
            floatingItem.getMFloatingContainer().setDragListener(listener);
        }
    }

    public final void p(boolean visible, @NotNull View... views) {
        Intrinsics.checkNotNullParameter(views, "views");
        for (View view : views) {
            if (view != null) {
                if (visible) {
                    view.setVisibility(0);
                } else {
                    view.setVisibility(4);
                }
            }
        }
    }

    public final void q(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        FloatingItem floatingItem = this.floatItemMap.get(key);
        if (floatingItem != null) {
            l.i(f441701f, "showFloatingView " + key);
            p(true, floatingItem.getMFloatingContainer());
        }
    }

    public final void r(@NotNull String key, boolean canFreeDrag) {
        Intrinsics.checkNotNullParameter(key, "key");
        FloatingItem floatingItem = this.floatItemMap.get(key);
        if (floatingItem != null) {
            floatingItem.getMFloatingContainer().A(canFreeDrag);
        }
    }

    public final int s(@NotNull String key, int w3, int h16) {
        Intrinsics.checkNotNullParameter(key, "key");
        FloatingItem floatingItem = this.floatItemMap.get(key);
        if (floatingItem != null) {
            floatingItem.getMFloatingContainer().C(w3, h16);
            return 0;
        }
        return 0;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\t\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0011\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lvh4/d$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getKet", "()Ljava/lang/String;", "setKet", "(Ljava/lang/String;)V", "ket", "Lcom/tencent/timi/game/floatwindow/impl/FloatWindowContainer;", "b", "Lcom/tencent/timi/game/floatwindow/impl/FloatWindowContainer;", "()Lcom/tencent/timi/game/floatwindow/impl/FloatWindowContainer;", "setMFloatingContainer", "(Lcom/tencent/timi/game/floatwindow/impl/FloatWindowContainer;)V", "mFloatingContainer", "Landroid/widget/FrameLayout;", "c", "Landroid/widget/FrameLayout;", "()Landroid/widget/FrameLayout;", "setMFloatingWidgetWrapper", "(Landroid/widget/FrameLayout;)V", "mFloatingWidgetWrapper", "<init>", "(Ljava/lang/String;Lcom/tencent/timi/game/floatwindow/impl/FloatWindowContainer;Landroid/widget/FrameLayout;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: vh4.d$b, reason: from toString */
    /* loaded from: classes26.dex */
    public static final /* data */ class FloatingItem {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String ket;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private FloatWindowContainer mFloatingContainer;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private FrameLayout mFloatingWidgetWrapper;

        public FloatingItem(@NotNull String ket, @NotNull FloatWindowContainer mFloatingContainer, @NotNull FrameLayout mFloatingWidgetWrapper) {
            Intrinsics.checkNotNullParameter(ket, "ket");
            Intrinsics.checkNotNullParameter(mFloatingContainer, "mFloatingContainer");
            Intrinsics.checkNotNullParameter(mFloatingWidgetWrapper, "mFloatingWidgetWrapper");
            this.ket = ket;
            this.mFloatingContainer = mFloatingContainer;
            this.mFloatingWidgetWrapper = mFloatingWidgetWrapper;
            mFloatingContainer.setBackgroundColor(0);
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final FloatWindowContainer getMFloatingContainer() {
            return this.mFloatingContainer;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final FrameLayout getMFloatingWidgetWrapper() {
            return this.mFloatingWidgetWrapper;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FloatingItem)) {
                return false;
            }
            FloatingItem floatingItem = (FloatingItem) other;
            if (Intrinsics.areEqual(this.ket, floatingItem.ket) && Intrinsics.areEqual(this.mFloatingContainer, floatingItem.mFloatingContainer) && Intrinsics.areEqual(this.mFloatingWidgetWrapper, floatingItem.mFloatingWidgetWrapper)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.ket.hashCode() * 31) + this.mFloatingContainer.hashCode()) * 31) + this.mFloatingWidgetWrapper.hashCode();
        }

        @NotNull
        public String toString() {
            return "FloatingItem(ket=" + this.ket + ", mFloatingContainer=" + this.mFloatingContainer + ", mFloatingWidgetWrapper=" + this.mFloatingWidgetWrapper + ")";
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ FloatingItem(String str, FloatWindowContainer floatWindowContainer, FrameLayout frameLayout, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, floatWindowContainer, (i3 & 4) != 0 ? new FrameLayout(BaseApplication.context) : frameLayout);
            if ((i3 & 2) != 0) {
                BaseApplication context = BaseApplication.context;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                floatWindowContainer = new FloatWindowContainer(context, null, 0, 6, null);
            }
        }
    }
}
