package vc2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016R\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001c"}, d2 = {"Lvc2/a;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "", "spacePx", "", "r", "Landroid/view/View;", "child", "widthUsed", "heightUsed", "measureChildWithMargins", "", "enable", "a", "canScrollHorizontally", "canScrollVertically", "d", "I", "mReserveSpace", "e", "Z", "mCanScroll", "Landroid/content/Context;", "context", "orientation", "reverseLayout", "<init>", "(Landroid/content/Context;IZ)V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a extends LinearLayoutManager {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mReserveSpace;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mCanScroll;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Context context, int i3, boolean z16) {
        super(context, i3, z16);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCanScroll = true;
    }

    public final void a(boolean enable) {
        this.mCanScroll = enable;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        if (this.mCanScroll && super.canScrollHorizontally()) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        if (this.mCanScroll && super.canScrollVertically()) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void measureChildWithMargins(@NotNull View child, int widthUsed, int heightUsed) {
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(child, "child");
        Object tag = child.getTag(R.id.f923157j);
        ViewGroup.LayoutParams layoutParams2 = child.getLayoutParams();
        if (tag != null && (tag instanceof ViewGroup.LayoutParams)) {
            layoutParams = (ViewGroup.LayoutParams) tag;
        } else {
            layoutParams = new ViewGroup.LayoutParams(layoutParams2);
            child.setTag(R.id.f923157j, layoutParams);
        }
        if (getOrientation() == 1) {
            if (layoutParams.height == -1 && this.mReserveSpace > 0) {
                layoutParams2.height = getHeight() - (this.mReserveSpace * 2);
            }
        } else if (getOrientation() == 0 && layoutParams.width == -1 && this.mReserveSpace > 0) {
            layoutParams2.width = getWidth() - (this.mReserveSpace * 2);
        }
        super.measureChildWithMargins(child, widthUsed, heightUsed);
    }

    public final void r(int spacePx) {
        this.mReserveSpace = spacePx;
    }
}
