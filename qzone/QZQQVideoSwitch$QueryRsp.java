package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZQQVideoSwitch$QueryRsp extends MessageMicro<QZQQVideoSwitch$QueryRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"is_target_user", "pop_window_status", "pop_window_text"}, new Object[]{Boolean.FALSE, 0, ""}, QZQQVideoSwitch$QueryRsp.class);
    public final PBBoolField is_target_user = PBField.initBool(false);
    public final PBEnumField pop_window_status = PBField.initEnum(0);
    public final PBStringField pop_window_text = PBField.initString("");
}
