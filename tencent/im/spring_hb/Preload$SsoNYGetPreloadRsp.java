package tencent.im.spring_hb;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class Preload$SsoNYGetPreloadRsp extends MessageMicro<Preload$SsoNYGetPreloadRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40}, new String[]{"retCode", "errMsg", "newestVer", "conf", WidgetCacheConstellationData.INTERVAL}, new Object[]{0, "", 0, "", 0}, Preload$SsoNYGetPreloadRsp.class);
    public final PBInt32Field retCode = PBField.initInt32(0);
    public final PBStringField errMsg = PBField.initString("");
    public final PBInt32Field newestVer = PBField.initInt32(0);
    public final PBStringField conf = PBField.initString("");
    public final PBInt32Field interval = PBField.initInt32(0);
}
