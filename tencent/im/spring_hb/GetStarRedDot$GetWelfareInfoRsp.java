package tencent.im.spring_hb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GetStarRedDot$GetWelfareInfoRsp extends MessageMicro<GetStarRedDot$GetWelfareInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"welfare_list"}, new Object[]{null}, GetStarRedDot$GetWelfareInfoRsp.class);
    public final PBRepeatMessageField<GetStarRedDot$WelfareItem> welfare_list = PBField.initRepeatMessage(GetStarRedDot$WelfareItem.class);
}
