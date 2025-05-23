package xa;

import com.qzone.reborn.albumx.common.bean.CommonGridItemData;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lxa/b;", "", "Lcom/qzone/reborn/albumx/common/bean/CommonGridItemData;", "a", "Lcom/qzone/reborn/albumx/common/bean/CommonGridItemData;", "()Lcom/qzone/reborn/albumx/common/bean/CommonGridItemData;", "c", "(Lcom/qzone/reborn/albumx/common/bean/CommonGridItemData;)V", "itemData", "", "b", "Z", "()Z", "d", "(Z)V", "showCeiling", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private CommonGridItemData itemData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean showCeiling;

    /* renamed from: a, reason: from getter */
    public final CommonGridItemData getItemData() {
        return this.itemData;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getShowCeiling() {
        return this.showCeiling;
    }

    public final void c(CommonGridItemData commonGridItemData) {
        this.itemData = commonGridItemData;
    }

    public final void d(boolean z16) {
        this.showCeiling = z16;
    }
}
