package qp3;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.open.appcommon.Common;
import com.tencent.open.base.f;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    protected static String f429187a = "ImageDownloader";

    /* renamed from: b, reason: collision with root package name */
    protected static int f429188b = 2048;

    /* renamed from: c, reason: collision with root package name */
    protected static int f429189c = 1048576;

    protected static void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e16) {
                f.d("", "", e16);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x008d, code lost:
    
        r5 = com.tencent.open.appcommon.Common.l() + com.tencent.open.base.img.ImageCache.f341025a + r12.f429195f + java.io.File.separator + com.tencent.open.base.c.c(r12.f429191b);
        r7 = new java.io.File(r5 + com.tencent.oskplayer.cache.FileDataSink.TEMP_FILE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00cd, code lost:
    
        if (r7.getParent() == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00d7, code lost:
    
        if (r7.getParentFile().exists() != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d9, code lost:
    
        r7.getParentFile().mkdirs();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e4, code lost:
    
        if (r7.exists() == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e6, code lost:
    
        r7.delete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e9, code lost:
    
        r7.createNewFile();
        r8 = new java.io.FileOutputStream(r5 + com.tencent.oskplayer.cache.FileDataSink.TEMP_FILE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0100, code lost:
    
        r8.write(r6.toByteArray());
        r8.flush();
        r0 = new java.io.File(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0113, code lost:
    
        if (r0.exists() == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0115, code lost:
    
        r0.delete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0118, code lost:
    
        r7.renameTo(r0);
        com.tencent.open.base.f.a("has download", r12.f429190a);
        r12.f429194e = r3.getLastModified();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0129, code lost:
    
        r8.close();
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0130, code lost:
    
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0131, code lost:
    
        r12.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0139, code lost:
    
        r12 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0141, code lost:
    
        r2 = r7;
        r8 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0181, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x017d, code lost:
    
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0185, code lost:
    
        r12.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x018a, code lost:
    
        r3.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0179, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x013b, code lost:
    
        r12 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x013c, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x013e, code lost:
    
        r12 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x013f, code lost:
    
        r0 = null;
        r8 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x018f: MOVE (r2 I:??[OBJECT, ARRAY]) = (r8 I:??[OBJECT, ARRAY]) (LINE:400), block:B:113:0x018f */
    /* JADX WARN: Removed duplicated region for block: B:101:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0181 A[Catch: Exception -> 0x017d, TRY_LEAVE, TryCatch #10 {Exception -> 0x017d, blocks: (B:84:0x0179, B:75:0x0181), top: B:83:0x0179 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0179 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01a3  */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(d dVar) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        File file;
        FileOutputStream fileOutputStream;
        ?? r85;
        FileOutputStream fileOutputStream2 = null;
        fileOutputStream2 = null;
        r2 = null;
        fileOutputStream2 = null;
        File file2 = null;
        try {
            try {
                httpURLConnection = c(dVar);
            } catch (Exception e16) {
                e = e16;
                file = null;
                httpURLConnection = null;
                inputStream = null;
            } catch (Throwable th5) {
                th = th5;
                httpURLConnection = null;
                inputStream = null;
            }
            try {
                if (httpURLConnection == null) {
                    f.a(f429187a, "----- downImg " + dVar.f429191b + " (http == null)----");
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return false;
                }
                if (Common.p() < httpURLConnection.getContentLength()) {
                    f.a(f429187a, "----- downImg " + dVar.f429191b + " (SD\u5361 no space)----");
                    httpURLConnection.disconnect();
                    return false;
                }
                inputStream = httpURLConnection.getInputStream();
                try {
                    try {
                        byte[] bArr = new byte[f429188b];
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        long j3 = 0;
                        while (true) {
                            int read = inputStream.read(bArr, 0, f429188b);
                            if (read <= 0) {
                                break;
                            }
                            if (j3 >= f429189c) {
                                try {
                                    inputStream.close();
                                } catch (Exception e17) {
                                    e17.printStackTrace();
                                }
                                httpURLConnection.disconnect();
                                return false;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                            j3 += read;
                        }
                    } catch (Exception e18) {
                        e = e18;
                        file = null;
                        r85 = 0;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Exception e19) {
                            e19.printStackTrace();
                            if (httpURLConnection == null) {
                            }
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection == null) {
                        httpURLConnection.disconnect();
                        throw th;
                    }
                    throw th;
                }
                httpURLConnection.disconnect();
                return true;
            } catch (Exception e26) {
                e = e26;
                file = null;
                inputStream = null;
                r85 = inputStream;
                f.d(f429187a, "download>>>", e);
                if (file2 != null) {
                    file2.delete();
                }
                if (file != null) {
                    file.delete();
                }
                if (r85 != 0) {
                }
                if (inputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                return false;
            } catch (Throwable th7) {
                th = th7;
                inputStream = null;
            }
        } catch (Throwable th8) {
            th = th8;
            fileOutputStream2 = fileOutputStream;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0180, code lost:
    
        a(r0);
        r0 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected static HttpURLConnection c(d dVar) {
        HttpURLConnection httpURLConnection;
        String substring;
        String substring2;
        try {
            String insertMtype = MsfSdkUtils.insertMtype("yingyongbao", dVar.f429191b);
            String str = "";
            if (com.tencent.open.base.a.i(com.tencent.open.adapter.a.f().e())) {
                String f16 = com.tencent.open.base.a.f(com.tencent.open.adapter.a.f().e());
                String d16 = com.tencent.open.base.a.d(com.tencent.open.adapter.a.f().e());
                int indexOf = insertMtype.indexOf(47, 7);
                if (indexOf < 0) {
                    substring = insertMtype.substring(7);
                    substring2 = "";
                } else {
                    substring = insertMtype.substring(7, indexOf);
                    substring2 = insertMtype.substring(indexOf);
                }
                f.a(f429187a, "https://" + f16 + ":" + d16 + substring2);
                httpURLConnection = (HttpURLConnection) new URL("http://" + f16 + ":" + d16 + substring2).openConnection();
                try {
                    httpURLConnection.setRequestProperty("X-Online-Host", substring);
                } catch (Exception e16) {
                    e = e16;
                    f.d(f429187a, "--getHttpConnection-- Exception!!!", e);
                    a(httpURLConnection);
                    return null;
                }
            } else {
                httpURLConnection = (HttpURLConnection) new URL(insertMtype).openConnection();
            }
            httpURLConnection.setRequestMethod("GET");
            boolean z16 = true;
            httpURLConnection.setDoInput(true);
            httpURLConnection.setAllowUserInteraction(true);
            httpURLConnection.setConnectTimeout(60000);
            httpURLConnection.setReadTimeout(120000);
            if (dVar.f429194e > 0) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                httpURLConnection.setRequestProperty("If-Modified-Since", simpleDateFormat.format(new Date(dVar.f429194e)));
            }
            int responseCode = httpURLConnection.getResponseCode();
            f.a(f429187a, "--getHttpConnection-- reponseCode=" + responseCode);
            if (responseCode != 302 && responseCode != 301) {
                if (responseCode != 200 && responseCode != 206) {
                    if (responseCode == 304) {
                        f.a(f429187a, "--getimg-- " + dVar.f429191b + " not modified");
                        dVar.f429192c = d(httpURLConnection) * 1000;
                        dVar.f429193d = System.currentTimeMillis();
                        a(httpURLConnection);
                    } else {
                        a(httpURLConnection);
                    }
                    httpURLConnection = null;
                    f.a(f429187a, "--getHttpConnection-- uc=" + httpURLConnection);
                    return httpURLConnection;
                }
                String contentType = httpURLConnection.getContentType();
                if (contentType != null) {
                    str = contentType.toLowerCase();
                }
                if (str.indexOf("text/vnd.wap.wml") == -1 && str.indexOf("application/vnd.wap.wmlc") == -1 && str.indexOf("text") == -1) {
                    z16 = false;
                }
                if (httpURLConnection != null) {
                    long d17 = d(httpURLConnection) * 1000;
                    dVar.f429192c = d17;
                    if (d17 == 0) {
                        dVar.f429192c = 86400000L;
                    }
                }
                dVar.f429193d = System.currentTimeMillis();
                f.a(f429187a, "--getHttpConnection-- uc=" + httpURLConnection);
                return httpURLConnection;
            }
            String headerField = httpURLConnection.getHeaderField("Location");
            f.a(f429187a, "--getHttpConnection-- loc=" + headerField);
            a(httpURLConnection);
            httpURLConnection = null;
            f.a(f429187a, "--getHttpConnection-- uc=" + httpURLConnection);
            return httpURLConnection;
        } catch (Exception e17) {
            e = e17;
            httpURLConnection = null;
        }
    }

    protected static long d(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Cache-Control");
        if (headerField == null) {
            return 0L;
        }
        String[] split = TextUtils.split(headerField, ",");
        for (int i3 = 0; i3 < split.length; i3++) {
            if (split[i3].contains("max-age")) {
                return Long.parseLong(split[i3].trim().replace("max-age=", ""));
            }
        }
        return 0L;
    }
}
