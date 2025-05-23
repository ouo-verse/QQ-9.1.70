package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRight$VerifyCircleUnCareRsp extends MessageMicro<QQCircleRight$VerifyCircleUnCareRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"extInfo", "isBlack", "isReverseBlack"}, new Object[]{null, 0, 0}, QQCircleRight$VerifyCircleUnCareRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBInt32Field isBlack = PBField.initInt32(0);
    public final PBInt32Field isReverseBlack = PBField.initInt32(0);
}
