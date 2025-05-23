package tencent.im.oidb.cmd0x7ba;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class oidb_0x7ba$PraiseInfo extends MessageMicro<oidb_0x7ba$PraiseInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 88, 96, 104}, new String[]{"uint64_ddwuin", "uint32_praise_today_count", "uint32_rank_number", "uint32_praise_total_count"}, new Object[]{0L, 0, 0, 0}, oidb_0x7ba$PraiseInfo.class);
    public final PBUInt64Field uint64_ddwuin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_praise_today_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_rank_number = PBField.initUInt32(0);
    public final PBUInt32Field uint32_praise_total_count = PBField.initUInt32(0);
}
