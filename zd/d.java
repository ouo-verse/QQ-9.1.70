package zd;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellPermission;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0003\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lzd/d;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setFeedUniKey", "(Ljava/lang/String;)V", "feedUniKey", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellPermission;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellPermission;", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellPermission;", "c", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellPermission;)V", "cellPermission", "<init>", "(Ljava/lang/String;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellPermission;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String feedUniKey;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private CommonCellPermission cellPermission;

    public d(String str, CommonCellPermission commonCellPermission) {
        this.feedUniKey = str;
        this.cellPermission = commonCellPermission;
    }

    /* renamed from: a, reason: from getter */
    public final CommonCellPermission getCellPermission() {
        return this.cellPermission;
    }

    /* renamed from: b, reason: from getter */
    public final String getFeedUniKey() {
        return this.feedUniKey;
    }

    public final void c(CommonCellPermission commonCellPermission) {
        this.cellPermission = commonCellPermission;
    }
}
