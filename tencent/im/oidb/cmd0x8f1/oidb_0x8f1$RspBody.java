package tencent.im.oidb.cmd0x8f1;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.label.comm.PersonalityTagComm$LabelInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8f1$RspBody extends MessageMicro<oidb_0x8f1$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"msg_label_info", "uint32_complete_flag", "bytes_label_cookie"}, new Object[]{null, 0, ByteStringMicro.EMPTY}, oidb_0x8f1$RspBody.class);
    public PersonalityTagComm$LabelInfo msg_label_info = new PersonalityTagComm$LabelInfo();
    public final PBUInt32Field uint32_complete_flag = PBField.initUInt32(0);
    public final PBBytesField bytes_label_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
}
