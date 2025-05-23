package tencent.im.oidb.cmd0xe2e;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.RedTouchWebviewHandler;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe2e$ReqBody extends MessageMicro<oidb_0xe2e$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 48, 56, 66, 72, 80, 88}, new String[]{"client", "group_id", "group_type", "mode", "keyword", "page", WidgetCacheConstellationData.NUM, "attachinfo", "miniapp_protect", "from", RedTouchWebviewHandler.PLUGIN_NAMESPACE}, new Object[]{null, 0L, 0, 0, "", 0, 0, "", 0, 0, 0}, oidb_0xe2e$ReqBody.class);
    public oidb_0xe2e$ClientInfo client = new oidb_0xe2e$ClientInfo();
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBUInt32Field group_type = PBField.initUInt32(0);
    public final PBUInt32Field mode = PBField.initUInt32(0);
    public final PBStringField keyword = PBField.initString("");
    public final PBUInt32Field page = PBField.initUInt32(0);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBStringField attachinfo = PBField.initString("");
    public final PBUInt32Field miniapp_protect = PBField.initUInt32(0);
    public final PBUInt32Field from = PBField.initUInt32(0);
    public final PBUInt32Field redpoint = PBField.initUInt32(0);
}
