package tencent.im.oidb.cmd0xe84;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe84$RspBody extends MessageMicro<oidb_0xe84$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"uint64_appid", "sint32_result", "uint32_interval", "msg_custom_data"}, new Object[]{0L, 0, 0, null}, oidb_0xe84$RspBody.class);
    public final PBUInt64Field uint64_appid = PBField.initUInt64(0);
    public final PBSInt32Field sint32_result = PBField.initSInt32(0);
    public final PBUInt32Field uint32_interval = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0xe84$CustomData> msg_custom_data = PBField.initRepeatMessage(oidb_0xe84$CustomData.class);
}
