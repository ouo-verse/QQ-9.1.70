package tvideo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes30.dex */
public final class TVideoFloatPr$GetQqPromotionLocationResp extends MessageMicro<TVideoFloatPr$GetQqPromotionLocationResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"errCode", "errMsg", "data"}, new Object[]{0, "", null}, TVideoFloatPr$GetQqPromotionLocationResp.class);
    public final PBInt32Field errCode = PBField.initInt32(0);
    public final PBStringField errMsg = PBField.initString("");
    public TVideoFloatPr$GetQqPromotionLocationData data = new TVideoFloatPr$GetQqPromotionLocationData();
}
