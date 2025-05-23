package v83;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.newalbum.collector.j;
import com.tencent.mobileqq.wink.newalbum.director.datasource.WinkAlbumDataSource;
import com.tencent.mobileqq.wink.newalbum.processor.WinkNewAlbumProcessorManager;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.MemoryAlbumGenerator;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u001e\u0010\n\u001a\u00020\t2\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005H\u0016J\u001e\u0010\u000b\u001a\u00020\t2\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lv83/b;", "Lv83/a;", "Lx83/b;", "", "l", "", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "mediaList", "", "k", "j", "b", "f", "isAuthorized", "a", "Ljava/lang/String;", "TAG", "c", "Z", "isProcessStarted", "()Ljava/lang/String;", "logTag", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b extends x83.b implements a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f441239a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isProcessStarted;

    static {
        b bVar = new b();
        f441239a = bVar;
        TAG = "WinkNewAlbum_WinkAlbumDirector";
        e.f441245a.c(bVar);
    }

    b() {
    }

    private final void l() {
        w83.b.f445025a.T();
    }

    @Override // v83.a
    public void a(boolean isAuthorized) {
        QLog.d(c(), 1, "onAuthorizeChanged, isAuthorized: " + isAuthorized);
        if (!isAuthorized) {
            b();
        }
    }

    @Override // x83.a
    public void b() {
        QLog.d(c(), 1, "destroyProcess, isProcessStarted:" + isProcessStarted);
        if (!isProcessStarted) {
            return;
        }
        super.b();
        isProcessStarted = false;
    }

    @Override // x83.a
    @NotNull
    public String c() {
        return TAG;
    }

    @Override // x83.a
    public void f() {
        QLog.d(c(), 1, "onDestroyProcess ");
        y83.b.f449557a.b();
        WinkAlbumDataSource.f324204a.b();
        MemoryAlbumGenerator.f326501a.b();
        WinkNewAlbumProcessorManager.f324234a.b();
        w83.b.f445025a.a();
    }

    @Override // x83.b
    public boolean j(@Nullable Map<String, ? extends LocalMediaInfo> mediaList) {
        w83.b.f445025a.R();
        j.INSTANCE.m(3, "exp_xsj_memoryalbum_3");
        y83.b.f449557a.i();
        WinkAlbumDataSource.f324204a.i();
        MemoryAlbumGenerator.f326501a.k(mediaList);
        WinkNewAlbumProcessorManager.f324234a.i();
        return true;
    }

    @Override // x83.b
    public boolean k(@Nullable Map<String, ? extends LocalMediaInfo> mediaList) {
        QLog.d(c(), 1, "startProcess, isProcessStarted:" + isProcessStarted + " ");
        if (isProcessStarted) {
            return false;
        }
        l();
        boolean k3 = super.k(mediaList);
        isProcessStarted = k3;
        return k3;
    }
}
