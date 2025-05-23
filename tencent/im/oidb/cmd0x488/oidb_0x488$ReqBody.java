package tencent.im.oidb.cmd0x488;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x488$ReqBody extends MessageMicro<oidb_0x488$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_add_block_req"}, new Object[]{null}, oidb_0x488$ReqBody.class);
    public oidb_0x488$AddBlockReq msg_add_block_req = new MessageMicro<oidb_0x488$AddBlockReq>() { // from class: tencent.im.oidb.cmd0x488.oidb_0x488$AddBlockReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_one_block_data"}, new Object[]{null}, oidb_0x488$AddBlockReq.class);
        public oidb_0x488$OneAddBlockData msg_one_block_data = new oidb_0x488$OneAddBlockData();
    };
}
