package tencent.im.oidb.cmd0xac5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xac5$ReqBody extends MessageMicro<cmd0xac5$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_uin", "uint64_tinyid", "uint32_gender"}, new Object[]{0L, 0L, 0L}, cmd0xac5$ReqBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0);
    public final PBUInt64Field uint32_gender = PBField.initUInt64(0);
}
