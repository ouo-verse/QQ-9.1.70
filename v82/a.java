package v82;

import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$Birthday;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b \b\u0016\u0018\u0000 82\u00020\u0001:\u00019B\u0007\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\tR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0010\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R$\u0010,\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001f\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00048\u0006\u00a2\u0006\f\n\u0004\b-\u0010\u0007\u001a\u0004\b.\u0010\tR\u001d\u00102\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00048\u0006\u00a2\u0006\f\n\u0004\b0\u0010\u0007\u001a\u0004\b1\u0010\tR\u001d\u00105\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b3\u0010\u0007\u001a\u0004\b4\u0010\t\u00a8\u0006:"}, d2 = {"Lv82/a;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "getLogTag", "Landroidx/lifecycle/MutableLiveData;", "", "i", "Landroidx/lifecycle/MutableLiveData;", "P1", "()Landroidx/lifecycle/MutableLiveData;", "gender", "Lcom/tencent/trpcprotocol/kuolie/user_info/user_info/userInfo$Birthday;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "M1", "birthday", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "Q1", "()Ljava/lang/String;", "Z1", "(Ljava/lang/String;)V", "nickName", "D", "L1", "W1", "avatar", "", "E", "Z", "T1", "()Z", "X1", "(Z)V", "isNewUser", UserInfo.SEX_FEMALE, "R1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "openId", "G", "Ljava/lang/Boolean;", "U1", "()Ljava/lang/Boolean;", "b2", "(Ljava/lang/Boolean;)V", "isZplanHead", "H", "N1", "confirmBtnClick", "I", "S1", "isConfirmBtnDisable", "J", "O1", "confirmBtnText", "<init>", "()V", "K", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public class a extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private String nickName;

    /* renamed from: D, reason: from kotlin metadata */
    private String avatar;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isNewUser;

    /* renamed from: F, reason: from kotlin metadata */
    private String openId;

    /* renamed from: G, reason: from kotlin metadata */
    private Boolean isZplanHead;

    /* renamed from: H, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> confirmBtnClick;

    /* renamed from: I, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> isConfirmBtnDisable;

    /* renamed from: J, reason: from kotlin metadata */
    private final MutableLiveData<String> confirmBtnText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Short> gender = new MutableLiveData<>((short) 0);

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<userInfo$Birthday> birthday;

    public a() {
        userInfo$Birthday userinfo_birthday = new userInfo$Birthday();
        userinfo_birthday.year.set(2000);
        userinfo_birthday.month.set(2);
        userinfo_birthday.day.set(23);
        this.birthday = new MutableLiveData<>(userinfo_birthday);
        this.nickName = "";
        this.avatar = "";
        this.isNewUser = true;
        this.openId = "";
        this.confirmBtnClick = new MutableLiveData<>(null);
        this.isConfirmBtnDisable = new MutableLiveData<>(Boolean.FALSE);
        this.confirmBtnText = new MutableLiveData<>("\u6309\u94ae");
    }

    /* renamed from: L1, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    public final MutableLiveData<userInfo$Birthday> M1() {
        return this.birthday;
    }

    public final MutableLiveData<Boolean> N1() {
        return this.confirmBtnClick;
    }

    public final MutableLiveData<String> O1() {
        return this.confirmBtnText;
    }

    public final MutableLiveData<Short> P1() {
        return this.gender;
    }

    /* renamed from: Q1, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    /* renamed from: R1, reason: from getter */
    public final String getOpenId() {
        return this.openId;
    }

    public final MutableLiveData<Boolean> S1() {
        return this.isConfirmBtnDisable;
    }

    /* renamed from: T1, reason: from getter */
    public final boolean getIsNewUser() {
        return this.isNewUser;
    }

    /* renamed from: U1, reason: from getter */
    public final Boolean getIsZplanHead() {
        return this.isZplanHead;
    }

    public final void W1(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.avatar = str;
    }

    public final void X1(boolean z16) {
        this.isNewUser = z16;
    }

    public final void Z1(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nickName = str;
    }

    public final void a2(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.openId = str;
    }

    public final void b2(Boolean bool) {
        this.isZplanHead = bool;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QQStrangerRegisterBaseVM";
    }
}
