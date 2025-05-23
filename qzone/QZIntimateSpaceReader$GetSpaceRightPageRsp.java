package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QZIntimateSpaceReader$GetSpaceRightPageRsp extends MessageMicro<QZIntimateSpaceReader$GetSpaceRightPageRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 50}, new String[]{"title", "members", "space_type", "display_right", "approval_type", "ext"}, new Object[]{"", null, 0, 0, 0, null}, QZIntimateSpaceReader$GetSpaceRightPageRsp.class);
    public final PBStringField title = PBField.initString("");
    public final PBRepeatMessageField<QZoneBaseMeta$StUser> members = PBField.initRepeatMessage(QZoneBaseMeta$StUser.class);
    public final PBEnumField space_type = PBField.initEnum(0);
    public final PBEnumField display_right = PBField.initEnum(0);
    public final PBEnumField approval_type = PBField.initEnum(0);
    public QZoneBaseCommon$StCommonExt ext = new QZoneBaseCommon$StCommonExt();
}
