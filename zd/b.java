package zd;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellForwardInfo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B/\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u001a\u0010\u001bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000e\u001a\u0004\b\u0003\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0019\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lzd/b;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setDataCenterPageId", "(Ljava/lang/String;)V", "dataCenterPageId", "c", "setFeedUniKey", "feedUniKey", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellForwardInfo;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellForwardInfo;", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellForwardInfo;", "e", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellForwardInfo;)V", "cellForward", "", "d", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "f", "(Ljava/lang/Boolean;)V", "isFakeWrite", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellForwardInfo;Ljava/lang/Boolean;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String dataCenterPageId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String feedUniKey;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private CommonCellForwardInfo cellForward;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Boolean isFakeWrite;

    public b(String str, String str2, CommonCellForwardInfo commonCellForwardInfo, Boolean bool) {
        this.dataCenterPageId = str;
        this.feedUniKey = str2;
        this.cellForward = commonCellForwardInfo;
        this.isFakeWrite = bool;
    }

    /* renamed from: a, reason: from getter */
    public final CommonCellForwardInfo getCellForward() {
        return this.cellForward;
    }

    /* renamed from: b, reason: from getter */
    public final String getDataCenterPageId() {
        return this.dataCenterPageId;
    }

    /* renamed from: c, reason: from getter */
    public final String getFeedUniKey() {
        return this.feedUniKey;
    }

    /* renamed from: d, reason: from getter */
    public final Boolean getIsFakeWrite() {
        return this.isFakeWrite;
    }

    public final void e(CommonCellForwardInfo commonCellForwardInfo) {
        this.cellForward = commonCellForwardInfo;
    }

    public final void f(Boolean bool) {
        this.isFakeWrite = bool;
    }
}
