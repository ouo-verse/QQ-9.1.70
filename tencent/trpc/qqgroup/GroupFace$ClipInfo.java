package tencent.trpc.qqgroup;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GroupFace$ClipInfo extends MessageMicro<GroupFace$ClipInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"left_x", "left_y", "right_x", "right_y"}, new Object[]{0, 0, 0, 0}, GroupFace$ClipInfo.class);
    public final PBUInt32Field left_x = PBField.initUInt32(0);
    public final PBUInt32Field left_y = PBField.initUInt32(0);
    public final PBUInt32Field right_x = PBField.initUInt32(0);
    public final PBUInt32Field right_y = PBField.initUInt32(0);
}
