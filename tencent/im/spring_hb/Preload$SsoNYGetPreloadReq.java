package tencent.im.spring_hb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes29.dex */
public final class Preload$SsoNYGetPreloadReq extends MessageMicro<Preload$SsoNYGetPreloadReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"ver", "commonInfo", "scene"}, new Object[]{0, null, 0}, Preload$SsoNYGetPreloadReq.class);
    public final PBInt32Field ver = PBField.initInt32(0);
    public Preload$NYCommonInfo commonInfo = new Preload$NYCommonInfo();
    public final PBInt32Field scene = PBField.initInt32(0);
}
