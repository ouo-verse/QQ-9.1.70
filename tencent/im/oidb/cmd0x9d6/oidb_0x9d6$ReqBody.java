package tencent.im.oidb.cmd0x9d6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x9d6$ReqBody extends MessageMicro<oidb_0x9d6$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"str_feed_id", "uint32_operation"}, new Object[]{"", 0}, oidb_0x9d6$ReqBody.class);
    public final PBStringField str_feed_id = PBField.initString("");
    public final PBUInt32Field uint32_operation = PBField.initUInt32(0);
}
