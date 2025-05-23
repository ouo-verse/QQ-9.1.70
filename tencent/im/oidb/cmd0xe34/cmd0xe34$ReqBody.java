package tencent.im.oidb.cmd0xe34;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xe34$ReqBody extends MessageMicro<cmd0xe34$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_bind_uin_info"}, new Object[]{null}, cmd0xe34$ReqBody.class);
    public final PBRepeatMessageField<cmd0xe34$BindUinInfo> rpt_bind_uin_info = PBField.initRepeatMessage(cmd0xe34$BindUinInfo.class);
}
