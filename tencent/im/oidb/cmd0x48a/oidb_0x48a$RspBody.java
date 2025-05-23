package tencent.im.oidb.cmd0x48a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x48a$RspBody extends MessageMicro<oidb_0x48a$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_chk_block_rsp"}, new Object[]{null}, oidb_0x48a$RspBody.class);
    public oidb_0x48a$ChkBlockRsp msg_chk_block_rsp = new MessageMicro<oidb_0x48a$ChkBlockRsp>() { // from class: tencent.im.oidb.cmd0x48a.oidb_0x48a$ChkBlockRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"msg_block_account_data", "uint32_result"}, new Object[]{null, 0}, oidb_0x48a$ChkBlockRsp.class);
        public oidb_0x48a$OneBlockAccountData msg_block_account_data = new oidb_0x48a$OneBlockAccountData();
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    };
}
