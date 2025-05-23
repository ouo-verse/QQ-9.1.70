package yu3;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import mqq.app.Packet;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u001a\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\r\u00a8\u0006\u0012"}, d2 = {"Lyu3/b;", "", "Lmqq/app/Packet;", "packet", "", "command", "serviceType", "", "body", "", "a", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "response", "Lcom/tencent/mobileqq/pb/MessageMicro;", "rspBody", "b", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f451254a = new b();

    b() {
    }

    public final void a(Packet packet, int command, int serviceType, byte[] body) {
        int checkRadix;
        Intrinsics.checkNotNullParameter(packet, "packet");
        Intrinsics.checkNotNullParameter(body, "body");
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(command);
        oidb_sso_oidbssopkg.uint32_service_type.set(serviceType);
        oidb_sso_oidbssopkg.str_client_version.set(AppSetting.n());
        if (!(body.length == 0)) {
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(body));
        }
        checkRadix = CharsKt__CharJVMKt.checkRadix(16);
        String num = Integer.toString(command, checkRadix);
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        packet.setSSOCommand("OidbSvc.0x" + num + "_" + serviceType);
        packet.putSendData(fh.b(oidb_sso_oidbssopkg.toByteArray()));
    }

    public final int b(FromServiceMsg response, MessageMicro<?> rspBody) {
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(rspBody, "rspBody");
        if (!response.isSuccess()) {
            QLog.d("AssistedChatSwitchReqWrapperUtil", 1, "parseOIDBRsp response.isSuccess: " + response.isSuccess());
            return -1;
        }
        byte[] a16 = fh.a(response.getWupBuffer());
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        try {
            oidb_sso_oidbssopkg.mergeFrom(a16);
        } catch (Exception e16) {
            QLog.e("AssistedChatSwitchReqWrapperUtil", 1, "parseOIDBRsp ssoPkg.mergeFrom error: ", e16);
        }
        int i3 = oidb_sso_oidbssopkg.uint32_result.get();
        if (i3 != 0) {
            QLog.d("AssistedChatSwitchReqWrapperUtil", 1, "parseOIDBRsp ssoResult: " + i3);
            return i3;
        }
        byte[] byteArray = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
        if (byteArray == null) {
            QLog.d("AssistedChatSwitchReqWrapperUtil", 1, "parseOIDBRsp oidb_sso.bytes_bodybuffer is null");
            return -2;
        }
        try {
            rspBody.mergeFrom(byteArray);
            return 0;
        } catch (Exception e17) {
            QLog.e("AssistedChatSwitchReqWrapperUtil", 1, "parseOIDBRsp rspBody.mergeFrom error: ", e17);
            return -3;
        }
    }
}
