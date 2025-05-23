package xy;

import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J(\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H&J \u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\u0010"}, d2 = {"Lxy/c;", "Lcom/tencent/biz/pubaccount/weishi/a;", "", "hideLoadingView", "Lyy/b;", ISchemeApi.KEY_PAGE_DATA, "", "isFirst", "isRefresh", "canLoadMore", "U4", "", "code", "", "msg", "Q0", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public interface c extends com.tencent.biz.pubaccount.weishi.a {
    void Q0(int code, String msg2, boolean isFirst);

    void U4(yy.b pageData, boolean isFirst, boolean isRefresh, boolean canLoadMore);

    void hideLoadingView();
}
