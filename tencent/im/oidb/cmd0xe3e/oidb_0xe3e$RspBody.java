package tencent.im.oidb.cmd0xe3e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe3e$RspBody extends MessageMicro<oidb_0xe3e$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_cache_time_seconds", "rpt_group_list"}, new Object[]{0, null}, oidb_0xe3e$RspBody.class);
    public final PBUInt32Field uint32_cache_time_seconds = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0xe3e$GroupList> rpt_group_list = PBField.initRepeatMessage(oidb_0xe3e$GroupList.class);
}
