package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StTagInfo;
import feedcloud.FeedCloudMeta$StUser;

/* loaded from: classes29.dex */
public final class QQCircleProfile$StGetMainPageProfileRsp extends MessageMicro<QQCircleProfile$StGetMainPageProfileRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 48, 58, 64, 74}, new String[]{"extInfo", QCircleAlphaUserReporter.KEY_USER, "bizData", "TempChatBtnStatus", "recomTagList", "pattonType", "pmBeginShow", "hasEditedSign", "guildInfo"}, new Object[]{null, null, ByteStringMicro.EMPTY, 0, null, 0, "", 0, null}, QQCircleProfile$StGetMainPageProfileRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public FeedCloudMeta$StUser user = new FeedCloudMeta$StUser();
    public final PBBytesField bizData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field TempChatBtnStatus = PBField.initInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta$StTagInfo> recomTagList = PBField.initRepeatMessage(FeedCloudMeta$StTagInfo.class);
    public final PBUInt32Field pattonType = PBField.initUInt32(0);
    public final PBStringField pmBeginShow = PBField.initString("");
    public final PBUInt32Field hasEditedSign = PBField.initUInt32(0);
    public QQCircleProfile$GuildInfo guildInfo = new QQCircleProfile$GuildInfo();
}
