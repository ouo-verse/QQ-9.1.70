package tencent.im.oidb.cmd0xe82;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.RedTouchWebviewHandler;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xe82$ReqBody extends MessageMicro<cmd0xe82$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48}, new String[]{"client", "group_id", "group_type", "mode", "miniapp_protect", RedTouchWebviewHandler.PLUGIN_NAMESPACE}, new Object[]{null, 0L, 0, 0, 0, 0}, cmd0xe82$ReqBody.class);
    public cmd0xe82$ClientInfo client = new cmd0xe82$ClientInfo();
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBUInt32Field group_type = PBField.initUInt32(0);
    public final PBUInt32Field mode = PBField.initUInt32(0);
    public final PBUInt32Field miniapp_protect = PBField.initUInt32(0);
    public final PBUInt32Field redpoint = PBField.initUInt32(0);
}
