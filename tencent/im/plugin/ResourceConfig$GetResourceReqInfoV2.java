package tencent.im.plugin;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.vivo.push.PushClientConstants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ResourceConfig$GetResourceReqInfoV2 extends MessageMicro<ResourceConfig$GetResourceReqInfoV2> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 56, 64, 72, 80}, new String[]{PushClientConstants.TAG_PKG_NAME, "curVer", "resSubType", "lanType", "state", "resId", "status", "push", "pluginType", "delFlag"}, new Object[]{"", 0L, 0, 0, 0, 0, 0, 0, 0, 0}, ResourceConfig$GetResourceReqInfoV2.class);
    public final PBStringField pkgName = PBField.initString("");
    public final PBInt64Field curVer = PBField.initInt64(0);
    public final PBUInt32Field resSubType = PBField.initUInt32(0);
    public final PBUInt32Field lanType = PBField.initUInt32(0);
    public final PBUInt32Field state = PBField.initUInt32(0);
    public final PBUInt32Field resId = PBField.initUInt32(0);
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBUInt32Field push = PBField.initUInt32(0);
    public final PBUInt32Field pluginType = PBField.initUInt32(0);
    public final PBUInt32Field delFlag = PBField.initUInt32(0);
}
