package zj3;

import android.text.TextUtils;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rdelivery.reshub.FileSuffix;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import wj3.ZPlanResHubPathParam;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\b\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\t\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u001c\u0010\u000b\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J#\u0010\u000e\u001a\u00020\u00022\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\f\"\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0005H\u0016R\u0014\u0010\u001a\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0019R \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001d\u00a8\u0006!"}, d2 = {"Lzj3/j;", "Lcom/tencent/rdelivery/reshub/api/d;", "", "fullDownloadUrl", tl.h.F, "Lcom/tencent/rdelivery/reshub/api/e;", "type", "fileExtension", "f", "d", QzoneZipCacheHelper.DIR, "e", "", "path", "g", "([Ljava/lang/String;)Ljava/lang/String;", "resId", "Lwj3/b;", "saveParam", "", "i", "pathParam", "b", "c", "a", "Ljava/lang/String;", "downloadFolderPath", "internalDownloadFolderPath", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "customDownloadPathMap", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class j implements com.tencent.rdelivery.reshub.api.d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String downloadFolderPath;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String internalDownloadFolderPath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, ZPlanResHubPathParam> customDownloadPathMap = new ConcurrentHashMap<>();

    public j() {
        BaseApplication context = BaseApplication.getContext();
        File externalFilesDir = context.getExternalFilesDir(null);
        String path = externalFilesDir != null ? externalFilesDir.getPath() : null;
        if (path == null) {
            path = context.getFilesDir().getPath();
            Intrinsics.checkNotNullExpressionValue(path, "context.filesDir.path");
        }
        this.downloadFolderPath = path;
        String path2 = context.getFilesDir().getPath();
        Intrinsics.checkNotNullExpressionValue(path2, "context.filesDir.path");
        this.internalDownloadFolderPath = path2;
        QLog.i("ZPlanShiplyRes_StorageImpl", 1, "init, downloadFolderPath= " + path + ",internalDownloadFolderPath = " + path2 + " ");
    }

    private final String d(com.tencent.rdelivery.reshub.api.e eVar, String str) {
        return g(this.internalDownloadFolderPath + File.separator + "ZRes", g(eVar.d(), eVar.e(), com.tencent.rdelivery.reshub.core.g.h().getConfigStoreSuffix(), str), eVar.getResId(), eVar.b());
    }

    private final String e(com.tencent.rdelivery.reshub.api.e eVar, String str, String str2) {
        String str3 = eVar.getResId() + "_" + eVar.b() + str2;
        if (Intrinsics.areEqual(SoLoadConstants.SONAME_AV_HEVC_DEC, eVar.getResId()) || Intrinsics.areEqual(SoLoadConstants.SONAME_AV_HEVC_ENC, eVar.getResId()) || Intrinsics.areEqual("r265_enc", eVar.getResId())) {
            str3 = StringsKt__StringsKt.substringAfterLast$default(eVar.g(), "/", (String) null, 2, (Object) null);
        }
        return g(str, str3);
    }

    private final String f(com.tencent.rdelivery.reshub.api.e eVar, String str, String str2) {
        String d16 = d(eVar, str);
        if (str2 != null) {
            return e(eVar, d16, str2);
        }
        return d16 + File.separator;
    }

    private final String g(String... path) {
        String joinToString$default;
        boolean isBlank;
        ArrayList arrayList = new ArrayList();
        for (String str : path) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                arrayList.add(str);
            }
        }
        String separator = File.separator;
        Intrinsics.checkNotNullExpressionValue(separator, "separator");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, separator, null, null, 0, null, null, 62, null);
        return joinToString$default;
    }

    private final String h(String fullDownloadUrl) {
        boolean endsWith$default;
        String substringAfterLast$default;
        boolean contains$default;
        if (!TextUtils.isEmpty(fullDownloadUrl)) {
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(fullDownloadUrl, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, false, 2, null);
            if (endsWith$default) {
                fullDownloadUrl = StringsKt__StringsKt.substringBeforeLast$default(fullDownloadUrl, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, (String) null, 2, (Object) null);
            }
            substringAfterLast$default = StringsKt__StringsKt.substringAfterLast$default(fullDownloadUrl, ".", (String) null, 2, (Object) null);
            String separator = File.separator;
            Intrinsics.checkNotNullExpressionValue(separator, "separator");
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) substringAfterLast$default, (CharSequence) separator, false, 2, (Object) null);
            if (contains$default) {
                substringAfterLast$default = "pak";
            }
            return "." + substringAfterLast$default;
        }
        return "";
    }

    @Override // com.tencent.rdelivery.reshub.api.d
    public String a(com.tencent.rdelivery.reshub.api.e pathParam) {
        Intrinsics.checkNotNullParameter(pathParam, "pathParam");
        ZPlanResHubPathParam zPlanResHubPathParam = this.customDownloadPathMap.get(pathParam.getResId());
        String unzipPath = zPlanResHubPathParam != null ? zPlanResHubPathParam.getUnzipPath() : null;
        if (!TextUtils.isEmpty(unzipPath)) {
            String str = this.downloadFolderPath;
            String str2 = File.separator;
            return str + str2 + unzipPath + str2;
        }
        return f(pathParam, "unzip", null);
    }

    @Override // com.tencent.rdelivery.reshub.api.d
    public String b(com.tencent.rdelivery.reshub.api.e pathParam) {
        boolean endsWith$default;
        Intrinsics.checkNotNullParameter(pathParam, "pathParam");
        ZPlanResHubPathParam zPlanResHubPathParam = this.customDownloadPathMap.get(pathParam.getResId());
        String resSavaPath = zPlanResHubPathParam != null ? zPlanResHubPathParam.getResSavaPath() : null;
        if (!TextUtils.isEmpty(resSavaPath)) {
            String h16 = h(pathParam.g());
            String str = this.downloadFolderPath;
            String separator = File.separator;
            String str2 = str + separator + resSavaPath;
            Intrinsics.checkNotNullExpressionValue(separator, "separator");
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str2, separator, false, 2, null);
            if (!endsWith$default) {
                return str2 + h16;
            }
            return e(pathParam, str2, FileSuffix.RES_FILE);
        }
        return f(pathParam, "res", FileSuffix.RES_FILE);
    }

    @Override // com.tencent.rdelivery.reshub.api.d
    public String c(com.tencent.rdelivery.reshub.api.e pathParam) {
        Intrinsics.checkNotNullParameter(pathParam, "pathParam");
        ZPlanResHubPathParam zPlanResHubPathParam = this.customDownloadPathMap.get(pathParam.getResId());
        String diffPatchPath = zPlanResHubPathParam != null ? zPlanResHubPathParam.getDiffPatchPath() : null;
        if (!TextUtils.isEmpty(diffPatchPath)) {
            return e(pathParam, this.downloadFolderPath + File.separator + diffPatchPath, ".diff");
        }
        return f(pathParam, "diff", ".diff");
    }

    public final void i(String resId, ZPlanResHubPathParam saveParam) {
        Intrinsics.checkNotNullParameter(resId, "resId");
        Intrinsics.checkNotNullParameter(saveParam, "saveParam");
        this.customDownloadPathMap.put(resId, saveParam);
    }
}
