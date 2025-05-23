package tencent.im.s2c.frdsysmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class FrdSysMsg$GroupInfoExt extends MessageMicro<FrdSysMsg$GroupInfoExt> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_notify_type", "uint64_group_code", "uint32_from_groupadmlist"}, new Object[]{0, 0L, 0}, FrdSysMsg$GroupInfoExt.class);
    public final PBUInt32Field uint32_notify_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt32Field uint32_from_groupadmlist = PBField.initUInt32(0);
}
