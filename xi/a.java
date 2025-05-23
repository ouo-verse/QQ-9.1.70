package xi;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.qzone.reborn.groupalbum.selectmedia.adapter.BaseProviderMultiAdapter;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b+\u0010,J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&J\u001f\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00028\u00002\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0018\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\rH\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\rH\u0016R\"\u0010$\u001a\u00020\u001e8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010'\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010&R\u0014\u0010*\u001a\u00020\u00168&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lxi/a;", "T", "", "Lcom/qzone/reborn/groupalbum/selectmedia/adapter/BaseProviderMultiAdapter;", "adapter", "", "k", "(Lcom/qzone/reborn/groupalbum/selectmedia/adapter/BaseProviderMultiAdapter;)V", "d", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "c", "Lcom/qzone/reborn/groupalbum/selectmedia/adapter/a;", "helper", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "a", "(Lcom/qzone/reborn/groupalbum/selectmedia/adapter/a;Ljava/lang/Object;)V", "", "payloads", "b", "(Lcom/qzone/reborn/groupalbum/selectmedia/adapter/a;Ljava/lang/Object;Ljava/util/List;)V", "", "viewType", "g", "viewHolder", "j", "holder", h.F, "i", "Landroid/content/Context;", "Landroid/content/Context;", "e", "()Landroid/content/Context;", "l", "(Landroid/content/Context;)V", "context", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "weakAdapter", "f", "()I", "itemViewType", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public abstract class a<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private WeakReference<BaseProviderMultiAdapter<T>> weakAdapter;

    public void a(com.qzone.reborn.groupalbum.selectmedia.adapter.a helper, T item) {
        Intrinsics.checkNotNullParameter(helper, "helper");
    }

    public void b(com.qzone.reborn.groupalbum.selectmedia.adapter.a helper, T item, List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
    }

    public abstract View c(ViewGroup parent);

    public BaseProviderMultiAdapter<T> d() {
        WeakReference<BaseProviderMultiAdapter<T>> weakReference = this.weakAdapter;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final Context e() {
        Context context = this.context;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("context");
        return null;
    }

    public abstract int f();

    public com.qzone.reborn.groupalbum.selectmedia.adapter.a g(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new com.qzone.reborn.groupalbum.selectmedia.adapter.a(c(parent));
    }

    public void h(com.qzone.reborn.groupalbum.selectmedia.adapter.a holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    public void i(com.qzone.reborn.groupalbum.selectmedia.adapter.a holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    public void j(com.qzone.reborn.groupalbum.selectmedia.adapter.a viewHolder, int viewType) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
    }

    public final void k(BaseProviderMultiAdapter<T> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.weakAdapter = new WeakReference<>(adapter);
    }

    public final void l(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }
}
