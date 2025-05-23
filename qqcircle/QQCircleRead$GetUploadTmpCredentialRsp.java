package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRead$GetUploadTmpCredentialRsp extends MessageMicro<QQCircleRead$GetUploadTmpCredentialRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"extInfo", "tmpSecretID", "tmpSecretKey", "sessionToken"}, new Object[]{null, "", "", ""}, QQCircleRead$GetUploadTmpCredentialRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBStringField tmpSecretID = PBField.initString("");
    public final PBStringField tmpSecretKey = PBField.initString("");
    public final PBStringField sessionToken = PBField.initString("");
}
