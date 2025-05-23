package tencent.im.oidb.cmd0x1122;

import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x1122$SetRsp extends MessageMicro<oidb_0x1122$SetRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{ForwardMiniChooseFriendOption.RESULT_LIST}, new Object[]{null}, oidb_0x1122$SetRsp.class);
    public final PBRepeatMessageField<oidb_0x1122$SNSUpdateResult> results = PBField.initRepeatMessage(oidb_0x1122$SNSUpdateResult.class);
}
