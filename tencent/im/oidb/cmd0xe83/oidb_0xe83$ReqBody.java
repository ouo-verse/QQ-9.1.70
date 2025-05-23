package tencent.im.oidb.cmd0xe83;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe83$ReqBody extends MessageMicro<oidb_0xe83$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40}, new String[]{"group_id", "client_info", "last_game_dynamic_ts", "mini_app_disable", "mode"}, new Object[]{0L, null, 0, 0, 0}, oidb_0xe83$ReqBody.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public oidb_0xe83$ClientInfo client_info = new oidb_0xe83$ClientInfo();
    public final PBUInt32Field last_game_dynamic_ts = PBField.initUInt32(0);
    public final PBUInt32Field mini_app_disable = PBField.initUInt32(0);
    public final PBUInt32Field mode = PBField.initUInt32(0);
}
