package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class birthday_hb_reminder_srv$ListQueryReply extends MessageMicro<birthday_hb_reminder_srv$ListQueryReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"ret_code", "ret_msg", "pack_count", "hb_list"}, new Object[]{0, "", 0, null}, birthday_hb_reminder_srv$ListQueryReply.class);
    public final PBEnumField ret_code = PBField.initEnum(0);
    public final PBStringField ret_msg = PBField.initString("");
    public final PBInt32Field pack_count = PBField.initInt32(0);
    public final PBRepeatMessageField<birthday_hb_reminder_srv$HbList> hb_list = PBField.initRepeatMessage(birthday_hb_reminder_srv$HbList.class);
}
