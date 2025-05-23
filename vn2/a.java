package vn2;

import android.view.View;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchUtilFetcher;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B)\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016R\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lvn2/a;", "Ldo2/a;", "", "l", "", DomainData.DOMAIN_NAME, "Landroid/view/View;", "view", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, h.F, BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getRecallReason", "()Ljava/lang/String;", "recallReason", "", "Lcom/tencent/mobileqq/search/model/y;", "resultList", "keyword", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "D", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a extends do2.a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String recallReason;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@Nullable List<y> list, @Nullable String str, @NotNull String recallReason) {
        super(list, str);
        Intrinsics.checkNotNullParameter(recallReason, "recallReason");
        this.recallReason = recallReason;
        r(13);
    }

    @Override // com.tencent.mobileqq.search.model.v
    @NotNull
    /* renamed from: h, reason: from getter */
    public String getRecallReason() {
        return this.recallReason;
    }

    @Override // com.tencent.mobileqq.search.model.x
    @NotNull
    public String l() {
        return "\u804a\u5929\u8bb0\u5f55";
    }

    @Override // com.tencent.mobileqq.search.model.x
    public int n() {
        return nn2.a.e("fts_native_chathistory_maxnum", 3);
    }

    @Override // com.tencent.mobileqq.search.model.x
    public void q(@Nullable View view) {
        ISearchUtilFetcher iSearchUtilFetcher = (ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class);
        Intrinsics.checkNotNull(view);
        iSearchUtilFetcher.fTSEntitySearchActivityLaunch(view.getContext(), this.f394360i, 2);
    }
}
