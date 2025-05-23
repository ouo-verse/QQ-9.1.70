package qzone;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceReader$StNotice extends MessageMicro<QZIntimateSpaceReader$StNotice> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 50, 56, 66, 74, 82, 90, 98, 106, 114, 122, 130}, new String[]{"notice_id", "notice_type", AlbumCacheData.CREATE_TIME, "notice_patton", "feed", "notice_message", "op_mask", "busi_data", "op_user", "action", "space_button", "notice_message_icon", "ext", "feed_comment", "feed_reply", "spaceinfo"}, new Object[]{"", 0, 0L, null, null, null, 1, ByteStringMicro.EMPTY, null, null, null, "", null, null, null, null}, QZIntimateSpaceReader$StNotice.class);
    public final PBStringField notice_id = PBField.initString("");
    public final PBUInt32Field notice_type = PBField.initUInt32(0);
    public final PBUInt64Field create_time = PBField.initUInt64(0);
    public QZIntimateSpaceReader$StNoticePattonInfo notice_patton = new QZIntimateSpaceReader$StNoticePattonInfo();
    public QZoneBaseMeta$StFeed feed = new QZoneBaseMeta$StFeed();
    public final PBRepeatMessageField<QZoneBaseMeta$StRichMsg> notice_message = PBField.initRepeatMessage(QZoneBaseMeta$StRichMsg.class);
    public final PBRepeatField<Integer> op_mask = PBField.initRepeat(PBEnumField.__repeatHelper__);
    public final PBBytesField busi_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public QZoneBaseMeta$StUser op_user = new QZoneBaseMeta$StUser();
    public QZIntimateSpaceReader$StPattonAction action = new QZIntimateSpaceReader$StPattonAction();
    public QZoneBaseMeta$StButton space_button = new QZoneBaseMeta$StButton();
    public final PBStringField notice_message_icon = PBField.initString("");
    public QZoneBaseCommon$StCommonExt ext = new QZoneBaseCommon$StCommonExt();
    public QZoneBaseMeta$StComment feed_comment = new QZoneBaseMeta$StComment();
    public QZoneBaseMeta$StReply feed_reply = new QZoneBaseMeta$StReply();
    public QZIntimateSpaceReader$CommreaderSpaceAbs spaceinfo = new QZIntimateSpaceReader$CommreaderSpaceAbs();
}
