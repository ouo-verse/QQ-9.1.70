package wn1;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import vn1.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00010\u0003B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u0005\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u0002*\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J2\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u001a\u0010\u000e\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\f0\u000bJ6\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u001c\u0010\u000e\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0000\u0012\u00028\u00000\r0\f0\u000bH&J&\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0004R\u0017\u0010\u001b\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lwn1/h;", "Lvn1/a;", "T", "Lcom/tencent/biz/richframework/part/adapter/delegate/AbsItemAdapterDelegate;", "", "b", "(Ljava/lang/Object;)Ljava/lang/Object;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "itemView", "", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "sections", "", "initSection", "d", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "items", "", "position", "", "c", "I", "getType", "()I", "type", "<init>", "(I)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class h<T extends vn1.a> extends AbsItemAdapterDelegate<T, vn1.a> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int type;

    public h(int i3) {
        this.type = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final boolean isForViewType(@NotNull vn1.a item, @NotNull List<vn1.a> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        if (item.getType() == this.type) {
            return true;
        }
        return false;
    }

    public abstract void d(@NotNull ViewGroup parent, @NotNull View itemView, @NotNull List<Class<? extends Section<? super T>>> sections);

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public final void initSection(@NotNull ViewGroup parent, @NotNull View itemView, @NotNull List<Class<? extends Section<T>>> sections) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        d(parent, itemView, (List) b(sections));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T> T b(Object obj) {
        return obj;
    }
}
