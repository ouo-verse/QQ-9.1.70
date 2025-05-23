package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QZIntimateSpaceReader$GetDisbandSpacePageRsp extends MessageMicro<QZIntimateSpaceReader$GetDisbandSpacePageRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 56, 66, 72, 80, 90, 96, 104}, new String[]{"ext", "members", "seconds_remain", "relation_time", "medal_count", "shuoshuo_count", "album_count", "cover", "space_type", "disband_status", "relation_icon", "resumable_time_setting", "display_properties"}, new Object[]{null, null, 0L, 0, 0, 0, 0, "", 0, 0, null, 0L, Boolean.FALSE}, QZIntimateSpaceReader$GetDisbandSpacePageRsp.class);
    public QZoneBaseCommon$StCommonExt ext = new QZoneBaseCommon$StCommonExt();
    public final PBRepeatMessageField<QZoneBaseMeta$StUser> members = PBField.initRepeatMessage(QZoneBaseMeta$StUser.class);
    public final PBUInt64Field seconds_remain = PBField.initUInt64(0);
    public final PBUInt32Field relation_time = PBField.initUInt32(0);
    public final PBUInt32Field medal_count = PBField.initUInt32(0);
    public final PBUInt32Field shuoshuo_count = PBField.initUInt32(0);
    public final PBUInt32Field album_count = PBField.initUInt32(0);
    public final PBStringField cover = PBField.initString("");
    public final PBEnumField space_type = PBField.initEnum(0);
    public final PBEnumField disband_status = PBField.initEnum(0);
    public final PBRepeatMessageField<QZIntimateSpaceReader$RelationIcon> relation_icon = PBField.initRepeatMessage(QZIntimateSpaceReader$RelationIcon.class);
    public final PBUInt64Field resumable_time_setting = PBField.initUInt64(0);
    public final PBBoolField display_properties = PBField.initBool(false);
}
