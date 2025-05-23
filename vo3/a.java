package vo3;

import com.tencent.ntcompose.lifecycle.common.Lifecycle;
import com.tencent.ntcompose.lifecycle.common.c;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0017\u0018\u0000 \u000b2\u00020\u0001:\u0002\u0014\u0010B\u000f\u0012\u0006\u0010/\u001a\u00020\r\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R2\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00160\u0015j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0016`\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0018R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001aR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010!R&\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u00020$j\b\u0012\u0004\u0012\u00020\u0002`%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010&R\u0014\u0010)\u001a\u00020\u001f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010(R$\u0010.\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00028V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-\u00a8\u00062"}, d2 = {"Lvo3/a;", "Lcom/tencent/ntcompose/lifecycle/common/Lifecycle;", "Lcom/tencent/ntcompose/lifecycle/common/Lifecycle$State;", "next", "", "g", "Lcom/tencent/ntcompose/lifecycle/common/b;", "observer", "c", h.F, "state", "i", "k", "Lcom/tencent/ntcompose/lifecycle/common/c;", "lifecycleOwner", "d", "b", "Lcom/tencent/ntcompose/lifecycle/common/Lifecycle$Event;", "event", "e", "a", "Ljava/util/LinkedHashMap;", "Lvo3/a$b;", "Lkotlin/collections/LinkedHashMap;", "Ljava/util/LinkedHashMap;", "observerMap", "Lcom/tencent/ntcompose/lifecycle/common/Lifecycle$State;", "Lcom/tencent/ntcompose/lifecycle/common/c;", "", "I", "addingObserverCounter", "", "f", "Z", "handlingEvent", "newEventOccurred", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "parentStates", "()Z", "isSynced", "getCurrentState", "()Lcom/tencent/ntcompose/lifecycle/common/Lifecycle$State;", "j", "(Lcom/tencent/ntcompose/lifecycle/common/Lifecycle$State;)V", "currentState", "provider", "<init>", "(Lcom/tencent/ntcompose/lifecycle/common/c;)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public class a extends Lifecycle {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: j, reason: collision with root package name */
    public static final int f442117j = 8;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private LinkedHashMap<com.tencent.ntcompose.lifecycle.common.b, b> observerMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Lifecycle.State state;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final c lifecycleOwner;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int addingObserverCounter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean handlingEvent;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean newEventOccurred;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ArrayList<Lifecycle.State> parentStates;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lvo3/a$a;", "", "Lcom/tencent/ntcompose/lifecycle/common/Lifecycle$State;", QCircleDaTongConstant.ElementParamValue.EM_XSJ_COMMERCIAL_AD_FINGER_STATE_1, "state2", "a", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: vo3.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes36.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Lifecycle.State a(Lifecycle.State state1, Lifecycle.State state2) {
            Intrinsics.checkNotNullParameter(state1, "state1");
            return (state2 == null || state2.compareTo(state1) >= 0) ? state1 : state2;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\b\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\"\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lvo3/a$b;", "", "Lcom/tencent/ntcompose/lifecycle/common/c;", "owner", "Lcom/tencent/ntcompose/lifecycle/common/Lifecycle$Event;", "event", "", "a", "Lcom/tencent/ntcompose/lifecycle/common/Lifecycle$State;", "Lcom/tencent/ntcompose/lifecycle/common/Lifecycle$State;", "b", "()Lcom/tencent/ntcompose/lifecycle/common/Lifecycle$State;", "setState", "(Lcom/tencent/ntcompose/lifecycle/common/Lifecycle$State;)V", "state", "Lcom/tencent/ntcompose/lifecycle/common/a;", "Lcom/tencent/ntcompose/lifecycle/common/a;", "lifecycleObserver", "Lcom/tencent/ntcompose/lifecycle/common/b;", "observer", "initialState", "<init>", "(Lcom/tencent/ntcompose/lifecycle/common/b;Lcom/tencent/ntcompose/lifecycle/common/Lifecycle$State;)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private Lifecycle.State state;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private com.tencent.ntcompose.lifecycle.common.a lifecycleObserver;

        public b(com.tencent.ntcompose.lifecycle.common.b observer, Lifecycle.State initialState) {
            Intrinsics.checkNotNullParameter(observer, "observer");
            Intrinsics.checkNotNullParameter(initialState, "initialState");
            this.state = initialState;
            this.lifecycleObserver = (com.tencent.ntcompose.lifecycle.common.a) observer;
        }

        public final void a(c owner, Lifecycle.Event event) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            Intrinsics.checkNotNullParameter(event, "event");
            Lifecycle.State targetState = event.getTargetState();
            this.state = a.INSTANCE.a(this.state, targetState);
            this.lifecycleObserver.onStateChanged(owner, event);
            this.state = targetState;
        }

        /* renamed from: b, reason: from getter */
        public final Lifecycle.State getState() {
            return this.state;
        }
    }

    public a(c provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.observerMap = new LinkedHashMap<>();
        this.state = Lifecycle.State.INITIALIZED;
        this.lifecycleOwner = provider;
        this.parentStates = new ArrayList<>();
    }

    private final void b(c lifecycleOwner) {
        List<com.tencent.ntcompose.lifecycle.common.b> reversed;
        Set<com.tencent.ntcompose.lifecycle.common.b> keySet = this.observerMap.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "observerMap.keys");
        reversed = CollectionsKt___CollectionsKt.reversed(keySet);
        for (com.tencent.ntcompose.lifecycle.common.b key : reversed) {
            if (this.newEventOccurred) {
                return;
            }
            b bVar = this.observerMap.get(key);
            if (bVar != null) {
                Intrinsics.checkNotNullExpressionValue(bVar, "observerMap[key] ?: continue");
                Intrinsics.checkNotNullExpressionValue(key, "key");
                while (bVar.getState().compareTo(this.state) > 0 && !this.newEventOccurred && this.observerMap.containsKey(key)) {
                    Lifecycle.Event a16 = Lifecycle.Event.INSTANCE.a(bVar.getState());
                    if (a16 != null) {
                        i(a16.getTargetState());
                        bVar.a(lifecycleOwner, a16);
                        h();
                    } else {
                        throw new IllegalStateException("no event down from " + bVar.getState());
                    }
                }
            }
        }
    }

    private final Lifecycle.State c(com.tencent.ntcompose.lifecycle.common.b observer) {
        List list;
        b bVar;
        Set<com.tencent.ntcompose.lifecycle.common.b> keySet = this.observerMap.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "observerMap.keys");
        list = CollectionsKt___CollectionsKt.toList(keySet);
        int indexOf = list.indexOf(observer);
        Lifecycle.State state = null;
        Lifecycle.State state2 = (indexOf <= 0 || (bVar = this.observerMap.get(list.get(indexOf + (-1)))) == null) ? null : bVar.getState();
        if (!this.parentStates.isEmpty()) {
            state = this.parentStates.get(r0.size() - 1);
        }
        Companion companion = INSTANCE;
        return companion.a(companion.a(this.state, state2), state);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0005, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void d(c lifecycleOwner) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (!this.newEventOccurred) {
            Set<com.tencent.ntcompose.lifecycle.common.b> keySet = this.observerMap.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "observerMap.keys");
            ArrayList<com.tencent.ntcompose.lifecycle.common.b> arrayList = new ArrayList();
            for (Object obj : keySet) {
                if (!linkedHashSet.contains((com.tencent.ntcompose.lifecycle.common.b) obj)) {
                    arrayList.add(obj);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            for (com.tencent.ntcompose.lifecycle.common.b key : arrayList) {
                if (this.newEventOccurred) {
                    break;
                }
                b bVar = this.observerMap.get(key);
                if (bVar != null) {
                    Intrinsics.checkNotNullExpressionValue(bVar, "observerMap[key] ?: continue");
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    while (bVar.getState().compareTo(this.state) < 0 && !this.newEventOccurred && this.observerMap.containsKey(key)) {
                        i(bVar.getState());
                        Lifecycle.Event c16 = Lifecycle.Event.INSTANCE.c(bVar.getState());
                        if (c16 != null) {
                            bVar.a(lifecycleOwner, c16);
                            h();
                        } else {
                            throw new IllegalStateException("no event up from " + bVar.getState());
                        }
                    }
                    linkedHashSet.add(key);
                }
            }
        }
    }

    private final boolean f() {
        Object first;
        Object last;
        if (this.observerMap.isEmpty()) {
            return true;
        }
        Collection<b> values = this.observerMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "observerMap.values");
        first = CollectionsKt___CollectionsKt.first(values);
        Lifecycle.State state = ((b) first).getState();
        Collection<b> values2 = this.observerMap.values();
        Intrinsics.checkNotNullExpressionValue(values2, "observerMap.values");
        last = CollectionsKt___CollectionsKt.last(values2);
        Lifecycle.State state2 = ((b) last).getState();
        return state == state2 && this.state == state2;
    }

    private final void g(Lifecycle.State next) {
        if (this.state == next) {
            return;
        }
        this.state = next;
        if (!this.handlingEvent && this.addingObserverCounter == 0) {
            this.handlingEvent = true;
            k();
            this.handlingEvent = false;
            return;
        }
        this.newEventOccurred = true;
    }

    private final void h() {
        this.parentStates.remove(r0.size() - 1);
    }

    private final void i(Lifecycle.State state) {
        this.parentStates.add(state);
    }

    private final void k() {
        Object first;
        Object lastOrNull;
        while (!f()) {
            this.newEventOccurred = false;
            Lifecycle.State state = this.state;
            Collection<b> values = this.observerMap.values();
            Intrinsics.checkNotNullExpressionValue(values, "observerMap.values");
            first = CollectionsKt___CollectionsKt.first(values);
            if (state.compareTo(((b) first).getState()) < 0) {
                b(this.lifecycleOwner);
            }
            Collection<b> values2 = this.observerMap.values();
            Intrinsics.checkNotNullExpressionValue(values2, "observerMap.values");
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull(values2);
            b bVar = (b) lastOrNull;
            if (!this.newEventOccurred && bVar != null && this.state.compareTo(bVar.getState()) > 0) {
                d(this.lifecycleOwner);
            }
        }
        this.newEventOccurred = false;
    }

    @Override // com.tencent.ntcompose.lifecycle.common.Lifecycle
    public void a(com.tencent.ntcompose.lifecycle.common.b observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (this.observerMap.containsKey(observer)) {
            return;
        }
        Lifecycle.State state = this.state;
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        if (state != state2) {
            state2 = Lifecycle.State.INITIALIZED;
        }
        b bVar = new b(observer, state2);
        if (this.observerMap.put(observer, bVar) != null) {
            return;
        }
        boolean z16 = this.addingObserverCounter != 0 || this.handlingEvent;
        Lifecycle.State c16 = c(observer);
        this.addingObserverCounter++;
        while (bVar.getState().compareTo(c16) < 0 && this.observerMap.containsKey(observer)) {
            i(bVar.getState());
            Lifecycle.Event c17 = Lifecycle.Event.INSTANCE.c(bVar.getState());
            if (c17 != null) {
                bVar.a(this.lifecycleOwner, c17);
                h();
                c16 = c(observer);
            } else {
                throw new IllegalStateException("no event up from " + bVar.getState());
            }
        }
        if (!z16) {
            k();
        }
        this.addingObserverCounter--;
    }

    public final void e(Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        g(event.getTargetState());
    }

    public void j(Lifecycle.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        g(state);
    }
}
