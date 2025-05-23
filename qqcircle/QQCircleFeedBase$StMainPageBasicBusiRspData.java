package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StTagInfo;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StMainPageBasicBusiRspData extends MessageMicro<QQCircleFeedBase$StMainPageBasicBusiRspData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 42, 48, 58, 66, 72, 80, 90, 98, 106, 114}, new String[]{"urlInfo", "opMask", "recomTagList", "pattonType", "profileBusiData", "giftCnt", "giftJumpUrl", "userFeedbackButtonJumpUrl", "urgeStatus", "urgePosition", "wordings", "pushBoxInfo", "rocketInfo", "header_info"}, new Object[]{null, 0, null, 0, ByteStringMicro.EMPTY, 0, "", "", 0, 0, null, null, null, null}, QQCircleFeedBase$StMainPageBasicBusiRspData.class);
    public final PBRepeatMessageField<FeedCloudCommon$Entry> urlInfo = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
    public final PBRepeatField<Integer> opMask = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatMessageField<FeedCloudMeta$StTagInfo> recomTagList = PBField.initRepeatMessage(FeedCloudMeta$StTagInfo.class);
    public final PBUInt32Field pattonType = PBField.initUInt32(0);
    public final PBBytesField profileBusiData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field giftCnt = PBField.initUInt32(0);
    public final PBStringField giftJumpUrl = PBField.initString("");
    public final PBStringField userFeedbackButtonJumpUrl = PBField.initString("");
    public final PBUInt32Field urgeStatus = PBField.initUInt32(0);
    public final PBUInt32Field urgePosition = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedCloudCommon$Entry> wordings = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
    public QQCircleFeedBase$StUserPushBoxInfo pushBoxInfo = new QQCircleFeedBase$StUserPushBoxInfo();
    public QQCircleFeedBase$StUserRocketInfo rocketInfo = new QQCircleFeedBase$StUserRocketInfo();
    public QQCircleFeedBase$HeaderInfo header_info = new QQCircleFeedBase$HeaderInfo();
}
