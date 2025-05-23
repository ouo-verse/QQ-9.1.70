package wn2;

import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.config.SearchConfig;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.am;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import org.json.JSONObject;

/* compiled from: P */
@Deprecated
/* loaded from: classes18.dex */
public class g extends com.tencent.mobileqq.search.model.k {
    public String X;
    protected String Y;
    protected String Z;

    /* renamed from: a0, reason: collision with root package name */
    protected String f445908a0;

    /* renamed from: b0, reason: collision with root package name */
    protected String f445909b0;

    /* renamed from: c0, reason: collision with root package name */
    protected long f445910c0;

    /* renamed from: d0, reason: collision with root package name */
    protected int f445911d0;

    /* renamed from: e0, reason: collision with root package name */
    protected String f445912e0;

    /* renamed from: f0, reason: collision with root package name */
    protected String f445913f0;

    /* renamed from: g0, reason: collision with root package name */
    protected String f445914g0;

    /* renamed from: h0, reason: collision with root package name */
    protected String f445915h0;

    /* renamed from: i0, reason: collision with root package name */
    protected boolean f445916i0;

    /* renamed from: j0, reason: collision with root package name */
    protected TroopInfo f445917j0;

    /* renamed from: k0, reason: collision with root package name */
    protected long f445918k0;

    public g(AppInterface appInterface, int i3, String str, String str2, String str3, String str4, String str5) {
        super(appInterface, i3, 0L);
        this.f445918k0 = com.tencent.mobileqq.search.j.f283415d0;
        this.X = str;
        this.Y = str2;
        this.Z = str3;
        this.f445908a0 = str4;
        this.f445909b0 = str5;
        TroopInfo w06 = SearchUtils.w0(appInterface, str);
        this.f445917j0 = w06;
        if (w06.isNewTroop()) {
            this.f445916i0 = true;
            this.f445918k0 = com.tencent.mobileqq.search.j.O;
        }
        C(6);
        D(this.Y);
    }

