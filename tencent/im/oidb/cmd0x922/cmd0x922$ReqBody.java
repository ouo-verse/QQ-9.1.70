package tencent.im.oidb.cmd0x922;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x922$ReqBody extends MessageMicro<cmd0x922$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_timestamp"}, new Object[]{0L}, cmd0x922$ReqBody.class);
    public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0);
}
