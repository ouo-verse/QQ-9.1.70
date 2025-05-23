package tencent.im.statsvc.stat.mute;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class StatSetMute$ReqBody extends MessageMicro<StatSetMute$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"set_mute"}, new Object[]{0}, StatSetMute$ReqBody.class);
    public final PBUInt32Field set_mute = PBField.initUInt32(0);
}
