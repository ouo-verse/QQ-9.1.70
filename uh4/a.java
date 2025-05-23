package uh4;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.timi.game.app.event.AppBecomeBackgroundEvent;
import com.tencent.timi.game.app.event.AppBecomeForegroundEvent;
import com.tencent.timi.game.utils.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000f2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002'(B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003J\u001e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fJ\u0016\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\tJ\u0016\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0003J\u0012\u0010\u0017\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\u001a\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00190\u0018H\u0016R\u0016\u0010\u001c\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001eR\"\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020!0 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\"R \u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\"\u00a8\u0006)"}, d2 = {"Luh4/a;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "roomId", "Luh4/e;", "creator", "", "g", "", "d", "e", "", "w", h.F, "i", "canFreeDrag", "Lxh4/a;", "listener", "f", "Luh4/b;", "c", "simpleBaseEvent", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Z", "backgrounding", "Luh4/g;", "Luh4/g;", "floatStatusListener", "", "Luh4/d;", "Ljava/util/Map;", "floatingViewMap", "floatShowingStatusMap", "<init>", "()V", "a", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final a f438980m = C11348a.f438985a.a();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean backgrounding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private g floatStatusListener = new c();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, d> floatingViewMap = new HashMap();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Boolean> floatShowingStatusMap = new HashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Luh4/a$a;", "", "Luh4/a;", "b", "Luh4/a;", "a", "()Luh4/a;", "holder", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: uh4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    private static final class C11348a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final C11348a f438985a = new C11348a();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final a holder = new a();

        C11348a() {
        }

        @NotNull
        public final a a() {
            return holder;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Luh4/a$b;", "", "Luh4/a;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Luh4/a;", "a", "()Luh4/a;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: uh4.a$b, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final a a() {
            return a.f438980m;
        }

        Companion() {
        }
    }

    public a() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @NotNull
    public final b c(@NotNull String roomId) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        d dVar = this.floatingViewMap.get(roomId);
        if (dVar != null) {
            return dVar.a();
        }
        return b.INSTANCE.b();
    }

    public final boolean d(@NotNull String roomId) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        if (this.floatingViewMap.get(roomId) != null) {
            l.i(vh4.d.INSTANCE.b(), "hideFloatWindow " + roomId + " , backgrounding:" + this.backgrounding);
            ((f) mm4.b.b(f.class)).E3(roomId.toString());
            this.floatShowingStatusMap.put(roomId, Boolean.FALSE);
            d dVar = this.floatingViewMap.get(roomId);
            if (dVar != null) {
                dVar.onHide();
                return true;
            }
            return true;
        }
        return false;
    }

    public final boolean e(@NotNull String roomId) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        if (this.floatingViewMap.get(roomId) == null) {
            return false;
        }
        l.i(vh4.d.INSTANCE.b(), "releaseFloatWindow " + roomId + " , backgrounding:" + this.backgrounding);
        ((f) mm4.b.b(f.class)).g1(roomId.toString(), 0);
        d remove = this.floatingViewMap.remove(roomId);
        if (remove != null) {
            remove.e();
        }
        this.floatShowingStatusMap.remove(roomId);
        return true;
    }

    public final void f(@NotNull String roomId, @NotNull xh4.a listener) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.floatingViewMap.get(roomId) != null) {
            ((f) mm4.b.b(f.class)).u1(roomId.toString(), listener);
        }
    }

    public final void g(@NotNull String roomId, @Nullable e creator) {
        d dVar;
        boolean contains$default;
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        if (this.floatingViewMap.get(roomId) != null) {
            l.i(vh4.d.INSTANCE.b(), "showFloatWindow " + roomId + " , backgrounding:" + this.backgrounding);
            if (this.backgrounding && !QBaseActivity.mAppForground) {
                this.backgrounding = true;
            } else {
                this.backgrounding = false;
                ((f) mm4.b.b(f.class)).d0(roomId.toString());
                d dVar2 = this.floatingViewMap.get(roomId);
                if (dVar2 != null) {
                    dVar2.onShow();
                }
            }
            this.floatShowingStatusMap.put(roomId, Boolean.TRUE);
        } else {
            if (creator != null) {
                dVar = creator.a(roomId);
            } else {
                dVar = null;
            }
            if (dVar != null) {
                ((f) mm4.b.b(f.class)).R(roomId.toString(), dVar.f(), dVar.getView());
                this.floatingViewMap.put(roomId, dVar);
                this.floatShowingStatusMap.put(roomId, Boolean.TRUE);
                dVar.b();
                if (this.backgrounding && !QBaseActivity.mAppForground) {
                    this.backgrounding = true;
                    ((f) mm4.b.b(f.class)).E3(roomId);
                } else {
                    this.backgrounding = false;
                    dVar.onShow();
                }
            }
        }
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) roomId, (CharSequence) "keep", false, 2, (Object) null);
        if (!contains$default) {
            ((f) mm4.b.b(f.class)).f0(roomId);
        }
        if (!this.floatingViewMap.isEmpty()) {
            ((f) mm4.b.b(f.class)).c2(this.floatStatusListener);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(AppBecomeForegroundEvent.class);
        arrayList.add(AppBecomeBackgroundEvent.class);
        return arrayList;
    }

    public final void h(@NotNull String roomId, boolean canFreeDrag) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        if (this.floatingViewMap.get(roomId) != null) {
            ((f) mm4.b.b(f.class)).e0(roomId.toString(), canFreeDrag);
        }
    }

    public final void i(@NotNull String roomId, int w3, int h16) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        if (this.floatingViewMap.get(roomId) != null) {
            ((f) mm4.b.b(f.class)).h0(roomId.toString(), w3, h16);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof AppBecomeForegroundEvent) {
            l.i(vh4.d.INSTANCE.b(), "AppBecomeForegroundEvent called");
            Iterator<Map.Entry<String, d>> it = this.floatingViewMap.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().d();
            }
            return;
        }
        if (simpleBaseEvent instanceof AppBecomeBackgroundEvent) {
            l.i(vh4.d.INSTANCE.b(), "AppBecomeBackgroundEvent called");
            Iterator<Map.Entry<String, d>> it5 = this.floatingViewMap.entrySet().iterator();
            while (it5.hasNext()) {
                it5.next().getValue().onBackground();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"uh4/a$c", "Luh4/g;", "", "c", "a", "d", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements g {
        c() {
        }

        @Override // uh4.g
        public void a() {
            l.i(vh4.d.INSTANCE.b(), "onWindowHide");
        }

        @Override // uh4.g
        public void b() {
            l.i(vh4.d.INSTANCE.b(), "onWindowDismiss");
            Map map = a.this.floatShowingStatusMap;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                if (((Boolean) entry.getValue()).booleanValue()) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            Iterator it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                ((f) mm4.b.b(f.class)).E3(((String) ((Map.Entry) it.next()).getKey()).toString());
            }
        }

        @Override // uh4.g
        public void d() {
            l.i(vh4.d.INSTANCE.b(), "onWindowShow");
        }

        @Override // uh4.g
        public void c() {
        }
    }
}
