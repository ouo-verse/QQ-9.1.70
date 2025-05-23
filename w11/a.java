package w11;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.localedit.fakenative.meta.WebResourceReq;
import com.tencent.localedit.fakenative.meta.WebResourceResp;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b2\u00103J@\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0011\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0012\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0015\u0010\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00182\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u001d\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004J\u0016\u0010\"\u001a\u00020!2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0004J\u0018\u0010$\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010\u00022\u0006\u0010 \u001a\u00020\u0004J\u000e\u0010%\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0004J\"\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010&\u001a\u00020\u00182\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010)\u001a\u00020\u0014J\u0010\u0010,\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\u0016\u0010/\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0004J\u000e\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0002\u00a8\u00064"}, d2 = {"Lw11/a;", "", "Ljava/io/InputStream;", "data", "", "mimeType", "", "headers", "encoding", "Lcom/tencent/localedit/fakenative/meta/WebResourceResp;", "d", "url", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "a", "", "p", "o", "l", "routeUrl", "", h.F, "(Ljava/lang/String;)Ljava/lang/Integer;", "localFilePath", "", "cacheMaxAge", "b", "Lcom/tencent/localedit/fakenative/meta/WebResourceReq;", Const.BUNDLE_KEY_REQUEST, ReportConstant.COSTREPORT_PREFIX, "path", "i", "dstFilePath", "", "r", "dataStream", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "f", "offset", "Ljava/io/File;", "file", "blockSize", "", "g", "j", "zipFilePath", "destDirPath", "t", "inputStream", "k", "<init>", "()V", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f444159a = new a();

    a() {
    }

    public static /* synthetic */ WebResourceResp c(a aVar, String str, long j3, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = -1;
        }
        if ((i3 & 4) != 0) {
            str2 = null;
        }
        return aVar.b(str, j3, str2);
    }

    private final WebResourceResp d(InputStream data, String mimeType, Map<String, String> headers, String encoding) {
        WebResourceResp webResourceResp = new WebResourceResp();
        if (mimeType != null) {
            webResourceResp.setMimeType(mimeType);
        }
        if (headers == null) {
            headers = new HashMap<>();
        }
        HashMap hashMap = new HashMap(headers);
        if (!hashMap.containsKey("Access-Control-Allow-Origin")) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            String lowerCase = "Access-Control-Allow-Origin".toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            if (!hashMap.containsKey(lowerCase)) {
                hashMap.put("Access-Control-Allow-Origin", "*");
            }
        }
        webResourceResp.setResponseHeaders(hashMap);
        if (encoding != null) {
            if (!webResourceResp.getResponseHeaders().containsKey("Content-Encoding")) {
                Map<String, String> responseHeaders = webResourceResp.getResponseHeaders();
                Locale locale2 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale2, "getDefault()");
                String lowerCase2 = "Content-Encoding".toLowerCase(locale2);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                if (!responseHeaders.containsKey(lowerCase2)) {
                    webResourceResp.getResponseHeaders().put("Content-Encoding", encoding);
                }
            }
            webResourceResp.setEncoding(encoding);
        }
        webResourceResp.setInputStream(data);
        return webResourceResp;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ WebResourceResp e(a aVar, InputStream inputStream, String str, Map map, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = null;
        }
        if ((i3 & 4) != 0) {
            map = null;
        }
        if ((i3 & 8) != 0) {
            str2 = null;
        }
        return aVar.d(inputStream, str, map, str2);
    }

    private final String m(String url) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(url);
        if (Intrinsics.areEqual(fileExtensionFromUrl, EnginePathProvider.ENGINE_JS_DIR)) {
            return "application/x-javascript";
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        if (mimeTypeFromExtension == null) {
            return "*/*";
        }
        return mimeTypeFromExtension;
    }

    @Nullable
    public final String a(@Nullable String url) {
        String replace$default;
        if (!p(url)) {
            return url;
        }
        String queryParameter = Uri.parse(url).getQueryParameter("client");
        if (queryParameter == null) {
            queryParameter = "desktop_local";
        }
        Intrinsics.checkNotNull(url);
        replace$default = StringsKt__StringsJVMKt.replace$default(url, "/local_edit", "/index." + queryParameter + ".html", false, 4, (Object) null);
        return replace$default;
    }

    @Nullable
    public final WebResourceResp b(@NotNull String localFilePath, long cacheMaxAge, @Nullable String mimeType) {
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(localFilePath, "localFilePath");
        if (!new File(localFilePath).exists()) {
            x11.b.f446855a.d("getWebResourceFromLocal", Intrinsics.stringPlus("getResponse local file not exists :", localFilePath));
            return null;
        }
        if (mimeType == null) {
            mimeType = m(localFilePath);
        }
        String str = mimeType;
        try {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(new BufferedInputStream(new FileInputStream(localFilePath)));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            x11.b.f446855a.c("getWebResourceFromLocal", "error opening file", m479exceptionOrNullimpl);
        }
        if (Result.m482isFailureimpl(m476constructorimpl)) {
            m476constructorimpl = null;
        }
        BufferedInputStream bufferedInputStream = (BufferedInputStream) m476constructorimpl;
        if (bufferedInputStream == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cacheMaxAge >= 0) {
            linkedHashMap.put("Cache-Control", Intrinsics.stringPlus("max-age=", Long.valueOf(cacheMaxAge)));
        }
        return e(this, bufferedInputStream, str, linkedHashMap, null, 8, null);
    }

    public final boolean f(@NotNull String dstFilePath) {
        Object m476constructorimpl;
        boolean z16;
        Unit unit;
        String str;
        Intrinsics.checkNotNullParameter(dstFilePath, "dstFilePath");
        boolean z17 = false;
        try {
            Result.Companion companion = Result.INSTANCE;
            if (dstFilePath.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            unit = null;
            if (z16) {
                str = dstFilePath;
            } else {
                str = null;
            }
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (str == null) {
            x11.b.f446855a.b("FakeNativeUtils", "deleteFile dstFilePath is empty");
            return false;
        }
        File file = new File(dstFilePath);
        if (!file.exists()) {
            file = null;
        }
        if (file != null) {
            if (file.isDirectory()) {
                z17 = FilesKt__UtilsKt.deleteRecursively(file);
            } else {
                z17 = file.delete();
            }
            unit = Unit.INSTANCE;
        }
        m476constructorimpl = Result.m476constructorimpl(unit);
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            x11.b.f446855a.b("FakeNativeUtils", "deleteFile failed " + m479exceptionOrNullimpl + " , dstFilePath=" + dstFilePath);
        }
        return z17;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] g(long offset, @Nullable File file, int blockSize) {
        RandomAccessFile randomAccessFile;
        byte[] bArr = new byte[blockSize];
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (IOException e16) {
            e = e16;
            randomAccessFile = null;
        } catch (Throwable th5) {
            th = th5;
            if (randomAccessFile2 != null) {
            }
            throw th;
        }
        try {
            try {
                randomAccessFile.seek(offset);
                int read = randomAccessFile.read(bArr);
                if (read == -1) {
                    bArr = null;
                } else if (read != blockSize) {
                    byte[] bArr2 = new byte[read];
                    System.arraycopy(bArr, 0, bArr2, 0, read);
                    bArr = bArr2;
                }
                try {
                    randomAccessFile.close();
                } catch (IOException e17) {
                    x11.b.f446855a.b("FakeNativeUtils", Intrinsics.stringPlus("piece_upload getBlock e ", e17));
                }
                return bArr;
            } catch (Throwable th6) {
                th = th6;
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (IOException e18) {
                        x11.b.f446855a.b("FakeNativeUtils", Intrinsics.stringPlus("piece_upload getBlock e ", e18));
                    }
                }
                throw th;
            }
        } catch (IOException e19) {
            e = e19;
            x11.b.f446855a.b("FakeNativeUtils", Intrinsics.stringPlus("piece_upload getBlock e ", e));
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e26) {
                    x11.b.f446855a.b("FakeNativeUtils", Intrinsics.stringPlus("piece_upload getBlock e ", e26));
                }
            }
            x11.b.f446855a.b("FakeNativeUtils", "piece_upload getBlock \u5931\u8d25");
            return null;
        }
    }

    @Nullable
    public final Integer h(@Nullable String routeUrl) {
        Object m476constructorimpl;
        List split$default;
        Object last;
        List split$default2;
        Object first;
        Object obj = null;
        if (routeUrl == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            split$default = StringsKt__StringsKt.split$default((CharSequence) routeUrl, new String[]{"docs.qq.com/"}, false, 0, 6, (Object) null);
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) split$default);
            split$default2 = StringsKt__StringsKt.split$default((CharSequence) last, new String[]{"/"}, false, 0, 6, (Object) null);
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) split$default2);
            m476constructorimpl = Result.m476constructorimpl(com.tencent.localedit.a.a().get((String) first));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            x11.b.f446855a.c("FakeNativeUtils", Intrinsics.stringPlus("\u65e0\u6cd5\u89e3\u6790\u6587\u6863url ", this), m479exceptionOrNullimpl);
        }
        if (!Result.m482isFailureimpl(m476constructorimpl)) {
            obj = m476constructorimpl;
        }
        return (Integer) obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0090  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String i(@NotNull String path) {
        BufferedReader bufferedReader;
        Intrinsics.checkNotNullParameter(path, "path");
        StringBuilder sb5 = new StringBuilder();
        FileInputStream fileInputStream = null;
        try {
            boolean exists = new File(path).exists();
            x11.b.f446855a.d("FakeNativeUtils", Intrinsics.stringPlus("getFileDataFromPath file exists: ", Boolean.valueOf(exists)));
            if (exists) {
                FileInputStream fileInputStream2 = new FileInputStream(path);
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream2));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb5.append(readLine);
                        } catch (IOException e16) {
                            e = e16;
                            fileInputStream = fileInputStream2;
                            try {
                                x11.b.f446855a.c("FakeNativeUtils", "getFileDataFromPath error: ", e);
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                return "";
                            } catch (Throwable th5) {
                                th = th5;
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            throw th;
                        }
                    }
                    fileInputStream = fileInputStream2;
                } catch (IOException e17) {
                    e = e17;
                    bufferedReader = null;
                } catch (Throwable th7) {
                    th = th7;
                    bufferedReader = null;
                }
            } else {
                bufferedReader = null;
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "stringBuilder.toString()");
            return sb6;
        } catch (IOException e18) {
            e = e18;
            bufferedReader = null;
        } catch (Throwable th8) {
            th = th8;
            bufferedReader = null;
        }
    }

    @NotNull
    public final String j(@Nullable String url) {
        boolean z16;
        Object m476constructorimpl;
        MessageDigest messageDigest;
        Charset charset;
        int i3 = 0;
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            return uuid;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.reset();
            charset = Charsets.UTF_8;
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (url != null) {
            byte[] bytes = url.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            messageDigest.update(bytes);
            StringBuilder sb5 = new StringBuilder();
            byte[] digest = messageDigest.digest();
            Intrinsics.checkNotNullExpressionValue(digest, "algorithm.digest()");
            int length = digest.length;
            while (i3 < length) {
                byte b16 = digest[i3];
                i3++;
                int i16 = b16 & 255;
                if (i16 < 16) {
                    sb5.append("0");
                }
                sb5.append(Integer.toHexString(i16));
            }
            m476constructorimpl = Result.m476constructorimpl(sb5.toString());
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                x11.b.f446855a.b("FakeNativeUtils", Intrinsics.stringPlus("getFileNameFromUrl failed, e:", m479exceptionOrNullimpl));
            }
            String uuid2 = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid2, "randomUUID().toString()");
            if (Result.m482isFailureimpl(m476constructorimpl)) {
                m476constructorimpl = uuid2;
            }
            return (String) m476constructorimpl;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @NotNull
    public final String k(@NotNull InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        int read = inputStream.read();
        int read2 = inputStream.read();
        int read3 = inputStream.read();
        if (read == 66 && read2 == 77) {
            return ".bmp";
        }
        if (read == 137 && read2 == 80) {
            return ".png";
        }
        if (read == 71 && read2 == 73) {
            return QzoneEmotionUtils.SIGN_ICON_URL_END;
        }
        if (read == 255 && read2 == 216) {
            return ".jpg";
        }
        if (82 == read && 73 == read2 && 70 == read3) {
            return ".webp";
        }
        return ".dat";
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0006, code lost:
    
        r9 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r9, new java.lang.String[]{cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER}, false, 0, 6, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0023, code lost:
    
        r9 = kotlin.text.StringsKt__StringsKt.removePrefix(r9, (java.lang.CharSequence) "https://docs.qq.com/local-edit/media/");
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String l(@Nullable String url) {
        List split$default;
        String removePrefix;
        if (url == null || split$default == null || (r9 = (String) split$default.get(0)) == null || removePrefix == null) {
            return "";
        }
        return removePrefix;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0010, code lost:
    
        r0 = kotlin.text.StringsKt__StringsKt.indexOf$default((java.lang.CharSequence) r13, ":", 0, false, 6, (java.lang.Object) null);
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String n(@NotNull String url) {
        int indexOf$default;
        int i3;
        List split$default;
        boolean contains$default;
        List split$default2;
        Intrinsics.checkNotNullParameter(url, "url");
        if (TextUtils.isEmpty(url) || indexOf$default < 0 || (i3 = indexOf$default + 3) >= url.length()) {
            return "";
        }
        String substring = url.substring(i3);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
        split$default = StringsKt__StringsKt.split$default((CharSequence) substring, new String[]{QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER}, false, 0, 6, (Object) null);
        Object[] array = split$default.toArray(new String[0]);
        if (array != null) {
            String[] strArr = (String[]) array;
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) strArr[0], (CharSequence) "#", false, 2, (Object) null);
            if (contains$default) {
                split$default2 = StringsKt__StringsKt.split$default((CharSequence) strArr[0], new String[]{"#"}, false, 0, 6, (Object) null);
                Object[] array2 = split$default2.toArray(new String[0]);
                if (array2 != null) {
                    strArr = (String[]) array2;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            return strArr[0];
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final boolean o(@Nullable String url) {
        boolean startsWith$default;
        if (url == null) {
            return false;
        }
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "https://docs.qq.com/local-edit/media/", false, 2, null);
        if (!startsWith$default) {
            return false;
        }
        return true;
    }

    public final boolean p(@Nullable String url) {
        if (url == null || !com.tencent.localedit.a.c().matches(url)) {
            return false;
        }
        return true;
    }

    public final void q(@Nullable InputStream dataStream, @NotNull String dstFilePath) {
        boolean z16;
        Object m476constructorimpl;
        Result m475boximpl;
        Intrinsics.checkNotNullParameter(dstFilePath, "dstFilePath");
        if (dstFilePath.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            x11.b.f446855a.b("FakeNativeUtils", Intrinsics.stringPlus("saveDataToFile error: dstFilePath=", dstFilePath));
            return;
        }
        File file = new File(dstFilePath);
        if (!file.exists() && !file.createNewFile()) {
            x11.b.f446855a.b("FakeNativeUtils", Intrinsics.stringPlus("saveDataToFile createNewFile error: dstFilePath=", dstFilePath));
            return;
        }
        if (dataStream == null) {
            m475boximpl = null;
        } else {
            try {
                Result.Companion companion = Result.INSTANCE;
                FileOutputStream fileOutputStream = new FileOutputStream(dstFilePath);
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = dataStream.read(bArr);
                    if (read == -1) {
                        break;
                    } else {
                        fileOutputStream.write(bArr, 0, read);
                    }
                }
                fileOutputStream.close();
                dataStream.close();
                m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                x11.b.f446855a.b("FakeNativeUtils", Intrinsics.stringPlus("saveDataToFile IOException: ", m479exceptionOrNullimpl));
            }
            m475boximpl = Result.m475boximpl(m476constructorimpl);
        }
        if (m475boximpl == null) {
            x11.b.f446855a.b("FakeNativeUtils", "saveDataToFile dataStream is empty");
        }
    }

    public final void r(@NotNull String data, @NotNull String dstFilePath) {
        boolean z16;
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(dstFilePath, "dstFilePath");
        boolean z17 = true;
        if (data.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (dstFilePath.length() != 0) {
                z17 = false;
            }
            if (!z17) {
                File file = new File(dstFilePath);
                if (!file.exists() && !file.createNewFile()) {
                    x11.b.f446855a.b("FakeNativeUtils", "saveDataToFile createNewFile error: data=" + data + " | dstFilePath=" + dstFilePath);
                    return;
                }
                try {
                    Result.Companion companion = Result.INSTANCE;
                    FileOutputStream fileOutputStream = new FileOutputStream(dstFilePath);
                    byte[] bytes = data.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int read = byteArrayInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, read);
                        }
                    }
                    fileOutputStream.close();
                    byteArrayInputStream.close();
                    m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
                Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                if (m479exceptionOrNullimpl != null) {
                    x11.b.f446855a.b("FakeNativeUtils", Intrinsics.stringPlus("saveDataToFile IOException: ", m479exceptionOrNullimpl));
                    return;
                }
                return;
            }
        }
        x11.b.f446855a.b("FakeNativeUtils", "saveDataToFile error: data=" + data + " | dstFilePath=" + dstFilePath);
    }

    public final boolean s(@Nullable WebResourceReq request) {
        Map<String, String> requestHeaders;
        String str;
        boolean z16;
        if (request == null || (requestHeaders = request.getRequestHeaders()) == null || (str = requestHeaders.get("Cache-Control")) == null) {
            return true;
        }
        String lowerCase = str.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        if (lowerCase == null) {
            return true;
        }
        if (!Intrinsics.areEqual(lowerCase, "no-store") && !Intrinsics.areEqual(lowerCase, "no-cache")) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            lowerCase = null;
        }
        if (lowerCase == null) {
            return true;
        }
        return false;
    }

    public final boolean t(@NotNull String zipFilePath, @NotNull String destDirPath) {
        Intrinsics.checkNotNullParameter(zipFilePath, "zipFilePath");
        Intrinsics.checkNotNullParameter(destDirPath, "destDirPath");
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(zipFilePath);
                try {
                    File file = new File(destDirPath);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    Enumeration<? extends ZipEntry> entries = zipFile2.entries();
                    Intrinsics.checkNotNullExpressionValue(entries, "zipFile.entries()");
                    while (entries.hasMoreElements()) {
                        ZipEntry nextElement = entries.nextElement();
                        if (nextElement != null) {
                            ZipEntry zipEntry = nextElement;
                            String name = zipEntry.getName();
                            Intrinsics.checkNotNullExpressionValue(name, "zipEntry.name");
                            File file2 = new File(file, name);
                            if (zipEntry.isDirectory()) {
                                file2.mkdirs();
                            } else {
                                File parentFile = file2.getParentFile();
                                if (parentFile != null) {
                                    parentFile.mkdirs();
                                }
                                BufferedInputStream bufferedInputStream = new BufferedInputStream(zipFile2.getInputStream(zipEntry));
                                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2), 1024);
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = bufferedInputStream.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    }
                                    bufferedOutputStream.write(bArr, 0, read);
                                }
                                bufferedInputStream.close();
                                bufferedOutputStream.flush();
                                bufferedOutputStream.close();
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type java.util.zip.ZipEntry");
                        }
                    }
                    zipFile2.close();
                    return true;
                } catch (Exception e16) {
                    e = e16;
                    zipFile = zipFile2;
                    x11.b.f446855a.b("FakeNativeUtils", Intrinsics.stringPlus("unzipFile failed, e:", e));
                    if (zipFile != null) {
                        zipFile.close();
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    zipFile = zipFile2;
                    if (zipFile != null) {
                        zipFile.close();
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }
}
