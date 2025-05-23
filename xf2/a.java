package xf2;

import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zf2.PromotionPanelItem;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R'\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0007j\b\u0012\u0004\u0012\u00020\u0003`\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lxf2/a;", "", "", "Lzf2/d;", "items", "", "b", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", VideoTemplateParser.ITEM_LIST, "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<PromotionPanelItem> itemList = new ArrayList<>();

    public final ArrayList<PromotionPanelItem> a() {
        return this.itemList;
    }

    public final void b(List<PromotionPanelItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.itemList.clear();
        this.itemList.addAll(items);
    }
}
