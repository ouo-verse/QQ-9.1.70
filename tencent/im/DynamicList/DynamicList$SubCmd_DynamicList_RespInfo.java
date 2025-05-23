package tencent.im.DynamicList;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class DynamicList$SubCmd_DynamicList_RespInfo extends MessageMicro<DynamicList$SubCmd_DynamicList_RespInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"uiReturnCode", "SubCmd_Resp_Add", "SubCmd_Resp_Modify", "SubCmd_Resp_Delete"}, new Object[]{0, null, null, 0}, DynamicList$SubCmd_DynamicList_RespInfo.class);
    public final PBUInt32Field uiReturnCode = PBField.initUInt32(0);
    public final PBRepeatMessageField<DynamicList$SubCmd_DynamicItem_Resp> SubCmd_Resp_Add = PBField.initRepeatMessage(DynamicList$SubCmd_DynamicItem_Resp.class);
    public final PBRepeatMessageField<DynamicList$SubCmd_DynamicItem_Resp> SubCmd_Resp_Modify = PBField.initRepeatMessage(DynamicList$SubCmd_DynamicItem_Resp.class);
    public final PBRepeatField<Integer> SubCmd_Resp_Delete = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
