package tencent.im.oidb;

import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xbcb$CheckUrlRsp extends MessageMicro<oidb_0xbcb$CheckUrlRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{ForwardMiniChooseFriendOption.RESULT_LIST, "next_req_duration"}, new Object[]{null, 0}, oidb_0xbcb$CheckUrlRsp.class);
    public final PBRepeatMessageField<oidb_0xbcb$UrlCheckResult> results = PBField.initRepeatMessage(oidb_0xbcb$UrlCheckResult.class);
    public final PBUInt32Field next_req_duration = PBField.initUInt32(0);
}
