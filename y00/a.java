package y00;

import NS_KING_SOCIALIZE_META.stMetaNumericSys;
import NS_KING_SOCIALIZE_META.stShareInfo;
import UserGrowth.stGetPersonalInfoRsp;
import UserGrowth.stSimpleMetaPerson;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.pubaccount.weishi.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\b&\u0018\u0000 S2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001TB\u0007\u00a2\u0006\u0004\bQ\u0010RJ\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J$\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\nH\u0002J\u0018\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\nH\u0002J\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\nH\u0002J\u0012\u0010\u001c\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u001c\u0010\u001d\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\nH\u0016J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\nH\u0016J\b\u0010\"\u001a\u00020\nH\u0016J\b\u0010#\u001a\u00020\nH\u0016J\u0012\u0010$\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010'\u001a\u00020\u000e2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J$\u0010+\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030)\u0018\u00010(j\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030)\u0018\u0001`*H\u0016J\b\u0010,\u001a\u00020\u000eH\u0016J\u0012\u0010-\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010.\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010/\u001a\u00020\fH\u0016J\n\u00101\u001a\u0004\u0018\u000100H\u0016J\b\u00102\u001a\u00020\nH\u0016J\u0010\u00104\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\fH\u0016J\n\u00105\u001a\u0004\u0018\u00010\fH\u0016J\b\u00106\u001a\u00020\nH\u0016J\b\u00107\u001a\u00020\nH\u0016J\u0012\u0010:\u001a\u00020\u000e2\b\u00109\u001a\u0004\u0018\u000108H\u0016J\u001a\u0010=\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u00072\b\u0010<\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010?\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020\u0007H\u0016J\u001a\u0010A\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010@\u001a\u00020\nH\u0004J\b\u0010B\u001a\u00020\u000eH\u0004R\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010K\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u00103\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010P\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010O\u00a8\u0006U"}, d2 = {"Ly00/a;", "Lcom/tencent/biz/pubaccount/weishi/presenter/a;", "Lcom/tencent/biz/pubaccount/weishi/profile/d;", "Lcom/tencent/biz/pubaccount/weishi/profile/c;", "Lcom/tencent/biz/pubaccount/weishi/profile/a;", "LUserGrowth/stSimpleMetaPerson;", "person", "", "y0", "A0", "", "hasFollowed", "", "personId", "", "C0", "posterId", "feedId", "isDing", "D0", WidgetCacheConstellationData.NUM, "isIncrease", "z0", "followStatus", "isShowPraise", "E0", "Landroid/os/Bundle;", "arguments", "o0", "T", "isSelectedByClickAvatar", "u", "fragmentVisible", "W", ExifInterface.LATITUDE_SOUTH, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "B0", "Lcom/tencent/biz/pubaccount/weishi/event/WSSimpleBaseEvent;", "event", "b", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "l0", "H0", "B", "q0", "LNS_KING_SOCIALIZE_META/stShareInfo;", "getShareInfo", "r0", "from", "G0", "getFrom", "j0", "k", "LUserGrowth/stGetPersonalInfoRsp;", "rsp", "P", "errCode", "errMsg", "onFail", "position", "m0", "isHost", "I0", "F0", "Lx00/a;", "f", "Lx00/a;", "profileHomePageFetcher", h.F, "LUserGrowth/stSimpleMetaPerson;", "i", "LNS_KING_SOCIALIZE_META/stShareInfo;", "shareInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", BdhLogUtil.LogTag.Tag_Conn, "Z", "isLoadingData", "<init>", "()V", "D", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public abstract class a extends com.tencent.biz.pubaccount.weishi.presenter.a<com.tencent.biz.pubaccount.weishi.profile.d> implements com.tencent.biz.pubaccount.weishi.profile.c, com.tencent.biz.pubaccount.weishi.profile.a {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isLoadingData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final x00.a profileHomePageFetcher = new x00.a();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private stSimpleMetaPerson person;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private stShareInfo shareInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String from;

    private final void C0(boolean hasFollowed, String personId) {
        boolean z16;
        boolean isBlank;
        com.tencent.biz.pubaccount.weishi.profile.d x06 = x0();
        stSimpleMetaPerson stsimplemetaperson = this.person;
        stMetaNumericSys stmetanumericsys = stsimplemetaperson != null ? stsimplemetaperson.nueric : null;
        if (x06 == null || TextUtils.isEmpty(personId) || stsimplemetaperson == null) {
            return;
        }
        String str = stsimplemetaperson.f25130id;
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (!z16 || stmetanumericsys == null) {
                }
                if (Intrinsics.areEqual(personId, stsimplemetaperson.f25130id)) {
                    int p16 = bb.p(stsimplemetaperson.followStatus, hasFollowed);
                    stsimplemetaperson.followStatus = p16;
                    x06.Oe(p16);
                    int z06 = z0(stmetanumericsys.fans_num, hasFollowed);
                    stmetanumericsys.fans_num = z06;
                    x06.p(z06);
                    x.j("WSProfilePresenter", "personId = " + personId + ", newFollowStatus = " + p16 + ", newFansCnt = " + z06);
                    return;
                }
                if (Intrinsics.areEqual(stsimplemetaperson.f25130id, bb.q())) {
                    int z07 = z0(stmetanumericsys.interest_num, hasFollowed);
                    stmetanumericsys.interest_num = z07;
                    x06.n(z07);
                    x.j("WSProfilePresenter", "personId = " + personId + ", newFollowCnt = " + z07);
                    return;
                }
                return;
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    private final void D0(String posterId, String feedId, boolean isDing) {
        com.tencent.biz.pubaccount.weishi.profile.d x06 = x0();
        stSimpleMetaPerson stsimplemetaperson = this.person;
        stMetaNumericSys stmetanumericsys = stsimplemetaperson != null ? stsimplemetaperson.nueric : null;
        if (x06 == null || TextUtils.isEmpty(posterId) || TextUtils.isEmpty(feedId) || stsimplemetaperson == null || stmetanumericsys == null || !Intrinsics.areEqual(posterId, stsimplemetaperson.f25130id)) {
            return;
        }
        int z06 = z0(stmetanumericsys.receivepraise_num, isDing);
        stmetanumericsys.receivepraise_num = z06;
        x06.ja(z06);
    }

    private final void E0(int followStatus, boolean isShowPraise) {
        if (r0()) {
            com.tencent.biz.pubaccount.weishi.profile.b.m(this.from, q0());
        } else {
            com.tencent.biz.pubaccount.weishi.profile.b.l(this.from, q0(), followStatus, isShowPraise);
        }
    }

    private final int z0(int num, boolean isIncrease) {
        if (isIncrease) {
            return num + 1;
        }
        int i3 = num - 1;
        if (i3 < 0) {
            return 0;
        }
        return i3;
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.c
    /* renamed from: B, reason: from getter */
    public stSimpleMetaPerson getPerson() {
        return this.person;
    }

    public void B0(String personId) {
        if (this.isLoadingData) {
            x.j("WSProfilePresenter", "is loading data.");
            return;
        }
        if (this.profileHomePageFetcher.a(personId, this)) {
            this.isLoadingData = true;
            return;
        }
        com.tencent.biz.pubaccount.weishi.profile.d x06 = x0();
        if (x06 != null) {
            x06.hideLoading();
        }
    }

    public void G0(String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        this.from = from;
    }

    public void H0(stSimpleMetaPerson person) {
        this.person = person;
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.a
    public void P(stGetPersonalInfoRsp rsp) {
        boolean isBlank;
        com.tencent.biz.pubaccount.weishi.profile.d x06 = x0();
        stSimpleMetaPerson stsimplemetaperson = rsp != null ? rsp.info : null;
        if (stsimplemetaperson != null && x06 != null) {
            stSimpleMetaPerson stsimplemetaperson2 = this.person;
            String str = stsimplemetaperson2 != null ? stsimplemetaperson2.f25130id : null;
            if (str == null) {
                str = "";
            }
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank && !Intrinsics.areEqual(str, stsimplemetaperson.f25130id)) {
                x.j("WSProfilePresenter", "no same person. mPerson.id = " + str + ", rsp.pid = " + stsimplemetaperson.f25130id);
                return;
            }
            x.j("WSProfilePresenter", "onSuccess() pid = " + stsimplemetaperson.f25130id + ", nick = " + stsimplemetaperson.nick + ", isShowPraisedFeed = " + rsp.isShowPraisedFeed);
            this.isLoadingData = false;
            this.person = stsimplemetaperson;
            this.shareInfo = rsp.share_info;
            boolean z16 = rsp.isShowPraisedFeed == 1;
            x06.nb(stsimplemetaperson, Intrinsics.areEqual(stsimplemetaperson.f25130id, bb.q()));
            String str2 = stsimplemetaperson.nick;
            x06.z4(str2 != null ? str2 : "");
            x06.t4(y0(this.person), A0(this.person), z16);
            x06.hideLoading();
            E0(rsp.info.followStatus, z16);
            return;
        }
        x.j("WSProfilePresenter", "rsp is null.");
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.c
    public boolean S() {
        return false;
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.c
    public void b(WSSimpleBaseEvent event) {
        if (event instanceof FollowEvent) {
            FollowEvent followEvent = (FollowEvent) event;
            C0(followEvent.hasFollowed(), followEvent.getPersonId());
        } else if (event instanceof LikeRspEvent) {
            LikeRspEvent likeRspEvent = (LikeRspEvent) event;
            if (likeRspEvent.getRpsStatus() == 4301 && likeRspEvent.isFromRsp()) {
                D0(likeRspEvent.getPosterId(), likeRspEvent.getFeedId(), likeRspEvent.getRspIsDing() == 1);
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.c
    public ArrayList<Class<?>> getEventClass() {
        ArrayList<Class<?>> arrayList = new ArrayList<>();
        arrayList.add(FollowEvent.class);
        arrayList.add(LikeRspEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.c
    public String getFrom() {
        return this.from;
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.c
    public stShareInfo getShareInfo() {
        return this.shareInfo;
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.c
    public boolean j0() {
        return false;
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.c
    public boolean k() {
        return r0();
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.c
    public void l0() {
        B0(q0());
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.a
    public void onFail(int errCode, String errMsg) {
        com.tencent.biz.pubaccount.weishi.profile.d x06 = x0();
        if (x06 == null) {
            return;
        }
        this.isLoadingData = false;
        x06.O0(errCode, errMsg);
        x06.hideLoading();
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.c
    public String q0() {
        stSimpleMetaPerson stsimplemetaperson = this.person;
        String str = stsimplemetaperson != null ? stsimplemetaperson.f25130id : null;
        return str == null ? "" : str;
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.c
    public boolean r0() {
        stSimpleMetaPerson stsimplemetaperson = this.person;
        return Intrinsics.areEqual(stsimplemetaperson != null ? stsimplemetaperson.f25130id : null, bb.q());
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.c
    public boolean z() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void F0() {
        this.person = null;
        this.shareInfo = null;
        this.isLoadingData = false;
        com.tencent.biz.pubaccount.weishi.profile.d x06 = x0();
        if (x06 != null) {
            x06.reset();
        }
    }

    private final int A0(stSimpleMetaPerson person) {
        stMetaNumericSys stmetanumericsys;
        if (person == null || (stmetanumericsys = person.nueric) == null) {
            return 0;
        }
        return stmetanumericsys.praise_num;
    }

    private final int y0(stSimpleMetaPerson person) {
        stMetaNumericSys stmetanumericsys;
        if (person == null || (stmetanumericsys = person.nueric) == null) {
            return 0;
        }
        return stmetanumericsys.feed_num;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void I0(stSimpleMetaPerson person, boolean isHost) {
        com.tencent.biz.pubaccount.weishi.profile.d x06;
        if (person == null || (x06 = x0()) == null) {
            return;
        }
        x06.nb(person, isHost);
        x06.h2();
        x06.h6(person.f25130id);
        x06.oh(getFrom());
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.c
    public void o0(Bundle arguments) {
        if (arguments == null) {
            return;
        }
        String string = arguments.getString("key_pid", "");
        stSimpleMetaPerson stsimplemetaperson = (stSimpleMetaPerson) arguments.getSerializable("key_person");
        if (stsimplemetaperson == null) {
            stsimplemetaperson = new stSimpleMetaPerson();
            stsimplemetaperson.f25130id = string;
        }
        H0(stsimplemetaperson);
        String string2 = arguments.getString("from", "");
        Intrinsics.checkNotNullExpressionValue(string2, "arguments.getString(WSProfileIntentKey.FROM, \"\")");
        G0(string2);
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.c
    public void m0(int position) {
        if (position == 0) {
            com.tencent.biz.pubaccount.weishi.profile.b.z(this.from, q0());
        } else {
            if (position != 1) {
                return;
            }
            com.tencent.biz.pubaccount.weishi.profile.b.v(this.from, q0());
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.c
    public void W(boolean fragmentVisible) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.c
    public void u(boolean isSelectedByClickAvatar) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.c
    public void T(stSimpleMetaPerson person, String feedId) {
    }
}
