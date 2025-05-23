package tencent.im.s2c.msgtype0x210.submsgtype0x123;

import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x123$MsgBody extends MessageMicro<submsgtype0x123$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58, 66}, new String[]{MessageForUniteGrayTip.KEY_UINT64_BUSI_TYPE, MessageForUniteGrayTip.KEY_UINT64_BUSI_ID, "uint64_ctrl_flag", "uint64_c2c_type", "uint64_service_type", MessageForUniteGrayTip.KEY_UINT64_TEMPL_ID, "rpt_templ_param", "bytes_templ_content"}, new Object[]{0L, 0L, 0, 0, 0, 0L, null, ByteStringMicro.EMPTY}, submsgtype0x123$MsgBody.class);
    public final PBUInt64Field uint64_busi_type = PBField.initUInt64(0);
    public final PBUInt64Field uint64_busi_id = PBField.initUInt64(0);
    public final PBUInt32Field uint64_ctrl_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint64_c2c_type = PBField.initUInt32(0);
    public final PBUInt32Field uint64_service_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_templ_id = PBField.initUInt64(0);
    public final PBRepeatMessageField<submsgtype0x123$TemplParam> rpt_templ_param = PBField.initRepeatMessage(submsgtype0x123$TemplParam.class);
    public final PBBytesField bytes_templ_content = PBField.initBytes(ByteStringMicro.EMPTY);
}
