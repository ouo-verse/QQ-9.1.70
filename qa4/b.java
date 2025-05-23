package qa4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.aa;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0013\b&\u0018\u0000 2*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\b\u0012\u0004\u0012\u00028\u00010\u00042\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005:\u00013B#\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001b\u0012\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000!\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\n\u001a\u00020\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00028\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\u0016\u0010\u0018\u001a\u00020\f2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0016J\u000e\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0006R\u001c\u0010 \u001a\u0004\u0018\u00010\u001b8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR \u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000!8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001e\u0010)\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00018\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lqa4/b;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lqa4/c;", "", "position", "getRealPosition", "", "j0", "holder", "", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getItemCount", "l0", "Lqa4/d;", "listener", "o0", "increaseCount", "n0", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "k0", "()Ljava/util/List;", "mapDataList", "D", "Lqa4/d;", "mOnBannerListener", "E", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mViewHolder", UserInfo.SEX_FEMALE, "I", "mIncreaseCount", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "G", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public abstract class b<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements c<T, VH> {

    /* renamed from: C, reason: from kotlin metadata */
    private final List<T> mapDataList;

    /* renamed from: D, reason: from kotlin metadata */
    private d<T> mOnBannerListener;

    /* renamed from: E, reason: from kotlin metadata */
    private VH mViewHolder;

    /* renamed from: F, reason: from kotlin metadata */
    private int mIncreaseCount;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* JADX WARN: Multi-variable type inference failed */
    public b(Context context, List<? extends T> mapDataList) {
        Intrinsics.checkNotNullParameter(mapDataList, "mapDataList");
        this.context = context;
        this.mapDataList = mapDataList;
        this.mIncreaseCount = 2;
        j0();
    }

    private final int getRealPosition(int position) {
        return sa4.a.f433598a.b(this.mIncreaseCount == 2, position, l0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(d this_apply, Object obj, int i3, View it) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this_apply.a(it, obj, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (l0() > 1) {
            return l0() + this.mIncreaseCount;
        }
        return l0();
    }

    public final boolean j0() {
        QLog.i("BannerAdapter", 1, "fillDataList");
        boolean z16 = !this.mapDataList.isEmpty();
        if (z16) {
            notifyDataSetChanged();
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<T> k0() {
        return this.mapDataList;
    }

    public int l0() {
        return this.mapDataList.size();
    }

    public final void n0(int increaseCount) {
        this.mIncreaseCount = increaseCount;
    }

    public final void o0(d<T> listener) {
        this.mOnBannerListener = listener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(VH holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.mViewHolder = holder;
        final int realPosition = getRealPosition(position);
        final T t16 = this.mapDataList.get(realPosition);
        d0(holder, this.mapDataList.get(realPosition), realPosition, l0());
        final d<T> dVar = this.mOnBannerListener;
        if (dVar != null) {
            View view = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
            aa.d(view, new View.OnClickListener() { // from class: qa4.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    b.m0(d.this, t16, realPosition, view2);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return (VH) u(parent, viewType);
    }
}
