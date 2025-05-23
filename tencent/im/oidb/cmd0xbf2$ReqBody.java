package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xbf2$ReqBody extends MessageMicro<cmd0xbf2$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_uin", "uint64_start_index", "uint64_num"}, new Object[]{0L, 0L, 0L}, cmd0xbf2$ReqBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_start_index = PBField.initUInt64(0);
    public final PBUInt64Field uint64_num = PBField.initUInt64(0);
}
