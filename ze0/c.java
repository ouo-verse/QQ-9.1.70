package ze0;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_COMM.COMM;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.transfile.ProtoServlet;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c extends a {
    @Override // ze0.a
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        bundle.putByteArray("key_data", bArr);
        notifyObserver(intent, this.f452401d, true, bundle, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0057  */
    @Override // ze0.a, mqq.app.MSFServlet
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSend(Intent intent, Packet packet) {
        COMM.StCommonExt stCommonExt;
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed;
        InvalidProtocolBufferMicroException e16;
        byte[] a16;
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_ext");
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed2 = null;
        if (byteArrayExtra != null) {
            stCommonExt = new COMM.StCommonExt();
            try {
                stCommonExt.mergeFrom(byteArrayExtra);
            } catch (InvalidProtocolBufferMicroException e17) {
                QLog.e("CertifiedAccountModifyFeedServlet", 2, QLog.getStackTraceString(e17));
            }
        } else {
            stCommonExt = null;
        }
        int intExtra = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
        byte[] byteArrayExtra2 = intent.getByteArrayExtra("key_request_feed_bytes");
        if (byteArrayExtra2 != null) {
            try {
                certifiedAccountMeta$StFeed = new CertifiedAccountMeta$StFeed();
            } catch (InvalidProtocolBufferMicroException e18) {
                certifiedAccountMeta$StFeed = null;
                e16 = e18;
            }
            try {
                certifiedAccountMeta$StFeed.mergeFrom(byteArrayExtra2);
            } catch (InvalidProtocolBufferMicroException e19) {
                e16 = e19;
                QLog.e("CertifiedAccountModifyFeedServlet", 2, QLog.getStackTraceString(e16));
                certifiedAccountMeta$StFeed2 = certifiedAccountMeta$StFeed;
                a16 = new b(stCommonExt, certifiedAccountMeta$StFeed2).a(intent, intExtra, a.getTraceId());
                if (a16 == null) {
                }
                packet.setSSOCommand("CertifiedAccountSvc.certified_account_write.ModifyFeed");
                packet.putSendData(fh.b(a16));
                packet.setTimeout(intent.getLongExtra(ProtoServlet.KEY_TIMEOUT, 30000L));
                super.onSend(intent, packet);
            }
            certifiedAccountMeta$StFeed2 = certifiedAccountMeta$StFeed;
        }
        a16 = new b(stCommonExt, certifiedAccountMeta$StFeed2).a(intent, intExtra, a.getTraceId());
        if (a16 == null) {
            a16 = new byte[4];
        }
        packet.setSSOCommand("CertifiedAccountSvc.certified_account_write.ModifyFeed");
        packet.putSendData(fh.b(a16));
        packet.setTimeout(intent.getLongExtra(ProtoServlet.KEY_TIMEOUT, 30000L));
        super.onSend(intent, packet);
    }
}
