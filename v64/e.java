package v64;

import android.view.ViewGroup;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B5\b\u0016\u0012\u0006\u00100\u001a\u00020/\u0012\f\u00102\u001a\b\u0012\u0004\u0012\u00028\u000001\u0012\u0014\b\u0002\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\u001d\u00a2\u0006\u0004\b4\u00105J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016J$\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00062\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u001a\u0010\u0017\u001a\u00020\u000b2\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\u0015J\u001e\u0010\u001b\u001a\u00020\u000b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\b\u0010\u001c\u001a\u00020\u0006H\u0016R \u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R0\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\r8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b\u001b\u0010.\u00a8\u00066"}, d2 = {"Lv64/e;", "T", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "holder", "position", "", "onBindViewHolder", "", "payloads", "getItemViewType", "onViewRecycled", "", "onFailedToRecycleView", "onViewAttachedToWindow", "onViewDetachedFromWindow", "Lv64/b;", "delegate", "j0", "items", "Ljava/lang/Runnable;", "callback", "setItems", "getItemCount", "Lv64/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lv64/c;", "mDelegatesManager", "Landroidx/recyclerview/widget/AsyncListDiffer;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/recyclerview/widget/AsyncListDiffer;", "mDiffer", "D", "Ljava/lang/Runnable;", "mSubmitListCallback", "Landroidx/recyclerview/widget/AsyncListDiffer$ListListener;", "E", "Landroidx/recyclerview/widget/AsyncListDiffer$ListListener;", "mListener", "getItems", "()Ljava/util/List;", "(Ljava/util/List;)V", "Ljava/util/concurrent/Executor;", "executor", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "diffCallback", "delegatesManager", "<init>", "(Ljava/util/concurrent/Executor;Landroidx/recyclerview/widget/DiffUtil$ItemCallback;Lv64/c;)V", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class e<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final AsyncListDiffer<T> mDiffer;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Runnable mSubmitListCallback;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final AsyncListDiffer.ListListener<T> mListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c<List<T>> mDelegatesManager;

    public e(@NotNull Executor executor, @NotNull DiffUtil.ItemCallback<T> diffCallback, @NotNull c<List<T>> delegatesManager) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        Intrinsics.checkNotNullParameter(delegatesManager, "delegatesManager");
        AsyncListDiffer.ListListener<T> listListener = new AsyncListDiffer.ListListener() { // from class: v64.d
            @Override // androidx.recyclerview.widget.AsyncListDiffer.ListListener
            public final void onCurrentListChanged(List list, List list2) {
                e.k0(e.this, list, list2);
            }
        };
        this.mListener = listListener;
        AsyncListDiffer<T> asyncListDiffer = new AsyncListDiffer<>(new AdapterListUpdateCallback(this), new AsyncDifferConfig.Builder(diffCallback).setBackgroundThreadExecutor(executor).build());
        this.mDiffer = asyncListDiffer;
        this.mDelegatesManager = delegatesManager;
        asyncListDiffer.addListListener(listListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(e this$0, List list, List list2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(list, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(list2, "<anonymous parameter 1>");
        Runnable runnable = this$0.mSubmitListCallback;
        if (runnable != null) {
            Intrinsics.checkNotNull(runnable);
            runnable.run();
            this$0.mSubmitListCallback = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mDiffer.getCurrentList().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        c<List<T>> cVar = this.mDelegatesManager;
        List<T> currentList = this.mDiffer.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "mDiffer.currentList");
        return cVar.d(currentList, position);
    }

    @NotNull
    public final List<T> getItems() {
        List<T> currentList = this.mDiffer.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "mDiffer.currentList");
        return currentList;
    }

    public final void j0(@NotNull b<List<T>> delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.mDelegatesManager.b(delegate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        c<List<T>> cVar = this.mDelegatesManager;
        List<T> currentList = this.mDiffer.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "mDiffer.currentList");
        cVar.e(currentList, position, holder, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return this.mDelegatesManager.f(parent, viewType);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        return this.mDelegatesManager.g(holder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.mDelegatesManager.h(holder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.mDelegatesManager.i(holder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.mDelegatesManager.j(holder);
    }

    public final void setItems(@NotNull List<? extends T> items, @Nullable Runnable callback) {
        Intrinsics.checkNotNullParameter(items, "items");
        if (callback != null) {
            this.mSubmitListCallback = callback;
        }
        this.mDiffer.submitList(items);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position, @NotNull List<?> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        c<List<T>> cVar = this.mDelegatesManager;
        List<T> currentList = this.mDiffer.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "mDiffer.currentList");
        cVar.e(currentList, position, holder, payloads);
    }

    public /* synthetic */ e(Executor executor, DiffUtil.ItemCallback itemCallback, c cVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(executor, itemCallback, (i3 & 4) != 0 ? new c(new b[0]) : cVar);
    }
}
