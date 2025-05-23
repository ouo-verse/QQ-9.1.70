package tencent.im.oidb.cmd0x488;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x488$RspBody extends MessageMicro<oidb_0x488$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_add_block_rsp"}, new Object[]{null}, oidb_0x488$RspBody.class);
    public oidb_0x488$AddBlockRsp msg_add_block_rsp = new MessageMicro<oidb_0x488$AddBlockRsp>() { // from class: tencent.im.oidb.cmd0x488.oidb_0x488$AddBlockRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_one_block_data"}, new Object[]{null}, oidb_0x488$AddBlockRsp.class);
        public oidb_0x488$OneAddBlockData msg_one_block_data = new oidb_0x488$OneAddBlockData();
    };
}
