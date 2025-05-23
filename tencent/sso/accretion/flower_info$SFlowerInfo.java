package tencent.sso.accretion;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class flower_info$SFlowerInfo extends MessageMicro<flower_info$SFlowerInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"send_uin", "recv_uin", "flower_url", WidgetCacheConstellationData.NUM}, new Object[]{0L, 0L, "", 0}, flower_info$SFlowerInfo.class);
    public final PBUInt64Field send_uin = PBField.initUInt64(0);
    public final PBUInt64Field recv_uin = PBField.initUInt64(0);
    public final PBStringField flower_url = PBField.initString("");
    public final PBUInt32Field num = PBField.initUInt32(0);
}
