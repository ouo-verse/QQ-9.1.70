package wn2;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.am;
import com.tencent.mobileqq.search.util.y;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class q extends com.tencent.mobileqq.search.model.k implements com.tencent.mobileqq.search.model.r {
    private TroopInfo X;
    private long Y;
    private String Z;

    /* renamed from: a0, reason: collision with root package name */
    private String f445973a0;

    /* renamed from: b0, reason: collision with root package name */
    private CharSequence f445974b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f445975c0;

    /* renamed from: d0, reason: collision with root package name */
    private long f445976d0;

    /* renamed from: e0, reason: collision with root package name */
    public int f445977e0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f445978f0;

    /* renamed from: g0, reason: collision with root package name */
    private String f445979g0;

    /* renamed from: h0, reason: collision with root package name */
    private String f445980h0;

    public q(AppInterface appInterface, int i3, TroopInfo troopInfo, long j3) {
        super(appInterface, i3, j3);
        this.f445976d0 = com.tencent.mobileqq.search.j.U;
        this.f445978f0 = false;
        this.f445979g0 = null;
        this.f445980h0 = null;
        this.X = troopInfo;
        if (((IRecentUserProxyService) appInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache().isUinInRecent(troopInfo.troopuin)) {
            this.f445978f0 = true;
            this.f445976d0 = com.tencent.mobileqq.search.j.K;
        } else if (this.X.troopmask == GroupMsgMask.ASSISTANT && ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).isUinInAssist(troopInfo.troopuin)) {
            this.f445976d0 = com.tencent.mobileqq.search.j.K;
        }
        C(7);
        D(troopInfo.troopuin);
    }

    private void S() {
        String newTroopNameOrTroopName;
        if (y.a()) {
            if (!TextUtils.isEmpty(this.X.troopRemark)) {
                newTroopNameOrTroopName = this.X.troopRemark;
            } else {
                newTroopNameOrTroopName = this.X.getNewTroopNameOrTroopName();
            }
            this.Z = newTroopNameOrTroopName;
            this.f445973a0 = this.X.getMemberNumClient() + HardCodeUtil.qqStr(R.string.l2o);
            this.f445974b0 = SearchUtils.V(this.X, this.f445975c0, this.f445977e0);
            return;
        }
        this.Z = this.X.getNewTroopNameOrTroopName();
        if (this.X.isQidianPrivateTroop()) {
            this.f445973a0 = "";
            return;
        }
        if (this.X.isNewTroop()) {
            this.f445973a0 = String.valueOf(this.X.getMemberNumClient() + HardCodeUtil.qqStr(R.string.l2o));
            return;
        }
        this.f445973a0 = this.X.troopuin;
    }

    @Override // com.tencent.mobileqq.search.model.z
    public JSONObject A() {
        com.tencent.mobileqq.search.business.contact.entity.d dVar = new com.tencent.mobileqq.search.business.contact.entity.d();
        dVar.f282931a = this.f445978f0;
        dVar.f282932b = this.X.isNewTroop();
        ArrayList arrayList = new ArrayList();
        if (this.f445979g0 != null && this.f445980h0 != null) {
            com.tencent.mobileqq.search.business.contact.entity.e eVar = new com.tencent.mobileqq.search.business.contact.entity.e();
            eVar.f282934b = this.f445979g0;
            eVar.f282933a = this.f445980h0;
            arrayList.add(eVar);
        }
        return am.b(arrayList, this.J, dVar, "Troop");
    }

    @Override // com.tencent.mobileqq.search.model.k
    /* renamed from: G */
    public Object getUin() {
        return this.X.troopuin;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public int H() {
        return 2;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public String K() {
        return this.f445973a0;
    }

    @Override // com.tencent.mobileqq.search.model.k
    /* renamed from: L */
    public String getTitle() {
        return this.Z;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public int M() {
        return 1;
    }

    @Override // com.tencent.mobileqq.search.model.k
    protected long N(String str) {
        this.f445975c0 = str;
        SearchUtils.b T0 = SearchUtils.T0(this.N, this.X, str);
        if (T0 != null) {
            this.Y = T0.f284969a;
            this.f445977e0 = T0.f284970b;
            this.f445980h0 = T0.f284972d;
            this.f445979g0 = T0.f284971c;
        } else {
            this.Y = Long.MIN_VALUE;
            this.f445980h0 = null;
            this.f445979g0 = null;
        }
        long j3 = this.Y;
        if (j3 != Long.MIN_VALUE) {
            this.Y = j3 + this.f445976d0;
            S();
        }
        return this.Y;
    }

    public CharSequence R() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) HardCodeUtil.qqStr(R.string.f212115mn));
        if (!TextUtils.isEmpty(this.X.troopRemark)) {
            spannableStringBuilder.append(SearchUtils.E(this.X.troopRemark, this.f445975c0, 6, false));
        }
        return spannableStringBuilder;
    }

    public boolean T(String str) {
        TroopInfo troopInfo = this.X;
        if (troopInfo == null) {
            return false;
        }
        return troopInfo.isOwner();
    }

    @Override // com.tencent.mobileqq.search.model.r
    public TroopInfo a() {
        return this.X;
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        return 4;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.t
    /* renamed from: l */
    public String getUin() {
        return this.X.troopuin;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: m */
    public CharSequence getDescription() {
        int i3;
        if (y.a()) {
            return this.f445974b0;
        }
        if (this.f445977e0 == 3 && !TextUtils.isEmpty(this.X.troopRemark) && (i3 = this.I) != -1 && i3 != 7) {
            return R();
        }
        if (SearchUtils.F0(this.I) || this.I == 8) {
            return "";
        }
        return HardCodeUtil.qqStr(R.string.l3s);
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
        return this.f445975c0;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.y
    public void v(View view) {
        super.v(view);
        if (SearchUtils.F0(this.I)) {
            ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).markEnterAioFromSearch();
            Intent intent = new Intent();
            intent.putExtra("uin", this.X.troopuin);
            intent.putExtra("uintype", 1);
            ISearchPieceFetcher iSearchPieceFetcher = (ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class);
            Context context = view.getContext();
            AppInterface appInterface = this.G;
            TroopInfo troopInfo = this.X;
            iSearchPieceFetcher.enterChatWin(context, appInterface, troopInfo.troopuin, 1, troopInfo.getTroopDisplayName(), false);
            SearchUtils.c1(this.f445975c0, 20, 2, view);
            ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.G, this.f445975c0);
            AppInterface appInterface2 = this.G;
            String charSequence = getTitleSpans().toString();
            TroopInfo troopInfo2 = this.X;
            SearchUtils.f1(appInterface2, charSequence, troopInfo2.troopuin, troopInfo2.troopcode, 1);
            SearchUtils.Z0(this.f445975c0, 30, view, false);
            SearchUtils.X0(this, view);
            if ((getUin() instanceof String) && !this.M) {
                SearchUtils.o1(this.G, this.f445975c0, this.L, (String) getUin(), H());
            }
            if (((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(view.getContext())) {
                String str = this.L;
                if (str != null && !TextUtils.isEmpty(str)) {
                    com.tencent.mobileqq.search.report.b.e(null, 0, this.I, "0X8009D31", 2, 0, null, null);
                } else {
                    com.tencent.mobileqq.search.report.b.e(null, 0, this.I, "0X8009D3B", 0, 0, null, null);
                }
            }
        } else {
            SearchUtils.l1(view, this);
        }
        new rn2.c(this.G).f("dc00899").a("Grp_listNew").d("search_result").c("clk_grp").b(this.X.troopuin).e();
    }
}
