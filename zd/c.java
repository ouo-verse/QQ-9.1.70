package zd;

import com.tencent.hippykotlin.demo.pages.qzone.data.CommonCellLike;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0013\u0010\u0014R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000e\u001a\u0004\b\u0003\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lzd/c;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setDataCenterPageId", "(Ljava/lang/String;)V", "dataCenterPageId", "c", "setFeedUniKey", "feedUniKey", "Lcom/tencent/hippykotlin/demo/pages/qzone/data/CommonCellLike;", "Lcom/tencent/hippykotlin/demo/pages/qzone/data/CommonCellLike;", "()Lcom/tencent/hippykotlin/demo/pages/qzone/data/CommonCellLike;", "d", "(Lcom/tencent/hippykotlin/demo/pages/qzone/data/CommonCellLike;)V", "cellLike", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/hippykotlin/demo/pages/qzone/data/CommonCellLike;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String dataCenterPageId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String feedUniKey;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private CommonCellLike cellLike;

    public c(String str, String str2, CommonCellLike commonCellLike) {
        this.dataCenterPageId = str;
        this.feedUniKey = str2;
        this.cellLike = commonCellLike;
    }

    /* renamed from: a, reason: from getter */
    public final CommonCellLike getCellLike() {
        return this.cellLike;
    }

    /* renamed from: b, reason: from getter */
    public final String getDataCenterPageId() {
        return this.dataCenterPageId;
    }

    /* renamed from: c, reason: from getter */
    public final String getFeedUniKey() {
        return this.feedUniKey;
    }

    public final void d(CommonCellLike commonCellLike) {
        this.cellLike = commonCellLike;
    }
}
