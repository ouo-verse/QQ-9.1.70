package tencent.im.DynamicList;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class DynamicList$SubCmd_DynamicList_ReqInfo extends MessageMicro<DynamicList$SubCmd_DynamicList_ReqInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"SubCmd_Req", "isGrayVer"}, new Object[]{null, Boolean.FALSE}, DynamicList$SubCmd_DynamicList_ReqInfo.class);
    public final PBRepeatMessageField<DynamicList$SubCmd_DynamicItem_Req> SubCmd_Req = PBField.initRepeatMessage(DynamicList$SubCmd_DynamicItem_Req.class);
    public final PBBoolField isGrayVer = PBField.initBool(false);
}
