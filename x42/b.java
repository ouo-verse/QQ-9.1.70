package x42;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010\u0003\u001a\u00020\u0002J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001d"}, d2 = {"Lx42/b;", "", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "d", "", "w", h.F, "oldW", "oldH", "", "e", "Landroid/graphics/Paint;", "a", "Landroid/graphics/Paint;", "paint", "Lx42/e;", "b", "Lx42/e;", "topShadowStrategy", "Lx42/a;", "c", "Lx42/a;", "bottomShadowStrategy", "", "topShadowHeight", "bottomShadowHeight", NodeProps.SHADOW_COLOR, "<init>", "(FFI)V", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e topShadowStrategy;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final x42.a bottomShadowStrategy;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"x42/b$a", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Canvas;", "c", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "onDraw", "onDrawOver", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f447178d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f447179e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ PorterDuffXfermode f447180f;

        a(Ref.IntRef intRef, b bVar, PorterDuffXfermode porterDuffXfermode) {
            this.f447178d = intRef;
            this.f447179e = bVar;
            this.f447180f = porterDuffXfermode;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDraw(@NotNull Canvas c16, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(c16, "c");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.onDraw(c16, parent, state);
            this.f447178d.element = c16.saveLayer(0.0f, 0.0f, parent.getWidth(), parent.getHeight(), this.f447179e.paint);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDrawOver(@NotNull Canvas c16, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(c16, "c");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.onDrawOver(c16, parent, state);
            this.f447179e.paint.setXfermode(this.f447180f);
            this.f447179e.paint.setShader(this.f447179e.topShadowStrategy.e(parent));
            this.f447179e.topShadowStrategy.f(c16, parent, state);
            this.f447179e.paint.setShader(this.f447179e.bottomShadowStrategy.e(parent));
            this.f447179e.bottomShadowStrategy.f(c16, parent, state);
            this.f447179e.paint.setXfermode(null);
            c16.restoreToCount(this.f447178d.element);
        }
    }

    public b(float f16, float f17, int i3) {
        Paint paint = new Paint();
        this.paint = paint;
        this.topShadowStrategy = new e(f16, paint, i3);
        this.bottomShadowStrategy = new x42.a(f17, paint, i3);
    }

    @NotNull
    public final RecyclerView.ItemDecoration d() {
        return new a(new Ref.IntRef(), this, new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public final void e(int w3, int h16, int oldW, int oldH) {
        this.topShadowStrategy.g(w3, h16, oldW, oldH);
        this.bottomShadowStrategy.g(w3, h16, oldW, oldH);
    }
}
