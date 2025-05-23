package xh1;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.discoveryv2.content.base.h;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lxh1/b;", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b extends RecyclerView.RecycledViewPool {
    public b() {
        h.Companion companion = h.INSTANCE;
        setMaxRecycledViews(companion.y(), 12);
        setMaxRecycledViews(companion.l(), 12);
        setMaxRecycledViews(companion.B(), 12);
        setMaxRecycledViews(companion.A(), 12);
        setMaxRecycledViews(companion.p(), 12);
    }
}
