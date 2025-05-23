package rs3;

import com.tencent.minibox.contract.GameInfo;
import com.tencent.minibox.contract.LocalInstallInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.minibox.basicinfo.VMBasicInfo$GCRealAppInfo;
import com.tencent.trpcprotocol.minibox.basicinfo.VMBasicInfo$GetGCRealAppInfoRsp;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\f\u0010\r\u001a\u00020\f*\u00020\u000bH\u0002J\f\u0010\u0010\u001a\u00020\u000f*\u00020\u000eH\u0002\u00a8\u0006\u0013"}, d2 = {"Lrs3/c;", "", "", "appId", "Lrs3/b;", "callback", "", "b", "Lqs3/d;", "ssoResponse", "c", "Lcom/tencent/trpcprotocol/minibox/basicinfo/VMBasicInfo$GetGCRealAppInfoRsp;", "Lcom/tencent/minibox/contract/LocalInstallInfo;", "e", "Lcom/tencent/trpcprotocol/minibox/basicinfo/VMBasicInfo$GCRealAppInfo;", "Lcom/tencent/minibox/contract/GameInfo;", "d", "<init>", "()V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f432150a = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"rs3/c$a", "Lqs3/a;", "Lqs3/d;", "ssoResponse", "", "q7", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class a implements qs3.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f432151d;

        a(b bVar) {
            this.f432151d = bVar;
        }

        @Override // qs3.a
        public void q7(@NotNull qs3.d ssoResponse) {
            Intrinsics.checkNotNullParameter(ssoResponse, "ssoResponse");
            c.f432150a.c(ssoResponse, this.f432151d);
        }
    }

    c() {
    }

    @JvmStatic
    public static final void b(@NotNull String appId, @NotNull b callback) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        e eVar = new e(appId, 0, 2, null);
        QLog.i("GcRealAppInfoHandler", 1, "getGcRealAppInfo req: appId=" + appId);
        qs3.c.f429464a.d(eVar, new a(callback));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(qs3.d ssoResponse, b callback) {
        if (ssoResponse.c()) {
            try {
                VMBasicInfo$GetGCRealAppInfoRsp vMBasicInfo$GetGCRealAppInfoRsp = new VMBasicInfo$GetGCRealAppInfoRsp();
                vMBasicInfo$GetGCRealAppInfoRsp.mergeFrom(ssoResponse.getData());
                LocalInstallInfo e16 = e(vMBasicInfo$GetGCRealAppInfoRsp);
                QLog.i("GcRealAppInfoHandler", 1, "getGcRealAppInfo success: data=" + e16);
                callback.a(e16);
                return;
            } catch (Throwable th5) {
                QLog.e("GcRealAppInfoHandler", 1, "getGcRealAppInfo exception: " + th5.getMessage());
                callback.a(null);
                return;
            }
        }
        QLog.e("GcRealAppInfoHandler", 1, "getGcRealAppInfo failed: " + ssoResponse.getRetCode());
        callback.a(null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005a, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final GameInfo d(VMBasicInfo$GCRealAppInfo vMBasicInfo$GCRealAppInfo) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        int i3;
        String str8;
        Integer intOrNull;
        String str9 = vMBasicInfo$GCRealAppInfo.gc_game_author.get();
        if (str9 == null) {
            str = "";
        } else {
            str = str9;
        }
        String str10 = vMBasicInfo$GCRealAppInfo.gc_version_name.get();
        if (str10 == null) {
            str2 = "";
        } else {
            str2 = str10;
        }
        String str11 = vMBasicInfo$GCRealAppInfo.gc_privacy_guide_pic.get();
        if (str11 == null) {
            str3 = "";
        } else {
            str3 = str11;
        }
        String str12 = vMBasicInfo$GCRealAppInfo.gc_permissions.get();
        if (str12 == null) {
            str4 = "";
        } else {
            str4 = str12;
        }
        String str13 = vMBasicInfo$GCRealAppInfo.gc_appid.get();
        if (str13 == null) {
            str5 = "";
        } else {
            str5 = str13;
        }
        String str14 = vMBasicInfo$GCRealAppInfo.gc_package_name.get();
        if (str14 == null) {
            str6 = "";
        } else {
            str6 = str14;
        }
        String str15 = vMBasicInfo$GCRealAppInfo.gc_app_name.get();
        if (str15 == null) {
            str7 = "";
        } else {
            str7 = str15;
        }
        String str16 = vMBasicInfo$GCRealAppInfo.gc_version_code.get();
        if (str16 != null && intOrNull != null) {
            i3 = intOrNull.intValue();
        } else {
            i3 = 0;
        }
        int i16 = i3;
        String str17 = vMBasicInfo$GCRealAppInfo.gc_apk_url.get();
        if (str17 == null) {
            str8 = "";
        } else {
            str8 = str17;
        }
        String str18 = vMBasicInfo$GCRealAppInfo.gc_icon_url.get();
        if (str18 == null) {
            str18 = "";
        }
        return new GameInfo(str, str2, str3, str4, str5, str6, str7, i16, str8, str18);
    }

    private final LocalInstallInfo e(VMBasicInfo$GetGCRealAppInfoRsp vMBasicInfo$GetGCRealAppInfoRsp) {
        String str;
        String str2;
        boolean z16 = vMBasicInfo$GetGCRealAppInfoRsp.config.entry.allow_local_installation_guide.get();
        boolean z17 = vMBasicInfo$GetGCRealAppInfoRsp.config.popup.allow_local_installation_popup.get();
        String str3 = vMBasicInfo$GetGCRealAppInfoRsp.config.popup.body_text.get();
        if (str3 == null) {
            str = "";
        } else {
            str = str3;
        }
        String str4 = vMBasicInfo$GetGCRealAppInfoRsp.config.popup.button_text.get();
        if (str4 == null) {
            str2 = "";
        } else {
            str2 = str4;
        }
        VMBasicInfo$GCRealAppInfo vMBasicInfo$GCRealAppInfo = vMBasicInfo$GetGCRealAppInfoRsp.info;
        Intrinsics.checkNotNullExpressionValue(vMBasicInfo$GCRealAppInfo, "this.info");
        return new LocalInstallInfo(z16, z17, str, str2, d(vMBasicInfo$GCRealAppInfo));
    }
}
