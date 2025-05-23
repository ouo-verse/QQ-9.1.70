package q73;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J(\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lq73/f;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Canvas;", "c", "Landroid/support/v7/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/support/v7/widget/RecyclerView$State;", "state", "", "onDraw", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "getItemOffsets", "Landroid/graphics/Paint;", "d", "Landroid/graphics/Paint;", "paint", "", "e", "I", "a", "()I", "b", "(I)V", "dividerPosition", "<init>", "()V", "f", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class f extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int dividerPosition;

    /* renamed from: h, reason: collision with root package name */
    private static final int f428667h = ImmersiveUtils.dpToPx(1.0f);

    /* renamed from: i, reason: collision with root package name */
    private static final int f428668i = ImmersiveUtils.dpToPx(8.0f);

    /* renamed from: m, reason: collision with root package name */
    private static final int f428669m = Color.parseColor("#66FFFFFF");
    private static final int C = ImmersiveUtils.dpToPx(8.0f);

    public f() {
        Paint paint = new Paint();
        this.paint = paint;
        this.dividerPosition = -1;
        paint.setAntiAlias(true);
        paint.setColor(f428669m);
        paint.setStrokeWidth(f428667h);
    }

    /* renamed from: a, reason: from getter */
    public final int getDividerPosition() {
        return this.dividerPosition;
    }

    public final void b(int i3) {
        this.dividerPosition = i3;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
        if (((RecyclerView.LayoutParams) layoutParams).getViewLayoutPosition() == this.dividerPosition) {
            outRect.set(0, 0, C, 0);
        } else {
            outRect.set(0, 0, 0, 0);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void onDraw(@NotNull Canvas c16, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(c16, "c");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.onDraw(c16, parent, state);
        int childCount = parent.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = parent.getChildAt(i3);
            if (parent.getChildAdapterPosition(childAt) == this.dividerPosition) {
                int top = childAt.getTop() + (childAt.getHeight() / 2);
                int i16 = f428668i;
                c16.drawRect(childAt.getRight() + (C / 2), top - (i16 / 2), childAt.getRight() + (r5 / 2) + f428667h, childAt.getTop() + (childAt.getHeight() / 2) + (i16 / 2), this.paint);
            }
        }
    }
}
