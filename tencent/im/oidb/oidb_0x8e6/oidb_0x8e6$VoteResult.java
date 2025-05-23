package tencent.im.oidb.oidb_0x8e6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8e6$VoteResult extends MessageMicro<oidb_0x8e6$VoteResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48, 56, 64}, new String[]{"uint32_ret", "bytes_err_msg", "uint64_tinyid", "uint64_uin", "uint32_vote_count", "uint32_succ_free_vote_count", "uint32_succ_pay_vote_count", "uint64_pay_stock"}, new Object[]{0, ByteStringMicro.EMPTY, 0L, 0L, 0, 0, 0, 0L}, oidb_0x8e6$VoteResult.class);
    public final PBUInt32Field uint32_ret = PBField.initUInt32(0);
    public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_vote_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_succ_free_vote_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_succ_pay_vote_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_pay_stock = PBField.initUInt64(0);
}
