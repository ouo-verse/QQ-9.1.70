package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneBaseMeta$StBanner extends MessageMicro<QZoneBaseMeta$StBanner> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 56}, new String[]{"id", "img", "color", "text", "action_url", "interval_time", "action_type"}, new Object[]{"", "", "", "", "", 0L, 0}, QZoneBaseMeta$StBanner.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f430333id = PBField.initString("");
    public final PBStringField img = PBField.initString("");
    public final PBStringField color = PBField.initString("");
    public final PBStringField text = PBField.initString("");
    public final PBStringField action_url = PBField.initString("");
    public final PBUInt64Field interval_time = PBField.initUInt64(0);
    public final PBEnumField action_type = PBField.initEnum(0);
}