    private void R() {
        int i3 = this.f445911d0;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        this.f445913f0 = "";
                        this.f445914g0 = null;
                        return;
                    } else if (!TextUtils.isEmpty(this.f445909b0)) {
                        this.f445913f0 = this.f445909b0;
                        this.f445914g0 = this.f445908a0;
                        return;
                    } else if (!TextUtils.isEmpty(this.f445908a0)) {
                        this.f445913f0 = this.f445908a0;
                        this.f445914g0 = this.Y;
                        return;
                    } else {
                        this.f445913f0 = this.Y;
                        this.f445914g0 = null;
                        return;
                    }
                }
                this.f445913f0 = this.Z;
                if (!TextUtils.isEmpty(this.f445908a0)) {
                    this.f445914g0 = this.f445908a0;
                    return;
                } else {
                    this.f445914g0 = this.Y;
                    return;
                }
            }
            if (!TextUtils.isEmpty(this.Z)) {
                this.f445913f0 = this.Z;
                this.f445914g0 = this.f445908a0;
                return;
            } else {
                this.f445913f0 = this.f445908a0;
                this.f445914g0 = this.Y;
                return;
            }
        }
        if (!TextUtils.isEmpty(this.Z)) {
            this.f445913f0 = this.Z;
            this.f445914g0 = this.Y;
        } else if (!TextUtils.isEmpty(this.f445908a0)) {
            this.f445913f0 = this.f445908a0;
            this.f445914g0 = this.Y;
        } else {
            this.f445913f0 = this.Y;
            this.f445914g0 = null;
        }
    }

    @Override // com.tencent.mobileqq.search.model.z
    public JSONObject A() {
        String str;
        int i3 = this.f445911d0;
        if (i3 == 0) {
            str = "uin";
        } else if (i3 == 1) {
            str = "nickname";
        } else if (i3 == 2) {
            str = "crad";
        } else if (i3 == 3) {
            str = "remark";
        } else {
            str = QzoneWebMusicJsPlugin.EVENT_UNKOWN;
        }
        String str2 = str;
        com.tencent.mobileqq.search.business.contact.entity.a aVar = new com.tencent.mobileqq.search.business.contact.entity.a();
        aVar.f282926d = this.f445916i0;
        return am.a(this.f445912e0, this.J, str2, this.f445910c0, aVar, "TroopMember", 0L);
    }

    @Override // com.tencent.mobileqq.search.model.k
    public Object G() {
        return this.Y;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public int H() {
        return 1;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public String K() {
        return this.f445914g0;
    }

    @Override // com.tencent.mobileqq.search.model.k
    /* renamed from: L */
    public String getTitle() {
        return this.f445913f0;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public int M() {
        return 1000;
    }

    @Override // com.tencent.mobileqq.search.model.k
    protected long N(String str) {
        long j3;
        long j16;
        long j17;
        this.f445915h0 = str;
        this.f445910c0 = Long.MIN_VALUE;
        boolean z16 = !this.f445917j0.isNewTroop();
        if (this.f445917j0.isNewTroop()) {
            j3 = com.tencent.mobileqq.search.j.f283426n;
        } else {
            j3 = com.tencent.mobileqq.search.j.f283423k;
        }
        long l06 = SearchUtils.l0(str, this.f445909b0, j3, false, false, z16);
        if (l06 > this.f445910c0) {
            this.f445910c0 = l06;
            this.f445911d0 = 3;
            this.f445912e0 = this.f445909b0;
        }
        if (this.f445910c0 == Long.MIN_VALUE) {
            if (this.f445917j0.isNewTroop()) {
                j17 = com.tencent.mobileqq.search.j.f283425m;
            } else {
                j17 = com.tencent.mobileqq.search.j.f283434v;
            }
            long l07 = SearchUtils.l0(str, this.Z, j17, false, false, z16);
            if (l07 > this.f445910c0) {
                this.f445910c0 = l07;
                this.f445911d0 = 2;
                this.f445912e0 = this.Z;
            }
        }
        if (this.f445910c0 == Long.MIN_VALUE) {
            if (this.f445917j0.isNewTroop()) {
                j16 = com.tencent.mobileqq.search.j.f283424l;
            } else {
                j16 = com.tencent.mobileqq.search.j.f283429q;
            }
            long l08 = SearchUtils.l0(str, this.f445908a0, j16, false, false, z16);
            if (l08 > this.f445910c0) {
                this.f445910c0 = l08;
                this.f445911d0 = 1;
                this.f445912e0 = this.f445908a0;
            }
        }
        if (this.f445910c0 == Long.MIN_VALUE) {
            long l09 = SearchUtils.l0(str, this.Y, com.tencent.mobileqq.search.j.f283432t, false, true, true);
            if (l09 > this.f445910c0) {
                this.f445910c0 = l09;
                this.f445911d0 = 0;
                this.f445912e0 = this.Y;
            }
        }
        QLog.d("ContactSearchModelGlobalTroopMember", 4, "match uin=", this.Y, " mMatchField=", Integer.valueOf(this.f445911d0), "mMatchValue=" + this.f445912e0, "[mMemberName=", this.f445908a0, " mMemberRemark=", this.f445909b0, " mMemberCard=", this.Z, "]");
        long j18 = this.f445910c0;
        if (j18 != Long.MIN_VALUE) {
            this.f445910c0 = j18 + this.f445918k0;
            R();
        }
        return this.f445910c0;
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        return 1;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.t
    /* renamed from: l */
    public String getUin() {
        return this.Y;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: m */
    public CharSequence getDescription() {
        String troopName = ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).getTroopName(this.G, this.X, true);
        if (troopName != null) {
            return HardCodeUtil.qqStr(R.string.l2m) + troopName;
        }
        return HardCodeUtil.qqStr(R.string.l2e);
    }

    @Override // com.tencent.mobileqq.search.model.y
    public CharSequence o() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public boolean r() {
        return false;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: s */
    public String getKeyword() {
        return this.f445915h0;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.y
    public void v(View view) {
        super.v(view);
        if (SearchUtils.F0(this.I)) {
            ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).markEnterAioFromSearch();
            String v06 = SearchUtils.v0(this.G, this.X);
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d o16 = SearchUtils.o(this.Y);
            if (!((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).isRobotUin(this.Y)) {
                if (o16 != null && o16.B()) {
                    ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).enterChatWin(view.getContext(), this.G, this.Y, 0, SearchUtils.x(o16), false);
                    SearchUtils.f1(this.G, SearchUtils.x(o16), this.Y, "", 0);
                } else {
                    ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).enterTroopTmpChatWin(view.getContext(), this.Y, this.X, 1000, getTitle().toString(), false, null, null);
                    String charSequence = getTitle().toString();
                    if (TextUtils.isEmpty(charSequence)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("ContactSearchModelGlobalTroopMember", 2, "saveSearchHistory title is null");
                        }
                        charSequence = getTitle();
                        if (TextUtils.isEmpty(charSequence)) {
                            if (QLog.isColorLevel()) {
                                QLog.d("ContactSearchModelGlobalTroopMember", 2, "saveSearchHistory titlestr is null");
                            }
                            charSequence = K();
                        }
                    }
                    SearchUtils.f1(this.G, charSequence, this.Y, v06, 1000);
                }
            } else {
                ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).openRobotProfileCard(view.getContext(), null, this.Y);
                SearchUtils.f1(this.G, getTitle().toString(), this.Y, v06, 1000);
            }
            ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.G, this.f445915h0);
            SearchUtils.c1(this.f445915h0, 20, 1, view);
            SearchUtils.Z0(this.f445915h0, 20, view, false);
            SearchUtils.X0(this, view);
            if (SearchConfig.needSeparate) {
                SearchUtils.V0("search", "contact", "contacts", 0, 0, SearchUtils.b0(this.I));
            }
            if ((G() instanceof String) && !this.M) {
                SearchUtils.o1(this.G, this.f445915h0, this.L, (String) G(), H());
            }
            if (((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(view.getContext())) {
                String str = this.L;
                if (str != null && !TextUtils.isEmpty(str)) {
                    com.tencent.mobileqq.search.report.b.e(null, 0, this.I, "0X8009D31", 1, 0, null, null);
                } else {
                    com.tencent.mobileqq.search.report.b.e(null, 0, this.I, "0X8009D37", 0, 0, null, null);
                }
            }
        }
    }
}
