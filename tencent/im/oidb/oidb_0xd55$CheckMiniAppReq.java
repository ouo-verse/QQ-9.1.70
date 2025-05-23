package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xd55$CheckMiniAppReq extends MessageMicro<oidb_0xd55$CheckMiniAppReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"mini_app_appid", "need_check_bind"}, new Object[]{0L, 0}, oidb_0xd55$CheckMiniAppReq.class);
    public final PBUInt64Field mini_app_appid = PBField.initUInt64(0);
    public final PBUInt32Field need_check_bind = PBField.initUInt32(0);
}
