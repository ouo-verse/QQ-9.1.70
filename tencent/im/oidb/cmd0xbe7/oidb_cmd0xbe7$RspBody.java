package tencent.im.oidb.cmd0xbe7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xbe7$RspBody extends MessageMicro<oidb_cmd0xbe7$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"rpt_question_info", "bytes_cookies", "bool_is_end", "uint32_recomand_strategy"}, new Object[]{null, ByteStringMicro.EMPTY, Boolean.FALSE, 0}, oidb_cmd0xbe7$RspBody.class);
    public final PBRepeatMessageField<oidb_cmd0xbe7$QuestionInfo> rpt_question_info = PBField.initRepeatMessage(oidb_cmd0xbe7$QuestionInfo.class);
    public final PBBytesField bytes_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBoolField bool_is_end = PBField.initBool(false);
    public final PBUInt32Field uint32_recomand_strategy = PBField.initUInt32(0);
}
