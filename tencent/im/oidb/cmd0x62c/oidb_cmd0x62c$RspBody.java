package tencent.im.oidb.cmd0x62c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x62c$RspBody extends MessageMicro<oidb_cmd0x62c$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_tinyid_info"}, new Object[]{null}, oidb_cmd0x62c$RspBody.class);
    public final PBRepeatMessageField<oidb_cmd0x62c$TinyIDInfo> msg_tinyid_info = PBField.initRepeatMessage(oidb_cmd0x62c$TinyIDInfo.class);
}
