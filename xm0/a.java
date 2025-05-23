package xm0;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\n\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\u0019\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\u00a8\u0006\u001c"}, d2 = {"Lxm0/a;", "", "", "b", "Ljava/lang/String;", "getPROCESS_NAME_MAIN", "()Ljava/lang/String;", "PROCESS_NAME_MAIN", "c", "e", "MAIN_CLIENT_NAME", "d", "getPROCESS_NAME_TOOL", "PROCESS_NAME_TOOL", "g", "TOOL_CLIENT_NAME", "f", "a", "DOWNLOADINFO_KEY", "DOWNLOADIN_JSON_KEY", h.F, "PROCESS_NAME_KEY", "i", "DOWNLOAD_ACTION", "j", "DOWNLOAD_CALLBACK_ACTION", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f448135a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String PROCESS_NAME_MAIN = "com.tencent.mobileqq";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String MAIN_CLIENT_NAME = "DownloadIPCMainClient";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String PROCESS_NAME_TOOL = "com.tencent.mobileqq:tool";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TOOL_CLIENT_NAME = "DownloadIPCWebClient";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String DOWNLOADINFO_KEY = "downloadInfo";

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String DOWNLOADIN_JSON_KEY = "downloadJson";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String PROCESS_NAME_KEY = "processName";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String DOWNLOAD_ACTION = "downloadJson";

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String DOWNLOAD_CALLBACK_ACTION = "downloadCallBack";

    a() {
    }

    @NotNull
    public final String a() {
        return DOWNLOADINFO_KEY;
    }

    @NotNull
    public final String b() {
        return DOWNLOADIN_JSON_KEY;
    }

    @NotNull
    public final String c() {
        return DOWNLOAD_ACTION;
    }

    @NotNull
    public final String d() {
        return DOWNLOAD_CALLBACK_ACTION;
    }

    @NotNull
    public final String e() {
        return MAIN_CLIENT_NAME;
    }

    @NotNull
    public final String f() {
        return PROCESS_NAME_KEY;
    }

    @NotNull
    public final String g() {
        return TOOL_CLIENT_NAME;
    }
}
