package tencent.im.oidb.oidb_0x8e6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8e6$ReqBody extends MessageMicro<oidb_0x8e6$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42}, new String[]{"rpt_vote_info", "uint32_portal", "uint32_client", "bytes_version", "msg_login_sig"}, new Object[]{null, 0, 0, ByteStringMicro.EMPTY, null}, oidb_0x8e6$ReqBody.class);
    public final PBRepeatMessageField<oidb_0x8e6$VoteInfo> rpt_vote_info = PBField.initRepeatMessage(oidb_0x8e6$VoteInfo.class);
    public final PBUInt32Field uint32_portal = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client = PBField.initUInt32(0);
    public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x8e6$LoginSig msg_login_sig = new MessageMicro<oidb_0x8e6$LoginSig>() { // from class: tencent.im.oidb.oidb_0x8e6.oidb_0x8e6$LoginSig
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_type", "bytes_sig", "uint32_appid"}, new Object[]{0, ByteStringMicro.EMPTY, 0}, oidb_0x8e6$LoginSig.class);
        public final PBUInt32Field uint32_type = PBField.initUInt32(0);
        public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    };
}
