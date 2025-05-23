package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.yes.wuji.WujiSmobaOuterClass$WujiSmobaHeroConf;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class GameDataServerOuterClass$GameRoleHeroInfo extends MessageMicro<GameDataServerOuterClass$GameRoleHeroInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 50, 56, 64, 72}, new String[]{"hero_info", "win_num", "fail_num", "skilled", "skilled_level", "skilled_title", "fight_score", "title_location_type", "title_rank"}, new Object[]{null, 0, 0, 0, 0, "", 0, 0, 0}, GameDataServerOuterClass$GameRoleHeroInfo.class);
    public WujiSmobaOuterClass$WujiSmobaHeroConf hero_info = new MessageMicro<WujiSmobaOuterClass$WujiSmobaHeroConf>() { // from class: trpc.yes.wuji.WujiSmobaOuterClass$WujiSmobaHeroConf
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42}, new String[]{"id", "name", "type", "lane_type", "icon"}, new Object[]{0, "", 0, 0, ""}, WujiSmobaOuterClass$WujiSmobaHeroConf.class);

        /* renamed from: id, reason: collision with root package name */
        public final PBInt32Field f437269id = PBField.initInt32(0);
        public final PBStringField name = PBField.initString("");
        public final PBInt32Field type = PBField.initInt32(0);
        public final PBInt32Field lane_type = PBField.initInt32(0);
        public final PBStringField icon = PBField.initString("");
    };
    public final PBUInt32Field win_num = PBField.initUInt32(0);
    public final PBUInt32Field fail_num = PBField.initUInt32(0);
    public final PBUInt32Field skilled = PBField.initUInt32(0);
    public final PBUInt32Field skilled_level = PBField.initUInt32(0);
    public final PBStringField skilled_title = PBField.initString("");
    public final PBUInt32Field fight_score = PBField.initUInt32(0);
    public final PBUInt32Field title_location_type = PBField.initUInt32(0);
    public final PBUInt32Field title_rank = PBField.initUInt32(0);
}
