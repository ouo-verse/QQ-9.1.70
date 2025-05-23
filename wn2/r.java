package wn2;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.api.ISearchTroopMemberApi;
import com.tencent.mobileqq.search.config.SearchConfig;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.am;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class r extends com.tencent.mobileqq.search.model.k {
    private TroopMemberInfo X;
    private String Y;
    private long Z;

    /* renamed from: a0, reason: collision with root package name */
    private int f445981a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f445982b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f445983c0;

    /* renamed from: d0, reason: collision with root package name */
    private String f445984d0;

    /* renamed from: e0, reason: collision with root package name */
    private final boolean f445985e0;

    public r(AppInterface appInterface, int i3, TroopMemberInfo troopMemberInfo) {
        super(appInterface, i3, 0L);
        this.f445981a0 = 1;
        this.f445985e0 = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105882", true);
        this.X = troopMemberInfo;
        C(6);
        D(troopMemberInfo.memberuin);
    }

    private void R() {
        if (this.f445985e0) {
            S();
            return;
        }
        int i3 = this.f445981a0;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        TroopMemberInfo troopMemberInfo = this.X;
                        this.f445983c0 = troopMemberInfo.autoremark;
                        this.f445984d0 = SearchUtils.w(troopMemberInfo.friendnick, troopMemberInfo.memberuin);
                        return;
                    }
                    return;
                }
                TroopMemberInfo troopMemberInfo2 = this.X;
                this.f445983c0 = troopMemberInfo2.troopnick;
                this.f445984d0 = SearchUtils.w(troopMemberInfo2.friendnick, troopMemberInfo2.memberuin);
                return;
            }
            TroopMemberInfo troopMemberInfo3 = this.X;
            String w3 = SearchUtils.w(troopMemberInfo3.troopnick, troopMemberInfo3.autoremark);
            this.f445983c0 = w3;
            if (!TextUtils.isEmpty(w3)) {
                this.f445984d0 = this.X.friendnick;
                return;
            }
            TroopMemberInfo troopMemberInfo4 = this.X;
            this.f445983c0 = troopMemberInfo4.friendnick;
            this.f445984d0 = troopMemberInfo4.memberuin;
            return;
        }
        TroopMemberInfo troopMemberInfo5 = this.X;
        this.f445983c0 = SearchUtils.w(troopMemberInfo5.troopnick, troopMemberInfo5.autoremark, troopMemberInfo5.friendnick);
        this.f445984d0 = this.X.memberuin;
    }

    private void S() {
        int i3 = this.f445981a0;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        TroopMemberInfo troopMemberInfo = this.X;
                        this.f445983c0 = troopMemberInfo.autoremark;
                        this.f445984d0 = troopMemberInfo.memberuin;
                        return;
                    }
                    return;
                }
                TroopMemberInfo troopMemberInfo2 = this.X;
                this.f445983c0 = troopMemberInfo2.troopnick;
                this.f445984d0 = troopMemberInfo2.memberuin;
                return;
            }
            TroopMemberInfo troopMemberInfo3 = this.X;
            this.f445983c0 = troopMemberInfo3.friendnick;
            this.f445984d0 = troopMemberInfo3.memberuin;
            return;
        }
        TroopMemberInfo troopMemberInfo4 = this.X;
        this.f445983c0 = SearchUtils.w(troopMemberInfo4.troopnick, troopMemberInfo4.autoremark, troopMemberInfo4.friendnick);
        this.f445984d0 = this.X.memberuin;
    }

    @Override // com.tencent.mobileqq.search.model.z
    public JSONObject A() {
        String str;
        int i3 = this.f445981a0;
        if (i3 == 0) {
            str = "uin";
        } else if (i3 == 1) {
            str = "nickname";
        } else if (i3 == 2) {
            str = "remark";
        } else if (i3 == 3) {
            str = "inteRemark";
        } else {
            str = QzoneWebMusicJsPlugin.EVENT_UNKOWN;
        }
        return am.a(this.f445982b0, this.J, str, this.Z, null, "TroopMember", 0L);
    }

    @Override // com.tencent.mobileqq.search.model.k
    public Object G() {
        return this.X.memberuin;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public int H() {
        return 1;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public String K() {
        return this.f445984d0;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public String L() {
        return this.f445983c0;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public int M() {
        return 1000;
    }

    @Override // com.tencent.mobileqq.search.model.k
    protected long N(String str) {
        this.Y = str;
        this.Z = Long.MIN_VALUE;
        long j06 = SearchUtils.j0(str, this.X.troopnick, com.tencent.mobileqq.search.j.f283423k);
        if (j06 > this.Z) {
            this.Z = j06;
            this.f445981a0 = 2;
            this.f445982b0 = this.X.troopnick;
        }
        long j07 = SearchUtils.j0(str, this.X.autoremark, com.tencent.mobileqq.search.j.f283428p);
        if (j07 > this.Z) {
            this.Z = j07;
            this.f445981a0 = 3;
            this.f445982b0 = this.X.autoremark;
        }
        long j08 = SearchUtils.j0(str, this.X.friendnick, com.tencent.mobileqq.search.j.f283429q);
        if (j08 > this.Z) {
            this.Z = j08;
            this.f445981a0 = 1;
            this.f445982b0 = this.X.friendnick;
        }
        long k06 = SearchUtils.k0(str, this.X.memberuin, com.tencent.mobileqq.search.j.f283432t, false);
        if (k06 > this.Z) {
            this.Z = k06;
            this.f445981a0 = 0;
            this.f445982b0 = this.X.memberuin;
        }
        long j3 = this.Z;
        if (j3 != Long.MIN_VALUE) {
            this.Z = j3 + com.tencent.mobileqq.search.j.H;
            R();
        }
        return this.Z;
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        return 1;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.t
    public String l() {
        return this.X.memberuin;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public CharSequence m() {
        if (SearchUtils.F0(this.I)) {
            return HardCodeUtil.qqStr(R.string.f171804l32);
        }
        if (this.I == 29 && !((ISearchTroopMemberApi) QRoute.api(ISearchTroopMemberApi.class)).canSelectToRemove(this.X)) {
            return HardCodeUtil.qqStr(R.string.f212155mr);
        }
        return HardCodeUtil.qqStr(R.string.l2t);
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
    public String s() {
        return this.Y;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.y
    public void v(View view) {
        super.v(view);
        if (SearchUtils.F0(this.I)) {
            ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).markEnterAioFromSearch();
            ISearchPieceFetcher iSearchPieceFetcher = (ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class);
            Context context = view.getContext();
            TroopMemberInfo troopMemberInfo = this.X;
            iSearchPieceFetcher.enterTroopTmpChatWin(context, troopMemberInfo.memberuin, troopMemberInfo.troopuin, 1000, L(), false, null, null);
            SearchUtils.c1(this.Y, 20, 1, view);
            SearchUtils.Z0(this.Y, 20, view, false);
            SearchUtils.X0(this, view);
            if (SearchConfig.needSeparate) {
                SearchUtils.V0("search", "contact", "contacts", 0, 0, SearchUtils.b0(this.I));
            }
            if ((G() instanceof String) && !this.M) {
                SearchUtils.o1(this.G, this.Y, this.L, (String) G(), H());
            }
            if (((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(view.getContext())) {
                String str = this.L;
                if (str != null && !TextUtils.isEmpty(str)) {
                    com.tencent.mobileqq.search.report.b.e(null, 0, this.I, "0X8009D31", 1, 0, null, null);
                    return;
                } else {
                    com.tencent.mobileqq.search.report.b.e(null, 0, this.I, "0X8009D37", 0, 0, null, null);
                    return;
                }
            }
            return;
        }
        SearchUtils.l1(view, this);
    }
}
