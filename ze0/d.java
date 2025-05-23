package ze0;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite$StPublishFeedReq;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite$StPublishFeedRsp;
import NS_COMM.COMM;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d extends f {

    /* renamed from: b, reason: collision with root package name */
    private CertifiedAccountWrite$StPublishFeedReq f452403b;

    public d(COMM.StCommonExt stCommonExt, CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        CertifiedAccountWrite$StPublishFeedReq certifiedAccountWrite$StPublishFeedReq = new CertifiedAccountWrite$StPublishFeedReq();
        this.f452403b = certifiedAccountWrite$StPublishFeedReq;
        if (stCommonExt != null) {
            certifiedAccountWrite$StPublishFeedReq.extInfo.set(stCommonExt);
        }
        if (certifiedAccountMeta$StFeed != null) {
            this.f452403b.feed.set(certifiedAccountMeta$StFeed);
        }
    }

    public static CertifiedAccountWrite$StPublishFeedRsp c(byte[] bArr) {
        try {
            return new CertifiedAccountWrite$StPublishFeedRsp().mergeFrom(bArr);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("CertifiedAccountGetMsgTopRequest", 2, "onResponse fail." + e16);
                return null;
            }
            return null;
        }
    }

    @Override // ze0.f
    public byte[] b() {
        return this.f452403b.toByteArray();
    }
}
