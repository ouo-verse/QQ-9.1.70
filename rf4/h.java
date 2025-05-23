package rf4;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.yolo.esports.download.common.DownloadInfo;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rf4.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 &2\u00020\u0001:\u0003\u0019\u001d!B\u0007\u00a2\u0006\u0004\b$\u0010%J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J(\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\"\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0016\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lrf4/h;", "", "", "fileMD5", "expectMD5", "Lrf4/h$b;", "callback", "", "l", "Lrf4/h$c;", "resInfo", "v", "zipFilePath", "unzipDestDir", "", "w", "", "result", "msg", ReportConstant.COSTREPORT_PREFIX, "Ljava/lang/Runnable;", "task", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "a", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "logger", "Landroid/os/Handler;", "b", "Landroid/os/Handler;", "mainHandler", "Lcom/tencent/mobileqq/qqlive/sail/b;", "c", "Lcom/tencent/mobileqq/qqlive/sail/b;", "downloadService", "<init>", "()V", "d", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi logger;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler mainHandler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqlive.sail.b downloadService;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\u001a\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\n"}, d2 = {"Lrf4/h$b;", "", "", "a", "onSuccess", "", "errorCode", "", "errorMsg", "onFailed", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface b {
        void a();

        void onFailed(int errorCode, @Nullable String errorMsg);

        void onSuccess();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lrf4/h$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "url", "b", "md5", "c", "unzipPath", "tempPath", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: rf4.h$c, reason: from toString */
    /* loaded from: classes26.dex */
    public static final /* data */ class ResInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String url;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String md5;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String unzipPath;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String tempPath;

        public ResInfo(@NotNull String url, @NotNull String md5, @NotNull String unzipPath, @NotNull String tempPath) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(md5, "md5");
            Intrinsics.checkNotNullParameter(unzipPath, "unzipPath");
            Intrinsics.checkNotNullParameter(tempPath, "tempPath");
            this.url = url;
            this.md5 = md5;
            this.unzipPath = unzipPath;
            this.tempPath = tempPath;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getMd5() {
            return this.md5;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getTempPath() {
            return this.tempPath;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getUnzipPath() {
            return this.unzipPath;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ResInfo)) {
                return false;
            }
            ResInfo resInfo = (ResInfo) other;
            if (Intrinsics.areEqual(this.url, resInfo.url) && Intrinsics.areEqual(this.md5, resInfo.md5) && Intrinsics.areEqual(this.unzipPath, resInfo.unzipPath) && Intrinsics.areEqual(this.tempPath, resInfo.tempPath)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.url.hashCode() * 31) + this.md5.hashCode()) * 31) + this.unzipPath.hashCode()) * 31) + this.tempPath.hashCode();
        }

        @NotNull
        public String toString() {
            return "ResInfo(url=" + this.url + ", md5=" + this.md5 + ", unzipPath=" + this.unzipPath + ", tempPath=" + this.tempPath + ")";
        }
    }

    public h() {
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.logger = (IAegisLogApi) api;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.downloadService = com.tencent.mobileqq.qqlive.sail.b.f272169b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean l(String fileMD5, String expectMD5, b callback) {
        boolean equals;
        if (!TextUtils.isEmpty(fileMD5)) {
            equals = StringsKt__StringsJVMKt.equals(expectMD5, fileMD5, true);
            if (equals) {
                return true;
            }
            this.logger.e("ZipResDownloader", "md5 check failed,expectedMD5:" + expectMD5 + ",actualMD5:" + fileMD5);
            s(7, "md5 check failed,expectedMD5:" + expectMD5 + ",actualMD5:" + fileMD5, callback);
            return false;
        }
        this.logger.e("ZipResDownloader", "cal md5 failed,md5 is empty");
        s(6, "cal md5 failed,md5 is empty", callback);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(b callback) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.onFailed(3, "game res url is empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(b callback) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.onSuccess();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(b callback) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.onFailed(4, "create tempDir failed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(b callback) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.onFailed(4, "create unzipDir failed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(b callback) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.a();
    }

    private final void s(final int result, final String msg2, final b callback) {
        u(new Runnable() { // from class: rf4.g
            @Override // java.lang.Runnable
            public final void run() {
                h.t(result, callback, msg2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(int i3, b callback, String str) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (i3 == 0) {
            callback.onSuccess();
        } else {
            callback.onFailed(i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(Runnable task) {
        if (Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            task.run();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(task);
        }
    }

    private final boolean v(ResInfo resInfo) {
        boolean z16;
        boolean z17;
        File file = new File(resInfo.getUnzipPath() + File.separator + resInfo.getMd5());
        if (file.exists() && file.isDirectory()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return true;
        }
        String[] list = file.list();
        if (list != null) {
            if (list.length == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(String zipFilePath, String fileMD5, String unzipDestDir, b callback) {
        String str;
        String str2 = "";
        try {
            try {
                FileUtils.deleteFilesInDirectory(unzipDestDir);
                FileUtils.uncompressZip(zipFilePath, unzipDestDir, false);
                File[] listFiles = new File(unzipDestDir).listFiles();
                if (listFiles != null && listFiles.length == 1 && listFiles[0].isDirectory()) {
                    String absolutePath = listFiles[0].getAbsolutePath();
                    this.logger.i("ZipResDownloader", "unzipped file path: " + absolutePath);
                    File parentFile = listFiles[0].getParentFile();
                    if (parentFile != null) {
                        str = parentFile.getAbsolutePath();
                    } else {
                        str = null;
                    }
                    String str3 = File.separator;
                    String lowerCase = fileMD5.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                    String str4 = str + str3 + lowerCase;
                    try {
                        this.logger.i("ZipResDownloader", "rename unzipped path to " + str4);
                        FileUtils.rename(absolutePath, str4);
                        s(0, "", callback);
                        str2 = str4;
                    } catch (IOException e16) {
                        str2 = str4;
                        e = e16;
                        FileUtils.deleteFilesInDirectory(unzipDestDir);
                        s(2, "unzip failed:" + e.getMessage(), callback);
                        FileUtils.deleteFile(zipFilePath);
                        FileUtils.deleteFile(str2);
                    } catch (Throwable th5) {
                        str2 = str4;
                        th = th5;
                        FileUtils.deleteFile(zipFilePath);
                        FileUtils.deleteFile(str2);
                        throw th;
                    }
                } else {
                    this.logger.e("ZipResDownloader", "uncompress failed");
                    s(8, "uncompress failed", callback);
                }
            } catch (IOException e17) {
                e = e17;
            }
            FileUtils.deleteFile(zipFilePath);
            FileUtils.deleteFile(str2);
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public final void m(@NotNull ResInfo resInfo, @NotNull final b callback) {
        Intrinsics.checkNotNullParameter(resInfo, "resInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.logger.i("ZipResDownloader", "download game res,url:" + resInfo.getUrl() + ",md5:" + resInfo.getMd5());
        if (TextUtils.isEmpty(resInfo.getUrl())) {
            this.logger.e("ZipResDownloader", "game res url is empty");
            u(new Runnable() { // from class: rf4.b
                @Override // java.lang.Runnable
                public final void run() {
                    h.n(h.b.this);
                }
            });
            return;
        }
        if (!v(resInfo)) {
            this.logger.i("ZipResDownloader", "no need to download game res");
            u(new Runnable() { // from class: rf4.c
                @Override // java.lang.Runnable
                public final void run() {
                    h.o(h.b.this);
                }
            });
            return;
        }
        File createDirectory = FileUtils.createDirectory(resInfo.getTempPath());
        if (!createDirectory.exists()) {
            this.logger.e("ZipResDownloader", "create tempDir failed");
            u(new Runnable() { // from class: rf4.d
                @Override // java.lang.Runnable
                public final void run() {
                    h.p(h.b.this);
                }
            });
            return;
        }
        if (!FileUtils.createDirectory(resInfo.getUnzipPath()).exists()) {
            this.logger.e("ZipResDownloader", "create unzipDir failed");
            u(new Runnable() { // from class: rf4.e
                @Override // java.lang.Runnable
                public final void run() {
                    h.q(h.b.this);
                }
            });
            return;
        }
        DownloadInfo downloadInfo = new DownloadInfo();
        downloadInfo.f390014e = resInfo.getUrl();
        downloadInfo.f390015f = resInfo.getMd5();
        downloadInfo.U = "zip";
        downloadInfo.f390016h = createDirectory.getAbsolutePath();
        com.tencent.mobileqq.qqlive.sail.b bVar = this.downloadService;
        String str = downloadInfo.f390014e;
        Intrinsics.checkNotNullExpressionValue(str, "downloadInfo.downloadUrl");
        bVar.C3(str);
        this.downloadService.J0(downloadInfo, new d(resInfo, callback));
        u(new Runnable() { // from class: rf4.f
            @Override // java.lang.Runnable
            public final void run() {
                h.r(h.b.this);
            }
        });
        this.downloadService.A3(downloadInfo);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"rf4/h$d", "Lcom/yolo/esports/download/cb/a;", "Lcom/yolo/esports/download/common/DownloadInfo;", "taskInfo", "", "a", "c", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements com.yolo.esports.download.cb.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ResInfo f431435b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f431436c;

        d(ResInfo resInfo, b bVar) {
            this.f431435b = resInfo;
            this.f431436c = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(b callback, DownloadInfo downloadInfo) {
            Integer num;
            Intrinsics.checkNotNullParameter(callback, "$callback");
            String str = null;
            if (downloadInfo != null) {
                num = Integer.valueOf(downloadInfo.H);
            } else {
                num = null;
            }
            if (downloadInfo != null) {
                str = downloadInfo.I;
            }
            callback.onFailed(1, "errorCode=" + num + ",errorMsg=" + str);
        }

        @Override // com.yolo.esports.download.cb.a
        public void a(@Nullable DownloadInfo taskInfo) {
            h.this.logger.i("ZipResDownloader", "start download game res");
        }

        @Override // com.yolo.esports.download.cb.a
        public void c(@Nullable final DownloadInfo taskInfo) {
            Integer num;
            boolean z16 = false;
            if (taskInfo != null && taskInfo.H == 0) {
                z16 = true;
            }
            if (!z16) {
                IAegisLogApi iAegisLogApi = h.this.logger;
                String str = null;
                if (taskInfo != null) {
                    num = Integer.valueOf(taskInfo.H);
                } else {
                    num = null;
                }
                if (taskInfo != null) {
                    str = taskInfo.I;
                }
                iAegisLogApi.e("ZipResDownloader", "download game res failed,errorCode=" + num + ",errorMsg=" + str);
                h hVar = h.this;
                final b bVar = this.f431436c;
                hVar.u(new Runnable() { // from class: rf4.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.d.e(h.b.this, taskInfo);
                    }
                });
                h.this.downloadService.f3(this);
                return;
            }
            if (!taskInfo.v()) {
                return;
            }
            h.this.logger.i("ZipResDownloader", "download game res success");
            h.this.downloadService.f3(this);
            long currentTimeMillis = System.currentTimeMillis();
            String fileMD5 = FileUtils.calcMd5(taskInfo.f390017i);
            h.this.logger.i("ZipResDownloader", "calc md5 done,cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            if (!h.this.l(fileMD5, this.f431435b.getMd5(), this.f431436c)) {
                return;
            }
            h hVar2 = h.this;
            String str2 = taskInfo.f390017i;
            Intrinsics.checkNotNullExpressionValue(str2, "taskInfo.fileAbsPath");
            Intrinsics.checkNotNullExpressionValue(fileMD5, "fileMD5");
            hVar2.w(str2, fileMD5, this.f431435b.getUnzipPath(), this.f431436c);
        }

        @Override // com.yolo.esports.download.cb.a
        public void b(@Nullable DownloadInfo taskInfo) {
        }
    }
}
