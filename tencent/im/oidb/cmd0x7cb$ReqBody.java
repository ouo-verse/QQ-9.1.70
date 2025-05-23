package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x7cb$ReqBody extends MessageMicro<cmd0x7cb$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_time_stamp"}, new Object[]{0}, cmd0x7cb$ReqBody.class);
    public final PBUInt32Field uint32_time_stamp = PBField.initUInt32(0);
}
