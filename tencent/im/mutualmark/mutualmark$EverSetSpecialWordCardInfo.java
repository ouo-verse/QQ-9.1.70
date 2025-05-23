package tencent.im.mutualmark;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class mutualmark$EverSetSpecialWordCardInfo extends MessageMicro<mutualmark$EverSetSpecialWordCardInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"latest_set_time", "msg_count"}, new Object[]{0, 0}, mutualmark$EverSetSpecialWordCardInfo.class);
    public final PBUInt32Field latest_set_time = PBField.initUInt32(0);
    public final PBUInt32Field msg_count = PBField.initUInt32(0);
}
