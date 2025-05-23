package t11;

import android.net.Uri;
import com.tencent.localedit.LocalEditSDK;
import com.tencent.localedit.fakenative.convert.c;
import com.tencent.localedit.fakenative.meta.FileIORequestData;
import com.tencent.localedit.fakenative.meta.WebResourceReq;
import com.tencent.localedit.fakenative.meta.WebResourceResp;
import com.tencent.localedit.fakenative.preload.FilePreloadManager;
import com.tencent.localedit.fakenative.resource.e;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import u11.d;
import x11.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001\bB\u0011\b\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\n\u001a\u00020\tH\u0014J\b\u0010\f\u001a\u00020\u000bH\u0014J\b\u0010\u000e\u001a\u00020\rH\u0014J\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fH\u0014J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\u0006\u0010\u0014\u001a\u00020\u0002R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0016R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001b\u00a8\u0006 "}, d2 = {"Lt11/a;", "Lu11/d;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "Lcom/tencent/localedit/fakenative/convert/c;", "c", "Lcom/tencent/localedit/fakenative/resource/e;", "a", "Lcom/tencent/localedit/fakenative/localserver/b;", "d", "Lcom/tencent/localedit/fakenative/packages/a;", "f", "Lv11/a;", "b", "Lcom/tencent/localedit/fakenative/intercept/c;", "Lcom/tencent/localedit/fakenative/meta/WebResourceReq;", "Lcom/tencent/localedit/fakenative/meta/WebResourceResp;", "e", "dispose", DomainData.DOMAIN_NAME, "", "Ljava/lang/String;", "currentUrl", "filePath", "globalPadId", "", "I", "currentDocsType", "<init>", "(Ljava/lang/String;)V", "g", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class a extends d {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String currentUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String filePath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String globalPadId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int currentDocsType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lt11/a$a;", "", "", "url", "Lt11/a;", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
    /* renamed from: t11.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final a a(@NotNull String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            b.f446855a.d("LocalEditController", Intrinsics.stringPlus("create url=", url));
            a aVar = new a(url, null);
            aVar.init();
            aVar.l();
            return aVar;
        }

        Companion() {
        }
    }

    public /* synthetic */ a(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        boolean z16;
        String str = this.currentUrl;
        int i3 = 0;
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            str = null;
        }
        if (str != null) {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("localFilePath");
            String str2 = "";
            if (queryParameter == null) {
                queryParameter = "";
            }
            this.filePath = queryParameter;
            String queryParameter2 = parse.getQueryParameter("globalPadId");
            if (queryParameter2 != null) {
                str2 = queryParameter2;
            }
            this.globalPadId = str2;
            Integer h16 = w11.a.f444159a.h(str);
            if (h16 != null) {
                i3 = h16.intValue();
            }
            this.currentDocsType = i3;
        }
    }

    private final void m() {
        ((FilePreloadManager) LocalEditSDK.INSTANCE.getManager(FilePreloadManager.class)).removePreloadTask(this.globalPadId);
    }

    @Override // u11.d
    @NotNull
    protected e a() {
        return LocalEditSDK.INSTANCE.getCache();
    }

    @Override // u11.d
    @NotNull
    protected v11.a b() {
        return new v11.a();
    }

    @Override // u11.d
    @NotNull
    protected c c() {
        return LocalEditSDK.INSTANCE.getConvert();
    }

    @Override // u11.d
    @NotNull
    protected com.tencent.localedit.fakenative.localserver.b d() {
        return LocalEditSDK.INSTANCE.getLocalServer();
    }

    @Override // u11.d, u11.b
    public void dispose() {
        super.dispose();
        getConvert().e(this.filePath);
        m();
        h().destroy();
        g().destroy();
    }

    @Override // u11.d
    @NotNull
    protected com.tencent.localedit.fakenative.intercept.c<WebResourceReq, WebResourceResp> e() {
        return new com.tencent.localedit.fakenative.intercept.d(this);
    }

    @Override // u11.d
    @NotNull
    protected com.tencent.localedit.fakenative.packages.a f() {
        return LocalEditSDK.INSTANCE.getPackageManager();
    }

    public final void n() {
        ((FilePreloadManager) LocalEditSDK.INSTANCE.getManager(FilePreloadManager.class)).addPreloadTask(new FileIORequestData(this.globalPadId, this.filePath, Integer.valueOf(this.currentDocsType), null, null, null, null, null, null, null, null, 2040, null));
    }

    a(String str) {
        this.currentUrl = str;
        this.filePath = "";
        this.globalPadId = "";
    }
}
