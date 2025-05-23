package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class GameDataServerOuterClass$GetAnchorLivingHeroRsp extends MessageMicro<GameDataServerOuterClass$GetAnchorLivingHeroRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"hero_info"}, new Object[]{null}, GameDataServerOuterClass$GetAnchorLivingHeroRsp.class);
    public GameDataServerOuterClass$AnchorSmobaHeroInfo hero_info = new MessageMicro<GameDataServerOuterClass$AnchorSmobaHeroInfo>() { // from class: trpc.yes.common.GameDataServerOuterClass$AnchorSmobaHeroInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50}, new String[]{"hero_id", "name", "icon", "fight_power", "equip_config", "rune_page"}, new Object[]{0, "", "", 0, null, null}, GameDataServerOuterClass$AnchorSmobaHeroInfo.class);
        public final PBUInt32Field hero_id = PBField.initUInt32(0);
        public final PBStringField name = PBField.initString("");
        public final PBStringField icon = PBField.initString("");
        public final PBUInt32Field fight_power = PBField.initUInt32(0);
        public GameDataServerOuterClass$SmobaEquipConfig equip_config = new MessageMicro<GameDataServerOuterClass$SmobaEquipConfig>() { // from class: trpc.yes.common.GameDataServerOuterClass$SmobaEquipConfig
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"name", "equips", "equip_idx", "equip_str"}, new Object[]{"", null, 0, ""}, GameDataServerOuterClass$SmobaEquipConfig.class);
            public final PBStringField name = PBField.initString("");
            public final PBRepeatMessageField<GameDataServerOuterClass$SmobaEquip> equips = PBField.initRepeatMessage(GameDataServerOuterClass$SmobaEquip.class);
            public final PBUInt32Field equip_idx = PBField.initUInt32(0);
            public final PBStringField equip_str = PBField.initString("");
        };
        public GameDataServerOuterClass$SmobaRunePage rune_page = new MessageMicro<GameDataServerOuterClass$SmobaRunePage>() { // from class: trpc.yes.common.GameDataServerOuterClass$SmobaRunePage
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 50}, new String[]{"name", "runes", "rune_page_idx", "total_level", "total_comm_attr", "rune_str"}, new Object[]{"", null, 0, 0, null, ""}, GameDataServerOuterClass$SmobaRunePage.class);
            public final PBStringField name = PBField.initString("");
            public final PBRepeatMessageField<GameDataServerOuterClass$SmobaRune> runes = PBField.initRepeatMessage(GameDataServerOuterClass$SmobaRune.class);
            public final PBUInt32Field rune_page_idx = PBField.initUInt32(0);
            public final PBInt32Field total_level = PBField.initInt32(0);
            public final PBRepeatMessageField<GameDataServerOuterClass$SmobaCommAttr> total_comm_attr = PBField.initRepeatMessage(GameDataServerOuterClass$SmobaCommAttr.class);
            public final PBStringField rune_str = PBField.initString("");
        };
    };
}
