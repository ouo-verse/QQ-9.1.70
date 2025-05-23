package v82;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$LimitInfo;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$MiniInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0004R\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017\u00a8\u0006!"}, d2 = {"Lv82/b;", "Lv82/a;", "", "getLogTag", "", "g2", "L", "Ljava/lang/String;", "getUin", "()Ljava/lang/String;", "setUin", "(Ljava/lang/String;)V", "uin", "M", "getConstellationStr", "setConstellationStr", "constellationStr", "", "N", "Z", "d2", "()Z", "f2", "(Z)V", "hasModifyGender", "P", "c2", "e2", "hasModifyBirthday", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b extends a {

    /* renamed from: L, reason: from kotlin metadata */
    private String uin = "";

    /* renamed from: M, reason: from kotlin metadata */
    private String constellationStr = "\u6c34\u74f6\u5ea7";

    /* renamed from: N, reason: from kotlin metadata */
    private boolean hasModifyGender;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean hasModifyBirthday;

    /* renamed from: c2, reason: from getter */
    public final boolean getHasModifyBirthday() {
        return this.hasModifyBirthday;
    }

    /* renamed from: d2, reason: from getter */
    public final boolean getHasModifyGender() {
        return this.hasModifyGender;
    }

    public final void e2(boolean z16) {
        this.hasModifyBirthday = z16;
    }

    public final void f2(boolean z16) {
        this.hasModifyGender = z16;
    }

    public final void g2() {
        QLog.i("QQStrangerRegisterProfileVM", 1, "setMiniUserInfo start.");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            QLog.e("QQStrangerRegisterTagVM", 1, "setMiniUserInfo, but app is null.");
            return;
        }
        userInfo$MiniInfo userinfo_miniinfo = new userInfo$MiniInfo();
        userinfo_miniinfo.open_id.set(getOpenId());
        Boolean isZplanHead = getIsZplanHead();
        boolean booleanValue = isZplanHead != null ? isZplanHead.booleanValue() : false;
        if (booleanValue) {
            userinfo_miniinfo.avatar.set("");
            userinfo_miniinfo.head_type.set(1);
        } else {
            userinfo_miniinfo.avatar.set(getAvatar());
            userinfo_miniinfo.head_type.set(0);
        }
        userinfo_miniinfo.birthday.set(M1().getValue());
        userinfo_miniinfo.nick.set(getNickName());
        QLog.i("QQStrangerRegisterProfileVM", 1, "setMiniUserInfo isZplanHead? " + booleanValue);
        userInfo$LimitInfo userinfo_limitinfo = new userInfo$LimitInfo();
        userinfo_limitinfo.limit_birth.set(this.hasModifyBirthday);
        userinfo_limitinfo.limit_gender.set(this.hasModifyGender);
        userinfo_miniinfo.limit_info.set(userinfo_limitinfo);
        Short value = P1().getValue();
        if (value != null) {
            userinfo_miniinfo.gender.set(value.shortValue() + 1);
        }
        ArrayList arrayList = new ArrayList();
        if (!booleanValue) {
            arrayList.add(1);
        }
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(7);
        arrayList.add(27);
        arrayList.add(29);
        com.tencent.mobileqq.matchfriend.request.a.b(appInterface, userinfo_miniinfo, getOpenId(), arrayList, 2);
    }

    @Override // v82.a, com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QQStrangerRegisterProfileVM";
    }
}
