package y73;

import android.content.Context;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.core.render.log.TavLogger;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\"\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u0004\u0018\u00010\u0004J\b\u0010\t\u001a\u0004\u0018\u00010\u0004R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\n\u00a8\u0006\u000f"}, d2 = {"Ly73/a;", "", "Landroid/content/Context;", "context", "", "soName", "soNameFull", "c", "b", "a", "Ljava/lang/String;", "binFilePath", "soFilePath", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f449547a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String binFilePath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String soFilePath;

    a() {
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String c(Context context, String soName, String soNameFull) {
        File file = new File(context.getApplicationInfo().nativeLibraryDir, "/" + soNameFull);
        QLog.d("WinkFFmpegUtil", 1, "getSoPath, step 1: " + file.getAbsoluteFile());
        if (!file.exists()) {
            try {
                Object invoke = ClassLoader.class.getDeclaredMethod("findLibrary", String.class).invoke(a.class.getClassLoader(), soName);
                Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.String");
                File file2 = new File((String) invoke);
                try {
                    QLog.d("WinkFFmpegUtil", 1, "getSoPath, step 2: " + file2.getAbsoluteFile());
                    file = file2;
                } catch (Error e16) {
                    e = e16;
                    file = file2;
                    QLog.e("WinkFFmpegUtil", 1, "getSoPath, step 2, error ", e);
                    if (!file.exists()) {
                    }
                    if (!file.exists()) {
                    }
                }
            } catch (Error e17) {
                e = e17;
            }
        }
        if (!file.exists()) {
            file = new File(new File(context.getPackageCodePath()).getParentFile(), "/lib/arm64/" + soNameFull);
            QLog.d("WinkFFmpegUtil", 1, "getSoPath, step 3: " + file.getAbsoluteFile());
        }
        if (!file.exists()) {
            QLog.d("WinkFFmpegUtil", 1, "getSoPath, succeed: " + file.getAbsolutePath());
            return file.getAbsolutePath();
        }
        QLog.e("WinkFFmpegUtil", 1, "getSoPath, failed ");
        return null;
    }

    @Nullable
    public final String a() {
        boolean z16;
        String str = binFilePath;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            QLog.d("WinkFFmpegUtil", 1, "getFFmpegCmdBinPath, " + binFilePath);
            return binFilePath;
        }
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String c16 = c(context, "tav_ffmpeg_cmd", "libtav_ffmpeg_cmd.so");
        binFilePath = c16;
        return c16;
    }

    @Nullable
    public final String b() {
        boolean z16;
        String str = soFilePath;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            TavLogger.e("WinkFFmpegUtil", "getFFmpegCmdSoPath, " + soFilePath);
            return soFilePath;
        }
        String str2 = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getAEKitBaseResUnzipFinalPath() + "libtavffmpeg.so";
        soFilePath = str2;
        return str2;
    }
}
