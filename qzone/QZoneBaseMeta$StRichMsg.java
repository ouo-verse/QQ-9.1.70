package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneBaseMeta$StRichMsg extends MessageMicro<QZoneBaseMeta$StRichMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50, 58, 66, 72}, new String[]{"type", "content", "uid", "name", "who", "url", "uin", "media_items", "ditto_uin"}, new Object[]{0, "", "", "", 0, "", "", null, 0L}, QZoneBaseMeta$StRichMsg.class);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBStringField content = PBField.initString("");
    public final PBStringField uid = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBInt32Field who = PBField.initInt32(0);
    public final PBStringField url = PBField.initString("");
    public final PBStringField uin = PBField.initString("");
    public final PBRepeatMessageField<QZoneBaseMeta$StMedia> media_items = PBField.initRepeatMessage(QZoneBaseMeta$StMedia.class);
    public final PBUInt64Field ditto_uin = PBField.initUInt64(0);
}
