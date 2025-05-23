package tencent.im.oidb.cmd0xedf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xedf$GroupAllianceNotify extends MessageMicro<oidb_0xedf$GroupAllianceNotify> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40}, new String[]{"uint64_alliance_id", "uint64_alliance_owner", "uint64_leader_group_code", "st_apply_alliance", "uint32_result"}, new Object[]{0L, 0L, 0L, null, 0}, oidb_0xedf$GroupAllianceNotify.class);
    public final PBUInt64Field uint64_alliance_id = PBField.initUInt64(0);
    public final PBUInt64Field uint64_alliance_owner = PBField.initUInt64(0);
    public final PBUInt64Field uint64_leader_group_code = PBField.initUInt64(0);
    public oidb_0xedf$ApplyAlliance st_apply_alliance = new MessageMicro<oidb_0xedf$ApplyAlliance>() { // from class: tencent.im.oidb.cmd0xedf.oidb_0xedf$ApplyAlliance
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_apply_group_code", "uint64_apply_group_owner", "uint64_source_group_owner"}, new Object[]{0L, 0L, 0L}, oidb_0xedf$ApplyAlliance.class);
        public final PBUInt64Field uint64_apply_group_code = PBField.initUInt64(0);
        public final PBUInt64Field uint64_apply_group_owner = PBField.initUInt64(0);
        public final PBUInt64Field uint64_source_group_owner = PBField.initUInt64(0);
    };
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
}
