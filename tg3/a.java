package tg3;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.open.base.g;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tav.core.AssetExtension;
import com.tencent.tencentmap.mapsdk.maps.TencentMapServiceProtocol;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import sg3.ZPlanCosUGCAvatarKeyInfo;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0003H\u0002J \u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0003H\u0002J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J0\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0003H\u0002J*\u0010!\u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00020 2\u0006\u0010\u001f\u001a\u00020\u0003J\u001e\u0010$\u001a\u00020\u00132\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010#\u001a\u0004\u0018\u00010\u0011\u00a8\u0006'"}, d2 = {"Ltg3/a;", "", "", "", "cosFileList", "Ljava/io/File;", "rootDir", "", "i", "file", "Lyv4/a;", "d", WadlProxyConsts.PARAM_FILENAME, "", "f", "filePath", "signature", "Lsg3/a;", "ugcAvatarKeyInfo", "", "b", "c", "uploadFile", "e", "Ljava/net/URL;", "url", "fileMd5", TencentMapServiceProtocol.SERVICE_NAME_AUTHORIZATION, "token", "Lokhttp3/Response;", "g", "dirPath", "Lkotlin/Pair;", "a", "uploadCosFileList", "ugcAvatarInfoKey", h.F, "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f436326a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: tg3.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11289a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(((File) t16).getName(), ((File) t17).getName());
            return compareValues;
        }
    }

    a() {
    }

    private final boolean b(String filePath, String signature, ZPlanCosUGCAvatarKeyInfo ugcAvatarKeyInfo) {
        File file = new File(filePath);
        if (!(filePath.length() == 0) && file.exists() && file.isFile()) {
            String c16 = c(ugcAvatarKeyInfo, signature);
            String e16 = e(ugcAvatarKeyInfo, file);
            if (e16.length() == 0) {
                QLog.e("ZPlanCosUploadUtil", 1, "doUploadFileToCos failed, getCosURLString failed.");
                return false;
            }
            QLog.i("ZPlanCosUploadUtil", 1, "url: " + e16);
            String md5String = g.a(MD5.getFileMd5(filePath));
            try {
                URL url = new URL(e16);
                Intrinsics.checkNotNullExpressionValue(md5String, "md5String");
                Response g16 = g(file, url, md5String, c16, ugcAvatarKeyInfo.getToken());
                QLog.i("ZPlanCosUploadUtil", 1, "rspCode: " + g16.code() + ", requestID: " + g16.headers().values("x-cos-request-id") + ", requestTrace: " + g16.headers().values("x-cos-trace-id"));
                if (g16.code() == 200) {
                    return true;
                }
                QLog.e("ZPlanCosUploadUtil", 1, "doUploadFileToCos, request upload by okhttp error.");
                return false;
            } catch (Throwable th5) {
                QLog.e("ZPlanCosUploadUtil", 1, "doUploadFileToCos failed.", th5);
                return false;
            }
        }
        QLog.e("ZPlanCosUploadUtil", 1, "doUploadFileToCos failed, file invalid.");
        return false;
    }

    private final String c(ZPlanCosUGCAvatarKeyInfo ugcAvatarKeyInfo, String signature) {
        String secretId = ugcAvatarKeyInfo.getSecretId();
        String str = ugcAvatarKeyInfo.getSignatureBegin() + ";" + ugcAvatarKeyInfo.getSignatureEnd();
        return "q-sign-algorithm=sha1&q-ak=" + secretId + "&q-sign-time=" + str + "&q-key-time=" + str + "&q-header-list=content-length;host;x-cos-acl;x-cos-content-sha1&q-url-param-list=&q-signature=" + signature;
    }

    private final yv4.a d(File file) {
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        String fileName = file.getName();
        String a16 = g.a(MD5.getFileMd5(file.getAbsolutePath()));
        yv4.a aVar = new yv4.a();
        a aVar2 = f436326a;
        Intrinsics.checkNotNullExpressionValue(fileName, "fileName");
        aVar.f451321a = aVar2.f(fileName);
        aVar.f451322b = (int) file.length();
        aVar.f451323c = a16;
        return aVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0041. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String e(ZPlanCosUGCAvatarKeyInfo ugcAvatarKeyInfo, File uploadFile) {
        List split$default;
        List split$default2;
        Object last;
        String str;
        String name = uploadFile.getName();
        Intrinsics.checkNotNullExpressionValue(name, "uploadFile.name");
        split$default = StringsKt__StringsKt.split$default((CharSequence) name, new String[]{"."}, false, 0, 6, (Object) null);
        split$default2 = StringsKt__StringsKt.split$default((CharSequence) split$default.get(0), new String[]{"_"}, false, 0, 6, (Object) null);
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) split$default2);
        String str2 = (String) last;
        switch (str2.hashCode()) {
            case -1417816805:
                if (str2.equals("texture")) {
                    str = "Texture";
                    if (ugcAvatarKeyInfo.getCosDir().length() == 0) {
                        QLog.e("ZPlanCosUploadUtil", 1, "doUploadFileToCos failed, cosDir invalid.");
                        return "";
                    }
                    return "https://ugc.superqqshow.qq.com" + ugcAvatarKeyInfo.getCosDir() + "/" + str + "/" + uploadFile.getName();
                }
                QLog.e("ZPlanCosUploadUtil", 1, "get subDirName failed.");
                return "";
            case 3076010:
                if (str2.equals("data")) {
                    str = "OperateData";
                    if (ugcAvatarKeyInfo.getCosDir().length() == 0) {
                    }
                }
                QLog.e("ZPlanCosUploadUtil", 1, "get subDirName failed.");
                return "";
            case 3226745:
                if (str2.equals("icon")) {
                    str = "Icon";
                    if (ugcAvatarKeyInfo.getCosDir().length() == 0) {
                    }
                }
                QLog.e("ZPlanCosUploadUtil", 1, "get subDirName failed.");
                return "";
            case 1069482120:
                if (str2.equals("ParamsConfig")) {
                    str = "ConfigData";
                    if (ugcAvatarKeyInfo.getCosDir().length() == 0) {
                    }
                }
                QLog.e("ZPlanCosUploadUtil", 1, "get subDirName failed.");
                return "";
            case 1330532588:
                if (str2.equals(AssetExtension.SCENE_THUMBNAIL)) {
                    str = "Thumbnail";
                    if (ugcAvatarKeyInfo.getCosDir().length() == 0) {
                    }
                }
                QLog.e("ZPlanCosUploadUtil", 1, "get subDirName failed.");
                return "";
            default:
                QLog.e("ZPlanCosUploadUtil", 1, "get subDirName failed.");
                return "";
        }
    }

    private final int f(String fileName) {
        List split$default;
        Object last;
        List split$default2;
        if (fileName.length() == 0) {
            return -1;
        }
        split$default = StringsKt__StringsKt.split$default((CharSequence) fileName, new String[]{"_"}, false, 0, 6, (Object) null);
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) split$default);
        split$default2 = StringsKt__StringsKt.split$default((CharSequence) last, new String[]{"."}, false, 0, 6, (Object) null);
        String str = (String) split$default2.get(0);
        switch (str.hashCode()) {
            case -1417816805:
                if (str.equals("texture")) {
                    return 1;
                }
                break;
            case 3076010:
                if (str.equals("data")) {
                    return 3;
                }
                break;
            case 3226745:
                if (str.equals("icon")) {
                    return 2;
                }
                break;
            case 1069482120:
                if (str.equals("ParamsConfig")) {
                    return 4;
                }
                break;
            case 1330532588:
                if (str.equals(AssetExtension.SCENE_THUMBNAIL)) {
                    return 5;
                }
                break;
        }
        return -1;
    }

    private final Response g(File file, URL url, String fileMd5, String authorization, String token) {
        QLog.i("ZPlanCosUploadUtil", 1, "upload by okhttp: md5: " + fileMd5);
        return new OkHttpClient.Builder().retryOnConnectionFailure(true).readTimeout(60L, TimeUnit.SECONDS).build().newCall(new Request.Builder().addHeader("Authorization", authorization).addHeader("Content-Length", String.valueOf(file.length())).addHeader("Host", "ugc.superqqshow.qq.com").addHeader("x-cos-content-sha1", fileMd5).addHeader("x-cos-security-token", token).addHeader("x-cos-acl", "private").url(url).put(RequestBody.INSTANCE.create((MediaType) null, file)).build()).execute();
    }

    private final void i(List<String> cosFileList, File rootDir) {
        List sortedWith;
        if (rootDir.exists() && rootDir.isDirectory()) {
            File[] listFiles = rootDir.listFiles();
            if (listFiles != null) {
                ArrayList arrayList = new ArrayList();
                for (File file : listFiles) {
                    if (file.isFile()) {
                        arrayList.add(file);
                    }
                }
                sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new C11289a());
                if (sortedWith != null) {
                    Iterator it = sortedWith.iterator();
                    while (it.hasNext()) {
                        String absolutePath = ((File) it.next()).getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath, "it.absolutePath");
                        cosFileList.add(absolutePath);
                    }
                }
            }
            if (listFiles != null) {
                ArrayList<File> arrayList2 = new ArrayList();
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        arrayList2.add(file2);
                    }
                }
                for (File it5 : arrayList2) {
                    a aVar = f436326a;
                    Intrinsics.checkNotNullExpressionValue(it5, "it");
                    aVar.i(cosFileList, it5);
                }
            }
        }
    }

    public final Pair<List<String>, List<yv4.a>> a(String dirPath) {
        Intrinsics.checkNotNullParameter(dirPath, "dirPath");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (dirPath.length() == 0) {
            return new Pair<>(null, null);
        }
        File file = new File(dirPath);
        if (file.exists() && file.isDirectory()) {
            i(arrayList, file);
            if (arrayList.isEmpty()) {
                return new Pair<>(null, null);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                File file2 = new File((String) it.next());
                if (file2.exists() && file2.isFile()) {
                    yv4.a d16 = f436326a.d(file2);
                    if (d16 == null) {
                        return new Pair<>(null, null);
                    }
                    arrayList2.add(d16);
                    QLog.i("ZPlanCosUploadUtil", 1, "filename: " + file2.getName() + ", fileType: " + d16.f451321a);
                } else {
                    QLog.e("ZPlanCosUploadUtil", 1, "cosUploadPrepare failed, file in rootDir invalid.");
                    return new Pair<>(null, null);
                }
            }
            return new Pair<>(arrayList, arrayList2);
        }
        return new Pair<>(null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean h(List<String> uploadCosFileList, ZPlanCosUGCAvatarKeyInfo ugcAvatarInfoKey) {
        boolean z16;
        int length;
        int i3;
        Intrinsics.checkNotNullParameter(uploadCosFileList, "uploadCosFileList");
        String[] signatures = ugcAvatarInfoKey != null ? ugcAvatarInfoKey.getSignatures() : null;
        if (!uploadCosFileList.isEmpty()) {
            if (signatures != null) {
                if (!(signatures.length == 0)) {
                    z16 = false;
                    if (!z16 && uploadCosFileList.size() == signatures.length) {
                        length = signatures.length;
                        for (i3 = 0; i3 < length; i3++) {
                            if (!b(uploadCosFileList.get(i3), signatures[i3], ugcAvatarInfoKey)) {
                                QLog.e("ZPlanCosUploadUtil", 1, "uploadToCos failed.");
                                return false;
                            }
                        }
                        return true;
                    }
                }
            }
            z16 = true;
            if (!z16) {
                length = signatures.length;
                while (i3 < length) {
                }
                return true;
            }
        }
        QLog.e("ZPlanCosUploadUtil", 1, "uploadToCos failed, files or signatures invaild.");
        return false;
    }
}
