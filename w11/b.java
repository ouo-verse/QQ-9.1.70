package w11;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lw11/b;", "", "", "urlString", "Ljava/io/File;", "file", "", "a", "<init>", "()V", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f444160a = new b();

    b() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c6, code lost:
    
        if (r9 == null) goto L62;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(@Nullable String urlString, @NotNull File file) {
        boolean z16;
        HttpURLConnection httpURLConnection;
        FileOutputStream fileOutputStream;
        URLConnection openConnection;
        int responseCode;
        Intrinsics.checkNotNullParameter(file, "file");
        if (urlString != null && urlString.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            x11.b.f446855a.b("HttpUtils", "url is empty");
            return false;
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            openConnection = new URL(urlString).openConnection();
        } catch (Exception e16) {
            e = e16;
            httpURLConnection = null;
            fileOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            fileOutputStream = null;
        }
        if (openConnection != null) {
            httpURLConnection = (HttpURLConnection) openConnection;
            try {
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.connect();
                responseCode = httpURLConnection.getResponseCode();
            } catch (Exception e17) {
                e = e17;
                fileOutputStream = null;
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream = null;
            }
            if (responseCode == 200) {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[1024];
                        Ref.IntRef intRef = new Ref.IntRef();
                        while (true) {
                            int read = bufferedInputStream2.read(bArr);
                            intRef.element = read;
                            if (read != -1) {
                                fileOutputStream.write(bArr, 0, read);
                            } else {
                                bufferedInputStream2.close();
                                fileOutputStream.close();
                                httpURLConnection.disconnect();
                                return true;
                            }
                        }
                    } catch (Exception e18) {
                        e = e18;
                        bufferedInputStream = bufferedInputStream2;
                        try {
                            x11.b.f446855a.b("HttpUtils", Intrinsics.stringPlus("sendHttpGet failed, e:", e));
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        bufferedInputStream = bufferedInputStream2;
                        if (bufferedInputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        throw th;
                    }
                } catch (Exception e19) {
                    e = e19;
                    fileOutputStream = null;
                } catch (Throwable th9) {
                    th = th9;
                    fileOutputStream = null;
                }
            } else {
                x11.b.f446855a.d("HttpUtils", Intrinsics.stringPlus("sendHttpGet download failed, code: ", Integer.valueOf(responseCode)));
                httpURLConnection.disconnect();
                return false;
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
        }
    }
}
