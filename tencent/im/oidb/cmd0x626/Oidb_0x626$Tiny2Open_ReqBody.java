package tencent.im.oidb.cmd0x626;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x626$Tiny2Open_ReqBody extends MessageMicro<Oidb_0x626$Tiny2Open_ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_tinyid_req_info"}, new Object[]{null}, Oidb_0x626$Tiny2Open_ReqBody.class);
    public final PBRepeatMessageField<Oidb_0x626$TinyIDInfoReq> msg_tinyid_req_info = PBField.initRepeatMessage(Oidb_0x626$TinyIDInfoReq.class);
}
