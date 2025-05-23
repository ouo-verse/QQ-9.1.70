package tencent.im.plugin;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.vivo.push.PushClientConstants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ResourceConfig$GetResourceRespInfoV2 extends MessageMicro<ResourceConfig$GetResourceRespInfoV2> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 50, 58, 66, 74, 82, 88, 96, 104, 112, 120, 128, 138, 146}, new String[]{PushClientConstants.TAG_PKG_NAME, "newVer", "resSubType", "lanType", "priority", "resName", "resDesc", "resURLBig", "resURLSmall", "resConf", "defaultState", "canChangeState", "resId", "status", "push", "pluginType", "newPluginDesc", "newPluginURL"}, new Object[]{"", 0, 0, 0, 0, "", "", "", "", "", 0, 0, 0, 0, 0, 0, "", ""}, ResourceConfig$GetResourceRespInfoV2.class);
    public final PBStringField pkgName = PBField.initString("");
    public final PBUInt32Field newVer = PBField.initUInt32(0);
    public final PBUInt32Field resSubType = PBField.initUInt32(0);
    public final PBUInt32Field lanType = PBField.initUInt32(0);
    public final PBUInt32Field priority = PBField.initUInt32(0);
    public final PBStringField resName = PBField.initString("");
    public final PBStringField resDesc = PBField.initString("");
    public final PBStringField resURLBig = PBField.initString("");
    public final PBStringField resURLSmall = PBField.initString("");
    public final PBStringField resConf = PBField.initString("");
    public final PBUInt32Field defaultState = PBField.initUInt32(0);
    public final PBUInt32Field canChangeState = PBField.initUInt32(0);
    public final PBUInt32Field resId = PBField.initUInt32(0);
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBUInt32Field push = PBField.initUInt32(0);
    public final PBUInt32Field pluginType = PBField.initUInt32(0);
    public final PBStringField newPluginDesc = PBField.initString("");
    public final PBStringField newPluginURL = PBField.initString("");
}
