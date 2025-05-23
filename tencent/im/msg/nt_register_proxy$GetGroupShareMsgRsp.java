package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nt_register_proxy$GetGroupShareMsgRsp extends MessageMicro<nt_register_proxy$GetGroupShareMsgRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40}, new String[]{"result", "err_msg", "group_code", "msg", "failed_seqs"}, new Object[]{0, ByteStringMicro.EMPTY, 0L, null, 0L}, nt_register_proxy$GetGroupShareMsgRsp.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field group_code = PBField.initUInt64(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBRepeatMessageField<nt_msg_common$Msg> f435956msg = PBField.initRepeatMessage(nt_msg_common$Msg.class);
    public final PBRepeatField<Long> failed_seqs = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
