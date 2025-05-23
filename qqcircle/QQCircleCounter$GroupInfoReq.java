package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleCounter$GroupInfoReq extends MessageMicro<QQCircleCounter$GroupInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID}, new Object[]{null, ""}, QQCircleCounter$GroupInfoReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatField<String> groupid = PBField.initRepeat(PBStringField.__repeatHelper__);
}
