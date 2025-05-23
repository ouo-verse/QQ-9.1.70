package wn2;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.api.ISearchUtilFetcher;
import com.tencent.mobileqq.search.config.SearchConfig;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.am;
import com.tencent.mobileqq.search.util.y;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService;
import com.tencent.robot.api.IRobotIdentityApi;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.util.Objects;
import org.jf.dexlib2.analysis.RegisterType;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c extends com.tencent.mobileqq.search.model.k implements com.tencent.mobileqq.search.model.n {
    private com.tencent.qqnt.ntrelation.friendsinfo.bean.d X;
    private com.tencent.qqnt.ntrelation.otherinfo.bean.c Y;
    private volatile String Z;

    /* renamed from: a0, reason: collision with root package name */
    private com.tencent.mobileqq.search.business.contact.entity.b f445864a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f445865b0;

    /* renamed from: c0, reason: collision with root package name */
    private long f445866c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f445867d0;

    /* renamed from: e0, reason: collision with root package name */
    private String f445868e0;

    /* renamed from: f0, reason: collision with root package name */
    private String f445869f0;

    /* renamed from: g0, reason: collision with root package name */
    private String f445870g0;

    /* renamed from: h0, reason: collision with root package name */
    private CharSequence f445871h0;

    /* renamed from: i0, reason: collision with root package name */
    private String f445872i0;

    /* renamed from: j0, reason: collision with root package name */
    public ChnToSpell.b f445873j0;

    /* renamed from: k0, reason: collision with root package name */
    public ChnToSpell.b f445874k0;

    /* renamed from: l0, reason: collision with root package name */
    public ChnToSpell.c f445875l0;

    /* renamed from: m0, reason: collision with root package name */
    public ChnToSpell.b f445876m0;

    /* renamed from: n0, reason: collision with root package name */
    public ChnToSpell.b f445877n0;

    /* renamed from: o0, reason: collision with root package name */
    public ChnToSpell.c f445878o0;

    /* renamed from: p0, reason: collision with root package name */
    private long f445879p0;

    public c(AppInterface appInterface, int i3, com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar, String str, com.tencent.mobileqq.search.business.contact.entity.b bVar) {
        this(appInterface, i3, dVar, str, com.tencent.mobileqq.search.business.contact.entity.b.a(bVar));
        this.f445864a0 = bVar;
    }

    private String U() {
        if (((IRobotIdentityApi) QRoute.api(IRobotIdentityApi.class)).isRobotUin(getUin())) {
            return HardCodeUtil.qqStr(R.string.f212145mq);
        }
        return this.f445865b0;
    }

    private String W() {
        int i3 = this.f445867d0;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return QzoneWebMusicJsPlugin.EVENT_UNKOWN;
                    }
                    return NotificationActivity.KEY_ALIAS;
                }
                return "remark";
            }
            return "nickname";
        }
        return "uin";
    }

    private String X() {
        if (!TextUtils.isEmpty("")) {
            return "";
        }
        return this.Y.j();
    }

    private void Y() {
        this.f445870g0 = null;
        int i3 = this.f445867d0;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        this.f445869f0 = "";
                        this.f445871h0 = null;
                    } else {
                        if (!TextUtils.isEmpty(this.X.r())) {
                            this.f445869f0 = this.X.r();
                        } else {
                            this.f445869f0 = this.X.p();
                        }
                        this.f445871h0 = "\u624b\u673a\u53f7\uff1a" + this.X.c();
                        if (this.X.c() != null && this.X.c().contains("@")) {
                            this.f445871h0 = "\u90ae\u7bb1\uff1a" + this.X.c();
                        } else if (String.valueOf(this.X.x()).equals(this.X.c())) {
                            this.f445871h0 = Z();
                        }
                    }
                } else {
                    this.f445869f0 = this.X.r();
                    this.f445871h0 = null;
                }
            } else if (!TextUtils.isEmpty(this.X.r())) {
                this.f445869f0 = this.X.r();
                this.f445871h0 = "\u6635\u79f0\uff1a" + this.X.p();
            } else {
                this.f445869f0 = this.X.p();
                this.f445871h0 = null;
            }
        } else {
            if (!TextUtils.isEmpty(this.X.r())) {
                this.f445869f0 = this.X.r();
            } else {
                this.f445869f0 = this.X.p();
            }
            this.f445871h0 = Z();
        }
        if (!TextUtils.isEmpty(this.f445871h0)) {
            this.f445871h0 = SearchUtils.B(this.f445871h0, this.f445872i0, true).f284973a;
        }
    }

    private String Z() {
        if ((this.X.e().byteValue() & RegisterType.UNINIT_REF) != 0) {
            return "\u4f01\u70b9\u9753\u53f7\uff1a" + this.X.x();
        }
        return "QQ\u53f7\uff1a" + this.X.x();
    }

    private void a0() {
        long j3 = this.f445866c0;
        if (j3 != Long.MIN_VALUE) {
            this.f445866c0 = j3 + this.f445879p0;
            b0();
        }
    }

    private void b0() {
        if (y.a()) {
            Y();
            return;
        }
        int i3 = this.f445867d0;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        this.f445869f0 = "";
                        return;
                    }
                    if (!TextUtils.isEmpty(this.X.r())) {
                        this.f445869f0 = this.X.r();
                        this.f445870g0 = this.X.c();
                        return;
                    } else if (!TextUtils.isEmpty(this.X.p())) {
                        this.f445869f0 = this.X.p();
                        this.f445870g0 = this.X.c();
                        return;
                    } else {
                        this.f445869f0 = this.X.c();
                        this.f445870g0 = X();
                        return;
                    }
                }
                this.f445869f0 = this.X.r();
                if (!TextUtils.isEmpty(this.X.p())) {
                    this.f445870g0 = this.X.p();
                    return;
                } else if (c0() && Objects.equals(this.X.c(), this.X.x())) {
                    this.f445870g0 = X();
                    return;
                } else {
                    this.f445870g0 = SearchUtils.w(this.X.x(), X());
                    return;
                }
            }
            if (!TextUtils.isEmpty(this.X.r())) {
                this.f445869f0 = this.X.r();
                this.f445870g0 = this.X.p();
                return;
            }
            this.f445869f0 = this.X.p();
            if (c0() && Objects.equals(this.X.c(), this.X.x())) {
                this.f445870g0 = X();
                return;
            } else {
                this.f445870g0 = SearchUtils.w(this.X.c(), X());
                return;
            }
        }
        if (!TextUtils.isEmpty(this.X.r())) {
            this.f445869f0 = this.X.r();
            this.f445870g0 = X();
        } else if (!TextUtils.isEmpty(this.X.p())) {
            this.f445869f0 = this.X.p();
            this.f445870g0 = X();
        } else {
            this.f445869f0 = X();
            this.f445870g0 = null;
        }
    }

    @Override // com.tencent.mobileqq.search.model.z
    public JSONObject A() {
        boolean z16;
        String W = W();
        com.tencent.mobileqq.search.business.contact.entity.a aVar = new com.tencent.mobileqq.search.business.contact.entity.a();
        boolean z17 = false;
        if (this.f445864a0 != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        aVar.f282923a = z16;
        if (this.X.n().byteValue() == 1) {
            z17 = true;
        }
        aVar.f282924b = z17;
        aVar.f282925c = Boolean.TRUE.equals(this.X.F());
        return am.a(this.f445868e0, this.J, W, this.f445866c0, aVar, "Friend", com.tencent.mobileqq.search.business.contact.entity.b.b(this.f445864a0));
    }

    @Override // com.tencent.mobileqq.search.model.k
    public Object G() {
        return this.X.x();
    }

    @Override // com.tencent.mobileqq.search.model.k
    public int H() {
        return 1;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public String K() {
        return this.f445870g0;
    }

    @Override // com.tencent.mobileqq.search.model.k
    /* renamed from: L */
    public String getTitle() {
        return this.f445869f0;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public int M() {
        return 0;
    }

    @Override // com.tencent.mobileqq.search.model.k
    protected long N(String str) {
        long k06;
        this.f445872i0 = str;
        this.f445866c0 = Long.MIN_VALUE;
        long V = V(str, this.X.r(), this.f445873j0, this.f445874k0, com.tencent.mobileqq.search.j.f283423k);
        if (V > this.f445866c0) {
            this.f445866c0 = V;
            this.f445867d0 = 2;
            this.f445868e0 = this.X.r();
            if (y.a()) {
                a0();
                return this.f445866c0;
            }
        }
        long V2 = V(str, this.X.p(), this.f445876m0, this.f445877n0, com.tencent.mobileqq.search.j.f283429q);
        if (V2 > this.f445866c0) {
            this.f445866c0 = V2;
            this.f445867d0 = 1;
            this.f445868e0 = this.X.p();
            if (y.a()) {
                a0();
                return this.f445866c0;
            }
        }
        long k07 = SearchUtils.k0(str, this.X.c(), com.tencent.mobileqq.search.j.f283431s, false);
        if (k07 > this.f445866c0) {
            this.f445866c0 = k07;
            this.f445867d0 = 3;
            this.f445868e0 = this.X.c();
        }
        String str2 = this.Z;
        if (!TextUtils.isEmpty(str2)) {
            k06 = SearchUtils.k0(str, str2, com.tencent.mobileqq.search.j.f283432t, false);
        } else {
            k06 = SearchUtils.k0(str, this.X.x(), com.tencent.mobileqq.search.j.f283432t, false);
        }
        if (k06 > this.f445866c0) {
            this.f445866c0 = k06;
            this.f445867d0 = 0;
            if (TextUtils.isEmpty(str2)) {
                str2 = this.X.x();
            }
            this.f445868e0 = str2;
        }
        a0();
        return this.f445866c0;
    }

    public Pair<CharSequence, CharSequence> R() {
        int i3 = this.f445867d0;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return null;
                    }
                    if (!TextUtils.isEmpty(this.X.r())) {
                        return new Pair<>(this.X.r(), SearchUtils.s0(this.X.c(), this.f445872i0, 6, true));
                    }
                    if (!TextUtils.isEmpty(this.X.p())) {
                        return new Pair<>(this.X.p(), SearchUtils.s0(this.X.c(), this.f445872i0, 6, true));
                    }
                    return new Pair<>(SearchUtils.u0(this.X.c(), this.f445872i0, 6, true), null);
                }
                return new Pair<>(SearchUtils.u0(this.X.r(), this.f445872i0, 6, true), null);
            }
            if (!TextUtils.isEmpty(this.X.r())) {
                return new Pair<>(this.X.r(), SearchUtils.s0(this.X.p(), this.f445872i0, 6, true));
            }
            return new Pair<>(SearchUtils.u0(this.X.p(), this.f445872i0, 6, true), null);
        }
        if (!TextUtils.isEmpty(this.X.r())) {
            return new Pair<>(this.X.r(), SearchUtils.s0(this.X.x(), this.f445872i0, 6, false));
        }
        if (!TextUtils.isEmpty(this.X.p())) {
            return new Pair<>(this.X.p(), SearchUtils.s0(this.X.x(), this.f445872i0, 6, false));
        }
        return new Pair<>(SearchUtils.u0(this.X.x(), this.f445872i0, 6, false), null);
    }

    public com.tencent.qqnt.ntrelation.friendsinfo.bean.d S() {
        return this.X;
    }

    public int T() {
        return this.I;
    }

    public long V(String str, String str2, ChnToSpell.b bVar, ChnToSpell.b bVar2, long j3) {
        if (this.N) {
            return SearchUtils.p0(str, str2, bVar, bVar2, j3);
        }
        return SearchUtils.m0(str, str2, bVar, bVar2, j3);
    }

    public boolean c0() {
        return ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).isQidianMaster(this.X.e().byteValue());
    }

    public void d0(String str) {
        this.Z = str;
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        return 1;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.t
    /* renamed from: l */
    public String getUin() {
        return this.X.x();
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: m */
    public CharSequence getDescription() {
        if (y.a()) {
            return this.f445871h0;
        }
        if (SearchUtils.F0(this.I)) {
            return HardCodeUtil.qqStr(R.string.f171805l33) + U();
        }
        return U();
    }

    @Override // com.tencent.mobileqq.search.model.y
    public CharSequence o() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public boolean r() {
        int i3 = this.I;
        if (i3 == 21 || i3 == 1 || i3 == 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: s */
    public String getKeyword() {
        return this.f445872i0;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.y
    public void v(View view) {
        super.v(view);
        if (SearchUtils.F0(this.I)) {
            ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).setContactSearchRecentAndHistroy(view.getContext(), this.G, this.X.x(), SearchUtils.x(this.X), this.f445872i0, view);
            String charSequence = getTitle().toString();
            if (TextUtils.isEmpty(charSequence)) {
                if (QLog.isColorLevel()) {
                    QLog.d(com.tencent.mobileqq.search.model.k.W, 2, "saveSearchHistory title is null");
                }
                charSequence = getTitle();
                if (TextUtils.isEmpty(charSequence)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(com.tencent.mobileqq.search.model.k.W, 2, "saveSearchHistory titlestr is null");
                    }
                    charSequence = K();
                }
            }
            SearchUtils.f1(this.G, charSequence, this.X.x(), "", 0);
            SearchUtils.Z0(this.f445872i0, 20, view, false);
            ((ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class)).reportContactResultItemClick(this, view);
            if (SearchConfig.needSeparate) {
                SearchUtils.V0("search", "contact", "contacts", 0, 0, SearchUtils.b0(this.I));
            }
            if ((G() instanceof String) && !this.M) {
                SearchUtils.o1(this.G, this.f445872i0, this.L, (String) G(), H());
            }
            if (((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(view.getContext())) {
                String str = this.L;
                if (str != null && !TextUtils.isEmpty(str)) {
                    com.tencent.mobileqq.search.report.b.e(null, 0, this.I, "0X8009D31", ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).getMostUseConstantsReportContact(), 0, null, null);
                    return;
                } else {
                    com.tencent.mobileqq.search.report.b.e(null, 0, this.I, "0X8009D37", 0, 0, null, null);
                    return;
                }
            }
            return;
        }
        if (11 == this.I) {
            QBaseActivity qBaseActivity = (QBaseActivity) view.getContext();
            if (Boolean.TRUE.equals(this.X.F())) {
                QQToast.makeText(qBaseActivity, qBaseActivity.getString(R.string.fu5), 0).show(qBaseActivity.getTitleBarHeight());
                return;
            }
        }
        ((ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class)).selectContactResult(view, this);
    }

    public c(AppInterface appInterface, int i3, com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar, String str, long j3) {
        super(appInterface, i3, j3);
        this.f445879p0 = com.tencent.mobileqq.search.j.M;
        this.f445865b0 = str;
        this.X = dVar;
        this.Y = ((IOtherInfoService) QRoute.api(IOtherInfoService.class)).getOtherSimpleInfoWithUid(dVar.getUid(), com.tencent.mobileqq.search.model.k.W);
        if (((IRecentUserProxyService) appInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache().isUinInRecentNotSubAccount(dVar.x())) {
            this.f445879p0 = com.tencent.mobileqq.search.j.H;
        } else if (dVar.n().byteValue() == 1) {
            this.f445879p0 = com.tencent.mobileqq.search.j.N;
        } else if (((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).isQidianMaster(dVar.e().byteValue())) {
            this.f445879p0 = com.tencent.mobileqq.search.j.f283417e0;
        } else if (Boolean.TRUE.equals(dVar.F())) {
            this.f445879p0 = com.tencent.mobileqq.search.j.L;
        }
        if (!TextUtils.isEmpty(dVar.r())) {
            ChnToSpell.c f16 = ChnToSpell.f(dVar.r());
            this.f445875l0 = f16;
            if (f16 != null) {
                this.f445873j0 = f16.b();
                this.f445874k0 = this.f445875l0.a();
            }
        }
        if (!TextUtils.isEmpty(dVar.p())) {
            ChnToSpell.c f17 = ChnToSpell.f(dVar.p());
            this.f445878o0 = f17;
            if (f17 != null) {
                this.f445876m0 = f17.b();
                this.f445877n0 = this.f445878o0.a();
            }
        }
        C(6);
        D(dVar.x());
    }
}
