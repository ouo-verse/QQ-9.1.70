package tencent.im.msgsync.cmd0x100;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Submsgtype0x8a$WithDrawWordingInfo extends MessageMicro<Submsgtype0x8a$WithDrawWordingInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"int32_item_id", "string_item_name"}, new Object[]{0, ""}, Submsgtype0x8a$WithDrawWordingInfo.class);
    public final PBInt32Field int32_item_id = PBField.initInt32(0);
    public final PBStringField string_item_name = PBField.initString("");
}
