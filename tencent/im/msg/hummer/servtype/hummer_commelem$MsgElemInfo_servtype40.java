package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hummer_commelem$MsgElemInfo_servtype40 extends MessageMicro<hummer_commelem$MsgElemInfo_servtype40> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"receiver_tiny_id", "gift_num", "gift_id", "gift_name"}, new Object[]{"", 0L, 0L, ""}, hummer_commelem$MsgElemInfo_servtype40.class);
    public final PBStringField receiver_tiny_id = PBField.initString("");
    public final PBUInt64Field gift_num = PBField.initUInt64(0);
    public final PBUInt64Field gift_id = PBField.initUInt64(0);
    public final PBStringField gift_name = PBField.initString("");
}
