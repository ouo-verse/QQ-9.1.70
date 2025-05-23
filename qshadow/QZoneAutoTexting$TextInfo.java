package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneAutoTexting$TextInfo extends MessageMicro<QZoneAutoTexting$TextInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 48, 56, 64}, new String[]{"id", "style", "status", "statusMsg", "content", "timestamp", "isSecurity", "delay_time"}, new Object[]{"", "", 0, "", "", 0L, Boolean.FALSE, 0L}, QZoneAutoTexting$TextInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f429485id = PBField.initString("");
    public final PBStringField style = PBField.initString("");
    public final PBEnumField status = PBField.initEnum(0);
    public final PBStringField statusMsg = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public final PBInt64Field timestamp = PBField.initInt64(0);
    public final PBBoolField isSecurity = PBField.initBool(false);
    public final PBInt64Field delay_time = PBField.initInt64(0);
}
