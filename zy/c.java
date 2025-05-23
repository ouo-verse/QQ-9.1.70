package zy;

import com.tencent.hippy.qq.api.TabPreloadItem;
import java.util.ArrayList;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0005H&J \u0010\f\u001a\u00020\u00052\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH&J \u0010\r\u001a\u00020\u00052\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH&J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0002H&J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0002H&J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0002H&J\b\u0010\u0013\u001a\u00020\u0012H&J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H&\u00a8\u0006\u0017"}, d2 = {"Lzy/c;", "Lcom/tencent/biz/pubaccount/weishi/a;", "", "isRefresh", "isFinished", "", "wb", "Yc", "Ljava/util/ArrayList;", "Lyy/c;", "Lkotlin/collections/ArrayList;", TabPreloadItem.TAB_NAME_MESSAGE, "U5", "A6", "show", "jc", "lg", "f6", "Lxy/a;", "getAdapter", "", "position", "P0", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public interface c extends com.tencent.biz.pubaccount.weishi.a {
    void A6(ArrayList<yy.c> msgList);

    void P0(int position);

    void U5(ArrayList<yy.c> msgList);

    void Yc();

    void f6(boolean show);

    xy.a getAdapter();

    void jc(boolean show);

    void lg(boolean show);

    void wb(boolean isRefresh, boolean isFinished);
}
