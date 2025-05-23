package tencent.im.oidb.cmd0x7c4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x7c4$GetSNFrdListReq extends MessageMicro<cmd0x7c4$GetSNFrdListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint64_uin", "uint32_sequence", "uint32_start_idx", "uint32_req_num"}, new Object[]{0L, 0, 0, 0}, cmd0x7c4$GetSNFrdListReq.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_sequence = PBField.initUInt32(0);
    public final PBUInt32Field uint32_start_idx = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_num = PBField.initUInt32(0);
}
