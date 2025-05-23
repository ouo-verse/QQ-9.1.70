package tencent.im.DynamicList;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class DynamicList$SubCmd_DynamicItem_Resp extends MessageMicro<DynamicList$SubCmd_DynamicItem_Resp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 58, 66, 74, 82, 90, 98, 104, 112, 122}, new String[]{"strPkgName", "uiPluginID", "uiNewVer", "uiType", "uiWeight", "uiOpenFlag", "strResName", "strResDesc", "strResURL_big", "strResURL_small", "strResConf", "strJumpInfo", "uiCanChangeStatus", "uiJumpType", "strDescIconUrl"}, new Object[]{"", 0, 0, 0, 0, 0, "", "", "", "", "", "", 0, 0, ""}, DynamicList$SubCmd_DynamicItem_Resp.class);
    public final PBStringField strPkgName = PBField.initString("");
    public final PBUInt32Field uiPluginID = PBField.initUInt32(0);
    public final PBUInt32Field uiNewVer = PBField.initUInt32(0);
    public final PBUInt32Field uiType = PBField.initUInt32(0);
    public final PBUInt32Field uiWeight = PBField.initUInt32(0);
    public final PBUInt32Field uiOpenFlag = PBField.initUInt32(0);
    public final PBStringField strResName = PBField.initString("");
    public final PBStringField strResDesc = PBField.initString("");
    public final PBStringField strResURL_big = PBField.initString("");
    public final PBStringField strResURL_small = PBField.initString("");
    public final PBStringField strResConf = PBField.initString("");
    public final PBStringField strJumpInfo = PBField.initString("");
    public final PBUInt32Field uiCanChangeStatus = PBField.initUInt32(0);
    public final PBUInt32Field uiJumpType = PBField.initUInt32(0);
    public final PBStringField strDescIconUrl = PBField.initString("");
}
