package v43;

import KQQ.ReqItem;
import KQQ.RespItem;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.biz.common.offline.BidDownloader;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.c;
import com.tencent.biz.common.util.k;
import com.tencent.biz.webviewplugin.OfflineWebResManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.photo.MediaDBValues;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.sso.offlinpkg.OfflinePkg$BidPkg;
import tencent.im.sso.offlinpkg.OfflinePkg$ReqBody;
import tencent.im.sso.offlinpkg.OfflinePkg$RspBody;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f440949a = "OfflineExpire";

    /* renamed from: b, reason: collision with root package name */
    public static int f440950b = 3;

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public static class b extends AbsPreDownloadTask {

        /* renamed from: d, reason: collision with root package name */
        BidDownloader f440962d;

        public b(BaseQQAppInterface baseQQAppInterface, String str, BidDownloader bidDownloader) {
            super(baseQQAppInterface, str);
            this.f440962d = bidDownloader;
        }

        @Override // com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask
        protected void realCancel() {
            QLog.i(a.f440949a, 1, "cancel predown bid=" + this.f440962d.f78389e);
        }

        @Override // com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask
        protected void realStart() {
            QLog.i(a.f440949a, 1, "realStart predown bid=" + this.f440962d.f78389e);
            this.f440962d.e();
        }
    }

    private static String b(ArrayList<String> arrayList, boolean z16) {
        String obj;
        Time time = new Time();
        time.setToNow();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("com.tencent.process.tmdownloader.exit");
        sb5.append(time.year);
        sb5.append(time.month + 1);
        sb5.append(time.monthDay);
        sb5.append(time.hour);
        if (z16) {
            sb5.append(time.minute - 1);
        } else {
            sb5.append(time.minute);
        }
        if (arrayList == null) {
            obj = "null";
        } else {
            obj = arrayList.toString();
        }
        sb5.append(obj);
        return MD5.toMD5(MD5.toMD5(sb5.toString()) + sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c() {
        Intent intent = new Intent("com.tencent.process.tmdownloader.exit");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("com.tencent.mobileqq:TMAssistantDownloadSDKService");
        intent.putStringArrayListExtra("procNameList", arrayList);
        intent.putExtra("verify", b(arrayList, false));
        if (QLog.isColorLevel()) {
            QLog.d(f440949a, 2, "sendBroadcast to close TMAssistant sdk process");
        }
        BaseApplication.getContext().sendBroadcast(intent);
    }

    protected static void d(String str) {
        int optInt;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(f440949a, 2, "parseExpire:" + str);
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                if (optJSONObject != null && (optInt = optJSONObject.optInt("bid")) > 0) {
                    String c16 = c.c(optInt + "");
                    if (!TextUtils.isEmpty(c16)) {
                        String str2 = c16 + optInt;
                        if (new File(str2).exists()) {
                            k.b(str2);
                        }
                    }
                }
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.i(f440949a, 2, "parseExpire: " + QLog.getStackTraceString(e16));
            }
        }
    }

    /* compiled from: P */
    /* renamed from: v43.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static class C11393a implements com.tencent.mobileqq.service.profile.a, Handler.Callback {

        /* renamed from: m, reason: collision with root package name */
        private static WeakReference<C11393a> f440951m;

        /* renamed from: d, reason: collision with root package name */
        MqqHandler f440952d;

        /* renamed from: e, reason: collision with root package name */
        final List<b> f440953e = new ArrayList();

        /* renamed from: f, reason: collision with root package name */
        final List<com.tencent.biz.common.offline.a> f440954f = new ArrayList();

        /* renamed from: h, reason: collision with root package name */
        private volatile boolean f440955h = false;

        /* renamed from: i, reason: collision with root package name */
        private boolean f440956i = false;

        public C11393a(AppRuntime appRuntime) {
            HtmlOffline.f78406i = appRuntime.getLongAccountUin() % 10 == 6;
        }

        private void b() {
            if (this.f440952d == null) {
                this.f440952d = new MqqWeakReferenceHandler(ThreadManagerV2.getSubThreadLooper(), this);
            }
        }

        private void c() {
            QLog.i(a.f440949a, 1, String.format("clear this=%d", Integer.valueOf(hashCode())));
            synchronized (this) {
                this.f440953e.clear();
                this.f440954f.clear();
            }
            this.f440955h = true;
            b();
            this.f440952d.removeMessages(0);
            this.f440952d.removeMessages(1);
        }

        private void d() {
            b();
            this.f440952d.sendEmptyMessageDelayed(1, 180000L);
            if (QLog.isColorLevel()) {
                QLog.i(a.f440949a, 2, "delayCheckCacheSize");
            }
        }

        private com.tencent.biz.common.offline.a e(WeakReference<AppRuntime> weakReference, String str, String str2, int i3) {
            return new C11394a(weakReference, str2, i3, str);
        }

        public static void g() {
            WeakReference<C11393a> weakReference = f440951m;
            if (weakReference == null) {
                return;
            }
            C11393a c11393a = weakReference.get();
            if (c11393a != null) {
                c11393a.c();
            }
            f440951m = null;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x011f  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0137 A[SYNTHETIC] */
        @Override // com.tencent.mobileqq.service.profile.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public ReqItem d2(int i3) {
            int i16;
            int i17;
            if (this.f440956i) {
                return null;
            }
            this.f440956i = true;
            if (QLog.isColorLevel()) {
                QLog.d(a.f440949a, 2, "getCheckUpdateItemData");
            }
            if (MobileQQ.sProcessId != 1) {
                return null;
            }
            ReqItem reqItem = new ReqItem();
            reqItem.cOperType = (byte) 1;
            reqItem.eServiceID = 127;
            OfflinePkg$ReqBody offlinePkg$ReqBody = new OfflinePkg$ReqBody();
            offlinePkg$ReqBody.uint32_cmd.set(2);
            offlinePkg$ReqBody.uint32_platform.set(a.f440950b);
            String str = AppSetting.f99551k + "." + AppSetting.f99542b;
            if (QLog.isColorLevel()) {
                QLog.d(a.f440949a, 1, String.format("OfflineExpireCheckUpdate, check update QQ Version: %s", str));
            }
            offlinePkg$ReqBody.str_qver.set(ByteStringMicro.copyFrom(str.getBytes()));
            offlinePkg$ReqBody.str_osrelease.set(ByteStringMicro.copyFrom(Build.VERSION.RELEASE.getBytes()));
            offlinePkg$ReqBody.int32_network.set(NetworkUtil.getNetWorkType());
            offlinePkg$ReqBody.str_from.set(ByteStringMicro.copyFrom("predown".getBytes()));
            String x16 = HtmlOffline.x();
            if (!TextUtils.isEmpty(x16)) {
                for (String str2 : x16.split(",")) {
                    if (!TextUtils.isEmpty(str2)) {
                        String[] split = str2.split("\\|");
                        try {
                            i16 = Integer.valueOf(split[0]).intValue();
                        } catch (NumberFormatException e16) {
                            e = e16;
                            i16 = 0;
                        } catch (Exception unused) {
                            i16 = 0;
                        }
                        try {
                            i17 = Integer.valueOf(split[1]).intValue();
                        } catch (NumberFormatException e17) {
                            e = e17;
                            e.printStackTrace();
                            if (QLog.isColorLevel()) {
                                QLog.i(a.f440949a, 2, "NumberFormatException:" + str2);
                            }
                            i17 = 0;
                            if (i16 != 0) {
                            }
                        } catch (Exception unused2) {
                            if (QLog.isColorLevel()) {
                                QLog.i(a.f440949a, 2, "Exception:" + str2);
                            }
                            i17 = 0;
                            if (i16 != 0) {
                            }
                        }
                        if (i16 != 0) {
                            OfflinePkg$BidPkg offlinePkg$BidPkg = new OfflinePkg$BidPkg();
                            offlinePkg$BidPkg.uint32_bid.set(i16);
                            offlinePkg$BidPkg.uint32_pkg_id.add(Integer.valueOf(i17));
                            offlinePkg$ReqBody.st_bid_pkg.add(offlinePkg$BidPkg);
                        }
                    }
                }
            }
            reqItem.vecParam = fh.b(offlinePkg$ReqBody.toByteArray());
            return reqItem;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 0) {
                h();
                return false;
            }
            if (i3 != 1) {
                return false;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (!(peekAppRuntime instanceof AppInterface)) {
                return false;
            }
            new OfflineWebResManager((AppInterface) peekAppRuntime).c();
            return false;
        }

        @Override // com.tencent.mobileqq.service.profile.a
        public void l2(RespItem respItem) {
            byte[] a16;
            if (QLog.isDevelopLevel()) {
                QLog.d(a.f440949a, 2, "handleCheckUpdateItemData result:" + ((int) respItem.cResult));
            }
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            if (MobileQQ.sProcessId != 1) {
                return;
            }
            if (respItem.cResult == 2) {
                g();
                this.f440955h = false;
                f440951m = new WeakReference<>(this);
                if (QLog.isDevelopLevel()) {
                    QLog.i(a.f440949a, 1, String.format("new obj=%d", Integer.valueOf(hashCode())));
                }
                if (respItem.eServiceID == 127 && (a16 = fh.a(respItem.vecUpdate)) != null) {
                    OfflinePkg$RspBody offlinePkg$RspBody = new OfflinePkg$RspBody();
                    try {
                        offlinePkg$RspBody.mergeFrom(a16);
                        a.d(new String(offlinePkg$RspBody.str_expire_pkg.get().toByteArray(), "UTF-8"));
                        f(new String(offlinePkg$RspBody.str_predown_pkg_ex.get().toByteArray(), "UTF-8"), waitAppRuntime, waitAppRuntime.getApplicationContext(), 1);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        if (QLog.isColorLevel()) {
                            QLog.i(a.f440949a, 2, "handleCheckUpdateItemData: " + QLog.getStackTraceString(e16));
                        }
                    }
                }
                d();
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(a.f440949a, 2, "***handleCheckUpdateItemData fail respitem.cResult:" + ((int) respItem.cResult));
            }
        }

        @Override // com.tencent.mobileqq.service.profile.a
        public int w0() {
            return 1;
        }

        private void h() {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.i(a.f440949a, 1, "app == null, download wont start");
                return;
            }
            IPreDownloadController iPreDownloadController = (IPreDownloadController) peekAppRuntime.getRuntimeService(IPreDownloadController.class, "");
            ArrayList arrayList = new ArrayList();
            synchronized (this) {
                arrayList.addAll(this.f440953e);
                this.f440953e.clear();
            }
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                b bVar = (b) arrayList.get(i3);
                BidDownloader bidDownloader = bVar.f440962d;
                String str = bidDownloader.f78389e;
                QLog.i(a.f440949a, 1, String.format("requestPreDownload bid=%s result=%b this=%d", bVar.f440962d.f78389e, Boolean.valueOf(iPreDownloadController.requestPreDownload(10066, "app", str, size - i3, bidDownloader.I, bidDownloader.G, bidDownloader.E ? 1 : 2, 0, c.i(str), bVar)), Integer.valueOf(hashCode())));
            }
        }

        protected void f(String str, AppRuntime appRuntime, Context context, int i3) {
            JSONArray jSONArray;
            int i16;
            int i17;
            int optInt;
            if (TextUtils.isEmpty(str) || !(appRuntime instanceof BaseQQAppInterface)) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i(a.f440949a, 2, "parsePreDown:" + str);
            }
            int i18 = 0;
            int i19 = i3 == 1 ? 300000 : 0;
            try {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray("data");
                WeakReference<AppRuntime> weakReference = new WeakReference<>(appRuntime);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                int length = optJSONArray != null ? optJSONArray.length() : 0;
                int i26 = 0;
                while (i26 < length) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i26);
                    if (optJSONObject != null && (optInt = optJSONObject.optInt("code")) > 0 && optInt < 10) {
                        String str2 = optJSONObject.optInt("bid") + "";
                        String optString = optJSONObject.optString("url");
                        int optInt2 = optJSONObject.optInt(MediaDBValues.FILESIZE, i18);
                        JSONObject t16 = HtmlOffline.t(str2);
                        jSONArray = optJSONArray;
                        if (t16 == null || t16.optInt("version", i18) < optJSONObject.optInt("id")) {
                            com.tencent.biz.common.offline.a e16 = e(weakReference, str2, optString, optInt2);
                            arrayList2.add(e16);
                            i17 = i26;
                            i16 = length;
                            BidDownloader bidDownloader = new BidDownloader(str2, appRuntime, e16, true, optInt);
                            bidDownloader.L = optJSONObject.optInt("id");
                            bidDownloader.E = optJSONObject.optInt("network", 0) == 1;
                            bidDownloader.I = optString;
                            bidDownloader.J = optInt2;
                            bidDownloader.f78391h = true;
                            b bVar = new b((BaseQQAppInterface) appRuntime, str2, bidDownloader);
                            if (bidDownloader.E) {
                                arrayList.add(bVar);
                            } else {
                                arrayList.add(0, bVar);
                            }
                            i26 = i17 + 1;
                            optJSONArray = jSONArray;
                            length = i16;
                            i18 = 0;
                        }
                    } else {
                        jSONArray = optJSONArray;
                    }
                    i17 = i26;
                    i16 = length;
                    i26 = i17 + 1;
                    optJSONArray = jSONArray;
                    length = i16;
                    i18 = 0;
                }
                QLog.i(a.f440949a, 1, String.format("preDownNew:%d this=%d", Integer.valueOf(arrayList.size()), Integer.valueOf(hashCode())));
                if (arrayList.size() > 0) {
                    synchronized (this) {
                        this.f440953e.clear();
                        this.f440953e.addAll(arrayList);
                        this.f440954f.clear();
                        this.f440954f.addAll(arrayList2);
                    }
                    b();
                    this.f440952d.sendEmptyMessageDelayed(0, i19);
                }
            } catch (JSONException e17) {
                e17.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.i(a.f440949a, 2, "parsePreDown: " + QLog.getStackTraceString(e17));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: v43.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes36.dex */
        public class C11394a implements com.tencent.biz.common.offline.a {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ WeakReference f440957d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f440958e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f440959f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f440960h;

            C11394a(WeakReference weakReference, String str, int i3, String str2) {
                this.f440957d = weakReference;
                this.f440958e = str;
                this.f440959f = i3;
                this.f440960h = str2;
            }

            @Override // com.tencent.biz.common.offline.a
            public void loaded(String str, int i3) {
                boolean isEmpty;
                AppRuntime appRuntime = (AppRuntime) this.f440957d.get();
                if (appRuntime != null) {
                    ((IPreDownloadController) appRuntime.getRuntimeService(IPreDownloadController.class, "")).preDownloadSuccess(this.f440958e, BidDownloader.k(i3) ? this.f440959f : -1L);
                }
                if (C11393a.this.f440955h) {
                    return;
                }
                synchronized (C11393a.this) {
                    isEmpty = C11393a.this.f440954f.remove(this) ? C11393a.this.f440954f.isEmpty() : false;
                }
                QLog.i(a.f440949a, 1, String.format("loaded predown bid=%s code=%d finish=%b cnt=%d this=%d", this.f440960h, Integer.valueOf(i3), Boolean.valueOf(isEmpty), Integer.valueOf(C11393a.this.f440954f.size()), Integer.valueOf(C11393a.this.hashCode())));
                if (!isEmpty || C11393a.this.f440955h) {
                    return;
                }
                a.c();
            }

            @Override // com.tencent.biz.common.offline.a
            public void progress(int i3) {
            }
        }
    }
}
