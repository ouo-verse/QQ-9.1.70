package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class birthday_hb_reminder_srv$ListQueryRequest extends MessageMicro<birthday_hb_reminder_srv$ListQueryRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"uin", "friends"}, new Object[]{"", null}, birthday_hb_reminder_srv$ListQueryRequest.class);
    public final PBStringField uin = PBField.initString("");
    public final PBRepeatMessageField<birthday_hb_reminder_srv$Friends> friends = PBField.initRepeatMessage(birthday_hb_reminder_srv$Friends.class);
}
