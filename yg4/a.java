package yg4;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.timi.game.ui.widget.f;
import com.tencent.timi.game.utils.l;
import com.yolo.esports.download.common.DownloadInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xg4.e;
import yg4.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000+\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0006*\u0001\u000f\u0018\u0000 \u00052\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lyg4/a;", "", "Lcom/yolo/esports/download/common/DownloadInfo;", "taskInfo", "", "c", "", "url", "b", "Lcom/tencent/mobileqq/app/QBaseActivity;", "a", "Lcom/tencent/mobileqq/app/QBaseActivity;", "getContext", "()Lcom/tencent/mobileqq/app/QBaseActivity;", "context", "yg4/a$c", "Lyg4/a$c;", "mImgDownloaderListener", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QBaseActivity context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mImgDownloaderListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"yg4/a$b", "Lcom/tencent/mobileqq/emosm/api/IFavroamingManagerService$AddCustomEmotionsCallback;", "", "progress", "", "", "addEmotionsResults", "", "onProgressChanged", "onUploadFinish", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements IFavroamingManagerService.AddCustomEmotionsCallback {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(int i3) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2 || i3 == 3) {
                        f.c("\u6dfb\u52a0\u5931\u8d25");
                        return;
                    }
                    return;
                }
                f.c("\u5df2\u6dfb\u52a0\u8fc7\u8be5\u8868\u60c5");
                return;
            }
            f.a("\u6dfb\u52a0\u6210\u529f");
            e.b.f447979b.k();
        }

        @Override // com.tencent.mobileqq.emosm.api.IFavroamingManagerService.AddCustomEmotionsCallback
        public void onProgressChanged(float progress, @Nullable List<Integer> addEmotionsResults) {
            l.i("FavHelper_", "onProgressChanged " + progress);
        }

        @Override // com.tencent.mobileqq.emosm.api.IFavroamingManagerService.AddCustomEmotionsCallback
        public void onUploadFinish(@Nullable List<Integer> addEmotionsResults) {
            final int i3;
            l.i("FavHelper_", "onUploadFinish addEmotionsResults:" + addEmotionsResults);
            if (addEmotionsResults != null) {
                i3 = addEmotionsResults.get(0).intValue();
            } else {
                i3 = -1;
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: yg4.b
                @Override // java.lang.Runnable
                public final void run() {
                    a.b.b(i3);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"yg4/a$c", "Lcom/yolo/esports/download/cb/a;", "Lcom/yolo/esports/download/common/DownloadInfo;", "taskInfo", "", "a", "c", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements com.yolo.esports.download.cb.a {
        c() {
        }

        @Override // com.yolo.esports.download.cb.a
        public void a(@Nullable DownloadInfo taskInfo) {
            l.b("FavHelper_", "onTaskStart taskInfo:" + taskInfo);
        }

        @Override // com.yolo.esports.download.cb.a
        public void b(@Nullable DownloadInfo taskInfo) {
            l.b("FavHelper_", "onTaskProgressChanged taskInfo:" + taskInfo);
        }

        @Override // com.yolo.esports.download.cb.a
        public void c(@Nullable DownloadInfo taskInfo) {
            l.b("FavHelper_", "onTaskStateChanged taskInfo:" + taskInfo);
            if (taskInfo != null && taskInfo.v()) {
                a.this.c(taskInfo);
            }
        }
    }

    public a(@NotNull QBaseActivity context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.mImgDownloaderListener = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(DownloadInfo taskInfo) {
        l.i("FavHelper_", "handleDownloadSucceed hasFile:" + AbsDownloader.hasFile(taskInfo.f390014e) + ", context:" + this.context + ", taskInfo:" + taskInfo);
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFavroamingManagerService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026ssConstant.MAIN\n        )");
        ArrayList arrayList = new ArrayList();
        arrayList.add(taskInfo.f390017i);
        ((IFavroamingManagerService) runtimeService).addCustomEmotions(arrayList, new b());
        ((f05.a) mm4.b.b(f05.a.class)).f3(this.mImgDownloaderListener);
    }

    public final void b(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String filePath = AbsDownloader.getFilePath(url);
        File file = new File(filePath);
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            l.e("FavHelper_", "bad parent file");
            return;
        }
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        DownloadInfo v06 = ((f05.a) mm4.b.b(f05.a.class)).v0(url);
        if (v06 != null && !Intrinsics.areEqual(v06.f390016h, parentFile.getAbsolutePath())) {
            ((f05.a) mm4.b.b(f05.a.class)).C3(url);
            v06 = null;
        }
        if (v06 == null) {
            v06 = new DownloadInfo();
        }
        v06.f390014e = url;
        v06.f390016h = parentFile.getAbsolutePath();
        v06.f390015f = file.getName();
        v06.U = "";
        if (v06.v() && !v06.f390017i.equals(filePath)) {
            f05.a aVar = (f05.a) mm4.b.b(f05.a.class);
            String str = v06.f390014e;
            Intrinsics.checkNotNullExpressionValue(str, "info.downloadUrl");
            aVar.C3(str);
        }
        ((f05.a) mm4.b.b(f05.a.class)).J0(v06, this.mImgDownloaderListener);
        ((f05.a) mm4.b.b(f05.a.class)).A3(v06);
    }
}
