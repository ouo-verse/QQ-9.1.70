package tencent.im.s2c.msgtype0x210.submsgtype0x122;

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
public final class submsgtype0x122$MsgBody extends MessageMicro<submsgtype0x122$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_content;
    public final PBBytesField bytes_pb_reserv;
    public final PBUInt64Field uint64_tips_seq_id;
    public final PBUInt64Field uint64_busi_type = PBField.initUInt64(0);
    public final PBUInt64Field uint64_busi_id = PBField.initUInt64(0);
    public final PBUInt32Field uint32_ctrl_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_c2c_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_templ_id = PBField.initUInt64(0);
    public final PBRepeatMessageField<submsgtype0x122$TemplParam> rpt_msg_templ_param = PBField.initRepeatMessage(submsgtype0x122$TemplParam.class);

    static {
        String[] strArr = {MessageForUniteGrayTip.KEY_UINT64_BUSI_TYPE, MessageForUniteGrayTip.KEY_UINT64_BUSI_ID, "uint32_ctrl_flag", "uint32_c2c_type", "uint32_service_type", MessageForUniteGrayTip.KEY_UINT64_TEMPL_ID, "rpt_msg_templ_param", MessageForUniteGrayTip.KEY_BYTES_CONTENT, MessageForUniteGrayTip.KEY_UINT64_TIPS_SEQ_ID, "bytes_pb_reserv"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58, 66, 80, 802}, strArr, new Object[]{0L, 0L, 0, 0, 0, 0L, null, byteStringMicro, 0L, byteStringMicro}, submsgtype0x122$MsgBody.class);
    }

    public submsgtype0x122$MsgBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_content = PBField.initBytes(byteStringMicro);
        this.uint64_tips_seq_id = PBField.initUInt64(0L);
        this.bytes_pb_reserv = PBField.initBytes(byteStringMicro);
    }
}
