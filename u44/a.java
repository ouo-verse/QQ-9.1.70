package u44;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.api.b;
import com.tencent.robot.qrcode.oidb.Cmd0x91bdPB$GetLongUrlReq;
import com.tencent.robot.qrcode.oidb.Cmd0x91bdPB$GetLongUrlRsq;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\r"}, d2 = {"Lu44/a;", "", "", "data", "", "shortUrl", "Lcom/tencent/robot/api/b;", "callback", "", "b", "c", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f438221a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J$\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"u44/a$a", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "", "errorMsg", "", "onError", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: u44.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C11323a extends ProtoUtils.TroopProtocolObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f438222d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f438223e;

        C11323a(String str, b bVar) {
            this.f438222d = str;
            this.f438223e = bVar;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public boolean onError(int errorCode, @Nullable String errorMsg, @Nullable Bundle bundle) {
            QLog.e("RobotUrlHelper", 1, "[requestLongUrl]: error. onError:" + errorCode + " ");
            this.f438223e.a(false, "");
            return true;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, @Nullable byte[] data, @NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            if (errorCode == 0 && data != null) {
                a.f438221a.b(data, this.f438222d, this.f438223e);
                return;
            }
            QLog.e("RobotUrlHelper", 1, "[requestLongUrl]: error. data is null. code: " + errorCode);
        }
    }

    a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(byte[] data, String shortUrl, b callback) {
        try {
            Cmd0x91bdPB$GetLongUrlRsq cmd0x91bdPB$GetLongUrlRsq = new Cmd0x91bdPB$GetLongUrlRsq();
            cmd0x91bdPB$GetLongUrlRsq.mergeFrom(data);
            String longUrl = cmd0x91bdPB$GetLongUrlRsq.long_url.get();
            Intrinsics.checkNotNullExpressionValue(longUrl, "longUrl");
            callback.a(true, longUrl);
            QLog.i("RobotUrlHelper", 1, "[handleResponse]: longUrl is " + longUrl + ", shortUrl is " + shortUrl);
        } catch (Exception e16) {
            QLog.e("RobotUrlHelper", 1, "[handleResponse]: ", e16);
            callback.a(false, "");
        }
    }

    public final void c(@NotNull String shortUrl, @NotNull b callback) {
        Intrinsics.checkNotNullParameter(shortUrl, "shortUrl");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        Cmd0x91bdPB$GetLongUrlReq cmd0x91bdPB$GetLongUrlReq = new Cmd0x91bdPB$GetLongUrlReq();
        cmd0x91bdPB$GetLongUrlReq.short_url.set(shortUrl);
        ProtoUtils.a(peekAppRuntime, new C11323a(shortUrl, callback), cmd0x91bdPB$GetLongUrlReq.toByteArray(), "OidbSvcTrpcTcp.0x91bd_1", 37309, 1);
    }
}
