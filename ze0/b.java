package ze0;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite$StModifyFeedReq;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite$StModifyFeedRsp;
import NS_COMM.COMM;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b extends f {

    /* renamed from: b, reason: collision with root package name */
    private CertifiedAccountWrite$StModifyFeedReq f452402b;

    public b(COMM.StCommonExt stCommonExt, CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        CertifiedAccountWrite$StModifyFeedReq certifiedAccountWrite$StModifyFeedReq = new CertifiedAccountWrite$StModifyFeedReq();
        this.f452402b = certifiedAccountWrite$StModifyFeedReq;
        if (stCommonExt != null) {
            certifiedAccountWrite$StModifyFeedReq.extInfo.set(stCommonExt);
        }
        if (certifiedAccountMeta$StFeed != null) {
            this.f452402b.feed.set(certifiedAccountMeta$StFeed);
        }
        this.f452402b.mBitmap.set(1L);
    }

    public static CertifiedAccountWrite$StModifyFeedRsp c(byte[] bArr) {
        try {
            return new CertifiedAccountWrite$StModifyFeedRsp().mergeFrom(bArr);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("CertifiedAccountModifyFeedRequest", 2, "onResponse fail." + e16);
                return null;
            }
            return null;
        }
    }

    @Override // ze0.f
    public byte[] b() {
        return this.f452402b.toByteArray();
    }
}
