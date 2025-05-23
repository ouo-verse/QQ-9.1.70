package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZQQVideoSwitch$QueryReq extends MessageMicro<QZQQVideoSwitch$QueryReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"local_pop_window_status", "scence"}, new Object[]{0, 0}, QZQQVideoSwitch$QueryReq.class);
    public final PBEnumField local_pop_window_status = PBField.initEnum(0);
    public final PBInt32Field scence = PBField.initInt32(0);
}
