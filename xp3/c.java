package xp3;

import com.tencent.aelight.camera.download.AEResManagerConfigBean;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import zp3.d;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b$\u0010%R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u0016\u0010\u0011\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0017\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0004R\u0016\u0010\u001d\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0004R\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lxp3/c;", "", "", "a", "Ljava/lang/String;", "sdkVersion", "", "b", "Z", "needCheckSameUser", "c", "openid", "d", "needCheckMiniApp", "", "e", "J", "miniAppId", "f", "appid", "", "g", "I", "apptype", h.F, "srcId", "i", "packageName", "j", "isNeedAppInfo", "k", "rawUrl", "Lzp3/d$a;", "l", "Lzp3/d$a;", "checkAppParams", "<init>", "()V", "opensdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public boolean needCheckSameUser;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public boolean needCheckMiniApp;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public long miniAppId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public long appid;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public int apptype;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public int srcId;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public boolean isNeedAppInfo;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    public String rawUrl;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    public d.a checkAppParams;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public String sdkVersion = AEResManagerConfigBean.DEFAULT_VERSION;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    public String openid = "";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public String packageName = "";
}
