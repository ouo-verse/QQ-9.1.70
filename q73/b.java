package q73;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.x;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 -2\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010*\u001a\u00020)\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J(\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R(\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010(\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#\u00a8\u0006."}, d2 = {"Lq73/b;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "Landroid/support/v7/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "a", "Landroid/graphics/Canvas;", "c", "Landroid/support/v7/widget/RecyclerView$State;", "state", "", "onDraw", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "getItemOffsets", "Landroid/graphics/Paint;", "d", "Landroid/graphics/Paint;", "paint", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "e", "Ljava/util/List;", "getMaterials", "()Ljava/util/List;", "b", "(Ljava/util/List;)V", "materials", "f", "I", "getDecorationHeight", "()I", "setDecorationHeight", "(I)V", "decorationHeight", tl.h.F, "getTextMargin", "setTextMargin", "textMargin", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "i", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<MetaMaterial> materials;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int decorationHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int textMargin;

    public b(@NotNull Context context) {
        List<MetaMaterial> emptyList;
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint();
        this.paint = paint;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.materials = emptyList;
        paint.setAntiAlias(true);
        paint.setColor(ContextCompat.getColor(context, R.color.bfo));
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(x.c(context, 12.0f));
        this.decorationHeight = x.c(context, 33.0f);
        this.textMargin = x.c(context, 15.0f);
    }

    private final int a(RecyclerView parent) {
        if (parent.getChildCount() == 1) {
            return parent.getChildAt(0).getLeft();
        }
        if (parent.getChildCount() <= 1) {
            return 0;
        }
        return ((ViewGroup) parent.getChildAt(1).findViewById(R.id.yos)).getLeft();
    }

    public final void b(@NotNull List<MetaMaterial> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.materials = list;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
        if (com.tencent.mobileqq.wink.editor.sticker.m.P(this.materials.get(((RecyclerView.LayoutParams) layoutParams).getViewLayoutPosition()))) {
            outRect.set(0, this.decorationHeight, 0, 0);
        } else {
            outRect.set(0, 0, 0, 0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0031, code lost:
    
        if (com.tencent.mobileqq.wink.editor.sticker.m.O(r4) == true) goto L10;
     */
    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onDraw(@NotNull Canvas c16, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        Object orNull;
        boolean z16;
        Intrinsics.checkNotNullParameter(c16, "c");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        int childCount = parent.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            int childAdapterPosition = parent.getChildAdapterPosition(parent.getChildAt(i3));
            orNull = CollectionsKt___CollectionsKt.getOrNull(this.materials, childAdapterPosition);
            MetaMaterial metaMaterial = (MetaMaterial) orNull;
            if (metaMaterial != null) {
                z16 = true;
            }
            z16 = false;
            if (z16) {
                c16.drawText(com.tencent.mobileqq.wink.editor.c.p(this.materials.get(childAdapterPosition)), a(parent), r2.getTop() - this.textMargin, this.paint);
            }
        }
    }
}
