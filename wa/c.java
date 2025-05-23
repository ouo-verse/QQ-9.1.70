package wa;

import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.mobileqq.mini.servlet.MiniAppGetPrivacyDetailServlet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0003\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0017\u0010\b\u00a8\u0006\u001b"}, d2 = {"Lwa/c;", "", "", "a", "I", "d", "()I", "i", "(I)V", "from", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "albumId", "c", "g", AEEditorConstants.ALBUMNAME, "e", "j", CommonConstant.KEY_USER_IDENTIFY, h.F, MiniAppGetPrivacyDetailServlet.KEY_AUTHORITY_NAME, "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int from;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String albumId = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String albumName = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int userIdentify;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int authority;

    /* renamed from: a, reason: from getter */
    public final String getAlbumId() {
        return this.albumId;
    }

    /* renamed from: b, reason: from getter */
    public final String getAlbumName() {
        return this.albumName;
    }

    /* renamed from: c, reason: from getter */
    public final int getAuthority() {
        return this.authority;
    }

    /* renamed from: d, reason: from getter */
    public final int getFrom() {
        return this.from;
    }

    /* renamed from: e, reason: from getter */
    public final int getUserIdentify() {
        return this.userIdentify;
    }

    public final void f(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumId = str;
    }

    public final void g(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumName = str;
    }

    public final void h(int i3) {
        this.authority = i3;
    }

    public final void i(int i3) {
        this.from = i3;
    }

    public final void j(int i3) {
        this.userIdentify = i3;
    }
}
