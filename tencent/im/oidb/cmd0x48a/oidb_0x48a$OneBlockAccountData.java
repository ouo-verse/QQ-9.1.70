package tencent.im.oidb.cmd0x48a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x48a$OneBlockAccountData extends MessageMicro<oidb_0x48a$OneBlockAccountData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_account_type", "uint64_block_qcall_id"}, new Object[]{0, 0L}, oidb_0x48a$OneBlockAccountData.class);
    public final PBUInt32Field uint32_account_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_block_qcall_id = PBField.initUInt64(0);
}
