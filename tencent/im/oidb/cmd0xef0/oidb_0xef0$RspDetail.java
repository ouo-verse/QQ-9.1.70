package tencent.im.oidb.cmd0xef0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xef0$RspDetail extends MessageMicro<oidb_0xef0$RspDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint64_group_code", "int32_result", "msg_group_info_ext"}, new Object[]{0L, 0, null}, oidb_0xef0$RspDetail.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public oidb_0xef0$GroupInfoExt msg_group_info_ext = new oidb_0xef0$GroupInfoExt();
}
