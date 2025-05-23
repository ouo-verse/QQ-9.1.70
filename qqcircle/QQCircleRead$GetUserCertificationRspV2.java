package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRead$GetUserCertificationRspV2 extends MessageMicro<QQCircleRead$GetUserCertificationRspV2> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "certList"}, new Object[]{null, null}, QQCircleRead$GetUserCertificationRspV2.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<QQCircleRead$CertificationDetailV2> certList = PBField.initRepeatMessage(QQCircleRead$CertificationDetailV2.class);
}
