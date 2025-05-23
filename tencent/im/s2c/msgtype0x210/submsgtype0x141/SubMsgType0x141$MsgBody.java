package tencent.im.s2c.msgtype0x210.submsgtype0x141;

import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x141$MsgBody extends MessageMicro<SubMsgType0x141$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"uint64_from", "uint64_to", "uint64_aio_uin", MessageForUniteGrayTip.KEY_UINT64_BUSI_ID, MessageForUniteGrayTip.KEY_UINT64_TIPS_SEQ_ID}, new Object[]{0L, 0L, 0L, 0L, 0L}, SubMsgType0x141$MsgBody.class);
    public final PBUInt64Field uint64_from = PBField.initUInt64(0);
    public final PBUInt64Field uint64_to = PBField.initUInt64(0);
    public final PBUInt64Field uint64_aio_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_busi_id = PBField.initUInt64(0);
    public final PBUInt64Field uint64_tips_seq_id = PBField.initUInt64(0);
}
