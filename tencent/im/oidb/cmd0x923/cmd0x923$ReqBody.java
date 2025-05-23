package tencent.im.oidb.cmd0x923;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x923$ReqBody extends MessageMicro<cmd0x923$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_type"}, new Object[]{0}, cmd0x923$ReqBody.class);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
}
