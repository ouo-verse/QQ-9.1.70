package tencent.im.troop.findtroop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class TabRecommendPB$GetRecommendExtraInfoRsp extends MessageMicro<TabRecommendPB$GetRecommendExtraInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"person_extra_info"}, new Object[]{null}, TabRecommendPB$GetRecommendExtraInfoRsp.class);
    public final PBRepeatMessageField<TabRecommendPB$PersonExtraInfo> person_extra_info = PBField.initRepeatMessage(TabRecommendPB$PersonExtraInfo.class);
}
