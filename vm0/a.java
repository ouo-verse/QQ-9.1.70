package vm0;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.fh;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.Packet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sm0.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lvm0/a;", "Lmqq/app/MSFServlet;", "Landroid/content/Intent;", "intent", "Lmqq/app/Packet;", "packet", "", "onSend", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "fromServiceMsg", "onReceive", "<init>", "()V", "d", "a", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a extends MSFServlet {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Map<String, c> f441847e = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0015\u00a8\u0006\u001c"}, d2 = {"Lvm0/a$a;", "", "", "cmd", "uuid", "", "data", "Lsm0/c;", "callback", "", "a", "", "CALLBACK_MAP", "Ljava/util/Map;", "", "DEFAULT_VALUE_TIMEOUT", "J", "", "RSP_HEADER_LENGTH", "I", "SEND_EXTRA_KEY_CMD", "Ljava/lang/String;", "SEND_EXTRA_KEY_DATA", "SEND_EXTRA_KEY_REQ_UUID", "SEND_EXTRA_KEY_TIMEOUT", "TAG", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: vm0.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull String cmd, @NotNull String uuid, @NotNull byte[] data, @NotNull c callback) {
            Intrinsics.checkNotNullParameter(cmd, "cmd");
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(callback, "callback");
            try {
                AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
                NewIntent newIntent = new NewIntent(waitAppRuntime.getApplication(), a.class);
                newIntent.putExtra("cmd", cmd);
                newIntent.putExtra("req_uuid", uuid);
                newIntent.putExtra("data", fh.b(data));
                waitAppRuntime.startServlet(newIntent);
                a.f441847e.put(uuid, callback);
            } catch (Exception e16) {
                a.f441847e.remove(uuid);
                callback.a("send cmd failed", e16);
                QLog.e("VasAdvServlet", 1, "requestAdv error: " + e16);
            }
        }

        Companion() {
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(@Nullable Intent intent, @Nullable FromServiceMsg fromServiceMsg) {
        if (intent != null && fromServiceMsg != null) {
            String stringExtra = intent.getStringExtra("cmd");
            String stringExtra2 = intent.getStringExtra("req_uuid");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                c cVar = (c) TypeIntrinsics.asMutableMap(f441847e).remove(stringExtra2);
                if (!fromServiceMsg.isSuccess()) {
                    if (cVar != null) {
                        cVar.a("from service msg failed", null);
                    }
                    QLog.d("VasAdvServlet", 1, "request failed, cmd:" + stringExtra + ", uuid:" + stringExtra2 + ", serviceMsg:" + fromServiceMsg.getShortStringForLog());
                    return;
                }
                try {
                    int length = fromServiceMsg.getWupBuffer().length - 4;
                    byte[] bArr = new byte[length];
                    PkgTools.copyData(bArr, 0, fromServiceMsg.getWupBuffer(), 4, length);
                    if (cVar != null) {
                        cVar.b(bArr);
                        return;
                    }
                    return;
                } catch (Exception e16) {
                    if (cVar != null) {
                        cVar.a("error when parse response", e16);
                    }
                    QLog.e("VasAdvServlet", 1, "onReceive error: " + e16);
                    return;
                }
            }
            QLog.d("VasAdvServlet", 1, "invalid cmd " + stringExtra + " or uuid " + stringExtra2 + ", discard rsp");
            return;
        }
        QLog.d("VasAdvServlet", 1, "onReceive intent or fromServiceMsg is null");
    }

    @Override // mqq.app.MSFServlet
    public void onSend(@Nullable Intent intent, @Nullable Packet packet) {
        String str;
        byte[] bArr = null;
        if (intent != null) {
            str = intent.getStringExtra("cmd");
        } else {
            str = null;
        }
        if (intent != null) {
            bArr = intent.getByteArrayExtra("data");
        }
        long j3 = 10000;
        if (intent != null) {
            j3 = intent.getLongExtra("timeout", 10000L);
        }
        if (packet != null) {
            packet.setSSOCommand(str);
            packet.setTimeout(j3);
            packet.putSendData(bArr);
            if (QLog.isColorLevel()) {
                QLog.d("VasAdvServlet", 2, "onSend cmd: " + str);
            }
        }
    }
}
