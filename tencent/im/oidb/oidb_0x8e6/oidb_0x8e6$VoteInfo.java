package tencent.im.oidb.oidb_0x8e6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8e6$VoteInfo extends MessageMicro<oidb_0x8e6$VoteInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"uint64_tinyid", "uint64_uin", "uint32_free_vote_count", "uint32_pay_vote_count", "uint32_source"}, new Object[]{0L, 0L, 0, 0, 0}, oidb_0x8e6$VoteInfo.class);
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_free_vote_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pay_vote_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
}
