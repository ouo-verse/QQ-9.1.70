package r83;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.vfs.IVFSAssistantApi;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0003\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lr83/a;", "", "", "b", "Ljava/lang/String;", "PRIVATE_BASE_PATH", "c", "WECLIP_MODEL_PATH", "d", "WECLIP_ALBUM_CONFIG_PATH", "e", "WINK_ROOT_PATH", "f", "getWINK_FILE_ROOT_PATH", "()Ljava/lang/String;", "WINK_FILE_ROOT_PATH", "g", "WINK_NEWALBUM_ROOT_PATH", h.F, "WINK_NEWALBUM_SCALED_RES_ROOT_PATH", "i", "a", "WINK_NEWALBUM_COLLECTOR_DEBUG_PATH", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f430945a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String PRIVATE_BASE_PATH;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final String WECLIP_MODEL_PATH;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final String WECLIP_ALBUM_CONFIG_PATH;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String WINK_ROOT_PATH;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String WINK_FILE_ROOT_PATH;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String WINK_NEWALBUM_ROOT_PATH;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final String WINK_NEWALBUM_SCALED_RES_ROOT_PATH;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String WINK_NEWALBUM_COLLECTOR_DEBUG_PATH;

    static {
        String str = BaseApplication.getContext().getFilesDir().getParent() + "/";
        PRIVATE_BASE_PATH = str;
        WECLIP_MODEL_PATH = str + "app_lib/winknewalbum/weclip/";
        WECLIP_ALBUM_CONFIG_PATH = str + "app_lib/winknewalbum/albumconfig/";
        String sDKPrivatePath = ((IVFSAssistantApi) QRoute.api(IVFSAssistantApi.class)).getSDKPrivatePath("wink/");
        Intrinsics.checkNotNullExpressionValue(sDKPrivatePath, "api(IVFSAssistantApi::cl\u2026etSDKPrivatePath(\"wink/\")");
        WINK_ROOT_PATH = sDKPrivatePath;
        String str2 = sDKPrivatePath + ProtocolDownloaderConstants.FILE_PREFIX;
        WINK_FILE_ROOT_PATH = str2;
        String str3 = str2 + "newalbum/";
        WINK_NEWALBUM_ROOT_PATH = str3;
        WINK_NEWALBUM_SCALED_RES_ROOT_PATH = str3 + "scaledres/";
        WINK_NEWALBUM_COLLECTOR_DEBUG_PATH = str3 + "debug/";
    }

    a() {
    }

    @NotNull
    public final String a() {
        return WINK_NEWALBUM_COLLECTOR_DEBUG_PATH;
    }

    @NotNull
    public final String b() {
        return WINK_NEWALBUM_ROOT_PATH;
    }
}
