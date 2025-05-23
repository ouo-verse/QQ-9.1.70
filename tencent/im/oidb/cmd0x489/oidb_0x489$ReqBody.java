package tencent.im.oidb.cmd0x489;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x489$ReqBody extends MessageMicro<oidb_0x489$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_del_block_req"}, new Object[]{null}, oidb_0x489$ReqBody.class);
    public oidb_0x489$DelBlockReq msg_del_block_req = new MessageMicro<oidb_0x489$DelBlockReq>() { // from class: tencent.im.oidb.cmd0x489.oidb_0x489$DelBlockReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_one_block_data"}, new Object[]{null}, oidb_0x489$DelBlockReq.class);
        public oidb_0x489$OneDelBlockData msg_one_block_data = new oidb_0x489$OneDelBlockData();
    };
}
