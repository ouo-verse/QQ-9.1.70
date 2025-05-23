package tencent.im.oidb.cmd0x48b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x48b$ReqBody extends MessageMicro<oidb_0x48b$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_get_blocklist_req"}, new Object[]{null}, oidb_0x48b$ReqBody.class);
    public oidb_0x48b$GetblockListReq msg_get_blocklist_req = new MessageMicro<oidb_0x48b$GetblockListReq>() { // from class: tencent.im.oidb.cmd0x48b.oidb_0x48b$GetblockListReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_start_idx", "uint32_req_num", "uint32_last_get_time"}, new Object[]{0, 0, 0}, oidb_0x48b$GetblockListReq.class);
        public final PBUInt32Field uint32_start_idx = PBField.initUInt32(0);
        public final PBUInt32Field uint32_req_num = PBField.initUInt32(0);
        public final PBUInt32Field uint32_last_get_time = PBField.initUInt32(0);
    };
}
