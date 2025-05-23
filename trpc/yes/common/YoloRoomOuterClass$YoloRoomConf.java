package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import trpc.yes.wuji.WujiYoloRoomOuterClass$WujiYoloCfmRoomConf;
import trpc.yes.wuji.WujiYoloRoomOuterClass$WujiYoloCodmRoomConf;
import trpc.yes.wuji.WujiYoloRoomOuterClass$WujiYoloPubgRoomConf;
import trpc.yes.wuji.WujiYoloRoomOuterClass$WujiYoloQsmRoomConf;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomConf extends MessageMicro<YoloRoomOuterClass$YoloRoomConf> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 26, 50, 58, 66, 74, 82, 90}, new String[]{"yolo_room_smoba_conf", "yolo_room_common_conf", "yolo_room_community_conf", "yolo_room_pubg_conf", "yolo_room_game_conf", "yolo_room_qsm_conf", "yolo_room_cfm_conf", "yolo_room_codm_conf"}, new Object[]{null, null, null, null, null, null, null, null}, YoloRoomOuterClass$YoloRoomConf.class);
    public YoloRoomOuterClass$YoloRoomSmobaConf yolo_room_smoba_conf = new YoloRoomOuterClass$YoloRoomSmobaConf();
    public YoloRoomOuterClass$YoloRoomCommonConf yolo_room_common_conf = new YoloRoomOuterClass$YoloRoomCommonConf();
    public YoloRoomOuterClass$YoloRoomCommunityConf yolo_room_community_conf = new YoloRoomOuterClass$YoloRoomCommunityConf();
    public YoloRoomOuterClass$YoloRoomPubgConf yolo_room_pubg_conf = new MessageMicro<YoloRoomOuterClass$YoloRoomPubgConf>() { // from class: trpc.yes.common.YoloRoomOuterClass$YoloRoomPubgConf
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"yolo_room_pubg_conf"}, new Object[]{null}, YoloRoomOuterClass$YoloRoomPubgConf.class);
        public WujiYoloRoomOuterClass$WujiYoloPubgRoomConf yolo_room_pubg_conf = new MessageMicro<WujiYoloRoomOuterClass$WujiYoloPubgRoomConf>() { // from class: trpc.yes.wuji.WujiYoloRoomOuterClass$WujiYoloPubgRoomConf
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBStringField room_background_img = PBField.initString("");
            public final PBBoolField is_use_voice = PBField.initBool(false);
            public final PBStringField room_background_img_v2 = PBField.initString("");
            public final PBStringField room_background_color_v2 = PBField.initString("");
            public final PBBoolField is_use_tgpa = PBField.initBool(false);
            public final PBInt32Field room_expire_user_timeout = PBField.initInt32(0);
            public final PBInt32Field wait_join_game_timeout = PBField.initInt32(0);
            public final PBInt32Field wait_battle_begin_timeout = PBField.initInt32(0);
            public final PBInt32Field wait_battle_end_timeout = PBField.initInt32(0);
            public final PBInt32Field daily_user_create_limit = PBField.initInt32(0);

            static {
                Boolean bool = Boolean.FALSE;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 800, 808, 816, 824, 832}, new String[]{"room_background_img", "is_use_voice", "room_background_img_v2", "room_background_color_v2", "is_use_tgpa", "room_expire_user_timeout", "wait_join_game_timeout", "wait_battle_begin_timeout", "wait_battle_end_timeout", "daily_user_create_limit"}, new Object[]{"", bool, "", "", bool, 0, 0, 0, 0, 0}, WujiYoloRoomOuterClass$WujiYoloPubgRoomConf.class);
            }
        };
    };
    public YoloRoomOuterClass$YoloRoomGameConf yolo_room_game_conf = new YoloRoomOuterClass$YoloRoomGameConf();
    public YoloRoomOuterClass$YoloRoomQsmConf yolo_room_qsm_conf = new MessageMicro<YoloRoomOuterClass$YoloRoomQsmConf>() { // from class: trpc.yes.common.YoloRoomOuterClass$YoloRoomQsmConf
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"yolo_room_qsm_conf"}, new Object[]{null}, YoloRoomOuterClass$YoloRoomQsmConf.class);
        public WujiYoloRoomOuterClass$WujiYoloQsmRoomConf yolo_room_qsm_conf = new MessageMicro<WujiYoloRoomOuterClass$WujiYoloQsmRoomConf>() { // from class: trpc.yes.wuji.WujiYoloRoomOuterClass$WujiYoloQsmRoomConf
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBStringField room_background_img = PBField.initString("");
            public final PBBoolField is_use_voice = PBField.initBool(false);
            public final PBStringField room_background_img_v2 = PBField.initString("");
            public final PBStringField room_background_color_v2 = PBField.initString("");
            public final PBBoolField is_use_tgpa = PBField.initBool(false);
            public final PBInt32Field room_expire_user_timeout = PBField.initInt32(0);
            public final PBInt32Field wait_join_game_timeout = PBField.initInt32(0);
            public final PBInt32Field wait_battle_begin_timeout = PBField.initInt32(0);
            public final PBInt32Field wait_battle_end_timeout = PBField.initInt32(0);
            public final PBInt32Field daily_user_create_limit = PBField.initInt32(0);

            static {
                Boolean bool = Boolean.FALSE;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 800, 808, 816, 824, 832}, new String[]{"room_background_img", "is_use_voice", "room_background_img_v2", "room_background_color_v2", "is_use_tgpa", "room_expire_user_timeout", "wait_join_game_timeout", "wait_battle_begin_timeout", "wait_battle_end_timeout", "daily_user_create_limit"}, new Object[]{"", bool, "", "", bool, 0, 0, 0, 0, 0}, WujiYoloRoomOuterClass$WujiYoloQsmRoomConf.class);
            }
        };
    };
    public YoloRoomOuterClass$YoloRoomCfmConf yolo_room_cfm_conf = new MessageMicro<YoloRoomOuterClass$YoloRoomCfmConf>() { // from class: trpc.yes.common.YoloRoomOuterClass$YoloRoomCfmConf
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"yolo_room_cfm_conf"}, new Object[]{null}, YoloRoomOuterClass$YoloRoomCfmConf.class);
        public WujiYoloRoomOuterClass$WujiYoloCfmRoomConf yolo_room_cfm_conf = new MessageMicro<WujiYoloRoomOuterClass$WujiYoloCfmRoomConf>() { // from class: trpc.yes.wuji.WujiYoloRoomOuterClass$WujiYoloCfmRoomConf
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBStringField room_background_img = PBField.initString("");
            public final PBBoolField is_use_voice = PBField.initBool(false);
            public final PBStringField room_background_img_v2 = PBField.initString("");
            public final PBStringField room_background_color_v2 = PBField.initString("");
            public final PBBoolField is_use_tgpa = PBField.initBool(false);
            public final PBInt32Field room_expire_user_timeout = PBField.initInt32(0);
            public final PBInt32Field wait_join_game_timeout = PBField.initInt32(0);
            public final PBInt32Field wait_battle_begin_timeout = PBField.initInt32(0);
            public final PBInt32Field wait_battle_end_timeout = PBField.initInt32(0);
            public final PBInt32Field daily_user_create_limit = PBField.initInt32(0);

            static {
                Boolean bool = Boolean.FALSE;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 800, 808, 816, 824, 832}, new String[]{"room_background_img", "is_use_voice", "room_background_img_v2", "room_background_color_v2", "is_use_tgpa", "room_expire_user_timeout", "wait_join_game_timeout", "wait_battle_begin_timeout", "wait_battle_end_timeout", "daily_user_create_limit"}, new Object[]{"", bool, "", "", bool, 0, 0, 0, 0, 0}, WujiYoloRoomOuterClass$WujiYoloCfmRoomConf.class);
            }
        };
    };
    public YoloRoomOuterClass$YoloRoomCodmConf yolo_room_codm_conf = new MessageMicro<YoloRoomOuterClass$YoloRoomCodmConf>() { // from class: trpc.yes.common.YoloRoomOuterClass$YoloRoomCodmConf
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"yolo_room_codm_conf"}, new Object[]{null}, YoloRoomOuterClass$YoloRoomCodmConf.class);
        public WujiYoloRoomOuterClass$WujiYoloCodmRoomConf yolo_room_codm_conf = new MessageMicro<WujiYoloRoomOuterClass$WujiYoloCodmRoomConf>() { // from class: trpc.yes.wuji.WujiYoloRoomOuterClass$WujiYoloCodmRoomConf
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBStringField room_background_img = PBField.initString("");
            public final PBBoolField is_use_voice = PBField.initBool(false);
            public final PBStringField room_background_img_v2 = PBField.initString("");
            public final PBStringField room_background_color_v2 = PBField.initString("");
            public final PBBoolField is_use_tgpa = PBField.initBool(false);
            public final PBInt32Field room_expire_user_timeout = PBField.initInt32(0);
            public final PBInt32Field wait_join_game_timeout = PBField.initInt32(0);
            public final PBInt32Field wait_battle_begin_timeout = PBField.initInt32(0);
            public final PBInt32Field wait_battle_end_timeout = PBField.initInt32(0);
            public final PBInt32Field daily_user_create_limit = PBField.initInt32(0);

            static {
                Boolean bool = Boolean.FALSE;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 800, 808, 816, 824, 832}, new String[]{"room_background_img", "is_use_voice", "room_background_img_v2", "room_background_color_v2", "is_use_tgpa", "room_expire_user_timeout", "wait_join_game_timeout", "wait_battle_begin_timeout", "wait_battle_end_timeout", "daily_user_create_limit"}, new Object[]{"", bool, "", "", bool, 0, 0, 0, 0, 0}, WujiYoloRoomOuterClass$WujiYoloCodmRoomConf.class);
            }
        };
    };
}
