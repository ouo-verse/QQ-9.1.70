package tencent.im.oidb.cmd0x1122;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class oidb_0x1122$FetchPagedRsp extends MessageMicro<oidb_0x1122$FetchPagedRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"is_over", "next_start", "user_perms"}, new Object[]{Boolean.FALSE, 0, null}, oidb_0x1122$FetchPagedRsp.class);
    public final PBBoolField is_over = PBField.initBool(false);
    public final PBUInt32Field next_start = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0x1122$UserPermission> user_perms = PBField.initRepeatMessage(oidb_0x1122$UserPermission.class);
}
