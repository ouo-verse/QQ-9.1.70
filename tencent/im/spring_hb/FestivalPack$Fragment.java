package tencent.im.spring_hb;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class FestivalPack$Fragment extends MessageMicro<FestivalPack$Fragment> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"pack_id", "pic", WidgetCacheConstellationData.NUM, "serial_num", "prize_id"}, new Object[]{"", "", 0, 0, 0L}, FestivalPack$Fragment.class);
    public final PBStringField pack_id = PBField.initString("");
    public final PBStringField pic = PBField.initString("");
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBUInt32Field serial_num = PBField.initUInt32(0);
    public final PBUInt64Field prize_id = PBField.initUInt64(0);
}
