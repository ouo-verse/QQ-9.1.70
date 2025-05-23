package tencent.im.oidb.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class DynamicBusinessHotWord$ReqBody extends MessageMicro<DynamicBusinessHotWord$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"version", "business", "rpt_group_id"}, new Object[]{ByteStringMicro.EMPTY, 0, null}, DynamicBusinessHotWord$ReqBody.class);
    public final PBBytesField version = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field business = PBField.initUInt32(0);
    public final PBRepeatMessageField<DynamicBusinessHotWord$GroupID> rpt_group_id = PBField.initRepeatMessage(DynamicBusinessHotWord$GroupID.class);
}
