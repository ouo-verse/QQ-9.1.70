package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class birthday_hb_reminder_srv$OpenNotifyRequest extends MessageMicro<birthday_hb_reminder_srv$OpenNotifyRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"listid", "send_uin", "recv_uin", "ts", "sign"}, new Object[]{"", "", "", "", ""}, birthday_hb_reminder_srv$OpenNotifyRequest.class);
    public final PBStringField listid = PBField.initString("");
    public final PBStringField send_uin = PBField.initString("");
    public final PBStringField recv_uin = PBField.initString("");

    /* renamed from: ts, reason: collision with root package name */
    public final PBStringField f436046ts = PBField.initString("");
    public final PBStringField sign = PBField.initString("");
}
