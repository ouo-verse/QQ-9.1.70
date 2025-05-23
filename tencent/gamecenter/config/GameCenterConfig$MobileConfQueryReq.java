package tencent.gamecenter.config;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GameCenterConfig$MobileConfQueryReq extends MessageMicro<GameCenterConfig$MobileConfQueryReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48}, new String[]{"qqVersion", "manufacturer", "model", "osVersionCode", "totalMemory", "cpuCoreCount"}, new Object[]{"", "", "", 0, 0, 0}, GameCenterConfig$MobileConfQueryReq.class);
    public final PBStringField qqVersion = PBField.initString("");
    public final PBStringField manufacturer = PBField.initString("");
    public final PBStringField model = PBField.initString("");
    public final PBInt32Field osVersionCode = PBField.initInt32(0);
    public final PBInt32Field totalMemory = PBField.initInt32(0);
    public final PBInt32Field cpuCoreCount = PBField.initInt32(0);
}
