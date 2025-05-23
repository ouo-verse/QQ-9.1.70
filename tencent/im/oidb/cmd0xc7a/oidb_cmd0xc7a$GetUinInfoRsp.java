package tencent.im.oidb.cmd0xc7a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xc7a$GetUinInfoRsp extends MessageMicro<oidb_cmd0xc7a$GetUinInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"uin_infos"}, new Object[]{null}, oidb_cmd0xc7a$GetUinInfoRsp.class);
    public final PBRepeatMessageField<oidb_cmd0xc7a$UinInfo> uin_infos = PBField.initRepeatMessage(oidb_cmd0xc7a$UinInfo.class);
}
