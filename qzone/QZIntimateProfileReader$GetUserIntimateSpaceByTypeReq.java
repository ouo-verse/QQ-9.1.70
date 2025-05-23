package qzone;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QZIntimateProfileReader$GetUserIntimateSpaceByTypeReq extends MessageMicro<QZIntimateProfileReader$GetUserIntimateSpaceByTypeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"space_type", QCircleSchemeAttr.AttrDebug.TARGET_SECOND_PAGE, "origin_schema"}, new Object[]{0, 0, ""}, QZIntimateProfileReader$GetUserIntimateSpaceByTypeReq.class);
    public final PBEnumField space_type = PBField.initEnum(0);
    public final PBEnumField targetpage = PBField.initEnum(0);
    public final PBStringField origin_schema = PBField.initString("");
}
