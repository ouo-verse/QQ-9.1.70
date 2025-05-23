package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$RotateMessageLabel extends MessageMicro<YoloRoomOuterClass$RotateMessageLabel> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"key", "text", "type", "uid", "uid_list"}, new Object[]{"", "", 0, 0L, 0L}, YoloRoomOuterClass$RotateMessageLabel.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField text = PBField.initString("");
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBRepeatField<Long> uid_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
