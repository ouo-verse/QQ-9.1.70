package px;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.webview.injector.DownloadInjector;
import com.tencent.mobileqq.webview.swift.injector.f;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.Md5Utils;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantbase.common.TMAssistantDownloadContentType;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes36.dex */
public class e implements c {

    /* renamed from: c, reason: collision with root package name */
    private static HashMap<String, px.a> f427864c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private static f f427865d = new DownloadInjector();

    /* renamed from: a, reason: collision with root package name */
    public TMAssistantDownloadClient f427866a;

    /* renamed from: b, reason: collision with root package name */
    private ITMAssistantDownloadClientListener f427867b = new a();

    @Override // px.c
    public boolean b(Context context, String str) {
        int f16 = f(context, str);
        if (QLog.isColorLevel()) {
            QLog.i("OfflineDownload", 2, "getDownloadState = " + f16);
        }
        return f16 == 2;
    }

    @Override // px.c
    public void c(Context context, String str, String str2, com.tencent.biz.common.offline.a aVar) {
        a(context, str, "0", str2, aVar, null);
    }

    public int f(Context context, String str) {
        TMAssistantDownloadClient downloadSDKClient = TMAssistantDownloadManager.getInstance(context).getDownloadSDKClient("OfflineDownload");
        this.f427866a = downloadSDKClient;
        try {
            TMAssistantDownloadTaskInfo downloadTaskState = downloadSDKClient.getDownloadTaskState(str);
            if (downloadTaskState == null) {
                return 0;
            }
            return downloadTaskState.mState;
        } catch (Exception unused) {
            return 0;
        }
    }

    public void g(com.tencent.biz.common.offline.a aVar, String str, String str2, int i3, String str3) {
        if (QLog.isColorLevel()) {
            QLog.d("OfflineDownload", 2, str3 + ", bid: " + str2 + ", errCode: " + i3);
        }
        if (aVar != null && i3 >= 0) {
            aVar.loaded(str, i3);
        }
        f427864c.remove(str);
    }

    @Override // px.c
    public void pauseDownload(String str) {
        TMAssistantDownloadClient tMAssistantDownloadClient;
        if (TextUtils.isEmpty(str) || (tMAssistantDownloadClient = this.f427866a) == null) {
            return;
        }
        tMAssistantDownloadClient.pauseDownloadTask(str);
        this.f427866a.unRegisterDownloadTaskListener(this.f427867b);
        f427864c.remove(str);
    }

