package tencent.im.spring_hb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class FestivalPack$GetWelfareInfoRsp extends MessageMicro<FestivalPack$GetWelfareInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"welfare_list"}, new Object[]{null}, FestivalPack$GetWelfareInfoRsp.class);
    public final PBRepeatMessageField<FestivalPack$WelfareItem> welfare_list = PBField.initRepeatMessage(FestivalPack$WelfareItem.class);
}
