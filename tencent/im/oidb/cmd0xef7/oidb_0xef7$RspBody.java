package tencent.im.oidb.cmd0xef7;

import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xef7$RspBody extends MessageMicro<oidb_0xef7$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"idol_info", "rank"}, new Object[]{null, 0L}, oidb_0xef7$RspBody.class);
    public oidb_0xef7$IdolInfo idol_info = new MessageMicro<oidb_0xef7$IdolInfo>() { // from class: tencent.im.oidb.cmd0xef7.oidb_0xef7$IdolInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48}, new String[]{"name", NotificationActivity.KEY_ALIAS, "avatar", "desc", "gender", "idol_id"}, new Object[]{"", "", "", "", 0, 0}, oidb_0xef7$IdolInfo.class);
        public final PBStringField name = PBField.initString("");
        public final PBRepeatField<String> alias = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBStringField avatar = PBField.initString("");
        public final PBStringField desc = PBField.initString("");
        public final PBUInt32Field gender = PBField.initUInt32(0);
        public final PBUInt32Field idol_id = PBField.initUInt32(0);
    };
    public final PBUInt64Field rank = PBField.initUInt64(0);
}
