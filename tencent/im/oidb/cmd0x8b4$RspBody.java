package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x8b4$RspBody extends MessageMicro<cmd0x8b4$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBBytesField bytes_tag = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<cmd0x8b4$GroupInfo> rpt_group_info = PBField.initRepeatMessage(cmd0x8b4$GroupInfo.class);
    public final PBRepeatField<ByteStringMicro> bytes_text_label = PBField.initRepeat(PBBytesField.__repeatHelper__);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 170, 178, 186}, new String[]{"uint32_result", "uint32_flag", "bytes_tag", "rpt_group_info", "bytes_text_label"}, new Object[]{0, 0, byteStringMicro, null, byteStringMicro}, cmd0x8b4$RspBody.class);
    }
}
