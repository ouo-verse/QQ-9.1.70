package ws2;

import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.troop.membersetting.handler.MemberSettingHandler;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.Packet;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00112\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0012"}, d2 = {"Lws2/c;", "Lmqq/app/MSFServlet;", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", Const.BUNDLE_KEY_REQUEST, "", "a", "Landroid/content/Intent;", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "response", "", "onReceive", "req", "Lmqq/app/Packet;", "p", "onSend", "<init>", "()V", "d", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public class c extends MSFServlet {
    @Override // mqq.app.MSFServlet
    public void onReceive(Intent request, FromServiceMsg response) {
        Object obj;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        if (QLog.isColorLevel()) {
            QLog.d("MemberSettingServlet", 2, "onReceive cmd=" + request.getStringExtra("cmd"));
        }
        ToServiceMsg toServiceMsg = (ToServiceMsg) request.getParcelableExtra(ToServiceMsg.class.getSimpleName());
        HashMap<String, Object> hashMap = response.attributes;
        Intrinsics.checkNotNullExpressionValue(hashMap, "response.attributes");
        hashMap.put(FromServiceMsg.class.getSimpleName(), toServiceMsg);
        if (!a(toServiceMsg) || response.getWupBuffer() == null) {
            obj = null;
        } else {
            int length = response.getWupBuffer().length - 4;
            byte[] bArr = new byte[length];
            PkgTools.copyData(bArr, 0, response.getWupBuffer(), 4, length);
            response.putWupBuffer(bArr);
            obj = response.getWupBuffer();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        MemberSettingHandler memberSettingHandler = new MemberSettingHandler((AppInterface) peekAppRuntime);
        ToServiceMsg toServiceMsg2 = (ToServiceMsg) request.getParcelableExtra(ToServiceMsg.class.getSimpleName());
        if (toServiceMsg2 != null) {
            if (obj == null) {
                obj = "";
            }
            memberSettingHandler.onReceive(toServiceMsg2, response, obj);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent req, Packet p16) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(p16, "p");
        ToServiceMsg toServiceMsg = (ToServiceMsg) req.getParcelableExtra(ToServiceMsg.class.getSimpleName());
        if (toServiceMsg != null) {
            p16.setSSOCommand(toServiceMsg.getServiceCmd());
            p16.putSendData(toServiceMsg.getWupBuffer());
            p16.setTimeout(toServiceMsg.getTimeout());
            p16.setAttributes(toServiceMsg.getAttributes());
            if (toServiceMsg.isNeedCallback()) {
                return;
            }
            p16.setNoResponse();
        }
    }

    private final boolean a(ToServiceMsg request) {
        if (request == null) {
            return false;
        }
        Object attribute = request.getAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(attribute, "request.getAttribute(Mob\u2026_PB_PROTOCOL_FLAG, false)");
        return ((Boolean) attribute).booleanValue();
    }
}
