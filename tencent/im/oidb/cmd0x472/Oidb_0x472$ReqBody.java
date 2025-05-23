package tencent.im.oidb.cmd0x472;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x472$ReqBody extends MessageMicro<Oidb_0x472$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 90}, new String[]{"uint64_uin", "reqChannelPara"}, new Object[]{0L, null}, Oidb_0x472$ReqBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public Oidb_0x472$ReqChannelPara reqChannelPara = new MessageMicro<Oidb_0x472$ReqChannelPara>() { // from class: tencent.im.oidb.cmd0x472.Oidb_0x472$ReqChannelPara
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_channel_id", "uint32_req_channel_list"}, new Object[]{0L, 0}, Oidb_0x472$ReqChannelPara.class);
        public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0);
        public final PBUInt32Field uint32_req_channel_list = PBField.initUInt32(0);
    };
}
