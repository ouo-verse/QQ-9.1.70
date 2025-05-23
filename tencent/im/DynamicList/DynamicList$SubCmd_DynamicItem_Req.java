package tencent.im.DynamicList;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class DynamicList$SubCmd_DynamicItem_Req extends MessageMicro<DynamicList$SubCmd_DynamicItem_Req> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uiPluginID", "uiNewVer", "uiOpenFlag"}, new Object[]{0, 0, 0}, DynamicList$SubCmd_DynamicItem_Req.class);
    public final PBUInt32Field uiPluginID = PBField.initUInt32(0);
    public final PBUInt32Field uiNewVer = PBField.initUInt32(0);
    public final PBUInt32Field uiOpenFlag = PBField.initUInt32(0);
}
