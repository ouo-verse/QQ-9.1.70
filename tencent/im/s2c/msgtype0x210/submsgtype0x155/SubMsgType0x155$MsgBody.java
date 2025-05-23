package tencent.im.s2c.msgtype0x210.submsgtype0x155;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x155$MsgBody extends MessageMicro<SubMsgType0x155$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58}, new String[]{ShortVideoConstants.FROM_UIN, "to_uin", "msg_seq", "msg_uid", ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME, "beat_type", "fold_msg"}, new Object[]{0L, 0L, 0, 0L, 0, 0, null}, SubMsgType0x155$MsgBody.class);
    public final PBUInt64Field from_uin = PBField.initUInt64(0);
    public final PBUInt64Field to_uin = PBField.initUInt64(0);
    public final PBUInt32Field msg_seq = PBField.initUInt32(0);
    public final PBUInt64Field msg_uid = PBField.initUInt64(0);
    public final PBUInt32Field msg_time = PBField.initUInt32(0);
    public final PBUInt32Field beat_type = PBField.initUInt32(0);
    public SubMsgType0x155$FoldingMsg fold_msg = new SubMsgType0x155$FoldingMsg();
}
