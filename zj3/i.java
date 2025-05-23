package zj3;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.z1.download.ZPlanFileCategory;
import com.tencent.mobileqq.zootopia.download.ah;
import com.tencent.mobileqq.zootopia.download.file.ZPlanFileDownloadResult;
import com.tencent.mobileqq.zootopia.download.file.ZPlanFileDownloadUtil;
import com.tencent.mobileqq.zootopia.download.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.reporter.api.IDownloaderReporter;
import com.tencent.raft.standard.net.IRDownload;
import com.tencent.raft.standard.net.IRNetwork;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0002\u0011\u0016B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J*\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\tH\u0016J@\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000fH\u0016R\u0014\u0010\u0013\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lzj3/i;", "Lcom/tencent/raft/standard/net/IRDownload;", "", "logMsg", "", "d", "c", "url", "filePath", "Lcom/tencent/raft/standard/net/IRDownload$IDownloadCallback;", "callback", "Lcom/tencent/raft/standard/net/IRDownload$IRDownloadTask;", "downloadWithUrl", "Lcom/tencent/raft/standard/net/IRDownload$DownloadPriority;", "priority", "", "extraInfo", "a", "Lcom/tencent/raft/standard/net/IRDownload;", "defaultDownloader", "<init>", "(Lcom/tencent/raft/standard/net/IRDownload;)V", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class i implements IRDownload {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final IRDownload defaultDownloader;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lzj3/i$b;", "Lcom/tencent/raft/standard/net/IRDownload$IRDownloadTask;", "", "cancel", "", "a", "I", "getCategoryType", "()I", "categoryType", "", "b", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "url", "<init>", "(ILjava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b implements IRDownload.IRDownloadTask {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int categoryType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final String url;

        public b(int i3, String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.categoryType = i3;
            this.url = url;
        }

        @Override // com.tencent.raft.standard.net.IRDownload.IRDownloadTask
        public boolean cancel() {
            ZPlanFileDownloadUtil.q(ZPlanFileDownloadUtil.f328039a, this.categoryType, this.url, null, 4, null);
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"zj3/i$c", "Lcom/tencent/mobileqq/zootopia/download/ah;", "", "progress", "Lcom/tencent/mobileqq/zootopia/download/x;", "task", "", "f", "c", "", "code", tl.h.F, "e", "d", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class c extends ah {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IRDownload.IDownloadCallback f452663b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ i f452664c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f452665d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f452666e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(IRDownload.IDownloadCallback iDownloadCallback, i iVar, String str, long j3) {
            super(null, 1, null);
            this.f452663b = iDownloadCallback;
            this.f452664c = iVar;
            this.f452665d = str;
            this.f452666e = j3;
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void b(x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            this.f452664c.d("onStartDownload - " + this.f452665d);
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void c(x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            this.f452664c.d("onComplete!!! - " + this.f452665d + ", code=" + task.getDownloadFailCode() + ", averSpeed=" + t74.a.a(task.getCurAverageSpeed()) + ", totalCallbackTime=" + (System.currentTimeMillis() - this.f452666e) + "ms, " + task.m() + ", " + this.f452663b);
            yj3.a.f450500a.w();
            IRDownload.IDownloadCallback iDownloadCallback = this.f452663b;
            IRNetwork.ResultInfo resultInfo = new IRNetwork.ResultInfo();
            resultInfo.setErrorType(IRNetwork.ResultInfo.ErrorType.SUCCESS);
            resultInfo.setErrorCode(Integer.valueOf(task.getDownloadFailCode()));
            iDownloadCallback.onComplete(resultInfo);
            ZPlanFileDownloadResult downloadResultInfo = task.getDownloadResultInfo();
            if (downloadResultInfo != null) {
                ((IDownloaderReporter) QRoute.api(IDownloaderReporter.class)).downloaderReport("ResHubDownload", downloadResultInfo.getUrl(), downloadResultInfo.getTotalLength());
            }
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void d(x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            this.f452664c.d("onWaitingDownload - " + this.f452665d);
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void e(x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            this.f452664c.d("onPause - " + this.f452665d);
            IRDownload.IDownloadCallback iDownloadCallback = this.f452663b;
            IRNetwork.ResultInfo resultInfo = new IRNetwork.ResultInfo();
            resultInfo.setErrorType(IRNetwork.ResultInfo.ErrorType.CANCELLED);
            iDownloadCallback.onComplete(resultInfo);
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void f(float progress, x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            this.f452663b.onProgress(task.getCurReceivedLength(), task.getCurTotalLength());
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void h(int code, x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            this.f452664c.c("onFailed!!! - " + this.f452665d + " --  code=" + code + ", FailCode=" + task.getDownloadFailCode() + ", FailInfo=" + task.getDownloadFailInfo() + ", totalCallbackTime=" + (System.currentTimeMillis() - this.f452666e) + "ms");
            IRDownload.IDownloadCallback iDownloadCallback = this.f452663b;
            IRNetwork.ResultInfo resultInfo = new IRNetwork.ResultInfo();
            resultInfo.setErrorType(IRNetwork.ResultInfo.ErrorType.OTHER_ERROR);
            resultInfo.setErrorCode(Integer.valueOf(task.getDownloadFailCode()));
            resultInfo.setErrorMessage(task.getDownloadFailInfo());
            iDownloadCallback.onComplete(resultInfo);
        }
    }

    public i(IRDownload defaultDownloader) {
        Intrinsics.checkNotNullParameter(defaultDownloader, "defaultDownloader");
        this.defaultDownloader = defaultDownloader;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(String logMsg) {
        QLog.e("ZPlanShiplyRes_Download", 1, logMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(String logMsg) {
        QLog.i("ZPlanShiplyRes_Download", 1, logMsg);
    }

    @Override // com.tencent.raft.standard.net.IRDownload
    public IRDownload.IRDownloadTask downloadWithUrl(String url, String filePath, IRDownload.IDownloadCallback callback) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(callback, "callback");
        d("downloadWithUrl: default");
        return downloadWithUrl(url, filePath, IRDownload.DownloadPriority.Normal, callback);
    }

    @Override // com.tencent.raft.standard.net.IRDownload
    public IRDownload.IRDownloadTask downloadWithUrl(String url, String filePath, IRDownload.DownloadPriority priority, IRDownload.IDownloadCallback callback) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(priority, "priority");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return downloadWithUrl(url, filePath, priority, callback, null);
    }

    @Override // com.tencent.raft.standard.net.IRDownload
    public IRDownload.IRDownloadTask downloadWithUrl(String url, String filePath, IRDownload.DownloadPriority priority, IRDownload.IDownloadCallback callback, Map<String, String> extraInfo) {
        String str;
        boolean contains$default;
        List split$default;
        String str2;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(priority, "priority");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Object obj = "";
        if (extraInfo == null || (str = extraInfo.get("res_type")) == null) {
            str = "";
        }
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "kuikly", false, 2, (Object) null);
        if (!contains$default && !Intrinsics.areEqual(str, "kuikly")) {
            String separator = File.separator;
            Intrinsics.checkNotNullExpressionValue(separator, "separator");
            split$default = StringsKt__StringsKt.split$default((CharSequence) filePath, new String[]{separator}, false, 0, 6, (Object) null);
            if (split$default.size() > 1) {
                obj = split$default.get(split$default.size() - 1);
                String substring = filePath.substring(0, (filePath.length() - ((String) obj).length()) - 1);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                str2 = substring;
            } else {
                str2 = "";
            }
            long currentTimeMillis = System.currentTimeMillis();
            String str3 = "ResHub_downloadWithUrl# " + url;
            d("START - " + str3 + ", fullFilePath= " + filePath + ", priority-" + priority + ", fileName=" + obj + ", callback=" + callback);
            int value = ZPlanFileCategory.RES_HUB.getValue();
            ZPlanFileDownloadUtil.f328039a.f(value, url, (r21 & 4) != 0 ? "" : str2, (r21 & 8) != 0 ? "" : (String) obj, (r21 & 16) != 0 ? "" : null, (r21 & 32) != 0 ? null : null, (r21 & 64) != 0 ? Boolean.FALSE : Boolean.valueOf(priority == IRDownload.DownloadPriority.High || priority == IRDownload.DownloadPriority.Highest), (r21 & 128) != 0 ? null : new c(callback, this, str3, currentTimeMillis));
            return new b(value, url);
        }
        return this.defaultDownloader.downloadWithUrl(url, filePath, priority, callback);
    }
}
