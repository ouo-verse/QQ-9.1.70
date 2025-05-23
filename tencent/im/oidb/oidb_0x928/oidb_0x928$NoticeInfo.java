package tencent.im.oidb.oidb_0x928;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x928$NoticeInfo extends MessageMicro<oidb_0x928$NoticeInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 56, 64, 72}, new String[]{"id", "title", "summary", "url", "icon", "type", "app_id", "show_expire", "hide_mode"}, new Object[]{"", "", "", "", "", 0, 0L, 0, 0}, oidb_0x928$NoticeInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f436014id = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField summary = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt64Field app_id = PBField.initUInt64(0);
    public final PBUInt32Field show_expire = PBField.initUInt32(0);
    public final PBUInt32Field hide_mode = PBField.initUInt32(0);
}
