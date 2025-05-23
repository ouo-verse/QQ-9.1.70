package zb1;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x6e7.oidb_0x6e7$ReqBody;
import tencent.im.oidb.cmd0x6e7.oidb_0x6e7$RspBody;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {

    /* compiled from: P */
    /* renamed from: zb1.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    class C11670a extends ProtoUtils.TroopProtocolObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f452215d;

        C11670a(b bVar) {
            this.f452215d = bVar;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            if (i3 == 0) {
                oidb_0x6e7$RspBody oidb_0x6e7_rspbody = new oidb_0x6e7$RspBody();
                try {
                    oidb_0x6e7_rspbody.mergeFrom(bArr);
                    if (QLog.isColorLevel()) {
                        QLog.d("zivonchen", 2, "is_white = " + oidb_0x6e7_rspbody.uint32_is_white.get() + ", req_interval = " + oidb_0x6e7_rspbody.uint32_interval.get());
                    }
                    b bVar = this.f452215d;
                    if (bVar != null) {
                        bVar.a(oidb_0x6e7_rspbody.uint32_is_white.get(), oidb_0x6e7_rspbody.uint32_interval.get());
                        return;
                    }
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("zivonchen", 2, QLog.getStackTraceString(e16));
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("zivonchen", 2, "requestWhiteList() errorCode = " + i3);
            }
            b bVar2 = this.f452215d;
            if (bVar2 != null) {
                bVar2.a(0, -1);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface b {
        void a(int i3, int i16);
    }

    public static String a(String str, String str2, String str3, String str4, String str5) {
        StringBuffer stringBuffer = new StringBuffer("http://");
        stringBuffer.append(str);
        stringBuffer.append("/ftn_handler/");
        stringBuffer.append(str2);
        stringBuffer.append("/?fname=");
        stringBuffer.append(HexUtil.string2HexString(str3));
        stringBuffer.append(str5);
        return stringBuffer.toString();
    }

    public static void b(QQAppInterface qQAppInterface, long j3, b bVar) {
        if (j3 < 0) {
            return;
        }
        oidb_0x6e7$ReqBody oidb_0x6e7_reqbody = new oidb_0x6e7$ReqBody();
        oidb_0x6e7_reqbody.uint64_group_code.set(j3);
        oidb_0x6e7_reqbody.str_app_src.set("android");
        oidb_0x6e7_reqbody.str_version.set(AppSetting.f99551k);
        ProtoUtils.k(qQAppInterface, new C11670a(bVar), oidb_0x6e7_reqbody.toByteArray(), "OidbSvc.oidb_0x6e7", 1767, 0, null);
    }
}
