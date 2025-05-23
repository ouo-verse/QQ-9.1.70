package trpc.qq_vgame.pk_manager;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.qq_vgame.common.AvGameCommon$Result;
import trpc.qq_vgame.common.AvGameCommon$UinWrap;

/* loaded from: classes29.dex */
public final class AvGamePkManager$GetPKInfoRsp extends MessageMicro<AvGamePkManager$GetPKInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public AvGameCommon$Result res = new AvGameCommon$Result();
    public final PBUInt32Field interval = PBField.initUInt32(0);
    public final PBUInt32Field user_total_num = PBField.initUInt32(0);
    public final PBRepeatMessageField<AvGameCommon$UinWrap> user_in_pk = PBField.initRepeatMessage(AvGameCommon$UinWrap.class);
    public final PBBoolField change_pool_id = PBField.initBool(false);
    public final PBUInt32Field real_pool_id = PBField.initUInt32(0);
    public final PBBoolField fresh_at_midfield = PBField.initBool(false);

    static {
        String[] strArr = {"res", WidgetCacheConstellationData.INTERVAL, "user_total_num", "user_in_pk", "change_pool_id", "real_pool_id", "fresh_at_midfield"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40, 48, 56}, strArr, new Object[]{null, 0, 0, null, bool, 0, bool}, AvGamePkManager$GetPKInfoRsp.class);
    }
}
