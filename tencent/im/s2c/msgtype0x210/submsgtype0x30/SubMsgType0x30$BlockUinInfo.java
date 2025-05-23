package tencent.im.s2c.msgtype0x210.submsgtype0x30;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x30$BlockUinInfo extends MessageMicro<SubMsgType0x30$BlockUinInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_block_uin", "uint32_source_id", "uint32_source_sub_id"}, new Object[]{0L, 0, 0}, SubMsgType0x30$BlockUinInfo.class);
    public final PBUInt64Field uint64_block_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_source_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_source_sub_id = PBField.initUInt32(0);
}
