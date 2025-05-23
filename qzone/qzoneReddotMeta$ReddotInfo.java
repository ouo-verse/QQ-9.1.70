package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class qzoneReddotMeta$ReddotInfo extends MessageMicro<qzoneReddotMeta$ReddotInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50}, new String[]{"reddot_id", "count", "user_list", "yellow_info", "map_bytes_info", "bubble_msg"}, new Object[]{0, null, null, null, null, ""}, qzoneReddotMeta$ReddotInfo.class);
    public final PBEnumField reddot_id = PBField.initEnum(0);
    public qzoneReddotMeta$StCount count = new qzoneReddotMeta$StCount();
    public final PBRepeatMessageField<QZoneBaseMeta$StUser> user_list = PBField.initRepeatMessage(QZoneBaseMeta$StUser.class);
    public QZoneBaseMeta$YellowInfo yellow_info = new QZoneBaseMeta$YellowInfo();
    public final PBRepeatMessageField<QZoneBaseCommon$BytesEntry> map_bytes_info = PBField.initRepeatMessage(QZoneBaseCommon$BytesEntry.class);
    public final PBStringField bubble_msg = PBField.initString("");
}
