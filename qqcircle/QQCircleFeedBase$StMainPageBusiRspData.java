package qqcircle;

import com.tencent.mobileqq.mini.servlet.MiniAppGetTeenagerConfigServlet;
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
import tianshu.QQCircleTianShu$RspEntry;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StMainPageBusiRspData extends MessageMicro<QQCircleFeedBase$StMainPageBusiRspData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40, 50, 56, 66, 72, 82, 90, 96, 106, 114, 120, 128, 138, 146}, new String[]{"urlInfo", "opMask", "recomTagList", "fuelValue", "pattonType", "profileBusiData", "giftCnt", "giftJumpUrl", MiniAppGetTeenagerConfigServlet.KEY_TIME_INTERVAL, "blackInfo", "RedPointInfo", "fuelValueStyle", "elementInfo", "userFeedbackButtonJumpUrl", "urgeStatus", "urgePosition", "specialMainPageTailText", "qqProfileGuideCopywriting"}, new Object[]{null, 0, null, 0, 0, ByteStringMicro.EMPTY, 0, "", 0, null, null, 0, null, "", 0, 0, "", null}, QQCircleFeedBase$StMainPageBusiRspData.class);
    public final PBRepeatMessageField<FeedCloudCommon$Entry> urlInfo = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
    public final PBRepeatField<Integer> opMask = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatMessageField<FeedCloudMeta$StTagInfo> recomTagList = PBField.initRepeatMessage(FeedCloudMeta$StTagInfo.class);
    public final PBUInt32Field fuelValue = PBField.initUInt32(0);
    public final PBUInt32Field pattonType = PBField.initUInt32(0);
    public final PBBytesField profileBusiData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field giftCnt = PBField.initUInt32(0);
    public final PBStringField giftJumpUrl = PBField.initString("");
    public final PBUInt32Field timeInterval = PBField.initUInt32(0);
    public QQCircleFeedBase$StBlackInfo blackInfo = new MessageMicro<QQCircleFeedBase$StBlackInfo>() { // from class: qqcircle.QQCircleFeedBase$StBlackInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"isBlocked", "blockedText"}, new Object[]{0, ""}, QQCircleFeedBase$StBlackInfo.class);
        public final PBUInt32Field isBlocked = PBField.initUInt32(0);
        public final PBStringField blockedText = PBField.initString("");
    };
    public QQCircleFeedBase$StPageRedPointInfo RedPointInfo = new QQCircleFeedBase$StPageRedPointInfo();
    public final PBUInt32Field fuelValueStyle = PBField.initUInt32(0);
    public final PBRepeatMessageField<QQCircleFeedBase$StMainPageBusiElementInfo> elementInfo = PBField.initRepeatMessage(QQCircleFeedBase$StMainPageBusiElementInfo.class);
    public final PBStringField userFeedbackButtonJumpUrl = PBField.initString("");
    public final PBUInt32Field urgeStatus = PBField.initUInt32(0);
    public final PBUInt32Field urgePosition = PBField.initUInt32(0);
    public final PBStringField specialMainPageTailText = PBField.initString("");
    public QQCircleTianShu$RspEntry qqProfileGuideCopywriting = new QQCircleTianShu$RspEntry();
}
