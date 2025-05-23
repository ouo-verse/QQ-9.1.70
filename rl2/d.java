package rl2;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.INewQWalletApi;
import com.tencent.mobileqq.qwallet.utils.j;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u00158BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\u001c\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0011R\u0011\u0010\u001e\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0011R\u0011\u0010 \u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u0011\u00a8\u0006#"}, d2 = {"Lrl2/d;", "", "", "a", "", "e", "Ljava/io/File;", "file", "", "c", "b", "", "Lrl2/e;", "Ljava/util/List;", "storageUnitList", "", "i", "()Ljava/lang/String;", "WALLET_EXTERNAL_TMP_PATH", "k", "WALLET_INTERNAL_TMP_PATH", "Lmqq/app/AppRuntime;", "d", "()Lmqq/app/AppRuntime;", "app", "g", "uin", h.F, "WALLET_EXTERNAL_PATH", "j", "WALLET_INTERNAL_PATH", "f", "INTERNAL_FILE_PATH", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f431658a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<e> storageUnitList;

    static {
        List listOf;
        List<e> listOf2;
        d dVar = new d();
        f431658a = dVar;
        String j3 = dVar.j();
        String g16 = dVar.g();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{dVar.i(), dVar.k()});
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new e[]{new a(), new c(), new b(j3 + g16 + "/qpayconfig/"), new b((List<String>) listOf), new b(((INewQWalletApi) QRoute.api(INewQWalletApi.class)).getFinancialPetStoragePath())});
        storageUnitList = listOf2;
    }

    d() {
    }

    @JvmStatic
    public static final void a() {
        Iterator<T> it = storageUnitList.iterator();
        while (it.hasNext()) {
            ((e) it.next()).a();
        }
    }

    private final boolean c(File file) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                f431658a.c(file2);
            }
        }
        return file.delete();
    }

    private final AppRuntime d() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        Intrinsics.checkNotNullExpressionValue(waitAppRuntime, "sMobileQQ.waitAppRuntime(null)");
        return waitAppRuntime;
    }

    @JvmStatic
    public static final long e() {
        Iterator<T> it = storageUnitList.iterator();
        long j3 = 0;
        while (it.hasNext()) {
            j3 += ((e) it.next()).b();
        }
        return j3;
    }

    private final String g() {
        return d().getCurrentAccountUin();
    }

    private final String i() {
        String SDCARD_PATH_QWALLET_TMP = j.f279283b;
        Intrinsics.checkNotNullExpressionValue(SDCARD_PATH_QWALLET_TMP, "SDCARD_PATH_QWALLET_TMP");
        return SDCARD_PATH_QWALLET_TMP;
    }

    private final String k() {
        String FILES_PATH_QWALLET_TMP = j.f279285d;
        Intrinsics.checkNotNullExpressionValue(FILES_PATH_QWALLET_TMP, "FILES_PATH_QWALLET_TMP");
        return FILES_PATH_QWALLET_TMP;
    }

    public final void b(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        if (!file.exists()) {
            return;
        }
        boolean c16 = c(file);
        QLog.i("StorageManagement", 1, file.getAbsolutePath() + " is exists and delete result is " + c16);
    }

    @NotNull
    public final String f() {
        String absolutePath = BaseApplication.getContext().getFilesDir().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getContext().filesDir.absolutePath");
        return absolutePath;
    }

    @NotNull
    public final String h() {
        String SDCARD_PATH_QWALLET = j.f279282a;
        Intrinsics.checkNotNullExpressionValue(SDCARD_PATH_QWALLET, "SDCARD_PATH_QWALLET");
        return SDCARD_PATH_QWALLET;
    }

    @NotNull
    public final String j() {
        String FILES_PATH_QWALLET = j.f279284c;
        Intrinsics.checkNotNullExpressionValue(FILES_PATH_QWALLET, "FILES_PATH_QWALLET");
        return FILES_PATH_QWALLET;
    }
}
