package up2;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.api.ISearchUtilFetcher;
import com.tencent.mobileqq.search.model.k;
import com.tencent.mobileqq.search.model.v;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.searchdetail.SearchPageType;
import com.tencent.mobileqq.search.searchdetail.content.wxminapp.SearchDetailModule;
import com.tencent.mobileqq.search.searchdetail.content.wxminapp.e;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends k {
    public MiniAppLocalSearchEntity X;
    protected String Y;
    public int[] Z;

    /* renamed from: a0, reason: collision with root package name */
    public String f439754a0;

    public a(AppInterface appInterface, int i3, MiniAppLocalSearchEntity miniAppLocalSearchEntity, String str, String str2) {
        super(appInterface, i3, 0L);
        this.Z = new int[3];
        this.X = miniAppLocalSearchEntity;
        this.Y = str;
        V();
        D(this.X.appId);
        this.f439754a0 = str2;
    }

    @Override // com.tencent.mobileqq.search.model.z
    public boolean B() {
        String str = this.X.appName;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.Y) && str.equalsIgnoreCase(this.Y)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public int H() {
        return 6;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public String K() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.k
    /* renamed from: L */
    public String getTitle() {
        return this.X.appName;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public int M() {
        return 0;
    }

    @Override // com.tencent.mobileqq.search.model.k
    protected long N(String str) {
        return 0L;
    }

    public boolean R() {
        if ((this.X.showMask & 1) != 0) {
            return true;
        }
        return false;
    }

    public String S() {
        return "https://qzonestyle.gtimg.cn/aoi/sola/20190108152813_orkMRcBegl.png";
    }

    @Override // com.tencent.mobileqq.search.model.k
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public String G() {
        return this.X.appId;
    }

    public String U() {
        return this.X.iconUrl;
    }

    protected void V() {
        if (B()) {
            C(3);
        } else {
            C(9);
        }
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        return 0;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.t
    /* renamed from: l */
    public String getUin() {
        return this.X.appId;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: m */
    public CharSequence getDescription() {
        return this.X.desc;
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
        return this.Y;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.y
    /* renamed from: u */
    public CharSequence getTitle() {
        return SearchUtils.u0(this.X.appName, this.Y, 10, true);
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.y
    public void v(View view) {
        int i3;
        String str;
        int i16;
        boolean z16;
        int a16;
        if (this.X == null) {
            QLog.e(k.W, 1, "miniAppInfo is null");
            return;
        }
        if (((ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class)).getLocalSearchManager(this.G) != null) {
            MiniAppLocalSearchEntity miniAppLocalSearchEntity = this.X;
            if (miniAppLocalSearchEntity.showMask == 0) {
                i16 = 1005;
            } else {
                i16 = 1027;
            }
            int i17 = i16;
            if (miniAppLocalSearchEntity.miniAppType == 1) {
                if (5 == this.C) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    a16 = e.a(SearchPageType.PAGE_LOCAL_SEARCH_MINIAPP_MORE, SearchDetailModule.MODULE_UNKNOWN);
                } else {
                    a16 = e.a(SearchPageType.PAGE_LOCAL_SEARCH, SearchDetailModule.MODULE_UNKNOWN);
                }
                String c16 = e.c("", 1);
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put(StartupReportKey.SCENE_NOTE, c16);
                QLog.i(k.W, 1, "startWxMiniAppByAppId scene=" + a16 + ", node=" + c16);
                ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByAppId((Activity) view.getContext(), this.X.appId, "", i17, 0, null, hashMap);
            } else if (!TextUtils.isEmpty(this.f439754a0)) {
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).gotoSchemaUri(view.getContext(), this.f439754a0);
            } else {
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).launchMiniAppById((Activity) view.getContext(), this.X.appId, null, null, null, null, i17, null);
            }
        }
        if (((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(view.getContext())) {
            AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
            HashMap<v, SearchUtils.d> hashMap2 = SearchUtils.f284965n;
            if (hashMap2.containsKey(this)) {
                SearchUtils.d dVar = hashMap2.get(this);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("project", com.tencent.mobileqq.search.report.b.c());
                    jSONObject.put("event_src", "client");
                    jSONObject.put("obj_lct", dVar.f284978c);
                    jSONObject.put("get_src", "native");
                } catch (JSONException e16) {
                    QLog.e(k.W, 2, "e = " + e16);
                }
                ReportModelDC02528 ver2 = new ReportModelDC02528().module("all_result").action("clk_item").obj1(dVar.f284977b + "").obj2(this.X.appId).ver1(dVar.f284976a).ver2(com.tencent.mobileqq.search.report.b.a(((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).getFromForHistoryCode()));
                if (R()) {
                    str = "1";
                } else {
                    str = "0";
                }
                com.tencent.mobileqq.search.report.b.h(null, ver2.ver3(str).ver7(jSONObject.toString()).session_id(appInterface.getCurrentAccountUin() + SearchUtils.f284963l));
            }
            String str2 = this.L;
            if (str2 != null && !TextUtils.isEmpty(str2)) {
                com.tencent.mobileqq.search.report.b.e(null, 0, this.I, "0X8009D31", 3, 0, null, null);
            } else {
                String str3 = this.X.appName;
                if (str3 != null && str3.equals(this.Y)) {
                    com.tencent.mobileqq.search.report.b.e(null, 0, this.I, "0X8009D33", 0, 0, this.X.appId, null);
                } else {
                    com.tencent.mobileqq.search.report.b.e(null, 0, this.I, "0X8009D45", 0, 0, this.X.appId, null);
                }
            }
        }
        MiniAppLocalSearchEntity miniAppLocalSearchEntity2 = this.X;
        if (miniAppLocalSearchEntity2 != null) {
            i3 = miniAppLocalSearchEntity2.reportType;
        } else {
            i3 = -1;
        }
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportMiniSearch(this.X, 1, true, i3);
    }

    @Override // com.tencent.mobileqq.search.model.z
    public Map<String, String> y() {
        boolean z16;
        int a16;
        String str;
        Map<String, String> y16 = super.y();
        if (y16 == null) {
            y16 = new HashMap<>();
        }
        if (5 == this.C) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            a16 = e.a(SearchPageType.PAGE_LOCAL_SEARCH_MINIAPP_MORE, SearchDetailModule.MODULE_UNKNOWN);
        } else {
            a16 = e.a(SearchPageType.PAGE_LOCAL_SEARCH, SearchDetailModule.MODULE_UNKNOWN);
        }
        y16.put("host_scene", a16 + "");
        if (this.X.miniAppType == 1) {
            str = "1";
        } else {
            str = "2";
        }
        y16.put("result_source", str);
        return y16;
    }

    @Override // com.tencent.mobileqq.search.model.z
    public String z() {
        return this.X.appId;
    }
}
