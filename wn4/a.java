package wn4;

import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.timi.game.utils.l;
import com.yolo.esports.download.common.DownloadInfo;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGFile;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u001c\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001*B\t\b\u0002\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u000f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013J\u001c\u0010\u0017\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0018\u001a\u00020\bR \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001dR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010#R\u001c\u0010'\u001a\n %*\u0004\u0018\u00010$0$8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010&\u00a8\u0006+"}, d2 = {"Lwn4/a;", "", "", "PAGUrl", "g", "f", "tag", "PAGSaveFileName", "", "l", "Lorg/libpag/PAGFile;", "pagFile", "j", "Lcom/yolo/esports/download/common/DownloadInfo;", "taskInfo", h.F, "Lf05/a;", "downloadService", "i", "Lwn4/a$a;", "listener", "b", "k", "e", "c", "", "Ljava/util/Map;", "absFilePathMap", "wn4/a$b", "Lwn4/a$b;", "downloadTaskListener", "Ljava/util/concurrent/CopyOnWriteArrayList;", "d", "Ljava/util/concurrent/CopyOnWriteArrayList;", "PAGResourceLoadListenerList", "Lf05/a;", "Lhi4/b;", "kotlin.jvm.PlatformType", "()Lhi4/b;", "initerService", "<init>", "()V", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f445988a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, String> absFilePathMap = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final b downloadTaskListener = new b();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<InterfaceC11498a> PAGResourceLoadListenerList = new CopyOnWriteArrayList<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static f05.a downloadService;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lwn4/a$a;", "", "", "url", "Lorg/libpag/PAGFile;", "pagFile", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: wn4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public interface InterfaceC11498a {
        void a(@NotNull String url, @NotNull PAGFile pagFile);
    }

    static {
        ((f05.a) mm4.b.b(f05.a.class)).init(null);
    }

    a() {
    }

    private final hi4.b d() {
        return (hi4.b) mm4.b.b(hi4.b.class);
    }

    private final String f(String PAGUrl) {
        List split$default;
        boolean z16;
        Object last;
        split$default = StringsKt__StringsKt.split$default((CharSequence) PAGUrl, new String[]{"/"}, false, 0, 6, (Object) null);
        List list = split$default;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) split$default);
            return (String) last;
        }
        return null;
    }

    private final String g(String PAGUrl) {
        boolean startsWith$default;
        boolean startsWith$default2;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(PAGUrl, "http://", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(PAGUrl, "https://", false, 2, null);
            if (!startsWith$default2) {
                return "https://" + PAGUrl;
            }
            return PAGUrl;
        }
        return PAGUrl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(DownloadInfo taskInfo) {
        boolean z16 = false;
        if (taskInfo != null && taskInfo.v()) {
            z16 = true;
        }
        if (!z16) {
            return;
        }
        String str = taskInfo.f390017i;
        l.e("TimiPAGResourceLoader_", "PAG file download success # " + str);
        Map<String, String> map = absFilePathMap;
        String str2 = "TG_PAG_" + taskInfo.f390014e;
        String str3 = taskInfo.f390017i;
        Intrinsics.checkNotNullExpressionValue(str3, "taskInfo.fileAbsPath");
        map.put(str2, str3);
        rm4.a.k("TG_PAG_" + taskInfo.f390014e, str);
        if (d().t()) {
            String str4 = taskInfo.N;
            Intrinsics.checkNotNullExpressionValue(str4, "taskInfo.extraInfo");
            PAGFile Load = PagViewMonitor.Load(taskInfo.f390017i);
            Intrinsics.checkNotNullExpressionValue(Load, "Load(taskInfo.fileAbsPath)");
            j(str4, Load);
            return;
        }
        l.e("TimiPAGResourceLoader_", "Download URL: " + taskInfo.N + " PAG Library not ready");
    }

    private final void j(String tag, PAGFile pagFile) {
        Iterator<T> it = PAGResourceLoadListenerList.iterator();
        while (it.hasNext()) {
            ((InterfaceC11498a) it.next()).a(tag, pagFile);
        }
    }

    private final void l(String tag, String PAGUrl, String PAGSaveFileName) {
        DownloadInfo v06 = ((f05.a) mm4.b.b(f05.a.class)).v0(PAGUrl);
        if (v06 == null) {
            v06 = new DownloadInfo();
            v06.f390015f = PAGSaveFileName;
            v06.f390014e = PAGUrl;
            v06.N = tag;
        }
        if (((f05.a) mm4.b.b(f05.a.class)).A3(v06) == -102) {
            h(v06);
        }
    }

    public final void b(@NotNull InterfaceC11498a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        CopyOnWriteArrayList<InterfaceC11498a> copyOnWriteArrayList = PAGResourceLoadListenerList;
        copyOnWriteArrayList.remove(listener);
        copyOnWriteArrayList.add(listener);
    }

    public final void c() {
        absFilePathMap.clear();
        f05.a aVar = downloadService;
        if (aVar != null) {
            aVar.M0(downloadTaskListener);
        }
        downloadService = null;
    }

    @Nullable
    public final PAGFile e(@NotNull String PAGUrl, @Nullable String PAGSaveFileName) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(PAGUrl, "PAGUrl");
        String g16 = g(PAGUrl);
        String str = absFilePathMap.get("TG_PAG_" + g16);
        boolean z18 = false;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            str = rm4.a.f("TG_PAG_" + g16, "");
        }
        if (PAGSaveFileName == null) {
            PAGSaveFileName = f(g16);
        }
        if (str != null && str.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            if (PAGSaveFileName == null || PAGSaveFileName.length() == 0) {
                z18 = true;
            }
            if (z18) {
                l.e("TimiPAGResourceLoader_", "error save name");
                return null;
            }
            l(PAGUrl, g16, PAGSaveFileName);
            return null;
        }
        File file = new File(str);
        if (file.exists() && d().t()) {
            return PagViewMonitor.Load(file.getAbsolutePath());
        }
        if (PAGSaveFileName == null) {
            l.e("TimiPAGResourceLoader_", "error save name");
            return null;
        }
        l(PAGUrl, g16, PAGSaveFileName);
        return null;
    }

    public final void i(@NotNull f05.a downloadService2) {
        Intrinsics.checkNotNullParameter(downloadService2, "downloadService");
        downloadService = downloadService2;
        downloadService2.b1(downloadTaskListener);
    }

    public final void k(@NotNull InterfaceC11498a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        PAGResourceLoadListenerList.remove(listener);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"wn4/a$b", "Lcom/yolo/esports/download/cb/a;", "Lcom/yolo/esports/download/common/DownloadInfo;", "taskInfo", "", "a", "c", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements com.yolo.esports.download.cb.a {
        b() {
        }

        @Override // com.yolo.esports.download.cb.a
        public void c(@Nullable DownloadInfo taskInfo) {
            a.f445988a.h(taskInfo);
        }

        @Override // com.yolo.esports.download.cb.a
        public void a(@Nullable DownloadInfo taskInfo) {
        }

        @Override // com.yolo.esports.download.cb.a
        public void b(@Nullable DownloadInfo taskInfo) {
        }
    }
}
