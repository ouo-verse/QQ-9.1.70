package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloUserGameData extends MessageMicro<YoloRoomOuterClass$YoloUserGameData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"user_smoba_game_data", "user_common_game_data", "user_pubg_game_data", "user_qsm_game_data", "user_cfm_game_data", "user_codm_game_data"}, new Object[]{null, null, null, null, null, null}, YoloRoomOuterClass$YoloUserGameData.class);
    public YoloRoomOuterClass$YoloSmobaUserGameData user_smoba_game_data = new YoloRoomOuterClass$YoloSmobaUserGameData();
    public YoloRoomOuterClass$YoloCommonUserGameData user_common_game_data = new YoloRoomOuterClass$YoloCommonUserGameData();
    public YoloRoomOuterClass$YoloPubgUserGameData user_pubg_game_data = new MessageMicro<YoloRoomOuterClass$YoloPubgUserGameData>() { // from class: trpc.yes.common.YoloRoomOuterClass$YoloPubgUserGameData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], YoloRoomOuterClass$YoloPubgUserGameData.class);
    };
    public YoloRoomOuterClass$YoloQsmUserGameData user_qsm_game_data = new MessageMicro<YoloRoomOuterClass$YoloQsmUserGameData>() { // from class: trpc.yes.common.YoloRoomOuterClass$YoloQsmUserGameData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], YoloRoomOuterClass$YoloQsmUserGameData.class);
    };
    public YoloRoomOuterClass$YoloCfmUserGameData user_cfm_game_data = new MessageMicro<YoloRoomOuterClass$YoloCfmUserGameData>() { // from class: trpc.yes.common.YoloRoomOuterClass$YoloCfmUserGameData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], YoloRoomOuterClass$YoloCfmUserGameData.class);
    };
    public YoloRoomOuterClass$YoloCodmUserGameData user_codm_game_data = new MessageMicro<YoloRoomOuterClass$YoloCodmUserGameData>() { // from class: trpc.yes.common.YoloRoomOuterClass$YoloCodmUserGameData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], YoloRoomOuterClass$YoloCodmUserGameData.class);
    };
}
