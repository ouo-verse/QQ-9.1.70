package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StUser;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRight$GetCircleUnCareListRsp extends MessageMicro<QQCircleRight$GetCircleUnCareListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"extInfo", FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_UIN_LIST, "userlist", "uidlist"}, new Object[]{null, 0, null, ""}, QQCircleRight$GetCircleUnCareListRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatField<Integer> uinlist = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatMessageField<FeedCloudMeta$StUser> userlist = PBField.initRepeatMessage(FeedCloudMeta$StUser.class);
    public final PBRepeatField<String> uidlist = PBField.initRepeat(PBStringField.__repeatHelper__);
}
