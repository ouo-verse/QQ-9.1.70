package u54;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.robot.slash.dialog.content.root.SlashRootVB;
import com.tencent.robot.widget.bottomdialog.behavior.BottomSheetDialogGestureBehavior;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;
import w64.i;
import w64.m;
import w64.n;
import x64.j;
import x64.k;
import x64.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lu54/a;", "Lw64/n;", "Lu54/c;", "Lw64/k;", "a", "Lw64/f;", "c", "Lw64/l;", "e", "Lw64/d;", "f", "Lw64/m;", "b", "Lw64/i;", "d", "Lcom/tencent/mvi/api/runtime/b;", "Lcom/tencent/mvi/api/runtime/b;", h.F, "()Lcom/tencent/mvi/api/runtime/b;", "mSlashContext", "Lcom/tencent/robot/slash/businessapi/b;", "Lcom/tencent/robot/slash/businessapi/b;", "g", "()Lcom/tencent/robot/slash/businessapi/b;", "buildApi", "<init>", "(Lcom/tencent/mvi/api/runtime/b;Lcom/tencent/robot/slash/businessapi/b;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a implements n<u54.c> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mvi.api.runtime.b mSlashContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.robot.slash.businessapi.b buildApi;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\t\u0010\t\u001a\u00020\bH\u0096\u0001J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"u54/a$a", "Lx64/l;", "Lcom/tencent/robot/widget/bottomdialog/behavior/c;", "viewOperator", "Lx64/j;", "uiMeasureHelper", "Lcom/tencent/robot/widget/bottomdialog/behavior/BottomSheetDialogGestureBehavior;", "a", "Lx64/l$a;", "getConfiguration", "Landroid/content/Context;", "context", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: u54.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C11325a implements l {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ k f438438a = new k();

        C11325a() {
        }

        @Override // x64.l
        @NotNull
        public BottomSheetDialogGestureBehavior a(@NotNull com.tencent.robot.widget.bottomdialog.behavior.c viewOperator, @NotNull j uiMeasureHelper) {
            Intrinsics.checkNotNullParameter(viewOperator, "viewOperator");
            Intrinsics.checkNotNullParameter(uiMeasureHelper, "uiMeasureHelper");
            return this.f438438a.a(viewOperator, uiMeasureHelper);
        }

        @Override // x64.l
        @NotNull
        public j b(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            Intrinsics.checkNotNullExpressionValue(displayMetrics, "context.resources.displayMetrics");
            return new v54.a(displayMetrics);
        }

        @Override // x64.l
        @NotNull
        /* renamed from: getConfiguration */
        public l.a getMConfiguration() {
            return this.f438438a.getMConfiguration();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\n"}, d2 = {"u54/a$b", "Lw64/f;", "Landroid/view/View;", "a", "Landroid/content/Context;", "buildContext", "Landroidx/fragment/app/Fragment;", "b", "Landroidx/lifecycle/LifecycleOwner;", "c", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements w64.f {
        b() {
        }

        @Override // w64.f
        @NotNull
        public View a() {
            return a.this.getBuildApi().getMAnchorView();
        }

        @Override // w64.f
        @NotNull
        public Fragment b() {
            Fragment c16 = a.this.getMSlashContext().c();
            Intrinsics.checkNotNullExpressionValue(c16, "mSlashContext.fragment");
            return c16;
        }

        @Override // w64.f
        @NotNull
        public Context buildContext() {
            Context requireContext = a.this.getMSlashContext().c().requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "mSlashContext.fragment.requireContext()");
            return requireContext;
        }

        @Override // w64.f
        @NotNull
        public LifecycleOwner c() {
            LifecycleOwner d16 = a.this.getMSlashContext().d();
            Intrinsics.checkNotNullExpressionValue(d16, "mSlashContext.lifecycleOwner");
            return d16;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"u54/a$c", "Lw64/k;", "Lu54/c;", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements w64.k<u54.c> {
        c() {
        }

        @Override // w64.k
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public u54.c a() {
            return a.this.getBuildApi().h();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"u54/a$d", "Lw64/i;", "Lml3/b;", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class d implements i {
        d() {
        }

        @Override // w64.i
        @NotNull
        public ml3.b a() {
            return new u54.b();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0007\u001a\u001e\u0012\u0006\b\u0001\u0012\u00020\u0004\u0012\u0006\b\u0001\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u0003H\u0016\u00a8\u0006\b"}, d2 = {"u54/a$e", "Lw64/l;", "Lu54/c;", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lw64/e;", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class e implements w64.l<u54.c> {
        e() {
        }

        @Override // w64.l
        @NotNull
        public BaseVB<? extends ol3.b, ? extends MviUIState, w64.e<u54.c>> a() {
            return new SlashRootVB();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"u54/a$f", "Lw64/m;", "Lcom/tencent/mvi/runtime/strategy/b;", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class f implements m {
        f() {
        }

        @Override // w64.m
        @NotNull
        public com.tencent.mvi.runtime.strategy.b a() {
            return new k64.d();
        }
    }

    public a(@NotNull com.tencent.mvi.api.runtime.b mSlashContext, @NotNull com.tencent.robot.slash.businessapi.b buildApi) {
        Intrinsics.checkNotNullParameter(mSlashContext, "mSlashContext");
        Intrinsics.checkNotNullParameter(buildApi, "buildApi");
        this.mSlashContext = mSlashContext;
        this.buildApi = buildApi;
    }

    @Override // w64.n
    @NotNull
    public w64.k<u54.c> a() {
        return new c();
    }

    @Override // w64.n
    @NotNull
    public m b() {
        return new f();
    }

    @Override // w64.n
    @NotNull
    public w64.f c() {
        return new b();
    }

    @Override // w64.n
    @NotNull
    public i d() {
        return new d();
    }

    @Override // w64.n
    @NotNull
    public w64.l<u54.c> e() {
        return new e();
    }

    @Override // w64.n
    @NotNull
    public w64.d<u54.c> f() {
        return new x64.i(new C11325a());
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final com.tencent.robot.slash.businessapi.b getBuildApi() {
        return this.buildApi;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final com.tencent.mvi.api.runtime.b getMSlashContext() {
        return this.mSlashContext;
    }
}
