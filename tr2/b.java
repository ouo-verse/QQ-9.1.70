package tr2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.util.SparseArray;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.mobileqq.intervideo.yiqikan.k;
import com.tencent.mobileqq.listentogether.api.IListenTogetherManagerApi;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.together.TogetherOperationHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopPushHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b implements Manager {
    private ConcurrentHashMap<Integer, tr2.e> C;
    private ConcurrentHashMap<Integer, tr2.c> D;
    SharedPreferences F;
    private final com.tencent.mobileqq.troop.api.observer.f H;
    private final com.tencent.mobileqq.troop.api.observer.b I;
    private ar J;

    /* renamed from: d, reason: collision with root package name */
    private final QQAppInterface f437155d;

    /* renamed from: e, reason: collision with root package name */
    private final LruCache<String, Long> f437156e;

    /* renamed from: f, reason: collision with root package name */
    private final HashMap<String, tr2.f> f437157f;

    /* renamed from: h, reason: collision with root package name */
    private SparseArray<ur2.a> f437158h;

    /* renamed from: i, reason: collision with root package name */
    private final Map<String, g> f437159i;

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<tr2.d> f437160m;
    ArrayList<h> E = new ArrayList<>(5);
    private TianShuGetAdvCallback G = new a();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements TianShuGetAdvCallback {
        a() {
        }

        @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
        public void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
            QLog.d("TogetherControlManager", 2, "ongetAdvs result:", Boolean.valueOf(z16), " rsp:", getAdsRsp.toString());
            if (z16) {
                h b16 = h.b(z16, getAdsRsp);
                if (b16 != null) {
                    b.this.E.add(b16);
                    URLDrawable.getDrawable(b16.f437169c, URLDrawable.URLDrawableOptions.obtain()).startDownload();
                } else {
                    QLog.d("TogetherControlManager", 2, "ongetAdvs banner is null");
                }
            }
        }
    }

    /* compiled from: P */
    /* renamed from: tr2.b$b, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    class C11306b extends com.tencent.mobileqq.troop.api.observer.f {
        C11306b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.troop.api.observer.f
        public void b(String str, int i3, ITroopPushHandler.PushType pushType) {
            if (QLog.isColorLevel()) {
                QLog.d("TogetherControlManager", 2, "onPassiveExit, troopUin=" + str + ", reason=" + i3);
            }
            Iterator it = b.this.C.entrySet().iterator();
            while (it.hasNext()) {
                ((tr2.e) ((Map.Entry) it.next()).getValue()).f(str, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class c extends com.tencent.mobileqq.troop.api.observer.b {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.troop.api.observer.b
        public void l(int i3, int i16, String str) {
            if (QLog.isColorLevel()) {
                QLog.d("TogetherControlManager", 2, "onTroopManagerSuccess,reqType=" + i3 + ", result=" + i16 + ", troopUin=" + str);
            }
            if (i16 == 0) {
                if (i3 == 9 || i3 == 2) {
                    Iterator it = b.this.C.entrySet().iterator();
                    while (it.hasNext()) {
                        ((tr2.e) ((Map.Entry) it.next()).getValue()).a(i3, i16, str);
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class d extends ar {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onUpdateDelFriend(boolean z16, Object obj) {
            QLog.i("TogetherControlManager", 1, "onUpdateDelFriend isSuccess: " + z16 + " object: " + obj);
            if (z16) {
                Iterator it = b.this.C.entrySet().iterator();
                while (it.hasNext()) {
                    ((tr2.e) ((Map.Entry) it.next()).getValue()).c(obj);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f implements DialogInterface.OnClickListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        public final Bundle f437165a = new Bundle();

        /* renamed from: b, reason: collision with root package name */
        public Object f437166b = null;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public String f437167a;

        /* renamed from: b, reason: collision with root package name */
        public String f437168b;

        /* renamed from: c, reason: collision with root package name */
        public String f437169c;

        /* renamed from: d, reason: collision with root package name */
        public TianShuAccess.AdItem f437170d;

        public static List<h> a(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp, int i3) {
            TianShuAccess.RspEntry e16 = b.e(z16, getAdsRsp, i3);
            if (e16 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i16 = 0; i16 < e16.value.lst.size(); i16++) {
                List<TianShuAccess.MapEntry> list = e16.value.lst.get(i16).argList.get();
                HashMap hashMap = new HashMap();
                for (TianShuAccess.MapEntry mapEntry : list) {
                    String str = mapEntry.key.get();
                    String str2 = mapEntry.value.get();
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                        hashMap.put(str, str2);
                    }
                }
                h hVar = new h();
                hVar.f437167a = (String) hashMap.get("type");
                hVar.f437169c = (String) hashMap.get("pic");
                hVar.f437168b = (String) hashMap.get("url");
                hVar.f437170d = e16.value.lst.get(i16);
                if (TextUtils.isEmpty(hVar.f437169c)) {
                    break;
                }
                URLDrawable.getDrawable(hVar.f437169c, URLDrawable.URLDrawableOptions.obtain()).startDownload();
                arrayList.add(hVar);
            }
            return arrayList;
        }

        public static h b(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
            List<TianShuAccess.RspEntry> list;
            TianShuAccess.AdPlacementInfo adPlacementInfo;
            if (z16 && getAdsRsp != null) {
                if (getAdsRsp.mapAds.has()) {
                    list = getAdsRsp.mapAds.get();
                } else {
                    list = null;
                }
                if (list == null) {
                    return null;
                }
                HashMap hashMap = new HashMap();
                for (TianShuAccess.RspEntry rspEntry : list) {
                    if (rspEntry != null && rspEntry.key.has()) {
                        hashMap.put(Integer.valueOf(rspEntry.key.get()), rspEntry);
                    }
                }
                TianShuAccess.RspEntry rspEntry2 = (TianShuAccess.RspEntry) hashMap.get(236);
                if (rspEntry2 != null && (adPlacementInfo = rspEntry2.value) != null && adPlacementInfo.lst.size() != 0 && rspEntry2.value.lst.get(0) != null && rspEntry2.value.lst.get(0).argList != null && rspEntry2.value.lst.get(0).argList.get() != null) {
                    List<TianShuAccess.MapEntry> list2 = rspEntry2.value.lst.get(0).argList.get();
                    HashMap hashMap2 = new HashMap();
                    for (TianShuAccess.MapEntry mapEntry : list2) {
                        String str = mapEntry.key.get();
                        String str2 = mapEntry.value.get();
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                            hashMap2.put(str, str2);
                        }
                    }
                    h hVar = new h();
                    hVar.f437167a = (String) hashMap2.get("type");
                    hVar.f437169c = (String) hashMap2.get("pic");
                    hVar.f437168b = (String) hashMap2.get("url");
                    hVar.f437170d = rspEntry2.value.lst.get(0);
                    if (TextUtils.isEmpty(hVar.f437169c)) {
                        return null;
                    }
                    return hVar;
                }
            }
            return null;
        }
    }

    public b(QQAppInterface qQAppInterface) {
        C11306b c11306b = new C11306b();
        this.H = c11306b;
        c cVar = new c();
        this.I = cVar;
        this.J = new d();
        this.f437155d = qQAppInterface;
        this.f437156e = new LruCache<>(100);
        this.f437157f = new HashMap<>(50);
        this.f437158h = new SparseArray<>();
        this.f437159i = new HashMap(50);
        this.f437160m = new ArrayList<>(50);
        J(2, new tr2.h(qQAppInterface));
        J(4, new com.tencent.mobileqq.intervideo.singtogether.d(qQAppInterface));
        y();
        qQAppInterface.addObserver(cVar);
        qQAppInterface.addObserver(c11306b);
        qQAppInterface.addObserver(this.J);
        this.F = BaseApplication.getContext().getSharedPreferences("togethers_sp", 0);
    }

    private boolean C(int i3, String str) {
        for (String str2 : this.f437157f.keySet()) {
            String[] split = str2.split("_");
            tr2.f fVar = this.f437157f.get(str2);
            if (split.length > 0 && fVar != null && !str.equals(split[2]) && 2 == fVar.f437192m && i3 == Integer.parseInt(split[0])) {
                return true;
            }
        }
        return false;
    }

    private void F(Context context, int i3, int i16, int i17, @Nullable Map<String, tr2.f> map, @Nullable Bundle bundle) {
        for (int i18 = 0; i18 < this.f437158h.size(); i18++) {
            ur2.a valueAt = this.f437158h.valueAt(i18);
            if (valueAt != null) {
                valueAt.a(context, i3, i16, i17, map, bundle);
            }
        }
    }

    private void G(com.tencent.mobileqq.troop.unreadmsg.a aVar) {
        Iterator<tr2.d> it = this.f437160m.iterator();
        while (it.hasNext()) {
            it.next().onUpdate(2, true, aVar);
        }
    }

    private void d(int i3, int i16, String str) {
        if (s(i3, i16, str) == null) {
            c(i3, i16, str, tr2.g.a(i3, i16, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @org.jetbrains.annotations.Nullable
    public static TianShuAccess.RspEntry e(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp, int i3) {
        List<TianShuAccess.RspEntry> list;
        if (!z16 || getAdsRsp == null) {
            return null;
        }
        if (getAdsRsp.mapAds.has()) {
            list = getAdsRsp.mapAds.get();
        } else {
            list = null;
        }
        if (list == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (TianShuAccess.RspEntry rspEntry : list) {
            if (rspEntry != null && rspEntry.key.has()) {
                hashMap.put(Integer.valueOf(rspEntry.key.get()), rspEntry);
            }
        }
        TianShuAccess.RspEntry rspEntry2 = (TianShuAccess.RspEntry) hashMap.get(Integer.valueOf(i3));
        if (h(rspEntry2)) {
            return null;
        }
        return rspEntry2;
    }

    private boolean g(int i3, Bundle bundle) {
        QLog.d("TogetherControlManager", 1, "checkParamsIsValid from=", Integer.valueOf(i3));
        if (i3 == 10) {
            return true;
        }
        int i16 = bundle.getInt(PictureConst.KEY_CATEGORY_ID, 0);
        String string = bundle.getString("video_id", "");
        String string2 = bundle.getString("title_name", "");
        String string3 = bundle.getString("room_cover", "");
        if (i16 != 0 && !TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
            return true;
        }
        QLog.d("TogetherControlManager", 1, "onArkTogetherClick return invalid params videoId=", string, " categoryId=", Integer.valueOf(i16), " titleName:", string2, " roomCover:", string3);
        return false;
    }

    private static boolean h(TianShuAccess.RspEntry rspEntry) {
        TianShuAccess.AdPlacementInfo adPlacementInfo;
        if (rspEntry != null && (adPlacementInfo = rspEntry.value) != null && adPlacementInfo.lst.size() != 0 && rspEntry.value.lst.get(0) != null && rspEntry.value.lst.get(0).argList != null && rspEntry.value.lst.get(0).argList.get() != null) {
            return false;
        }
        return true;
    }

    public static b q(QQAppInterface qQAppInterface) {
        return (b) qQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
    }

    private String u(String str, String str2, String[] strArr) {
        if (this.f437157f.get(str2) != null) {
            if (str.equals(strArr[2]) && 3 != this.f437157f.get(str2).f437191i && this.f437157f.get(str2).f437191i != 0) {
                return v(strArr[0]);
            }
            if (str.equals(strArr[2]) && 2 == this.f437157f.get(str2).f437192m) {
                return v(strArr[0]);
            }
            if (!str.equals(strArr[2]) && com.tencent.mobileqq.intervideo.yiqikan.f.i(Integer.parseInt(strArr[0]), strArr[2], Integer.parseInt(strArr[1]))) {
                return v(strArr[0]);
            }
        }
        return "";
    }

    private String v(String str) {
        if (Integer.parseInt(str) == 1) {
            return HardCodeUtil.qqStr(R.string.u7a);
        }
        return HardCodeUtil.qqStr(R.string.f172789u74) + this.f437158h.get(Integer.parseInt(str)).getBusinessName() + HardCodeUtil.qqStr(R.string.u7f);
    }

    private void y() {
        ConcurrentHashMap<Integer, tr2.e> concurrentHashMap = new ConcurrentHashMap<>(2);
        this.C = concurrentHashMap;
        concurrentHashMap.put(2, new k(this.f437155d));
        this.C.put(4, new com.tencent.mobileqq.intervideo.singtogether.c(this.f437155d));
    }

    private boolean z(QBaseActivity qBaseActivity, int i3, int i16, String str, long j3, int i17) {
        boolean B = B(i3, i16, str);
        if (QLog.isColorLevel()) {
            QLog.d("TogetherControlManager", 2, "join serviceType=", Integer.valueOf(i3), " isOpen=" + B);
        }
        if (!B) {
            R(i17, qBaseActivity);
            return false;
        }
        tr2.f s16 = s(i3, i16, str);
        if (s16 != null && s16.f437191i != 3) {
            if (s16.I != j3 && j3 != 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("TogetherControlManager", 2, "join serviceType=", Integer.valueOf(i3), " session.identifyId=" + s16.I + " msg.identify=" + j3);
                }
                R(i17, qBaseActivity);
                return false;
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TogetherControlManager", 2, "join serviceType=", Integer.valueOf(i3), " session=", s16);
        }
        return false;
    }

    public boolean A(QBaseActivity qBaseActivity) {
        if (NetworkUtil.isNetworkAvailable(qBaseActivity)) {
            return true;
        }
        QQToast.makeText(qBaseActivity, 1, qBaseActivity.getString(R.string.f171155cp4), 0).show();
        return false;
    }

    public boolean B(int i3, int i16, String str) {
        TroopInfo n3;
        if (i3 != 1) {
            if (i3 == 2 && i16 == 1 && (n3 = ((TroopManager) this.f437155d.getManager(QQManagerFactory.TROOP_MANAGER)).n(str)) != null && n3.isWatchTogetherOpen()) {
                return true;
            }
            return false;
        }
        return ((IListenTogetherManagerApi) QRoute.api(IListenTogetherManagerApi.class)).isListenTogetherOpen(i16, str);
    }

    public void D(Context context, String str, int i3, int i16, int i17, @Nullable Bundle bundle) {
        ur2.a aVar = this.f437158h.get(i16);
        if (aVar != null) {
            if (i16 == 2) {
                if (i17 == 0) {
                    N("video_tab", "clk_panelvideo", 0, str);
                } else if (i17 == 2) {
                    N("video_tab", "clk_setvideo", 0, str);
                }
            }
            if (f(context, i16, str, i17)) {
                if (QLog.isColorLevel()) {
                    QLog.d("TogetherControlManager", 2, "start serviceType=", Integer.valueOf(i16), " fail because of other together business exist, from=", Integer.valueOf(i17));
                    return;
                }
                return;
            }
            d(i16, i3, str);
            if (aVar.g(context, str, i3, i17, false, m(), bundle)) {
                this.f437158h.get(i16).e(context, str, i3, i17, t(i16), bundle);
                F(context, i16, 3, i17, m(), bundle);
                return;
            }
            QQCustomDialog b16 = aVar.b();
            if (b16 != null) {
                b16.show();
                return;
            }
            QQCustomDialog qQCustomDialog = new QQCustomDialog(context, R.style.qZoneInputDialog);
            qQCustomDialog.setContentView(R.layout.f167856jn);
            qQCustomDialog.setTitle(HardCodeUtil.qqStr(R.string.u75) + this.f437158h.get(i16).getBusinessName() + HardCodeUtil.qqStr(R.string.u6t));
            qQCustomDialog.setMessage(HardCodeUtil.qqStr(R.string.u6q) + this.f437158h.get(i16).getBusinessName() + HardCodeUtil.qqStr(R.string.f172787u72));
            qQCustomDialog.setNegativeButton(HardCodeUtil.qqStr(R.string.ket), new f());
            qQCustomDialog.show();
            return;
        }
        throw new IllegalArgumentException("TogetherDelegate not register! serviceType: " + i16);
    }

    public void E(QBaseActivity qBaseActivity, int i3, int i16, String str, long j3, int i17, Bundle bundle) {
        QBaseActivity qBaseActivity2;
        boolean z16;
        int i18;
        int i19;
        String str2;
        Bundle bundle2;
        int i26;
        int i27;
        if (i17 == 10) {
            N("video_tab", "clk_join_bar", 0, str);
        }
        if (qBaseActivity == null) {
            BaseActivity baseActivity = BaseActivity.sTopActivity;
            if (baseActivity == null) {
                QLog.d("TogetherControlManager", 1, "joinTogetherAndEnter return null activity");
                return;
            }
            qBaseActivity2 = baseActivity;
        } else {
            qBaseActivity2 = qBaseActivity;
        }
        if (!A(qBaseActivity2)) {
            return;
        }
        if (i3 == 1) {
            com.tencent.mobileqq.listentogether.g.e(qBaseActivity2, i16, str, 1, true, bundle.getString("song_id", ""));
            return;
        }
        if (i3 == 2) {
            if (i16 == 2) {
                if (QLog.isColorLevel()) {
                    QLog.d("TogetherControlManager", 2, "join serviceType=", 2, " sessionType is error");
                    return;
                }
                return;
            }
            N("video_tab", "clk_videoark", 0, str);
            QBaseActivity qBaseActivity3 = qBaseActivity2;
            if (L(qBaseActivity2, i3, i16, str, i17, bundle) || !z(qBaseActivity3, i3, i16, str, j3, R.string.vtw)) {
                return;
            }
            TroopInfo B = ((TroopManager) this.f437155d.getManager(QQManagerFactory.TROOP_MANAGER)).B(str);
            WatchTogetherSession watchTogetherSession = (WatchTogetherSession) s(i3, i16, str);
            if (B != null && watchTogetherSession != null) {
                Bundle e16 = tr2.g.e(true, B.isTroopOwner(this.f437155d.getCurrentAccountUin()), B.isOwnerOrAdmin(), B.troopowneruin, str, i17);
                int i28 = watchTogetherSession.F;
                if (i28 != 0) {
                    if (i28 != 1) {
                        if (f(qBaseActivity3, 2, str, i17)) {
                            if (QLog.isColorLevel()) {
                                QLog.d("TogetherControlManager", 2, "start serviceType=", 2, " fail because of other together business exist, from=", Integer.valueOf(i17));
                                return;
                            }
                            return;
                        } else {
                            N("video_tab", "clk_videoark_suc", 0, str);
                            tr2.g.j(this.f437155d, watchTogetherSession.G, watchTogetherSession.H, null, e16, 1);
                            return;
                        }
                    }
                    N("video_tab", "clk_videoark_suc", 0, str);
                    D(qBaseActivity3, str, 1, 2, i17, e16);
                    return;
                }
                QQToast.makeText(qBaseActivity3, 0, R.string.boo, 0).show();
                return;
            }
            return;
        }
        QBaseActivity qBaseActivity4 = qBaseActivity2;
        if (i3 == 4) {
            if (i16 == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                N("sing_tab", "clk_singark", 0, str);
                i18 = 2;
                i19 = 1;
                str2 = str;
            } else {
                i18 = 2;
                i19 = 1;
                str2 = str;
                ReportController.o(this.f437155d, "dc00899", "c2c_AIO", "", "sing_tab", "clk_singark", 0, 1, str, "", "", "");
            }
            String str3 = str2;
            int i29 = i18;
            int i36 = i19;
            if (!z(qBaseActivity4, i3, i16, str, j3, R.string.vry)) {
                return;
            }
            Bundle bundle3 = new Bundle();
            String currentAccountUin = this.f437155d.getCurrentAccountUin();
            boolean B2 = B(i3, i16, str3);
            if (i16 == i36) {
                TroopInfo B3 = ((TroopManager) this.f437155d.getManager(QQManagerFactory.TROOP_MANAGER)).B(str3);
                if (B3 == null) {
                    return;
                }
                i26 = i17;
                bundle2 = tr2.g.e(B2, B3.isTroopOwner(currentAccountUin), B3.isOwnerOrAdmin(), B3.troopowneruin, str, i26);
            } else {
                if (i16 == i29) {
                    i26 = 9;
                    bundle2 = tr2.g.d(B2, 9);
                    i27 = i29;
                    D(qBaseActivity4, str, i27, 4, i26, bundle2);
                }
                bundle2 = bundle3;
                i26 = -1;
            }
            i27 = i16;
            D(qBaseActivity4, str, i27, 4, i26, bundle2);
        }
    }

    public void H(tr2.c cVar) {
        ArrayList<String> arrayList;
        if (this.D == null) {
            this.D = new ConcurrentHashMap<>(4);
        }
        if (cVar != null) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.d("TogetherControlManager", 2, "putFakePanelData, data.id=", Integer.valueOf(cVar.f437177a), "data.isGetFakeData=", Boolean.valueOf(cVar.f437184h));
                    if (cVar.f437184h) {
                        QLog.d("TogetherControlManager", 2, "putFakePanelData, data.numberOfPeople=", Integer.valueOf(cVar.f437185i));
                        Iterator<String> it = cVar.f437186j.iterator();
                        while (it.hasNext()) {
                            QLog.d("TogetherControlManager", 2, "putFakePanelData, data.uin=", it.next());
                        }
                    }
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("TogetherControlManager", 2, "putFakePanelData error", e16.getMessage());
                    return;
                }
                return;
            }
        }
        if (cVar != null && (arrayList = cVar.f437186j) != null && arrayList.size() >= 5 && cVar.f437185i >= 150) {
            this.D.put(Integer.valueOf(cVar.f437177a), cVar);
        } else if (QLog.isColorLevel()) {
            QLog.d("TogetherControlManager", 2, "putFakePanelData error data");
        }
    }

    public void I(int i3, int i16, String str, int i17) {
        ((TogetherOperationHandler) this.f437155d.getBusinessHandler(BusinessHandlerFactory.TOGETHER_OPERATOR_HANDLER)).F2(i3, i16, str, i17);
    }

    public void J(int i3, ur2.a aVar) {
        this.f437158h.put(i3, aVar);
    }

    public void K(int i3, int i16, String str, int i17) {
        this.f437159i.remove(i3 + "-" + i16 + "-" + str + "-" + i17);
    }

    public boolean L(QBaseActivity qBaseActivity, int i3, int i16, String str, int i17, Bundle bundle) {
        boolean B = B(i3, i16, str);
        if (QLog.isColorLevel()) {
            QLog.d("TogetherControlManager", 2, "reopenTogetherBusinessWhenClose serviceType=", Integer.valueOf(i3), " isOpen=" + B);
        }
        if (B || !g(i17, bundle)) {
            return false;
        }
        if (f(qBaseActivity, i3, str, i17)) {
            if (QLog.isColorLevel()) {
                QLog.d("TogetherControlManager", 2, "reopenTogetherBusinessWhenClose checkIsOtherBusinessOpen");
            }
            return true;
        }
        if (C(i3, str)) {
            if (QLog.isColorLevel()) {
                QLog.d("TogetherControlManager", 2, "reopenTogetherBusinessWhenClose isSameServiceAndJoinStatus");
            }
            QQToast.makeText(qBaseActivity, 1, v(String.valueOf(i3)), 0).show(qBaseActivity.getTitleBarHeight());
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TogetherControlManager", 2, "start serviceType=", 2, " fail because of business not open, from=", Integer.valueOf(i17));
        }
        this.f437158h.get(i3).d(qBaseActivity, str, i16, i17, bundle);
        return true;
    }

    public void M(String str, int i3, String str2) {
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
        QLog.d("TogetherControlManager", 1, "reportTianShu time = ", Long.valueOf(serverTimeMillis), " actionId:", Integer.valueOf(i3), " itemId:", str2);
        TianShuReportData tianShuReportData = new TianShuReportData();
        tianShuReportData.mActionId = i3;
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mItemId = str2;
        tianShuReportData.mTraceId = str + "_" + serverTimeMillis;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mOperTime = serverTimeMillis;
        tianShuReportData.mAppId = "tianshu.156";
        tianShuReportData.mPageId = "tianshu.156";
        TianShuManager.getInstance().report(tianShuReportData);
    }

    public void N(String str, String str2, int i3, String str3) {
        int i16;
        TroopInfo B = ((TroopManager) this.f437155d.getManager(QQManagerFactory.TROOP_MANAGER)).B(str3);
        if (B == null) {
            return;
        }
        if (B.isOwnerOrAdmin()) {
            i16 = 1;
        } else {
            i16 = 2;
        }
        if (B.isTroopOwner(this.f437155d.getCurrentUin())) {
            i16 = 0;
        }
        ReportController.o(this.f437155d, "dc00899", "Grp_AIO", "", str, str2, 0, i3, str3, "", i16 + "", "");
    }

    public void O(boolean z16) {
        if (this.E.size() > 0) {
            if (QLog.isColorLevel()) {
                QLog.d("TogetherControlManager", 1, "requestEntryBanner size:", Integer.valueOf(this.E.size()));
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mPosId = 236;
        tianShuAdPosItemData.mNeedCnt = 1;
        arrayList.add(tianShuAdPosItemData);
        TianShuManager.getInstance().requestAdv(arrayList, this.G);
        if (z16) {
            long currentTimeMillis = System.currentTimeMillis();
            this.F.edit().putLong("banner_inter", currentTimeMillis).commit();
            if (QLog.isColorLevel()) {
                QLog.d("TogetherControlManager", 1, "saveBannerInterval ", Long.valueOf(currentTimeMillis));
            }
        }
    }

    public void P() {
        ((TogetherOperationHandler) this.f437155d.getBusinessHandler(BusinessHandlerFactory.TOGETHER_OPERATOR_HANDLER)).D2();
    }

    public void Q(com.tencent.mobileqq.troop.unreadmsg.a aVar) {
        SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences("togethers_sp", 0).edit();
        edit.putString(aVar.f301845b, aVar.f301847d + "_" + aVar.f301846c);
        edit.apply();
    }

    public void R(int i3, QBaseActivity qBaseActivity) {
        QQToast.makeText(qBaseActivity, 1, i3, 0).show(qBaseActivity.getTitleBarHeight());
    }

    public void S(Context context, String str, int i3, int i16, int i17, @Nullable Bundle bundle) {
        ur2.a aVar = this.f437158h.get(i16);
        if (aVar != null) {
            if (i16 == 2) {
                if (i17 == 0) {
                    N("video_tab", "clk_panelvideo", 0, str);
                } else if (i17 == 2) {
                    N("video_tab", "clk_setvideo", 0, str);
                }
            }
            if (f(context, i16, str, i17)) {
                if (QLog.isColorLevel()) {
                    QLog.d("TogetherControlManager", 2, "start serviceType=", Integer.valueOf(i16), " fail because of other together business exist, from=", Integer.valueOf(i17));
                    return;
                }
                return;
            }
            d(i16, i3, str);
            if (aVar.g(context, str, i3, i17, true, m(), bundle)) {
                this.f437158h.get(i16).f(context, str, i3, i17, t(i16), bundle);
                F(context, i16, 1, i17, m(), bundle);
                return;
            }
            QQCustomDialog b16 = aVar.b();
            if (b16 != null) {
                b16.show();
                return;
            }
            QQCustomDialog qQCustomDialog = new QQCustomDialog(context, R.style.qZoneInputDialog);
            qQCustomDialog.setContentView(R.layout.f167856jn);
            qQCustomDialog.setTitle(HardCodeUtil.qqStr(R.string.u6p) + this.f437158h.get(i16).getBusinessName() + HardCodeUtil.qqStr(R.string.u6r));
            qQCustomDialog.setMessage(HardCodeUtil.qqStr(R.string.f172786u70) + this.f437158h.get(i16).getBusinessName() + HardCodeUtil.qqStr(R.string.u79));
            qQCustomDialog.setNegativeButton(HardCodeUtil.qqStr(R.string.ket), new e());
            qQCustomDialog.show();
            return;
        }
        throw new IllegalArgumentException("TogetherDelegate not register! serviceType: " + i16);
    }

    public void T(int i3, int i16, String str, long j3) {
        this.f437156e.put(i3 + "_" + i16 + "_" + str, Long.valueOf(j3));
    }

    public void c(int i3, int i16, String str, tr2.f fVar) {
        this.f437157f.put(i3 + "_" + i16 + "_" + str, fVar);
    }

    public boolean f(Context context, int i3, String str, int i16) {
        int i17;
        if (i3 != 1) {
            IListenTogetherManagerApi iListenTogetherManagerApi = (IListenTogetherManagerApi) QRoute.api(IListenTogetherManagerApi.class);
            if (i16 < 3) {
                i17 = 1;
            } else {
                i17 = 2;
            }
            if (iListenTogetherManagerApi.isListenTogetherOpen(i17, str)) {
                QQToast.makeText(context, 1, HardCodeUtil.qqStr(R.string.u76), 0).show();
                return true;
            }
            if (((IListenTogetherManagerApi) QRoute.api(IListenTogetherManagerApi.class)).isJoinSession()) {
                QQToast.makeText(context, 1, HardCodeUtil.qqStr(R.string.u6z), 0).show();
                return true;
            }
        }
        if (!this.f437155d.isVideoChatting() && !QavCameraUsage.a(context)) {
            if (this.f437155d.isPttRecordingOrPlaying()) {
                QQToast.makeText(context, 1, HardCodeUtil.qqStr(R.string.u6v), 1).show();
                return true;
            }
            if (!this.f437155d.isCallIdle()) {
                QQToast.makeText(context, 1, HardCodeUtil.qqStr(R.string.u7c), 1).show();
                return true;
            }
            for (String str2 : this.f437157f.keySet()) {
                String[] split = str2.split("_");
                if (split.length > 0 && i3 != Integer.parseInt(split[0])) {
                    String u16 = u(str, str2, split);
                    if (!TextUtils.isEmpty(u16)) {
                        QQToast.makeText(context, 1, u16, 0).show();
                        return true;
                    }
                }
            }
            return false;
        }
        QQToast.makeText(context, 1, HardCodeUtil.qqStr(R.string.u6u), 1).show();
        return true;
    }

    public void i() {
        ConcurrentHashMap<Integer, tr2.c> concurrentHashMap = this.D;
        if (concurrentHashMap == null) {
            this.D = new ConcurrentHashMap<>(4);
        } else {
            concurrentHashMap.clear();
        }
    }

    public void j(tr2.f fVar, int i3, String str, long j3, long j16, Object obj) {
        ur2.a aVar = this.f437158h.get(fVar.f437187d);
        if (aVar != null) {
            aVar.c(fVar, i3, str, j3, j16, obj);
        }
    }

    public void k(boolean z16, tr2.f fVar, int i3, String str) {
        ((TogetherOperationHandler) this.f437155d.getBusinessHandler(BusinessHandlerFactory.TOGETHER_OPERATOR_HANDLER)).notifyUI(1, z16, new Object[]{fVar, Integer.valueOf(i3), str});
    }

    public void l(tr2.f fVar, int i3, String str, long j3, long j16, Object obj) {
        ((TogetherOperationHandler) this.f437155d.getBusinessHandler(BusinessHandlerFactory.TOGETHER_OPERATOR_HANDLER)).notifyUI(0, true, new Object[]{fVar, Integer.valueOf(i3), str, Long.valueOf(j3), Long.valueOf(j16), obj});
    }

    @Nullable
    public HashMap<String, tr2.f> m() {
        HashMap<String, tr2.f> hashMap = this.f437157f;
        if (hashMap != null) {
            return (HashMap) hashMap.clone();
        }
        return new HashMap<>();
    }

    public h n() {
        if (this.E.size() > 0) {
            return this.E.remove(0);
        }
        return null;
    }

    public g o(int i3, int i16, String str, int i17) {
        String str2 = i3 + "-" + i16 + "-" + str + "-" + i17;
        g gVar = this.f437159i.get(str2);
        if (gVar == null) {
            g gVar2 = new g();
            this.f437159i.put(str2, gVar2);
            return gVar2;
        }
        return gVar;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        for (int i3 = 0; i3 < this.f437158h.size(); i3++) {
            ur2.a valueAt = this.f437158h.valueAt(i3);
            if (valueAt != null) {
                valueAt.onDestroy();
            }
        }
        this.f437155d.removeObserver(this.I);
        this.f437155d.removeObserver(this.H);
        this.f437155d.removeObserver(this.J);
        TianShuManager.getInstance().removeAdvCallback(this.G);
    }

    public tr2.c p(int i3) {
        ConcurrentHashMap<Integer, tr2.c> concurrentHashMap = this.D;
        if (concurrentHashMap == null) {
            this.D = new ConcurrentHashMap<>(4);
            return null;
        }
        return concurrentHashMap.get(Integer.valueOf(i3));
    }

    public long r(int i3, int i16, long j3) {
        Long l3 = this.f437156e.get(i3 + "_" + i16 + "_" + j3);
        if (l3 == null) {
            return 0L;
        }
        return l3.longValue();
    }

    public <T extends tr2.f> T s(int i3, int i16, String str) {
        T t16 = (T) this.f437157f.get(i3 + "_" + i16 + "_" + str);
        if (t16 != null) {
            return t16;
        }
        return null;
    }

    @Nullable
    public HashMap<String, tr2.f> t(int i3) {
        if (this.f437157f != null) {
            HashMap<String, tr2.f> hashMap = new HashMap<>();
            for (String str : this.f437157f.keySet()) {
                if (str.contains(i3 + "")) {
                    hashMap.put(str, this.f437157f.get(str));
                }
            }
            return hashMap;
        }
        return new HashMap<>();
    }

    public <T extends tr2.e> T w(int i3) {
        T t16 = (T) this.C.get(Integer.valueOf(i3));
        if (t16 == null) {
            return null;
        }
        return t16;
    }

    public void x(String str, int i3, int i16, com.tencent.mobileqq.troop.unreadmsg.a aVar) {
        Q(aVar);
        G(aVar);
        N("video_tab", "exp_whitebar", 0, aVar.f301845b);
    }
}
