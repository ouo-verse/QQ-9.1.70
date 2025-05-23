package wn2;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.config.SearchConfig;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.troop.api.IDiscussionService;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes18.dex */
public class n extends com.tencent.mobileqq.search.model.k {

    /* renamed from: j0, reason: collision with root package name */
    private static final int[] f445958j0 = {1000, 1004, 1005, 1006, 1001, 10002, 10004, 10010};
    private RecentUser X;
    private long Y;
    private String Z;

    /* renamed from: a0, reason: collision with root package name */
    private String f445959a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f445960b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f445961c0;

    /* renamed from: d0, reason: collision with root package name */
    private String f445962d0;

    /* renamed from: e0, reason: collision with root package name */
    private String f445963e0;

    /* renamed from: f0, reason: collision with root package name */
    private String f445964f0;

    /* renamed from: g0, reason: collision with root package name */
    private String f445965g0;

    /* renamed from: h0, reason: collision with root package name */
    private String f445966h0;

    /* renamed from: i0, reason: collision with root package name */
    private int f445967i0;

    public n(AppInterface appInterface, int i3, RecentUser recentUser, long j3) {
        super(appInterface, i3, j3);
        this.f445967i0 = 1;
        this.X = recentUser;
        S();
    }

    private void S() {
        String qqStr;
        DiscussionMemberInfo discussionMemberInfo;
        RecentUser recentUser = this.X;
        this.f445963e0 = recentUser.uin;
        this.f445962d0 = recentUser.displayName;
        int type = recentUser.getType();
        if (type != 1000) {
            if (type != 1001) {
                if (type != 10002) {
                    if (type != 10004) {
                        if (type != 10010) {
                            switch (type) {
                                case 1004:
                                    Map map = (Map) ((IDiscussionService) this.G.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberInfoMapByUin(this.X.troopUin);
                                    if (map != null && (discussionMemberInfo = (DiscussionMemberInfo) map.get(this.X.uin)) != null) {
                                        String str = discussionMemberInfo.memberName;
                                        if (!TextUtils.isEmpty(discussionMemberInfo.inteRemark)) {
                                            this.f445961c0 = discussionMemberInfo.inteRemark;
                                        }
                                        if (!TextUtils.isEmpty(str)) {
                                            this.f445962d0 = str;
                                        }
                                    }
                                    qqStr = HardCodeUtil.qqStr(R.string.l3e);
                                    String str2 = this.f445962d0;
                                    if (str2 != null && str2.equals(this.X.uin)) {
                                        this.f445962d0 = ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).getBuddyName(this.G, this.X.uin, true);
                                        break;
                                    }
                                    break;
                                case 1005:
                                    qqStr = "wap\u4e34\u65f6\u4f1a\u8bdd";
                                    break;
                                case 1006:
                                    this.f445964f0 = this.X.displayName;
                                    this.f445962d0 = null;
                                    String uinByPhoneNum = ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).getUinByPhoneNum(this.G, this.X.uin);
                                    PhoneContact queryContactByCodeNumber = ((IPhoneContactService) this.G.getRuntimeService(IPhoneContactService.class, "")).queryContactByCodeNumber(this.X.uin);
                                    if (queryContactByCodeNumber != null) {
                                        this.f445964f0 = queryContactByCodeNumber.name;
                                    } else if (uinByPhoneNum != null) {
                                        this.f445964f0 = ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).getBuddyName(this.G, uinByPhoneNum, true);
                                    }
                                    qqStr = HardCodeUtil.qqStr(R.string.l3w);
                                    break;
                                default:
                                    qqStr = HardCodeUtil.qqStr(R.string.l38);
                                    break;
                            }
                        } else {
                            qqStr = HardCodeUtil.qqStr(R.string.f168332fc);
                        }
                    } else {
                        qqStr = "QQ\u7535\u5f71\u7968\u4e34\u65f6\u4f1a\u8bdd";
                    }
                } else {
                    qqStr = HardCodeUtil.qqStr(R.string.l2y);
                }
            } else {
                qqStr = HardCodeUtil.qqStr(R.string.l3q);
            }
        } else {
            String y06 = SearchUtils.y0(this.G, this.X.troopUin);
            TroopMemberInfo troopMemberInfoSync = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberInfoSync(y06, this.X.uin, null, com.tencent.mobileqq.search.model.k.W + "-initData");
            if (troopMemberInfoSync != null) {
                if (!TextUtils.isEmpty(troopMemberInfoSync.troopnick)) {
                    this.f445960b0 = troopMemberInfoSync.troopnick;
                }
                if (!TextUtils.isEmpty(troopMemberInfoSync.autoremark)) {
                    this.f445961c0 = troopMemberInfoSync.autoremark;
                }
                if (!TextUtils.isEmpty(troopMemberInfoSync.friendnick)) {
                    this.f445962d0 = troopMemberInfoSync.friendnick;
                }
            }
            qqStr = HardCodeUtil.qqStr(R.string.l2s);
        }
        if (SearchUtils.F0(this.I)) {
            this.Z = HardCodeUtil.qqStr(R.string.l3t) + qqStr;
        } else {
            this.Z = qqStr;
        }
        if (TextUtils.isEmpty(this.f445962d0) || this.f445962d0.equals(this.f445963e0)) {
            this.f445962d0 = ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).getBuddyName(this.G, this.f445963e0, true);
        }
    }

    private void T() {
        int i3 = this.f445967i0;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            this.f445965g0 = this.f445964f0;
                            this.f445966h0 = this.f445963e0;
                            return;
                        }
                        return;
                    }
                    this.f445965g0 = this.f445961c0;
                    this.f445966h0 = SearchUtils.w(this.f445962d0, this.f445963e0);
                    return;
                }
                this.f445965g0 = this.f445960b0;
                this.f445966h0 = SearchUtils.w(this.f445962d0, this.f445963e0);
                return;
            }
            String w3 = SearchUtils.w(this.f445960b0, this.f445961c0);
            this.f445965g0 = w3;
            if (!TextUtils.isEmpty(w3)) {
                this.f445966h0 = this.f445962d0;
                return;
            } else {
                this.f445965g0 = this.f445962d0;
                this.f445966h0 = this.f445963e0;
                return;
            }
        }
        this.f445965g0 = SearchUtils.w(this.f445960b0, this.f445961c0, this.f445962d0);
        this.f445966h0 = this.f445963e0;
    }

    @Override // com.tencent.mobileqq.search.model.k
    /* renamed from: G */
    public Object getUin() {
        return this.X.uin;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public int H() {
        return 1;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public String K() {
        return this.f445966h0;
    }

    @Override // com.tencent.mobileqq.search.model.k
    /* renamed from: L */
    public String getTitle() {
        return this.f445965g0;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public int M() {
        return this.X.getType();
    }

    @Override // com.tencent.mobileqq.search.model.k
    protected long N(String str) {
        this.f445959a0 = str;
        this.Y = Long.MIN_VALUE;
        long R = R(str, this.f445960b0, com.tencent.mobileqq.search.j.f283423k);
        if (R > this.Y) {
            this.Y = R;
            this.f445967i0 = 2;
        }
        long R2 = R(str, this.f445961c0, com.tencent.mobileqq.search.j.f283428p);
        if (R2 > this.Y) {
            this.Y = R2;
            this.f445967i0 = 3;
        }
        long R3 = R(str, this.f445962d0, com.tencent.mobileqq.search.j.f283429q);
        if (R3 > this.Y) {
            this.Y = R3;
            this.f445967i0 = 1;
        }
        long R4 = R(str, this.f445964f0, com.tencent.mobileqq.search.j.f283430r);
        if (R4 > this.Y) {
            this.Y = R4;
            this.f445967i0 = 4;
        }
        long k06 = SearchUtils.k0(str, this.f445963e0, com.tencent.mobileqq.search.j.f283432t, false);
        if (k06 > this.Y) {
            this.Y = k06;
            this.f445967i0 = 0;
        }
        long j3 = this.Y;
        if (j3 != Long.MIN_VALUE) {
            this.Y = j3 + com.tencent.mobileqq.search.j.H;
            T();
        }
        return this.Y;
    }

    public long R(String str, String str2, long j3) {
        if (this.N) {
            return SearchUtils.o0(str, str2, j3, true, false, false);
        }
        return SearchUtils.j0(str, str2, j3);
    }

    public String getTroopUin() {
        return this.X.troopUin;
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        int type = this.X.getType();
        if (type != 1001) {
            if (type != 1006) {
                if (type != 10002 && type != 10004) {
                    return 1;
                }
                return 32;
            }
            return 11;
        }
        return 32;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.t
    /* renamed from: l */
    public String getUin() {
        return this.X.uin;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: m */
    public CharSequence getDescription() {
        return this.Z;
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
        return this.f445959a0;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.y
    public void v(View view) {
        super.v(view);
        if (SearchUtils.F0(this.I)) {
            ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).markEnterAioFromSearch();
            if (!((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).isRobotUin(this.X.uin)) {
                int type = this.X.getType();
                if (type != 0 && type != 10002 && type != 10004) {
                    if (type != 1000) {
                        if (type != 1001) {
                            switch (type) {
                            }
                        }
                    }
                    ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).markEnterAioFromSearch();
                    ISearchPieceFetcher iSearchPieceFetcher = (ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class);
                    Context context = view.getContext();
                    RecentUser recentUser = this.X;
                    iSearchPieceFetcher.enterTroopTmpChatWin(context, recentUser.uin, recentUser.troopUin, recentUser.getType(), this.f445965g0, false, null, null);
                }
                ISearchPieceFetcher iSearchPieceFetcher2 = (ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class);
                Context context2 = view.getContext();
                AppInterface appInterface = this.G;
                RecentUser recentUser2 = this.X;
                iSearchPieceFetcher2.enterChatWin(context2, appInterface, recentUser2.uin, recentUser2.getType(), this.f445965g0, false);
            } else {
                ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).openRobotProfileCard(view.getContext(), null, this.X.uin);
            }
            SearchUtils.c1(this.f445959a0, 20, 1, view);
            ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.G, this.f445959a0);
            AppInterface appInterface2 = this.G;
            String charSequence = getTitleSpans().toString();
            String str = this.f445963e0;
            RecentUser recentUser3 = this.X;
            String str2 = recentUser3.troopUin;
            if (str2 == null) {
                str2 = "";
            }
            SearchUtils.f1(appInterface2, charSequence, str, str2, recentUser3.getType());
            SearchUtils.Z0(this.f445959a0, 20, view, false);
            SearchUtils.X0(this, view);
            if (SearchConfig.needSeparate) {
                SearchUtils.V0("search", "contact", "contacts", 0, 0, SearchUtils.b0(this.I));
            }
            if (getUin() instanceof String) {
                SearchUtils.o1(this.G, this.f445959a0, this.L, (String) getUin(), H());
            }
            if (((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(view.getContext())) {
                String str3 = this.L;
                if (str3 != null && !TextUtils.isEmpty(str3)) {
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
