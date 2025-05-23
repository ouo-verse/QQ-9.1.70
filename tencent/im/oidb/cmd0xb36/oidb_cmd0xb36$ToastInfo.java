package tencent.im.oidb.cmd0xb36;

import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xb36$ToastInfo extends MessageMicro<oidb_cmd0xb36$ToastInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 50, 58}, new String[]{"type", "wording", "id", "uins", "expired", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "icon"}, new Object[]{0, "", 0L, 0L, 0, "", ""}, oidb_cmd0xb36$ToastInfo.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField wording = PBField.initString("");

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt64Field f435985id = PBField.initUInt64(0);
    public final PBRepeatField<Long> uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field expired = PBField.initUInt32(0);
    public final PBStringField link = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
}
