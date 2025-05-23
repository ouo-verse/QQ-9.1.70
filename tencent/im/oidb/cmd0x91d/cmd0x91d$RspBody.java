package tencent.im.oidb.cmd0x91d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x91d$RspBody extends MessageMicro<cmd0x91d$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"msg_update_info", "uint64_last_time"}, new Object[]{null, 0L}, cmd0x91d$RspBody.class);
    public cmd0x91d$LabelUpdateInfo msg_update_info = new cmd0x91d$LabelUpdateInfo();
    public final PBUInt64Field uint64_last_time = PBField.initUInt64(0);
}
