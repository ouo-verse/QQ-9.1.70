package tencent.im.oidb.cmd0xdc2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77$ImageInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xdc2$BatchSendReq extends MessageMicro<oidb_cmd0xdc2$BatchSendReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40}, new String[]{"send_type", "recv_uin", "recv_openid", "image_info", "recv_guild_id"}, new Object[]{0, 0L, "", null, 0L}, oidb_cmd0xdc2$BatchSendReq.class);
    public final PBUInt32Field send_type = PBField.initUInt32(0);
    public final PBUInt64Field recv_uin = PBField.initUInt64(0);
    public final PBStringField recv_openid = PBField.initString("");
    public oidb_cmd0xb77$ImageInfo image_info = new oidb_cmd0xb77$ImageInfo();
    public final PBUInt64Field recv_guild_id = PBField.initUInt64(0);
}
