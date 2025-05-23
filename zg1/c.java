package zg1;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import zg1.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b&\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00010\u0003B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0004R\u0017\u0010\u000f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lzg1/c;", "Lzg1/a;", "T", "Lcom/tencent/biz/richframework/part/adapter/delegate/AbsItemAdapterDelegate;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "c", "d", "I", "b", "()I", "type", "<init>", "(I)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class c<T extends a> extends AbsItemAdapterDelegate<T, a> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int type;

    public c(int i3) {
        this.type = i3;
    }

    /* renamed from: b, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final boolean isForViewType(@NotNull a item, @NotNull List<a> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        if (item.getType() == this.type) {
            return true;
        }
        return false;
    }
}
