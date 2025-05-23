package tencent.im.oidb.oidb_0x783;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x783$ReqBody extends MessageMicro<oidb_0x783$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40}, new String[]{"uint32_subcmd", "uint32_type", "msg_discussinfo", "rpt_uinlist", "uint32_groupid"}, new Object[]{0, 0, null, null, 0}, oidb_0x783$ReqBody.class);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public oidb_0x783$DiscussGroup msg_discussinfo = new MessageMicro<oidb_0x783$DiscussGroup>() { // from class: tencent.im.oidb.oidb_0x783.oidb_0x783$DiscussGroup
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 29}, new String[]{"uint64_confid", "uint32_confseq", "uint32_time"}, new Object[]{0L, 0, 0}, oidb_0x783$DiscussGroup.class);
        public final PBUInt64Field uint64_confid = PBField.initUInt64(0);
        public final PBUInt32Field uint32_confseq = PBField.initUInt32(0);
        public final PBFixed32Field uint32_time = PBField.initFixed32(0);
    };
    public final PBRepeatMessageField<oidb_0x783$UinListInfo> rpt_uinlist = PBField.initRepeatMessage(oidb_0x783$UinListInfo.class);
    public final PBUInt32Field uint32_groupid = PBField.initUInt32(0);
}
