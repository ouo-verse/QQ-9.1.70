package tencent.im.oidb.cmd0x625;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x625$Open2Tiny_RspBody extends MessageMicro<Oidb_0x625$Open2Tiny_RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_tinyid_rsp_info"}, new Object[]{null}, Oidb_0x625$Open2Tiny_RspBody.class);
    public final PBRepeatMessageField<Oidb_0x625$TinyIDInfoRsp> msg_tinyid_rsp_info = PBField.initRepeatMessage(Oidb_0x625$TinyIDInfoRsp.class);
}
