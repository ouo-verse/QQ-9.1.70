package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class birthday_hb_reminder_srv$Friends extends MessageMicro<birthday_hb_reminder_srv$Friends> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"uin", "birthdate"}, new Object[]{"", ""}, birthday_hb_reminder_srv$Friends.class);
    public final PBStringField uin = PBField.initString("");
    public final PBStringField birthdate = PBField.initString("");
}
