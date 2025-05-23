package tencent.im.oidb.cmd0x10fa;

import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x10fa$IsFriendBatchRsp extends MessageMicro<oidb_0x10fa$IsFriendBatchRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"appid", ForwardMiniChooseFriendOption.RESULT_LIST}, new Object[]{0, null}, oidb_0x10fa$IsFriendBatchRsp.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0x10fa$IsFriendResult> results = PBField.initRepeatMessage(oidb_0x10fa$IsFriendResult.class);
}
