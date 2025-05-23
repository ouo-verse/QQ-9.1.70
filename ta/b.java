package ta;

import androidx.recyclerview.widget.DiffUtil;
import com.qzone.reborn.base.h;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u0005\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lta/b;", "Lcom/qzone/reborn/base/h;", "Lxa/a;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "itemCallback", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;", "", "delegatesManager", "<init>", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public class b extends h<xa.a> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(DiffUtil.ItemCallback<xa.a> itemCallback, AdapterDelegatesManager<List<xa.a>> delegatesManager) {
        super(itemCallback, delegatesManager);
        Intrinsics.checkNotNullParameter(itemCallback, "itemCallback");
        Intrinsics.checkNotNullParameter(delegatesManager, "delegatesManager");
    }
}
