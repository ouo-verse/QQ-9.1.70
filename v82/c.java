package v82;

import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$Tag;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0004J\u0014\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a8\u0006\u000e"}, d2 = {"Lv82/c;", "Lv82/a;", "", "getLogTag", "", "c2", "", "Lcom/tencent/trpcprotocol/kuolie/user_info/user_info/userInfo$Tag;", "selectedTags", "d2", "<init>", "()V", "L", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c extends a {
    public final void c2() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            QLog.e("QQStrangerRegisterTagVM", 1, "fetchAllTags, but app is null.");
        } else {
            com.tencent.mobileqq.matchfriend.request.a.a(appInterface, 2);
        }
    }

    public final void d2(List<userInfo$Tag> selectedTags) {
        Intrinsics.checkNotNullParameter(selectedTags, "selectedTags");
        if (selectedTags.size() <= 0) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            QLog.e("QQStrangerRegisterTagVM", 1, "updateUserTag, but app is null.");
        } else {
            com.tencent.mobileqq.matchfriend.request.a.c(appInterface, getOpenId(), selectedTags, 0, 2);
        }
    }

    @Override // v82.a, com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QQStrangerRegisterTagVM";
    }
}
