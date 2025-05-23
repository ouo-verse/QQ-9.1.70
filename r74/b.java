package r74;

import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.sqshow.sharedengine.anim.state.AnimState;
import com.tencent.sqshow.sharedengine.anim.state.PortalInitAnimState;
import com.tencent.sqshow.sharedengine.anim.state.PullDownAnimState;
import com.tencent.sqshow.sharedengine.anim.state.b;
import com.tencent.zplan.zplantracing.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t74.l;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J \u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\rJ(\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0004R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lr74/b;", "", "Lr74/b$a$a;", "listener", "", h.F, "Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", "gender", "", "now", "Lcom/tencent/zplan/zplantracing/c;", "zplanSpanContext", "b", "", "e", "newState", "c", "Lq74/a;", "params", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "urlTemplate", "f", "g", "Lcom/tencent/sqshow/sharedengine/anim/state/AnimState;", "a", "Lcom/tencent/sqshow/sharedengine/anim/state/AnimState;", "animState", "Lcom/tencent/sqshow/sharedengine/anim/state/PullDownAnimState;", "Lcom/tencent/sqshow/sharedengine/anim/state/PullDownAnimState;", "pullDownAnim", "Lcom/tencent/sqshow/sharedengine/anim/state/PortalInitAnimState;", "Lcom/tencent/sqshow/sharedengine/anim/state/PortalInitAnimState;", "portalInitAnim", "d", "Lr74/b$a$a;", "animStateChangeListener", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private AnimState animState;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private PullDownAnimState pullDownAnim;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private PortalInitAnimState portalInitAnim;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Companion.InterfaceC11119a animStateChangeListener;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(b this$0, int i3, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Companion.InterfaceC11119a interfaceC11119a = this$0.animStateChangeListener;
        if (interfaceC11119a != null) {
            interfaceC11119a.onStateChange(i3, i16);
        }
    }

    public final void b(EnumUserGender gender, double now, c zplanSpanContext) {
        Intrinsics.checkNotNullParameter(gender, "gender");
        AnimState animState = this.animState;
        if (animState != null) {
            animState.c(this, gender, now, zplanSpanContext);
        }
    }

    public final void c(int newState) {
        AnimState animState;
        AnimState animState2 = this.animState;
        final int stateType = animState2 != null ? animState2.getStateType() : 0;
        if (newState == 1) {
            animState = this.pullDownAnim;
        } else if (newState != 2) {
            animState = this.animState;
        } else {
            animState = this.portalInitAnim;
        }
        final int stateType2 = animState != null ? animState.getStateType() : 0;
        if (animState != null) {
            animState.j();
        }
        this.animState = animState;
        l.f435563a.f(new Runnable() { // from class: r74.a
            @Override // java.lang.Runnable
            public final void run() {
                b.d(b.this, stateType, stateType2);
            }
        });
    }

    public final int e() {
        AnimState animState = this.animState;
        if (animState != null) {
            return animState.getStateType();
        }
        return 0;
    }

    public final void f(q74.a params, c zplanSpanContext, EnumUserGender gender, FilamentUrlTemplate urlTemplate) {
        PortalInitAnimState portalInitAnimState;
        PullDownAnimState pullDownAnimState;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(urlTemplate, "urlTemplate");
        if (this.pullDownAnim == null) {
            this.pullDownAnim = new PullDownAnimState(params);
        }
        PullDownAnimState pullDownAnimState2 = this.pullDownAnim;
        if (((pullDownAnimState2 == null || pullDownAnimState2.i(gender)) ? false : true) && (pullDownAnimState = this.pullDownAnim) != null) {
            pullDownAnimState.a(zplanSpanContext, gender, urlTemplate, new C11120b());
        }
        if (this.portalInitAnim == null) {
            this.portalInitAnim = new PortalInitAnimState(params);
        }
        PortalInitAnimState portalInitAnimState2 = this.portalInitAnim;
        if (!((portalInitAnimState2 == null || portalInitAnimState2.i(gender)) ? false : true) || (portalInitAnimState = this.portalInitAnim) == null) {
            return;
        }
        b.a.a(portalInitAnimState, zplanSpanContext, gender, urlTemplate, null, 8, null);
    }

    public final void h(Companion.InterfaceC11119a listener) {
        this.animStateChangeListener = listener;
    }

    public final void g() {
        c(1);
        PullDownAnimState pullDownAnimState = this.pullDownAnim;
        if (pullDownAnimState != null) {
            pullDownAnimState.j();
        }
        PortalInitAnimState portalInitAnimState = this.portalInitAnim;
        if (portalInitAnimState != null) {
            portalInitAnimState.j();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"r74/b$b", "Lcom/tencent/sqshow/sharedengine/anim/state/a;", "", "success", "", "onResult", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: r74.b$b, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11120b implements com.tencent.sqshow.sharedengine.anim.state.a {
        C11120b() {
        }

        @Override // com.tencent.sqshow.sharedengine.anim.state.a
        public void onResult(boolean success) {
            if (success) {
                b.this.c(1);
            }
        }
    }
}
