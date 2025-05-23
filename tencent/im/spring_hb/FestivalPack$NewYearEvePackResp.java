package tencent.im.spring_hb;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* loaded from: classes29.dex */
public final class FestivalPack$NewYearEvePackResp extends MessageMicro<FestivalPack$NewYearEvePackResp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field promotion_id = PBField.initUInt32(0);
    public FestivalPack$Pack pack = new FestivalPack$Pack();
    public final PBUInt32Field interval = PBField.initUInt32(0);
    public final PBUInt32Field reason = PBField.initUInt32(0);
    public final PBUInt32Field limit = PBField.initUInt32(0);
    public final PBUInt32Field share_forbidden = PBField.initUInt32(0);
    public final PBBoolField reserved_zplan = PBField.initBool(false);
    public final PBStringField map_ext = PBField.initString("");
    public final PBBoolField has_red_dot = PBField.initBool(false);

    static {
        String[] strArr = {"promotion_id", "pack", WidgetCacheConstellationData.INTERVAL, "reason", "limit", "share_forbidden", "reserved_zplan", "map_ext", QCircleScheme.AttrDetail.HAS_RED_DOT};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 32, 48, 56, 64, 72, 82, 88}, strArr, new Object[]{0, null, 0, 0, 0, 0, bool, "", bool}, FestivalPack$NewYearEvePackResp.class);
    }
}
