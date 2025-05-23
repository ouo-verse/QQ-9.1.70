package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* loaded from: classes29.dex */
public final class QQCircleProfile$CheckBindGroupRsp extends MessageMicro<QQCircleProfile$CheckBindGroupRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "prompt_text"}, new Object[]{null, ""}, QQCircleProfile$CheckBindGroupRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBStringField prompt_text = PBField.initString("");
}
