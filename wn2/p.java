package wn2;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.bless.api.IBlessApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class p extends com.tencent.mobileqq.search.model.k {
    private long X;
    private String Y;
    private int Z;

    /* renamed from: a0, reason: collision with root package name */
    private String f445968a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f445969b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f445970c0;

    /* renamed from: d0, reason: collision with root package name */
    private String f445971d0;

    /* renamed from: e0, reason: collision with root package name */
    private long f445972e0;

    public p(AppInterface appInterface, int i3, String str, int i16, long j3) {
        super(appInterface, i3, j3);
        this.X = com.tencent.mobileqq.search.j.T;
        this.Y = str;
        this.Z = i16;
        S();
    }

    static String R(AppInterface appInterface) {
        if (TextUtils.isEmpty(((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderName())) {
            return ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountTitle();
        }
        return ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderName();
    }

    private void S() {
        switch (this.Z) {
            case 1001:
                this.f445969b0 = MobileQQ.sMobileQQ.getResources().getString(R.string.bp_);
                break;
            case 1008:
                if (TextUtils.equals(this.Y, AppConstants.NEW_KANDIAN_UIN)) {
                    this.f445969b0 = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getXinKandianName(this.G, MobileQQ.sMobileQQ.getApplicationContext());
                    break;
                }
                break;
            case 4000:
                this.f445969b0 = MobileQQ.sMobileQQ.getResources().getString(R.string.cil);
                break;
            case 5000:
                this.f445969b0 = MobileQQ.sMobileQQ.getResources().getString(R.string.i59);
                break;
            case 6000:
                this.f445969b0 = MobileQQ.sMobileQQ.getResources().getString(R.string.c5f);
                break;
            case 7000:
                this.f445969b0 = MobileQQ.sMobileQQ.getResources().getString(R.string.f173172hr1);
                if (!AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(this.Y)) {
                    String nickWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getNickWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.Y), com.tencent.mobileqq.search.model.k.W);
                    if (TextUtils.isEmpty(nickWithUid)) {
                        nickWithUid = this.Y;
                    }
                    if (TextUtils.isEmpty(nickWithUid) || nickWithUid.equals(this.Y)) {
                        String buddyNickName = ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).getBuddyNickName(this.G, this.Y, true);
                        if (!TextUtils.isEmpty(buddyNickName)) {
                            nickWithUid = buddyNickName;
                        }
                    }
                    if (TextUtils.isEmpty(nickWithUid)) {
                        nickWithUid = this.Y;
                    }
                    this.f445969b0 += "(" + nickWithUid + ")";
                    break;
                }
                break;
            case AppConstants.VALUE.UIN_TYPE_EC_SHOP_ASSIST /* 7120 */:
                this.f445969b0 = MobileQQ.sMobileQQ.getResources().getString(R.string.f170868aw2);
                break;
            case AppConstants.VALUE.UIN_TYPE_TROOP_BAR_ASSIST /* 7210 */:
                this.f445969b0 = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.G, MobileQQ.sMobileQQ.getApplicationContext());
                break;
            case AppConstants.VALUE.UIN_TYPE_KANDIAN_MERGE /* 7220 */:
                this.f445969b0 = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getMergerKandianName(this.G, MobileQQ.sMobileQQ.getApplicationContext());
                break;
            case AppConstants.VALUE.UIN_TYPE_SERVICE_ACCOUNT_FOLDER /* 7230 */:
                this.f445969b0 = R(this.G);
                break;
            case 9000:
                this.f445969b0 = MobileQQ.sMobileQQ.getResources().getString(R.string.a_7);
                break;
            case 9002:
                this.f445969b0 = MobileQQ.sMobileQQ.getResources().getString(R.string.f170010ct);
                break;
            case 9003:
                this.f445969b0 = MobileQQ.sMobileQQ.getResources().getString(R.string.f170625wa);
                break;
            case 10002:
                this.f445969b0 = MobileQQ.sMobileQQ.getResources().getString(R.string.bpb);
                break;
        }
        if (!TextUtils.isEmpty(this.f445969b0)) {
            this.f445970c0 = ChnToSpell.d(this.f445969b0, 1).toLowerCase();
            this.f445971d0 = ChnToSpell.d(this.f445969b0, 2).toLowerCase();
        }
    }

    @Override // com.tencent.mobileqq.search.model.k
    /* renamed from: G */
    public Object getUin() {
        return "tool:" + this.Y;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public int H() {
        return 5;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public String K() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.k
    /* renamed from: L */
    public String getTitle() {
        return this.f445969b0;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public int M() {
        return this.Z;
    }

    @Override // com.tencent.mobileqq.search.model.k
    protected long N(String str) {
        this.f445968a0 = str;
        this.f445972e0 = Long.MIN_VALUE;
        long j06 = SearchUtils.j0(str, this.f445969b0, com.tencent.mobileqq.search.j.f283429q);
        if (j06 > this.f445972e0) {
            this.f445972e0 = j06;
        }
        if (this.Z == 9002) {
            long j07 = SearchUtils.j0(str, MobileQQ.sMobileQQ.getResources().getString(R.string.f170172i0), com.tencent.mobileqq.search.j.f283433u);
            if (j07 > this.f445972e0) {
                this.f445972e0 = j07;
            }
        }
        long j3 = this.f445972e0;
        if (j3 != Long.MIN_VALUE) {
            this.f445972e0 = j3 + com.tencent.mobileqq.search.j.V;
            if (AppConstants.EC_SHOP_ASSISTANT_UIN.equals(getUin()) && (HardCodeUtil.qqStr(R.string.l3c).equals(str) || HardCodeUtil.qqStr(R.string.l3j).equals(str) || HardCodeUtil.qqStr(R.string.l2v).equals(str))) {
                this.f445972e0 = com.tencent.mobileqq.search.j.F + 1;
            }
        }
        return this.f445972e0;
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        return ((Integer) ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).getFaceTypeAndResId(this.G, this.Z, this.Y).first).intValue();
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.t
    /* renamed from: l */
    public String getUin() {
        return this.Y;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: m */
    public CharSequence getDescription() {
        int i3 = this.Z;
        if (i3 != 7220) {
            if (i3 != 9002) {
                return null;
            }
            return SearchUtils.D(MobileQQ.sMobileQQ.getResources().getString(R.string.f170172i0), this.f445968a0, 255);
        }
        String string = MobileQQ.sMobileQQ.getResources().getString(R.string.fwa);
        IPublicAccountConfigUtil iPublicAccountConfigUtil = (IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class);
        AppInterface appInterface = this.G;
        IPublicAccountConfigUtil iPublicAccountConfigUtil2 = (IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class);
        AppInterface appInterface2 = this.G;
        IPublicAccountConfigUtil iPublicAccountConfigUtil3 = (IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class);
        AppInterface appInterface3 = this.G;
        return SearchUtils.D(String.format(string, iPublicAccountConfigUtil.getSubscriptName(appInterface, appInterface.getApplication().getApplicationContext()), iPublicAccountConfigUtil2.getMergerKandianName(appInterface2, appInterface2.getApplication().getApplicationContext()), iPublicAccountConfigUtil3.getMergerKandianName(appInterface3, appInterface3.getApplication().getApplicationContext())), this.f445968a0, 255);
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
        return this.f445968a0;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.y
    public void v(View view) {
        long j3;
        super.v(view);
        if (SearchUtils.F0(this.I)) {
            int i3 = this.Z;
            if (i3 != 4000) {
                if (i3 != 5000) {
                    if (i3 != 6000) {
                        if (i3 != 7000) {
                            if (i3 != 7120) {
                                if (i3 != 7210) {
                                    if (i3 != 7230) {
                                        if (i3 != 9000) {
                                            if (i3 != 9002) {
                                                if (i3 == 9003) {
                                                    ((IBlessApi) QRoute.api(IBlessApi.class)).openWebBlessActivity(this.G, view.getContext());
                                                }
                                            } else {
                                                ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).startActivateFriendsForModelTroop(view.getContext());
                                                int i16 = this.I;
                                                if (i16 == 2 || i16 == 1) {
                                                    ReportController.o(this.G, "CliOper", "", "", "0X8006477", "0X8006477", i16, 0, "", "", "", "");
                                                }
                                            }
                                        } else {
                                            ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).startTroopNotificationForModelTroop(this.G, view.getContext());
                                        }
                                    } else {
                                        ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).startServiceAccountFolderForModelTroop(view.getContext());
                                        if (QLog.isColorLevel()) {
                                            QLog.d("ContactSearchModelTool", 2, "enterServiceAccountFolderActivityFromSearch");
                                        }
                                    }
                                } else {
                                    ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).startTroopBarAssistForModelTroop(this.G, view.getContext());
                                }
                            } else {
                                ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).startECShopAssistForModelTroop(this.G, view.getContext());
                                ReportController.o(this.G, "dc00899", "Shop_lifeservice", "", "Shop_folder", "Clk_Searchshopfolder", 0, 0, "", "", "", "");
                            }
                        } else {
                            ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).startSubAccountAssistantForModelTroop(this.G, view.getContext(), this.Y, this.Z);
                        }
                    } else {
                        ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).startDataLinePCForModelTroop(view.getContext());
                    }
                } else {
                    ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).startTroopAssistantForModelTroop(view.getContext());
                }
            } else {
                ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).startRecommendContactForModelTroop(view.getContext());
            }
            ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.G, this.f445968a0);
            try {
                j3 = Long.parseLong(this.Y);
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
                j3 = 0;
            }
            SearchUtils.c1(this.f445968a0, 20, (int) j3, view);
            return;
        }
        SearchUtils.l1(view, this);
    }
}
