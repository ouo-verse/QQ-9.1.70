package tencent.im.new_year_2021;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class FestivalPack$NewYearEvePackResp extends MessageMicro<FestivalPack$NewYearEvePackResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 64}, new String[]{"promotion_id", "pack", "pack_list", WidgetCacheConstellationData.INTERVAL, "share_forbidden"}, new Object[]{0, null, null, 0, 0}, FestivalPack$NewYearEvePackResp.class);
    public final PBUInt32Field promotion_id = PBField.initUInt32(0);
    public Pack2021$Pack pack = new Pack2021$Pack();
    public final PBRepeatMessageField<Pack2021$Pack> pack_list = PBField.initRepeatMessage(Pack2021$Pack.class);
    public final PBUInt32Field interval = PBField.initUInt32(0);
    public final PBUInt32Field share_forbidden = PBField.initUInt32(0);
}
