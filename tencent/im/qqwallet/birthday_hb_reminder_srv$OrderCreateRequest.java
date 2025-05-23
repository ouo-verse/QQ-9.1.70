package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class birthday_hb_reminder_srv$OrderCreateRequest extends MessageMicro<birthday_hb_reminder_srv$OrderCreateRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 50, 58, 66, 74, 82}, new String[]{"listid", "amount", "send_uin", "send_name", "recv_uin", "recv_name", "birthdate", "arrival_time", "ts", "sign"}, new Object[]{"", 0L, "", "", "", "", "", "", "", ""}, birthday_hb_reminder_srv$OrderCreateRequest.class);
    public final PBStringField listid = PBField.initString("");
    public final PBInt64Field amount = PBField.initInt64(0);
    public final PBStringField send_uin = PBField.initString("");
    public final PBStringField send_name = PBField.initString("");
    public final PBStringField recv_uin = PBField.initString("");
    public final PBStringField recv_name = PBField.initString("");
    public final PBStringField birthdate = PBField.initString("");
    public final PBStringField arrival_time = PBField.initString("");

    /* renamed from: ts, reason: collision with root package name */
    public final PBStringField f436047ts = PBField.initString("");
    public final PBStringField sign = PBField.initString("");
}
