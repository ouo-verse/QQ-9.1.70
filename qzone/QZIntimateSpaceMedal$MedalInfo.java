package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceMedal$MedalInfo extends MessageMicro<QZIntimateSpaceMedal$MedalInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50, 56}, new String[]{"id", "name", "icon", "rule_desc", "type", "progress", "is_new"}, new Object[]{"", "", "", "", 0, null, Boolean.FALSE}, QZIntimateSpaceMedal$MedalInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f430331id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField rule_desc = PBField.initString("");
    public final PBEnumField type = PBField.initEnum(0);
    public QZIntimateSpaceMedal$MedalProgressInfo progress = new MessageMicro<QZIntimateSpaceMedal$MedalProgressInfo>() { // from class: qzone.QZIntimateSpaceMedal$MedalProgressInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"total", "current"}, new Object[]{0, 0}, QZIntimateSpaceMedal$MedalProgressInfo.class);
        public final PBUInt32Field total = PBField.initUInt32(0);
        public final PBUInt32Field current = PBField.initUInt32(0);
    };
    public final PBBoolField is_new = PBField.initBool(false);
}
