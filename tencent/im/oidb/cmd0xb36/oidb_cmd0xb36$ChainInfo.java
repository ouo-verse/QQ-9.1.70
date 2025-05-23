package tencent.im.oidb.cmd0xb36;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xb36$ChainInfo extends MessageMicro<oidb_cmd0xb36$ChainInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 48, 56, 64}, new String[]{"id", "type", "uin", "desc", "pic", "created", "expired", "is_joined"}, new Object[]{0L, 0, 0L, "", "", 0, 0, 0}, oidb_cmd0xb36$ChainInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt64Field f435984id = PBField.initUInt64(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField desc = PBField.initString("");
    public final PBRepeatField<String> pic = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field created = PBField.initUInt32(0);
    public final PBUInt32Field expired = PBField.initUInt32(0);
    public final PBUInt32Field is_joined = PBField.initUInt32(0);
}
