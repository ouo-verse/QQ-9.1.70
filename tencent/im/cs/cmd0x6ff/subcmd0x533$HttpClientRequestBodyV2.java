package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class subcmd0x533$HttpClientRequestBodyV2 extends MessageMicro<subcmd0x533$HttpClientRequestBodyV2> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 34, 80}, new String[]{"msg_device", "rpt_string_sentences", "uint32_timeout_ms"}, new Object[]{null, "", 0}, subcmd0x533$HttpClientRequestBodyV2.class);
    public subcmd0x533$HttpDeviceV2 msg_device = new subcmd0x533$HttpDeviceV2();
    public final PBRepeatField<String> rpt_string_sentences = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field uint32_timeout_ms = PBField.initUInt32(0);
}
