package us3;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.minibox.business.api.MiniBoxAppInfo;
import com.tencent.minibox.business.api.MiniBoxSDK;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qq.minibox.api.data.VirtualAppInfo;
import com.tencent.qq.minibox.manager.MiniBoxDownloadTask;
import java.io.File;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n\u00a8\u0006\u0012"}, d2 = {"Lus3/i;", "", "Lcom/tencent/gamecenter/wadl/biz/entity/WadlResult;", "wadlResult", "Lcom/tencent/qq/minibox/manager/MiniBoxDownloadTask;", "c", "Lcom/tencent/minibox/business/api/MiniBoxAppInfo;", "info", "Lcom/tencent/qq/minibox/api/data/MiniBoxAppDataInfo;", "a", "", "time", "", "d", "size", "b", "<init>", "()V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f439988a = new i();

    i() {
    }

    @Nullable
    public final VirtualAppInfo a(@Nullable MiniBoxAppInfo info) {
        if (info != null) {
            VirtualAppInfo virtualAppInfo = new VirtualAppInfo();
            virtualAppInfo.y(String.valueOf(info.getIconFilePath()));
            virtualAppInfo.A(String.valueOf(info.getAppName()));
            virtualAppInfo.N(String.valueOf(info.getPkgName()));
            virtualAppInfo.c0(String.valueOf(info.getVersionCode()));
            String apkPath = MiniBoxSDK.getApkPath(BaseApplication.getContext(), info.getPkgName());
            if (!TextUtils.isEmpty(apkPath)) {
                String a16 = m51.c.f416181a.a(new File(apkPath));
                if (a16 == null) {
                    a16 = "";
                }
                virtualAppInfo.M(a16);
            }
            virtualAppInfo.F(3);
            return virtualAppInfo;
        }
        return null;
    }

    @NotNull
    public final String b(long size) {
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        long j3 = 1024;
        long j16 = (size / j3) / j3;
        if (j16 > 1024) {
            return decimalFormat.format(j16 / j3) + "GB";
        }
        return decimalFormat.format(j16) + "MB";
    }

    @NotNull
    public final MiniBoxDownloadTask c(@NotNull WadlResult wadlResult) {
        Intrinsics.checkNotNullParameter(wadlResult, "wadlResult");
        MiniBoxDownloadTask miniBoxDownloadTask = new MiniBoxDownloadTask();
        String str = wadlResult.wadlParams.apkUrl;
        Intrinsics.checkNotNullExpressionValue(str, "wadlResult.wadlParams.apkUrl");
        miniBoxDownloadTask.E(str);
        String str2 = wadlResult.wadlParams.appId;
        Intrinsics.checkNotNullExpressionValue(str2, "wadlResult.wadlParams.appId");
        miniBoxDownloadTask.z(str2);
        String str3 = wadlResult.wadlParams.appName;
        Intrinsics.checkNotNullExpressionValue(str3, "wadlResult.wadlParams.appName");
        miniBoxDownloadTask.A(str3);
        String str4 = wadlResult.wadlParams.packageName;
        Intrinsics.checkNotNullExpressionValue(str4, "wadlResult.wadlParams.packageName");
        miniBoxDownloadTask.N(str4);
        miniBoxDownloadTask.c0(String.valueOf(wadlResult.wadlParams.versionCode));
        String str5 = wadlResult.wadlParams.iconUrl;
        Intrinsics.checkNotNullExpressionValue(str5, "wadlResult.wadlParams.iconUrl");
        miniBoxDownloadTask.y(str5);
        miniBoxDownloadTask.n0(wadlResult.downloadFileSize);
        miniBoxDownloadTask.r0(wadlResult.speed);
        miniBoxDownloadTask.o0(wadlResult.taskStatus);
        miniBoxDownloadTask.p0(wadlResult.fileSize);
        miniBoxDownloadTask.q0(wadlResult.progress);
        miniBoxDownloadTask.m0(wadlResult.businessId);
        return miniBoxDownloadTask;
    }

    @NotNull
    public final String d(long time) {
        long j3 = 3600;
        long j16 = time / j3;
        String str = "";
        if (j16 > 0) {
            str = "" + j16 + "\u5c0f\u65f6";
        }
        long j17 = time % j3;
        long j18 = 60;
        long j19 = j17 % j18;
        long j26 = j17 / j18;
        if (j26 > 0) {
            return str + j26 + "\u5206\u949f";
        }
        if (j19 > 0) {
            return str + j19 + '\u79d2';
        }
        return "0\u79d2";
    }
}
