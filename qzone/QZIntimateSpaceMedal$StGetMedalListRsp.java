package qzone;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceMedal$StGetMedalListRsp extends MessageMicro<QZIntimateSpaceMedal$StGetMedalListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40}, new String[]{"total", "got_num", "medals", "attach_info", PictureConst.KEY_HAS_MORE}, new Object[]{0, 0, null, "", Boolean.FALSE}, QZIntimateSpaceMedal$StGetMedalListRsp.class);
    public final PBUInt32Field total = PBField.initUInt32(0);
    public final PBUInt32Field got_num = PBField.initUInt32(0);
    public final PBRepeatMessageField<QZIntimateSpaceMedal$MedalInfo> medals = PBField.initRepeatMessage(QZIntimateSpaceMedal$MedalInfo.class);
    public final PBStringField attach_info = PBField.initString("");
    public final PBBoolField has_more = PBField.initBool(false);
}
