package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneBaseMeta$StFeedCellSpaceInfo extends MessageMicro<QZoneBaseMeta$StFeedCellSpaceInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"space_id", "space_type", "space_members"}, new Object[]{"", 0, null}, QZoneBaseMeta$StFeedCellSpaceInfo.class);
    public final PBStringField space_id = PBField.initString("");
    public final PBInt32Field space_type = PBField.initInt32(0);
    public final PBRepeatMessageField<QZoneBaseMeta$StUser> space_members = PBField.initRepeatMessage(QZoneBaseMeta$StUser.class);
}
