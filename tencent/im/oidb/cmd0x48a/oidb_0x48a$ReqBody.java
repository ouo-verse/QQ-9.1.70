package tencent.im.oidb.cmd0x48a;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x48a$ReqBody extends MessageMicro<oidb_0x48a$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_chk_block_req"}, new Object[]{null}, oidb_0x48a$ReqBody.class);
    public oidb_0x48a$ChkBlockReq msg_chk_block_req = new MessageMicro<oidb_0x48a$ChkBlockReq>() { // from class: tencent.im.oidb.cmd0x48a.oidb_0x48a$ChkBlockReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_block_account_data"}, new Object[]{null}, oidb_0x48a$ChkBlockReq.class);
        public oidb_0x48a$OneBlockAccountData msg_block_account_data = new oidb_0x48a$OneBlockAccountData();
    };
}
