package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import trpc.yes.wuji.WujiSafeOuterClass$WujiSafeConf;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomCommonConf extends MessageMicro<YoloRoomOuterClass$YoloRoomCommonConf> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50, 58, 66}, new String[]{"get_data_pull_time", "forbidden_speech_conf_list", "tag_list", "safe_conf", "is_ios_audit", "greet_words_list", "enter_room_greet_words_list", "game_config_info"}, new Object[]{0, null, "", null, Boolean.FALSE, "", "", null}, YoloRoomOuterClass$YoloRoomCommonConf.class);
    public final PBRepeatField<String> enter_room_greet_words_list;
    public YesGameInfoOuterClass$GameConfigInfo game_config_info;
    public final PBRepeatField<String> greet_words_list;
    public final PBBoolField is_ios_audit;
    public WujiSafeOuterClass$WujiSafeConf safe_conf;
    public final PBRepeatField<String> tag_list;
    public final PBInt32Field get_data_pull_time = PBField.initInt32(0);
    public final PBRepeatMessageField<YoloRoomOuterClass$YoloRoomForbiddenSpeechConf> forbidden_speech_conf_list = PBField.initRepeatMessage(YoloRoomOuterClass$YoloRoomForbiddenSpeechConf.class);

    public YoloRoomOuterClass$YoloRoomCommonConf() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.tag_list = PBField.initRepeat(pBStringField);
        this.safe_conf = new WujiSafeOuterClass$WujiSafeConf();
        this.is_ios_audit = PBField.initBool(false);
        this.greet_words_list = PBField.initRepeat(pBStringField);
        this.enter_room_greet_words_list = PBField.initRepeat(pBStringField);
        this.game_config_info = new YesGameInfoOuterClass$GameConfigInfo();
    }
}
