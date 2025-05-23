package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceRedDotReader$EntranceInfo extends MessageMicro<QZIntimateSpaceRedDotReader$EntranceInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50, 56, 64, 74, 82, 88}, new String[]{"name", "icon", "url", "status", "guide", "background", "lst_publish_time", "is_show_entrance", "space_id", "entry", "relation_type"}, new Object[]{"", "", "", 0, "", "", 0L, Boolean.FALSE, "", null, 0}, QZIntimateSpaceRedDotReader$EntranceInfo.class);
    public final PBStringField name = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBEnumField status = PBField.initEnum(0);
    public final PBStringField guide = PBField.initString("");
    public final PBStringField background = PBField.initString("");
    public final PBInt64Field lst_publish_time = PBField.initInt64(0);
    public final PBBoolField is_show_entrance = PBField.initBool(false);
    public final PBStringField space_id = PBField.initString("");
    public final PBRepeatMessageField<QZoneBaseCommon$Entry> entry = PBField.initRepeatMessage(QZoneBaseCommon$Entry.class);
    public final PBInt32Field relation_type = PBField.initInt32(0);
}
