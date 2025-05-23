package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TaskCenterReader$EeveeAttach extends MessageMicro<TaskCenterReader$EeveeAttach> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 82}, new String[]{"need_vv_info", "trans_info"}, new Object[]{Boolean.FALSE, ByteStringMicro.EMPTY}, TaskCenterReader$EeveeAttach.class);
    public final PBBoolField need_vv_info = PBField.initBool(false);
    public final PBBytesField trans_info = PBField.initBytes(ByteStringMicro.EMPTY);
}
