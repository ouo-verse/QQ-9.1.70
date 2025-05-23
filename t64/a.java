package t64;

import android.os.Looper;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.luggage.wxa.bf.l0;
import com.tencent.qphone.base.util.QLog;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013JP\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007J\u0012\u0010\u000f\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\r\u001a\u00020\fJ\f\u0010\u0011\u001a\u00020\u0007*\u0004\u0018\u00010\u0010\u00a8\u0006\u0014"}, d2 = {"Lt64/a;", "", "", "url", "saveDir", WadlProxyConsts.PARAM_FILENAME, "Lkotlin/Function1;", "", "onSuccess", "onFailure", "c", "Ljava/io/InputStream;", "Ljava/io/File;", l0.NAME, "", "b", "Ljava/io/Closeable;", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f435496a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"t64/a$a", "Lokhttp3/Callback;", "Lokhttp3/Call;", "call", "Ljava/io/IOException;", "e", "", "onFailure", "Lokhttp3/Response;", "response", "onResponse", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: t64.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C11273a implements Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f435497a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f435498b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1<String, Unit> f435499c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<String, Unit> f435500d;

        /* JADX WARN: Multi-variable type inference failed */
        C11273a(String str, String str2, Function1<? super String, Unit> function1, Function1<? super String, Unit> function12) {
            this.f435497a = str;
            this.f435498b = str2;
            this.f435499c = function1;
            this.f435500d = function12;
        }

        @Override // okhttp3.Callback
        public void onFailure(@NotNull Call call, @NotNull IOException e16) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(e16, "e");
            b bVar = b.f435501a;
            bVar.a(bVar.b(this.f435497a));
            File b16 = bVar.b(this.f435497a + this.f435498b);
            Function1<String, Unit> function1 = this.f435499c;
            if (function1 != null) {
                String absolutePath = b16.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "it.absolutePath");
                function1.invoke(absolutePath);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(@NotNull Call call, @NotNull Response response) {
            InputStream byteStream;
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            QLog.d("FileDownloadUtil", 4, "isMainThread: " + Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()));
            b bVar = b.f435501a;
            bVar.a(bVar.b(this.f435497a));
            File b16 = bVar.b(this.f435497a + this.f435498b);
            ResponseBody body = response.body();
            if (body != null && (byteStream = body.byteStream()) != null) {
                Function1<String, Unit> function1 = this.f435500d;
                Function1<String, Unit> function12 = this.f435499c;
                if (a.f435496a.b(byteStream, b16)) {
                    if (function1 != null) {
                        String absolutePath = b16.getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath, "saveFile.absolutePath");
                        function1.invoke(absolutePath);
                        return;
                    }
                    return;
                }
                if (function12 != null) {
                    String absolutePath2 = b16.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath2, "saveFile.absolutePath");
                    function12.invoke(absolutePath2);
                    return;
                }
                return;
            }
            Function1<String, Unit> function13 = this.f435499c;
            if (function13 != null) {
                String absolutePath3 = b16.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath3, "saveFile.absolutePath");
                function13.invoke(absolutePath3);
            }
        }
    }

    a() {
    }

    @JvmStatic
    public static final void c(@NotNull String url, @NotNull String saveDir, @NotNull String fileName, @Nullable Function1<? super String, Unit> onSuccess, @Nullable Function1<? super String, Unit> onFailure) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(saveDir, "saveDir");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        File b16 = b.f435501a.b(saveDir + fileName);
        if (b16.isFile() && b16.exists()) {
            if (QLog.isColorLevel()) {
                QLog.i("FileDownloadUtil", 2, "startDownload download file is exists");
            }
            if (onSuccess != null) {
                String absolutePath = b16.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "downloadFile.absolutePath");
                onSuccess.invoke(absolutePath);
                return;
            }
            return;
        }
        new OkHttpClient.Builder().build().newCall(new Request.Builder().url(url).build()).enqueue(new C11273a(saveDir, fileName, onFailure, onSuccess));
    }

    public final void a(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e16) {
                QLog.e("FileDownloadUtil", 1, e16, new Object[0]);
            }
        }
    }

    public final boolean b(@NotNull InputStream inputStream, @NotNull File saveFile) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        Intrinsics.checkNotNullParameter(saveFile, "saveFile");
        Closeable closeable = null;
        try {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(saveFile);
                try {
                    byte[] bArr = new byte[2048];
                    Ref.IntRef intRef = new Ref.IntRef();
                    while (true) {
                        int read = inputStream.read(bArr);
                        intRef.element = read;
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            fileOutputStream.flush();
                            a(fileOutputStream);
                            a(inputStream);
                            return true;
                        }
                    }
                } catch (IOException e16) {
                    e = e16;
                    closeable = fileOutputStream;
                    QLog.e("FileDownloadUtil", 1, e, new Object[0]);
                    a(closeable);
                    a(inputStream);
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    closeable = fileOutputStream;
                    a(closeable);
                    a(inputStream);
                    throw th;
                }
            } catch (IOException e17) {
                e = e17;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