    public void e(TMAssistantDownloadClient tMAssistantDownloadClient, px.a aVar, String str) {
        String str2 = null;
        try {
            try {
                TMAssistantDownloadTaskInfo downloadTaskState = tMAssistantDownloadClient.getDownloadTaskState(str);
                if (downloadTaskState != null) {
                    str2 = downloadTaskState.mSavePath;
                }
                if (TextUtils.isEmpty(str2)) {
                    g(aVar.f427863d, str, aVar.f427862c, 14, "get current download path fail after download");
                    return;
                }
            } catch (Exception e16) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("OfflineDownload", 4, e16.toString());
                }
                if (TextUtils.isEmpty(null)) {
                    g(aVar.f427863d, str, aVar.f427862c, 14, "get current download path fail after download");
                    return;
                }
            }
            File file = new File(str2);
            if (!file.exists()) {
                g(aVar.f427863d, str, aVar.f427862c, 15, "cannot get current file after download");
            } else if (!FileUtils.copyFile(str2, aVar.f427861b)) {
                g(aVar.f427863d, str, aVar.f427862c, 16, "rename file fail after download");
                file.delete();
            } else {
                g(aVar.f427863d, str, aVar.f427862c, 0, "offline zip download success");
            }
        } catch (Throwable th5) {
            if (TextUtils.isEmpty(null)) {
                g(aVar.f427863d, str, aVar.f427862c, 14, "get current download path fail after download");
                return;
            }
            throw th5;
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class a implements ITMAssistantDownloadClientListener {
        a() {
        }

        @Override // com.tencent.tmdownloader.ITMAssistantDownloadClientListener
        public void onDownloadSDKTaskStateChanged(TMAssistantDownloadClient tMAssistantDownloadClient, String str, int i3, int i16, String str2) {
            com.tencent.biz.common.offline.a aVar;
            if (QLog.isColorLevel()) {
                QLog.d("OfflineDownload", 2, "task onDownloadSDKTaskStateChanged + url = " + str + ", state = " + i3 + ", errorCode = " + i16);
            }
            if (tMAssistantDownloadClient == null) {
                e.this.g(null, str, null, -1, "client is null, " + str2);
                return;
            }
            px.a aVar2 = (px.a) e.f427864c.get(str);
            if (aVar2 == null || (aVar = aVar2.f427863d) == null) {
                e.this.g(null, str, null, -1, "download info is null or callback is null");
                return;
            }
            if (i3 == 2) {
                if (QLog.isColorLevel()) {
                    QLog.d("OfflineDownload", 2, "task downloading + url = " + str);
                    return;
                }
                return;
            }
            if (i3 == 3) {
                if (QLog.isColorLevel()) {
                    QLog.d("OfflineDownload", 2, "task paused + url = " + str);
                    return;
                }
                return;
            }
            if (i3 == 4) {
                e.this.e(tMAssistantDownloadClient, aVar2, str);
                return;
            }
            if (i3 != 5) {
                return;
            }
            e.this.g(aVar, str, aVar2.f427862c, i16, "offline zip download fail");
            try {
                e.this.f427866a.cancelDownloadTask(str);
            } catch (Exception e16) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("OfflineDownload", 4, e16.toString());
                }
            }
        }

        @Override // com.tencent.tmdownloader.ITMAssistantDownloadClientListener
        public void onDownloadSDKTaskProgressChanged(TMAssistantDownloadClient tMAssistantDownloadClient, String str, long j3, long j16) {
            px.a aVar;
            com.tencent.biz.common.offline.a aVar2;
            if (tMAssistantDownloadClient == null || (aVar = (px.a) e.f427864c.get(str)) == null || (aVar2 = aVar.f427863d) == null) {
                return;
            }
            aVar2.progress((int) ((((float) j3) * 100.0f) / ((float) j16)));
        }

        @Override // com.tencent.tmdownloader.ITMAssistantDownloadClientListener
        public void onDwonloadSDKServiceInvalid(TMAssistantDownloadClient tMAssistantDownloadClient) {
        }
    }

    @Override // px.c
    public void a(Context context, String str, String str2, String str3, com.tencent.biz.common.offline.a aVar, Map<String, String> map) {
        if (aVar == null) {
            return;
        }
        if (context == null) {
            aVar.loaded(str, 11);
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            if (AppNetConnInfo.getRecentNetworkInfo() == null) {
                aVar.loaded(str, 10);
                return;
            }
            File file = new File(str3.substring(0, str3.lastIndexOf("/")));
            if (!file.exists() && !file.mkdirs()) {
                aVar.loaded(str, 13);
                return;
            }
            String md5 = Md5Utils.getMD5(str);
            px.a aVar2 = new px.a(md5, str3, str2, aVar);
            f427864c.put(str, aVar2);
            TMAssistantDownloadClient downloadSDKClient = TMAssistantDownloadManager.getInstance(context).getDownloadSDKClient("OfflineDownload");
            this.f427866a = downloadSDKClient;
            downloadSDKClient.registerDownloadTaskListener(this.f427867b);
            try {
                int startDownloadTask = this.f427866a.startDownloadTask(str, 0, TMAssistantDownloadContentType.CONTENT_TYPE_OTHERS, md5, map);
                if (startDownloadTask == 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("OfflineDownload", 2, "offline downloader start, url: " + str);
                        QLog.d("PERF_LOG", 2, "NF.OfflineDownloader: " + str);
                    }
                } else if (startDownloadTask == 4) {
                    if (QLog.isColorLevel()) {
                        QLog.d("OfflineDownload", 2, "offline downloader start fail, file exists, url: " + str);
                    }
                    e(this.f427866a, aVar2, str);
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("OfflineDownload", 2, "offline downloader start fail, result " + startDownloadTask + ", url: " + str);
                    }
                    aVar.loaded(str, 10);
                }
                try {
                    f427865d.h(context, str, aVar2.f427861b, aVar2.f427860a);
                    return;
                } catch (Throwable unused) {
                    return;
                }
            } catch (Exception unused2) {
                if (QLog.isColorLevel()) {
                    QLog.d("OfflineDownload", 2, "offline downloader start fail, result -1, url: " + str);
                }
                aVar.loaded(str, 10);
                return;
            }
        }
        aVar.loaded(str, 12);
    }
}
