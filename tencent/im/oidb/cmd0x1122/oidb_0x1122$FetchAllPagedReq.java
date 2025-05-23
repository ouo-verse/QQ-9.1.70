package tencent.im.oidb.cmd0x1122;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class oidb_0x1122$FetchAllPagedReq extends MessageMicro<oidb_0x1122$FetchAllPagedReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"start_index", "req_num", "req_tags"}, new Object[]{0, 0, 0L}, oidb_0x1122$FetchAllPagedReq.class);
    public final PBUInt32Field start_index = PBField.initUInt32(0);
    public final PBUInt32Field req_num = PBField.initUInt32(0);
    public final PBRepeatField<Long> req_tags = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
