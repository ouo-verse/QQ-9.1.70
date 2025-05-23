package re;

import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.share.d;
import com.qzone.reborn.share.i;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellUserInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\b\u0010\b\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\n\u001a\u00020\tR\"\u0010\u0011\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lre/b;", "Lcom/qzone/reborn/share/i;", "", "getLogTag", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feed", "", "W1", "S1", "", "U1", UserInfo.SEX_FEMALE, "Z", "T1", "()Z", "X1", "(Z)V", "isFromDetail", "<init>", "()V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b extends i {

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isFromDetail;

    public b() {
        Q1(new d("qzone_feed"));
    }

    public final CommonFeed S1() {
        Object data = getData();
        if (data instanceof CommonFeed) {
            return (CommonFeed) data;
        }
        return null;
    }

    /* renamed from: T1, reason: from getter */
    public final boolean getIsFromDetail() {
        return this.isFromDetail;
    }

    public final boolean U1() {
        CommonUser user;
        CommonFeed S1 = S1();
        if (S1 == null) {
            return false;
        }
        CommonCellUserInfo cellUserInfo = S1.getCellUserInfo();
        return Intrinsics.areEqual((cellUserInfo == null || (user = cellUserInfo.getUser()) == null) ? null : user.getUin(), LoginData.getInstance().getUinString());
    }

    public final void W1(CommonFeed feed) {
        R1(feed);
    }

    public final void X1(boolean z16) {
        this.isFromDetail = z16;
    }

    @Override // com.qzone.reborn.share.i, com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QzoneFeedProShareViewModel";
    }
}
