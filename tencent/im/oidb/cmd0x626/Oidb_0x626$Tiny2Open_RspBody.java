package tencent.im.oidb.cmd0x626;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x626$Tiny2Open_RspBody extends MessageMicro<Oidb_0x626$Tiny2Open_RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_openid_rsp_info"}, new Object[]{null}, Oidb_0x626$Tiny2Open_RspBody.class);
    public final PBRepeatMessageField<Oidb_0x626$OpenIDInfoRsp> msg_openid_rsp_info = PBField.initRepeatMessage(Oidb_0x626$OpenIDInfoRsp.class);
}
