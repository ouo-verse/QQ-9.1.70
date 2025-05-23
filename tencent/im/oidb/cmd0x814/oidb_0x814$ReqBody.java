package tencent.im.oidb.cmd0x814;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x814$ReqBody extends MessageMicro<oidb_0x814$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"show_uin", "start", WidgetCacheConstellationData.NUM, "history"}, new Object[]{0L, 0, 0, 0}, oidb_0x814$ReqBody.class);
    public final PBUInt64Field show_uin = PBField.initUInt64(0);
    public final PBUInt32Field start = PBField.initUInt32(0);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBUInt32Field history = PBField.initUInt32(0);
}
