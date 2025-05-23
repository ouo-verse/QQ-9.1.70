package tencent.im.oidb.cmd0x489;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x489$RspBody extends MessageMicro<oidb_0x489$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_del_block_rsp"}, new Object[]{null}, oidb_0x489$RspBody.class);
    public oidb_0x489$DelBlockRsp msg_del_block_rsp = new MessageMicro<oidb_0x489$DelBlockRsp>() { // from class: tencent.im.oidb.cmd0x489.oidb_0x489$DelBlockRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_one_block_data"}, new Object[]{null}, oidb_0x489$DelBlockRsp.class);
        public oidb_0x489$OneDelBlockData msg_one_block_data = new oidb_0x489$OneDelBlockData();
    };
}
