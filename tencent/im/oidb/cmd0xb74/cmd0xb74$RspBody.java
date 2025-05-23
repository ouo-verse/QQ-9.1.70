package tencent.im.oidb.cmd0xb74;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xb74$RspBody extends MessageMicro<cmd0xb74$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_like_info"}, new Object[]{null}, cmd0xb74$RspBody.class);
    public final PBRepeatMessageField<cmd0xb74$LikeInfo> rpt_like_info = PBField.initRepeatMessage(cmd0xb74$LikeInfo.class);
}
