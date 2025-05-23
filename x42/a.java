package x42;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.recyclerview.widget.RecyclerView;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import x42.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001 B\u001f\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001d\u001a\u00020\f\u00a2\u0006\u0004\b\u001e\u0010\u001fJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J(\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0017\u00a8\u0006!"}, d2 = {"Lx42/a;", "Lx42/d;", "Landroid/graphics/Canvas;", PM.CANVAS, "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "f", "Landroid/graphics/Shader;", "e", "", "w", h.F, "oldW", "oldH", "g", "Lx42/c;", "d", "Lx42/c;", "mScrollHelper", "", "Z", "isCanDrawShadow", "", "shadowHeight", "Landroid/graphics/Paint;", "paint", NodeProps.SHADOW_COLOR, "<init>", "(FLandroid/graphics/Paint;I)V", "a", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a extends d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c mScrollHelper;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isCanDrawShadow;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"x42/a$b", "Lx42/c$c;", "", "b", "d", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b extends c.C11529c {
        b() {
        }

        @Override // x42.c.C11529c, x42.c.b
        public void b() {
            super.b();
            a.this.isCanDrawShadow = false;
        }

        @Override // x42.c.C11529c, x42.c.b
        public void d() {
            super.d();
            a.this.isCanDrawShadow = true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(float f16, @NotNull Paint paint, int i3) {
        super(f16, paint, i3);
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.isCanDrawShadow = true;
    }

    @NotNull
    public Shader e(@NotNull RecyclerView parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (this.mScrollHelper == null) {
            c cVar = new c();
            this.mScrollHelper = cVar;
            cVar.c(parent, new b());
        }
        return new LinearGradient(0.0f, parent.getHeight() - getShadowHeight(), 0.0f, parent.getHeight(), new int[]{getCom.tencent.mtt.hippy.dom.node.NodeProps.SHADOW_COLOR java.lang.String(), 0}, (float[]) null, Shader.TileMode.CLAMP);
    }

    public void f(@NotNull Canvas canvas, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        if (this.isCanDrawShadow) {
            canvas.drawRect(new RectF(0.0f, parent.getHeight() - getShadowHeight(), parent.getWidth(), parent.getHeight()), getPaint());
        }
    }

    public void g(int w3, int h16, int oldW, int oldH) {
    }
}
