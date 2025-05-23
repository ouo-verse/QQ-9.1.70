package u6;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.vfs.IVFSAssistantApi;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f438461a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f438462b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f438463c;

    static {
        String sDKPrivatePath = ((IVFSAssistantApi) QRoute.api(IVFSAssistantApi.class)).getSDKPrivatePath("qzone/");
        f438461a = sDKPrivatePath;
        String str = sDKPrivatePath + ProtocolDownloaderConstants.FILE_PREFIX;
        f438462b = str;
        f438463c = str + "download/";
    }
}
