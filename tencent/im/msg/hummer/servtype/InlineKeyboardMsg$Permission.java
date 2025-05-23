package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class InlineKeyboardMsg$Permission extends MessageMicro<InlineKeyboardMsg$Permission> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"type", "specify_role_ids", "specify_tinyids"}, new Object[]{0, "", ""}, InlineKeyboardMsg$Permission.class);
    public final PBRepeatField<String> specify_role_ids;
    public final PBRepeatField<String> specify_tinyids;
    public final PBUInt32Field type = PBField.initUInt32(0);

    public InlineKeyboardMsg$Permission() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.specify_role_ids = PBField.initRepeat(pBStringField);
        this.specify_tinyids = PBField.initRepeat(pBStringField);
    }
}
