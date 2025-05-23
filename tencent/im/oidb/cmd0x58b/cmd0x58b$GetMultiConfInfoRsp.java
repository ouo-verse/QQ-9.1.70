package tencent.im.oidb.cmd0x58b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x58b$GetMultiConfInfoRsp extends MessageMicro<cmd0x58b$GetMultiConfInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_get_conf_info"}, new Object[]{null}, cmd0x58b$GetMultiConfInfoRsp.class);
    public final PBRepeatMessageField<cmd0x58b$GetConfInfoRsp> msg_get_conf_info = PBField.initRepeatMessage(cmd0x58b$GetConfInfoRsp.class);
}
